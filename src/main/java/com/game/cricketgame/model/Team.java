package com.game.cricketgame.model;

import com.game.cricketgame.enums.Nation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {

    private String name;
    private String code;
    private String coachName;
    private String ownedBy;
    private Nation nation;
    private List<Players> playersList = new ArrayList<>();
}
