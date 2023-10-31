package com.game.cricketgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Innings {

    private String name;
    private String code;
    private Integer totalBalls = 0;
    private Integer remainingBalls = 0;
    private Integer ballsUsed = 0;
    private Integer totalScore = 0;
    private Integer totalWickets = 0;
    private Integer remainingWickets = 0;
    private Integer totalExtras = 0;
    private Integer overs = 0;
    private String battingTeam;
    private List<Batsmen> batsmenList = new ArrayList<>();
    private List<Bowlers> bowlersList = new ArrayList<>();
    private List<Over> oversList = new ArrayList<>();

}
