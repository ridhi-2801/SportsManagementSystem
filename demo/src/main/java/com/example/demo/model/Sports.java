package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sports {
    @Id
    @GeneratedValue
    private int sportsId;
    private int noOfPlayers;
    private String sportsName;
    private String sportsType;
}
