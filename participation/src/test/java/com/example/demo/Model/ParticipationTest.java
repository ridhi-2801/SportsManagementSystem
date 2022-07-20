package com.example.demo.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParticipationTest {

    private Participation participation;

    @BeforeEach
    void setUp() {
        participation=new Participation(1,1,"ridhi",1,"abc",4,"football","pending");
    }

    @Test
    void getParticipationId() {

        participation.setParticipationId(1);
        assertEquals(1,participation.getParticipationId());

    }

    @Test
    void getPlayerId() {
        participation.setPlayerId(1);
        assertEquals(1,participation.getPlayerId());
    }

    @Test
    void getPlayerName() {
        participation.setPlayerName("abc");
        assertEquals("abc",participation.getPlayerName());
    }

    @Test
    void getEventId() {
        participation.setEventId(1);
        assertEquals(1,participation.getEventId());
    }

    @Test
    void getEventName() {
        participation.setEventName("xyz");
        assertEquals("xyz",participation.getEventName());
    }

    @Test
    void getSportsId() {
        participation.setSportsId(1);
        assertEquals(1,participation.getSportsId());
    }

    @Test
    void getSportsName() {
        participation.setSportsName("xyz");
        assertEquals("xyz",participation.getSportsName());
    }

    @Test
    void getStatus() {
        participation.setStatus("pending");
        assertEquals("pending",participation.getStatus());
    }
}