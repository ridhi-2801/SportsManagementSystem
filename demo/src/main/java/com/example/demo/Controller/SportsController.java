package com.example.demo.Controller;

import com.example.demo.Exception.TokenException;
import com.example.demo.Service.TokenService;
import com.example.demo.model.Events;
import com.example.demo.model.Sports;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.SportsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SportsController {

    @Autowired
    private SportsRepository sportsRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/viewAllSports")
    public List<Sports> viewAllSports(@RequestHeader(value = "Authorization", required = true) String token){
        System.out.println("inside viewAllSports");
        try {
            boolean tokenValidity=tokenService.checkValidity(token);
            if (tokenValidity == true) {

                return sportsRepository.findAll();

            } else {
                throw new TokenException("Token Expired");
            }
        }catch(TokenException e){
            log.error("Token Expired");

        }
      return new ArrayList<>();
    }
    @GetMapping("/viewSportsByName")
    public Sports viewSportsByName(@RequestHeader(value = "Authorization",required = true) String token,@RequestBody String sportsName){
        log.info(sportsName);
        Sports sports = sportsRepository.findBySportsName(sportsName);
        try {
            if(tokenService.checkValidity(token)==false){
                throw new TokenException("Token invalid");
            }
            if(sports==null){
                throw new Exception();
            }
        }
        catch(TokenException e){
            log.error("viewSportsByName Exception");
        }
        catch(Exception e){
            log.error("List Empty");
        }
        System.out.println(sports);
        return sports;
    }

    @GetMapping("/viewAllEvents")
    public List<Events> viewEvents(@RequestHeader(value = "Authorization", required = true)String token){
        try {
            boolean valid = tokenService.checkValidity(token);
            if(valid==false){
                throw new TokenException("Invalid Token");
            }
        }
        catch (TokenException te){
            log.error("viewEventsSportsName");
        }
        catch(Exception e){
            log.error("Empty Events List");
        }
        return eventRepository.findAll();
    }

    @PutMapping("/addEvent")
    public void addEvent(@RequestHeader(value = "Authorization", required = true)String token,@RequestBody Events events){
        try{
            if(tokenService.checkValidity(token)==false){
                throw new TokenException("Invalid token");
            }
        }catch (TokenException e){
            log.error("cannot add event");
        }
        eventRepository.save(events);
    }

    @DeleteMapping("/deleteEvent")
    public String deleteEvent(@RequestHeader(value = "Authorization", required = true)String token,@RequestBody int id){

        try{
            if(tokenService.checkValidity(token)==false){
                throw new TokenException("Invalid token");
            }
            eventRepository.deleteById(id);
        }catch (TokenException e){
            log.error("cannot add event");
        }catch (Exception ex){
            log.error("Cant find this id");
        }


        return id+" successfully deleted";

    }

    @PostMapping("/viewEventByName")
    public Events viewEventByName(@RequestHeader(value = "Authorization", required = true)String token,@RequestBody String eventName){
        Events e=eventRepository.findByEventName(eventName);
        try{
            if(tokenService.checkValidity(token)==false){
                throw new TokenException("Invalid token");
            }
            if(e==null){
                throw new Exception();
            }

        }catch (TokenException te){
            log.error("cannot add event");
        }catch (Exception ex){
            log.error("this event doesn't exist try searching another one.");
        }
        System.out.println(eventName);

        System.out.println(e);
        return e;
    }

}
