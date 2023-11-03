package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Over;
import com.game.cricketgame.service.OverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/over")
public class OverController {

    private static final Logger log = LoggerFactory.getLogger(OverController.class);

    @Autowired
    private OverService OverServicetCome;

    @PostMapping("/add")
    public ResponseEntity<Over> addOver(@RequestBody Over over) throws Exception {
        try {
            return ResponseEntity.ok(OverServicetCome.save(over));
        }catch(Exception e) {
            throw new Exception("Failed to Save Over"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Over>> addAllOver(@RequestBody List<Over> overList) throws Exception {
        try {
            return ResponseEntity.ok(OverServicetCome.saveAll(overList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all over"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Over> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(OverServicetCome.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<Over>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(OverServicetCome.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            OverServicetCome.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
