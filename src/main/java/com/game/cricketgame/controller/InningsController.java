package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Innings;
import com.game.cricketgame.service.InningsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/innings")
public class InningsController {

    private static final Logger log = LoggerFactory.getLogger(InningsController.class);

    @Autowired
    private InningsService inningsService;

    @PostMapping("/add")
    public ResponseEntity<Innings> addInnings(@RequestBody Innings innings) throws Exception {
        try {
            return ResponseEntity.ok(inningsService.save(innings));
        }catch(Exception e) {
            throw new Exception("Failed to Save Innings"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Innings>> addAllInnings(@RequestBody List<Innings> inningsList) throws Exception {
        try {
            return ResponseEntity.ok(inningsService.saveAll(inningsList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all innings"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Innings> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(inningsService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<Innings>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(inningsService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            inningsService.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
