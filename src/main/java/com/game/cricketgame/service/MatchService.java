package com.game.cricketgame.service;


import com.game.cricketgame.entities.Match;
import com.game.cricketgame.entities.Players;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MatchService {

    Match save(Match match);
    Match update(Match match);
    void delete(Long id);
    Match fetch(Long id);
    List<Match> fetchAll();
    List<Match> saveAll(List<Match> matchList);
    Match createMatch(Match match);

    Map<String, List<Players>> getListOfPlayers(Long id);
}
