package com.game.cricketgame.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bowlers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer balls = 0;
    private Integer overs = 0;
    private Integer runs = 0;
    private Integer nosSixes = 0;
    private Integer nosFours = 0;
    private Integer nosThrees = 0;
    private Integer nosTwos = 0;
    private Integer nosSingles = 0;
    private Integer nosDots = 0;
    private Integer wickets = 0;

    @ManyToOne(cascade=CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Players players = new Players();

}
