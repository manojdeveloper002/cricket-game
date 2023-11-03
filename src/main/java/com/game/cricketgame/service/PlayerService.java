package com.game.cricketgame.service;

import com.game.cricketgame.entities.Players;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    Players savePlayers(Players players);
    Players updatePlayers(Players players);
    void deletePlayers(Long id);
    Players fetch(Long id);
    List<Players> fetchAll();
    List<Players> saveAllPlayers(List<Players> playersList);

}
