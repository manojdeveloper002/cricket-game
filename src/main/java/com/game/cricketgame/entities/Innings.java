package com.game.cricketgame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Innings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer totalBalls = 0;
    private Integer remainingBalls = 0;
    private Integer ballsUsed = 0;
    private Integer totalScore = 0;
    private Integer totalWickets = 0;
    private Integer remainingWickets = 0;
    private Integer totalExtras = 0;
    private Integer overs = 0;
    private Float oversUsed = 0f;
    private String battingTeam;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "innings_Id")
    private List<Batsmen> batsmenList = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "innings_Id")
    private List<Bowlers> bowlersList = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "innings_Id")
    private List<Over> oversList = new ArrayList<>();

}
