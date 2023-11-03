package com.game.cricketgame.service.impl;

import com.game.cricketgame.entities.Players;
import com.game.cricketgame.entities.Team;
import com.game.cricketgame.repos.TeamRepo;
import com.game.cricketgame.service.PlayerService;
import com.game.cricketgame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    
    @Autowired
    TeamRepo repo;

    @Autowired
    PlayerService playerService;

    @Override
    public Team save(Team team) {
        List<Players> oldPlayers = new ArrayList<>();
        List<Players> existingPlayer = new ArrayList<>();
        existingPlayer.addAll(team.getPlayersList());
        for(Players players : team.getPlayersList()){
            if(players.getId() != null){
                Players playersData = playerService.fetch(players.getId());
                if(playersData != null) {
                    oldPlayers.add(playersData);
                    existingPlayer.remove(players);
                }
            }
        }
        oldPlayers.addAll(existingPlayer);
        team.getPlayersList().clear();
        team.getPlayersList().addAll(oldPlayers);
        return repo.save(team);
    }

    @Override
    public Team update(Team team) {
        Team updatedData = repo.findById(team.getId()).orElse(null);
        if(updatedData != null){
            repo.save(team);
        }
        return team;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Team fetch(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Team> fetchAll() {
        return repo.findAll();
    }

    @Override
    public List<Team> saveAll(List<Team> team) {
        return repo.saveAll(team);
    }
}
