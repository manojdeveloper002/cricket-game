package com.game.cricketgame.controller;

import com.game.cricketgame.entities.OutCome;
import com.game.cricketgame.service.OutComeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outcome")
public class OutComeController {

    private static final Logger log = LoggerFactory.getLogger(OutComeController.class);

    @Autowired
    private OutComeService outComeService;

    @PostMapping("/add")
    public ResponseEntity<OutCome> addOutCome(@RequestBody OutCome outCome) throws Exception {
        try {
            return ResponseEntity.ok(outComeService.save(outCome));
        }catch(Exception e) {
            throw new Exception("Failed to Save OutCome"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<OutCome>> addAllOutCome(@RequestBody List<OutCome> outComeList) throws Exception {
        try {
            return ResponseEntity.ok(outComeService.saveAll(outComeList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all outCome"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<OutCome> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(outComeService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<OutCome>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(outComeService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            outComeService.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
