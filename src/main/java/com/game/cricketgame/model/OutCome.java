package com.game.cricketgame.model;

import com.game.cricketgame.enums.ExtraType;
import com.game.cricketgame.enums.WicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutCome {

    private Integer outcome = 0;
    private WicketType wicketType;
    private ExtraType extraType;
    private Integer noBalls = 0;
    private Integer currentRuns = 0;

}
