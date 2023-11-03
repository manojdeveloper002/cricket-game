package com.game.cricketgame.entities;

import com.game.cricketgame.enums.Nation;
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
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ownedBy;
    private Nation nation;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "teamId")
    private List<Players> playersList = new ArrayList<>();
}
