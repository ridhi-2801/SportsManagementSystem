package com.example.demo.Controller;

import com.example.demo.FeignClient.EventClient;
import com.example.demo.FeignClient.PlayerClient;
import com.example.demo.Model.Events;
import com.example.demo.Model.Participation;
import com.example.demo.Model.Player;
import com.example.demo.Repository.ParticipationRepository;
import com.example.demo.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    TokenService tokenService;

    @Autowired
    ParticipationRepository participationRepository;

    @Autowired
    EventClient eventClient;

    @Autowired
    PlayerClient playerClient;

    @GetMapping("/addParticipation")
    public String addParticipation(@RequestHeader(value="Authorization") String token, @RequestBody Participation participation){
        if(tokenService.checkValidity(token)){
            participationRepository.save(participation);
            return "Successfully added";
        }else{
            return "Invalid Token";
        }
    }
    @GetMapping("/getParticipants")
    public List<Participation> getParticipants(@RequestHeader(value="Authorization") String token){
        if(tokenService.checkValidity(token)){
            return participationRepository.findAll();

        }else{
            System.out.println("Invalid Token");
            return new ArrayList<>();
        }
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestHeader(value="Authorization") String token,@RequestBody int participationId){
        if(tokenService.checkValidity(token)){

                Optional<Participation> p = participationRepository.findById(participationId);

                System.out.println(p.get());
                if(p!=null){
                    Events events=eventClient.viewEventByName(token,p.get().getEventName());
                    int slotsLeft=events.getNoOfSlots();
                    List<Player> playerList=playerClient.players(token);
                    if(slotsLeft==0){
                        p.get().setStatus("Declined");
                        System.out.println(p.get().getStatus());
                        participationRepository.deleteById(participationId);
                        participationRepository.save(p.get());
                    }
                    for(int i=0; i<playerList.size(); i++){
                        slotsLeft--;
                        if(playerList.get(i).getPlayerId()==participationId){
                            p.get().setStatus("Approved");
                            System.out.println(p.get().getStatus());
                            participationRepository.deleteById(participationId);
                            participationRepository.save(p.get());
                        }
                    }

                }else{
                    return "Wrong participatioon id";
                }


        }else{
             return "invalid token";
        }
        return "Status is pending";
    }

    @GetMapping("/getApprovedParticipations")
    public List<Participation> getApprovedParticipations (@RequestHeader(value="Authorization") String token){
        if(tokenService.checkValidity(token)){
            return participationRepository.findByStatus("Approved");

        }else{
            System.out.println("Invalid Token");
            return new ArrayList<>();
        }
    }
    @GetMapping("/getDeclinedParticipations")
    public List<Participation> getDeclinedParticipations (@RequestHeader(value="Authorization") String token){
        if(tokenService.checkValidity(token)){
            return participationRepository.findByStatus("Declined");

        }else{
            System.out.println("Invalid Token");
            return new ArrayList<>();
        }
    }
    @GetMapping("/getPendingParticipations")
    public List<Participation> getPendingParticipations (@RequestHeader(value="Authorization") String token){
        if(tokenService.checkValidity(token)){
            return participationRepository.findByStatus("Pending");

        }else{
            System.out.println("Invalid Token");
            return new ArrayList<>();
        }
    }


}
