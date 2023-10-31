package com.game.cricketgame.service;

import com.game.cricketgame.model.Innings;
import com.game.cricketgame.model.Match;
import org.springframework.stereotype.Service;

@Service
public interface InningsService {

    Innings createInnings(Integer overs, String inningsName, String battingTeam);
}
