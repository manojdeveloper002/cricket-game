package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Match;
import com.game.cricketgame.entities.Players;
import com.game.cricketgame.entities.ScoreBoard;
import com.game.cricketgame.service.MatchService;
import com.game.cricketgame.service.ScoreBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cricket-game")
public class CricketGameController {

    private static final Logger log = LoggerFactory.getLogger(CricketGameController.class);

    @Autowired
    private ScoreBoardService scoreBoardService;
    @Autowired
    private MatchService matchService;

    @PostMapping("/initiate-match")
    public ResponseEntity<ScoreBoard> initiateGame(@RequestBody Match match) throws Exception {
        try {
            return ResponseEntity.ok(scoreBoardService.InitiateMatch(match));
        }catch(Exception e) {
            throw new Exception("Failed to start Match"+ e.getMessage());
        }
    }

    @PostMapping("/initiate-match/{id}")
    public ResponseEntity<Object> initiateGame(@PathVariable Long id) throws Exception {
        try {
            ScoreBoard sc = new ScoreBoard();
            if(scoreBoardService.checkMatchExited(id) == null){
                if(matchService.fetch(id) != null){
                    sc = scoreBoardService.InitiateMatch(id);
                }else{
                    return ResponseEntity.ok("Match Not Found");
                }
            }else{
                return ResponseEntity.ok("Match Already Played");
            }
            return ResponseEntity.ok(sc);
        }catch(Exception e) {
            throw new Exception("Failed to start Match"+ e.getMessage());
        }
    }


}
