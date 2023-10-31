package com.game.cricketgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Batsmen {

    private Integer ballsPlayed = 0;
    private Integer scored = 0;
    private Integer strike = 0;
    private Integer nosSixes = 0;
    private Integer nosThrees = 0;
    private Integer nosFours = 0;
    private Integer nosTwos = 0;
    private Integer nosSingles = 0;
    private Integer nosDots = 0;
    private Players players;

}
