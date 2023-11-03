package com.game.cricketgame.service;

import com.game.cricketgame.entities.Match;
import com.game.cricketgame.entities.ScoreBoard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScoreBoardService {

    ScoreBoard InitiateMatch(Match match);
    ScoreBoard checkMatchExited(Long matchId);
    ScoreBoard InitiateMatch(Long matchId) throws Exception;
    ScoreBoard save(ScoreBoard scoreBoard);
    ScoreBoard update(ScoreBoard scoreBoard);
    void delete(Long id);
    ScoreBoard fetch(Long id);
    List<ScoreBoard> fetchAll();
    List<ScoreBoard> saveAll(List<ScoreBoard> scoreBoardList);
}
