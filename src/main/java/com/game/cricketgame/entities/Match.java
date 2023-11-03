package com.game.cricketgame.entities;

import com.game.cricketgame.enums.MatchType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "match_table")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    private MatchType type;
    private Date date;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Team teamA;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
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
