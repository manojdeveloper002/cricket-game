package com.game.cricketgame.model;

import com.game.cricketgame.enums.MatchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {

    private String code;
    private String name;
    private String location;
    private MatchType type;
    private Date date;
    private Team teamA;
    private Team TeamB;

    public int getTotalOverByMatchType(){
        if(MatchType.T20.equals(this.type)){
            return 20;
        }else if(MatchType.OneDay.equals(this.type)){
            return 50;
        }
        return 0;
    }



}
