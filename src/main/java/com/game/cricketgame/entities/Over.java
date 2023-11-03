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
@Table(name = "overs_table")
public class Over {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer overRuns = 0;
    private Integer overWickets = 0;
    private Integer overExtras = 0;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "over_id")
    private List<OutCome> outComesList = new ArrayList<>();
}
