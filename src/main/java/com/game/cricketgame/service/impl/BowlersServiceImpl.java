package com.game.cricketgame.service.impl;


import com.game.cricketgame.entities.Bowlers;
import com.game.cricketgame.repos.BowlersRepo;
import com.game.cricketgame.service.BowlersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlersServiceImpl implements BowlersService{

    @Autowired
    BowlersRepo repo;

    @Override
    public Bowlers save(Bowlers bowlers) {
        return repo.save(bowlers);
    }

    @Override
    public Bowlers update(Bowlers bowlers) {
        Bowlers updatedData = repo.findById(bowlers.getId()).orElse(null);
        if(updatedData != null){
            repo.save(bowlers);
        }
        return bowlers;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Bowlers fetch(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Bowlers> fetchAll() {
        return repo.findAll();
    }

    @Override
    public List<Bowlers> saveAll(List<Bowlers> bowlers) {
        return repo.saveAll(bowlers);
    }
}
