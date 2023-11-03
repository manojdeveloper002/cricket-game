package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Players;
import com.game.cricketgame.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    public ResponseEntity<Players> addPlayers(@RequestBody Players players) throws Exception {
        try {
            return ResponseEntity.ok(playerService.savePlayers(players));
        }catch(Exception e) {
            throw new Exception("Failed to Save Players"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Players>> addAllPlayers(@RequestBody List<Players> playersList) throws Exception {
        try {
            return ResponseEntity.ok(playerService.saveAllPlayers(playersList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all players"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Players> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(playerService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<Players>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(playerService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            playerService.deletePlayers(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
