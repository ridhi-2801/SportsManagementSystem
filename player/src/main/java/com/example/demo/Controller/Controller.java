package com.example.demo.Controller;

import com.example.demo.Model.Player;
import com.example.demo.Repository.PlayerRepository;
import com.example.demo.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    TokenService tokenService;

    @Autowired
    PlayerRepository playerRepository;

    @PostMapping("/addPlayer")
    public String addPlayer(@RequestHeader(value = "Authorization",required = true) String token, @RequestBody Player player,BindingResult result){

        if(tokenService.checkValidity(token)){
            try {
                playerRepository.save(player);
                if(result.hasErrors()) {
                    throw new Exception();
                }
                return player.getPlayerName()+" added successfully";
            }catch(Exception e){
                return "Invalid details"+e;
            }

        }else{
            return "Invalid Token";
        }

    }

    @DeleteMapping("/deletePlayer")
    public String deletePlayer(@RequestHeader(value = "Authorization",required = true) String token, @RequestBody int id){
        if(tokenService.checkValidity(token)){

            if(playerRepository.existsById(id)) {
                playerRepository.deleteById(id);
                return "Player with id "+id+" successfully deleted";
            }else{
                return "No player found with id "+id;
            }

        }else{
            return "Invalid Token";
        }
    }

    @GetMapping("/players")
    public List<Player> players(@RequestHeader(value = "Authorization",required = true) String token){
        try {
            if (tokenService.checkValidity(token)) {
                return playerRepository.findAll();

            }else{
                throw new Exception();

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
