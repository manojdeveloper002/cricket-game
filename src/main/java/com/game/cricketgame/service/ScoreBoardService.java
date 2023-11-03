package com.game.cricketgame.service;

import com.game.cricketgame.model.Match;
import com.game.cricketgame.model.ScoreBoard;
import org.springframework.stereotype.Service;

@Service
public interface ScoreBoardService {

    ScoreBoard InitiateMatch(Match match);
}
