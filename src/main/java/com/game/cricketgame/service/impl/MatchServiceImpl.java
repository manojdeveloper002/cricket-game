package com.game.cricketgame.service.impl;

import com.game.cricketgame.entities.Match;
import com.game.cricketgame.repos.MatchRepo;
import com.game.cricketgame.service.MatchService;
import com.game.cricketgame.service.TeamService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepo repo;

    @Autowired
    private TeamService teamService;

    @Override
    public Match save(Match match) {
        return repo.save(match);
    }

    @Override
    public Match update(Match match) {
        Match updatedData = repo.findById(match.getId()).orElse(null);
        if(updatedData != null){
            repo.save(match);
        }
        return match;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Match fetch(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Match> fetchAll() {
        return repo.findAll();
    }

    @Override
    public List<Match> saveAll(List<Match> matchList) {
        return repo.saveAll(matchList);
    }

    @Override
    public Match createMatch(Match match) {
        if(match.getTeamA().getId() != null){
            match.setTeamA(teamService.fetch(match.getTeamA().getId()));
        }
        if(match.getTeamB().getId() != null){
            match.setTeamB(teamService.fetch(match.getTeamB().getId()));
        }
        return repo.save(match);
    }
}
