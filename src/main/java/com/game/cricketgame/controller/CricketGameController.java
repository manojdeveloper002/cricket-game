package com.game.cricketgame.controller;

import com.game.cricketgame.model.Match;
import com.game.cricketgame.model.ScoreBoard;
import com.game.cricketgame.service.ScoreBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cricket-game")
public class CricketGameController {

    private static final Logger log = LoggerFactory.getLogger(CricketGameController.class);

    @Autowired
    private ScoreBoardService scoreBoardService;
    @PostMapping("/initiate-match")
    public ResponseEntity<ScoreBoard> initiateGame(@RequestBody Match match) throws Exception {
        try {
            return ResponseEntity.ok(scoreBoardService.InitiateMatch(match));
        }catch(Exception e) {
            throw new Exception("Failed to start Match"+ e.getMessage());
        }
    }

}
