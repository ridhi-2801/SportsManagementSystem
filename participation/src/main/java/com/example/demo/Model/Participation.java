package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participation {

    @Id
    @GeneratedValue
    private int participationId;
    private int playerId;
    private String playerName;
    private int eventId;
    private String eventName;
    private int sportsId;
    private String sportsName;
    @Value("Pending")
    private String status;


}
