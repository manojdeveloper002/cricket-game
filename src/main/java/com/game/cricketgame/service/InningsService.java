package com.game.cricketgame.service;

import com.game.cricketgame.entities.Innings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InningsService {

    Innings createInnings(Integer overs, String inningsName, String battingTeam);

    Innings save(Innings innings);
    Innings update(Innings innings);
    void delete(Long id);
    Innings fetch(Long id);
    List<Innings> fetchAll();
    List<Innings> saveAll(List<Innings> inningsList);
}
