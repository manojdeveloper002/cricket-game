package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Batsmen;
import com.game.cricketgame.service.BatsmenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batsmen")
public class BatsmenController {

    private static final Logger log = LoggerFactory.getLogger(BatsmenController.class);

    @Autowired
    private BatsmenService batsmenService;

    @PostMapping("/add")
    public ResponseEntity<Batsmen> addBatsmen(@RequestBody Batsmen batsmen) throws Exception {
        try {
            return ResponseEntity.ok(batsmenService.save(batsmen));
        }catch(Exception e) {
            throw new Exception("Failed to Save Batsmen"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Batsmen>> addAllBatsmen(@RequestBody List<Batsmen> batsmenList) throws Exception {
        try {
            return ResponseEntity.ok(batsmenService.saveAll(batsmenList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all batsmen"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Batsmen> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(batsmenService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<Batsmen>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(batsmenService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            batsmenService.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
