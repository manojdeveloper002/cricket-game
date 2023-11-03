package com.game.cricketgame.service.impl;

import com.game.cricketgame.entities.Over;
import com.game.cricketgame.repos.OverRepo;
import com.game.cricketgame.service.OverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverServiceImpl implements OverService {

    @Autowired
    OverRepo repo;

    @Override
    public Over save(Over over) {
        return repo.save(over);
    }

    @Override
    public Over update(Over over) {
        Over updatedData = repo.findById(over.getId()).orElse(null);
        if(updatedData != null){
            repo.save(over);
        }
        return updatedData;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Over fetch(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Over> fetchAll() {
        return repo.findAll();
    }

    @Override
    public List<Over> saveAll(List<Over> over) {
        return repo.saveAll(over);
    }
}
