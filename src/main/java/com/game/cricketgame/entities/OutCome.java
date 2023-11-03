package com.game.cricketgame.entities;

import com.game.cricketgame.enums.ExtraType;
import com.game.cricketgame.enums.WicketType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OutCome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer outcome = 0;
    private WicketType wicketType;
    private ExtraType extraType;
    private Integer noBalls = 0;
    private Integer currentRuns = 0;

}
