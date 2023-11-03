package com.game.cricketgame.controller;

import com.game.cricketgame.entities.Team;
import com.game.cricketgame.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public ResponseEntity<Team> addTeam(@RequestBody Team team) throws Exception {
        try {
            return ResponseEntity.ok(teamService.save(team));
        }catch(Exception e) {
            throw new Exception("Failed to Save Team"+ e.getMessage());
        }
    }

    @PostMapping("/add-all")
    public ResponseEntity<List<Team>> addAllTeam(@RequestBody List<Team> teamList) throws Exception {
        try {
            return ResponseEntity.ok(teamService.saveAll(teamList));
        }catch(Exception e) {
            throw new Exception("Failed to Save all team"+ e.getMessage());
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Team> fetch(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(teamService.fetch(id));
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<Team>> fetchAll() throws Exception {
        try {
            return ResponseEntity.ok(teamService.fetchAll());
        }catch(Exception e) {
            throw new Exception("Failed to fetch all"+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        try {
            teamService.delete(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch(Exception e) {
            throw new Exception("Failed to fetch"+ e.getMessage());
        }
    }
}
