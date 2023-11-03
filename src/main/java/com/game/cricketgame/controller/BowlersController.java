package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Bowlers;
import com.game.cricketgame.service.BowlersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bowlers")
public class BowlersController {

    private static final Logger log = LoggerFactory.getLogger(BowlersController.class);

    @Autowired
    private BowlersService bowlersService;

    @PostMapping("/add")
    public ResponseEntity<Bowlers> addBowlers(@RequestBody Bowlers bowlers) throws Exception {
        try {
            return ResponseEntity.ok(bowlersService.save(bowlers));
        }catch(Exception e) {
            throw new Exception("Failed to Save Bowlers"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Bowlers>> addAllBowlers(@RequestBody List<Bowlers> bowlersList) throws Exception {
        try {
            return ResponseEntity.ok(bowlersService.saveAll(bowlersList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all bowlers"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Bowlers> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(bowlersService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<Bowlers>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(bowlersService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            bowlersService.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
