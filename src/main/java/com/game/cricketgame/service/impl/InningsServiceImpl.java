package com.game.cricketgame.service.impl;

import com.game.cricketgame.entities.Innings;
import com.game.cricketgame.repos.InningsRepo;
import com.game.cricketgame.service.InningsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InningsServiceImpl implements InningsService {

    private static final Logger log = LoggerFactory.getLogger(InningsServiceImpl.class);

    @Autowired
    private InningsRepo repo;

    private static final int oversBalls = 6;
    @Override
    public Innings createInnings(Integer oversNo, String inningsName, String battingTeam) {
        log.info("Creating innings oversNo "+oversNo+" innings name "+ inningsName+" battingTeam "+battingTeam);
        Innings ing = new Innings();
        ing.setOvers(oversNo);
        ing.setTotalBalls(oversNo * oversBalls);
        ing.setName(inningsName);
        ing.setBattingTeam(battingTeam);
        return ing;
    }

    @Override
    public Innings save(Innings ing) {
        return repo.save(ing);
    }

    @Override
    public Innings update(Innings ing) {
        Innings updatedData = repo.findById(ing.getId()).orElse(null);
        if(updatedData != null){
            repo.save(ing);
        }
        return ing;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Innings fetch(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Innings> fetchAll() {
        return repo.findAll();
    }

    @Override
    public List<Innings> saveAll(List<Innings> ingList) {
        return repo.saveAll(ingList);
    }
}
