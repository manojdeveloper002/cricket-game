package com.game.cricketgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Over {

    private Integer overRuns = 0;
    private Integer overWickets = 0;
    private Integer overExtras = 0;
    private List<OutCome> outComesList = new ArrayList<>();
}
