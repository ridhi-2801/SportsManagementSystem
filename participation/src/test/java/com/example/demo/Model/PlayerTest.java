package com.example.demo.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp(){
        player=new Player(1,"Ridhi",22,"7838685037","ridhi2801@gmail.com","female","football");
    }

    @Test
    void getSetPlayerId() {

        player.setPlayerId(1);
        assertEquals(1,player.getPlayerId());

    }

    @Test
    void getSetPlayerName() {
        player.setPlayerName("Joker");
        assertEquals("Joker",player.getPlayerName());
    }

    @Test
    void getSetAge() {
        player.setAge(22);
        assertEquals(22,player.getAge());
    }

    @Test
    void getSetContactNumber() {
        player.setContactNumber("9811152323");
        assertEquals("9811152323",player.getContactNumber());
    }

    @Test
    void getSetEmail() {
        player.setEmail("ridhi2801@gmail.com");
        assertEquals("ridhi2801@gmail.com",player.getEmail());
    }

    @Test
    void getSetGender() {
        player.setGender("Female");
        assertEquals("Female",player.getGender());
    }

    @Test
    void getSetSportsName() {
        player.setSportsName("Football");
        assertEquals("Football",player.getSportsName());
    }
}