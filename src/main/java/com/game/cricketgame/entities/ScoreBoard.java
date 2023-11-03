package com.game.cricketgame.entities;

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
public class ScoreBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String result;
    @Column(name = "description")
    private String desc;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "score_id")
    private List<Innings> inningsList = new ArrayList<>();

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "match_id")
    private Match match = new Match();
}
