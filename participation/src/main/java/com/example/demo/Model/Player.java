package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int playerId;
    private String playerName;
    private int age;
    private String contactNumber;
    private String email;
    private String gender;
    private String sportsName;

}
