package com.game.cricketgame.model;

import com.game.cricketgame.enums.Nation;
import com.game.cricketgame.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Players {
    private String code;
    private String name;
    private Boolean isCap;
    private Integer age = 0;
    private String ownedBy;
    private Nation nation;
    private Roles roles;
}
