package com.example.demo.Controller;

import com.example.demo.FeignClient.EventClient;
import com.example.demo.FeignClient.PlayerClient;
import com.example.demo.Model.Participation;
import com.example.demo.Repository.ParticipationRepository;
import com.example.demo.Service.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

class ControllerTest {




    @MockBean
    ParticipationRepository participationRepository;


   @InjectMocks
   Controller controller;



    @Test
    void addParticipation() {



    }

    @Test
    void getParticipants() {



    }

    @Test
    void updateStatus() {
    }

    @Test
    void getApprovedParticipations() {
    }

    @Test
    void getDeclinedParticipations() {
    }

    @Test
    void getPendingParticipations() {
    }
}