package com.example.demo.Model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    private int eventId;
    private String eventDate;
    private String eventName;
    private int noOfSlots;
    private String sportsName;


}
