package com.game.cricketgame.controller;

import com.game.cricketgame.entities.ScoreBoard;
import com.game.cricketgame.service.ScoreBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scoreboard")
public class ScoreBoardController {

    private static final Logger log = LoggerFactory.getLogger(ScoreBoardController.class);

    @Autowired
    private ScoreBoardService scoreBoardService;

    @PostMapping("/add")
    public ResponseEntity<ScoreBoard> addScoreBoard(@RequestBody ScoreBoard scoreBoard) throws Exception {
        try {
            return ResponseEntity.ok(scoreBoardService.save(scoreBoard));
        }catch(Exception e) {
            throw new Exception("Failed to Save ScoreBoard"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<ScoreBoard>> addAllScoreBoard(@RequestBody List<ScoreBoard> scoreBoardList) throws Exception {
        try {
            return ResponseEntity.ok(scoreBoardService.saveAll(scoreBoardList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all scoreBoard"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<ScoreBoard> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(scoreBoardService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<ScoreBoard>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(scoreBoardService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            scoreBoardService.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
