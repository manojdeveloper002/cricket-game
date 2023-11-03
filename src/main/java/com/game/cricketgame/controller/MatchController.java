package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Match;
import com.game.cricketgame.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private static final Logger log = LoggerFactory.getLogger(MatchController.class);
    @Autowired
    private MatchService matchService;


    @PostMapping("/add")
    public ResponseEntity<Match> addMatch(@RequestBody Match match) throws Exception {
        try {
            return ResponseEntity.ok(matchService.save(match));
        }catch(Exception e) {
            throw new Exception("Failed to Save Match"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Match>> addAllMatch(@RequestBody List<Match> matchList) throws Exception {
        try {
            return ResponseEntity.ok(matchService.saveAll(matchList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all match"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Match> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(matchService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<Match>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(matchService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            matchService.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Match> create(@RequestBody Match match) throws Exception {
        try {
            return ResponseEntity.ok(matchService.createMatch(match));
        }catch(Exception e) {
            throw new Exception("Failed to Save Match"+ e.getMessage());
        }
    }
}
