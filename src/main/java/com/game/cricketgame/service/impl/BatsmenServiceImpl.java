package com.game.cricketgame.service.impl;


import com.game.cricketgame.entities.Batsmen;
import com.game.cricketgame.repos.BatsmenRepo;
import com.game.cricketgame.service.BatsmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatsmenServiceImpl implements BatsmenService {
    @Autowired
    BatsmenRepo repo;

    @Override
    public Batsmen save(Batsmen batsmen) {
        return repo.save(batsmen);
    }

    @Override
    public Batsmen update(Batsmen batsmen) {
        Batsmen updatedData = repo.findById(batsmen.getId()).orElse(null);
        if(updatedData != null){
            repo.save(batsmen);
        }
        return batsmen;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Batsmen fetch(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Batsmen> fetchAll() {
        return repo.findAll();
    }

    @Override
    public List<Batsmen> saveAll(List<Batsmen> batsmen) {
        return repo.saveAll(batsmen);
    }
}
