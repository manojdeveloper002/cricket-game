package com.game.cricketgame.service.impl;

import com.game.cricketgame.entities.Players;
import com.game.cricketgame.repos.PlayersRepo;
import com.game.cricketgame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayersRepo playersRepo;
    @Override
    public Players savePlayers(Players players) {
        return playersRepo.save(players);
    }

    @Override
    public Players updatePlayers(Players players) {
        Players updatedPlayer = playersRepo.findById(players.getId()).orElse(null);
        if(updatedPlayer != null){
            playersRepo.save(players);
        }
        return players;
    }

    @Override
    public void deletePlayers(Long id) {
        playersRepo.deleteById(id);
    }

    @Override
    public Players fetch(Long id) {
        return playersRepo.findById(id).orElse(null);
    }

    @Override
    public List<Players> fetchAll() {
        return playersRepo.findAll();
    }

    @Override
    public List<Players> saveAllPlayers(List<Players> playersList) {
        return playersRepo.saveAll(playersList);
    }
}
