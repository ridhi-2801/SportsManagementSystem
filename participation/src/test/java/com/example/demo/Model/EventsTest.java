package com.example.demo.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventsTest {

    private Events events;

    @BeforeEach
    public void setUp(){
        events=new Events(1,"02/02/2020","tournament",2,"football");
    }

    @Test
    void getSetEventId() {
        events.setEventId(1);
        assertEquals(1,events.getEventId());
    }

    @Test
    void getSetEventDate() {
        events.setEventDate("02/04/2020");
        assertEquals("02/04/2020",events.getEventDate());
    }

    @Test
    void getSetEventName() {
        events.setEventName("finale");
        assertEquals("finale",events.getEventName());
    }

    @Test
    void getSetNoOfSlots() {
        events.setNoOfSlots(1);
        assertEquals(1,events.getNoOfSlots());
    }

    @Test
    void getSetSportsName() {
        events.setSportsName("football");
        assertEquals("football",events.getSportsName());
    }


}