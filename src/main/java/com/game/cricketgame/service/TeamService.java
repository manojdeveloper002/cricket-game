package com.game.cricketgame.service;

import com.game.cricketgame.entities.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {


    Team save(Team team);
    Team update(Team team);
    void delete(Long id);
    Team fetch(Long id);
    List<Team> fetchAll();
    List<Team> saveAll(List<Team> teamList);
}
