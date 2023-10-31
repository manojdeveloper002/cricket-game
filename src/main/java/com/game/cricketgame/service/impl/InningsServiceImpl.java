package com.game.cricketgame.service.impl;

import com.game.cricketgame.model.Innings;
import com.game.cricketgame.model.Match;
import com.game.cricketgame.service.InningsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InningsServiceImpl implements InningsService {

    private static final Logger log = LoggerFactory.getLogger(InningsServiceImpl.class);

    private static final int oversBalls = 6;
    @Override
    public Innings createInnings(Integer oversNo, String inningsName, String battingTeam) {
        log.info("Creating innings oversNo "+oversNo+" innings name "+ inningsName+" battingTeam "+battingTeam);
        Innings ing = new Innings();
        ing.setCode(inningsName+"-"+battingTeam);
        ing.setOvers(oversNo);
        ing.setTotalBalls(oversNo * oversBalls);
        ing.setName(inningsName);
        ing.setBattingTeam(battingTeam);
        return ing;
    }
}
