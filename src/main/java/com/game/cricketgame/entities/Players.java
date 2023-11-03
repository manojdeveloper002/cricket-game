package com.game.cricketgame.entities;

import com.game.cricketgame.enums.Nation;
import com.game.cricketgame.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private Boolean isCap;
    private Integer age = 0;
    private String ownedBy;
    private Nation nation;
    private Roles roles;
    private Long teamId;
    private Date dob;
}
