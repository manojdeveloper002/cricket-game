package com.game.cricketgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScoreBoard {

    private String name;
    private String code;
    private String result;
    private String desc;
    private List<Innings> inningsList = new ArrayList<>();
    private Match match;
}
