package com.game.cricketgame.service.impl;

import com.game.cricketgame.entities.OutCome;
import com.game.cricketgame.repos.OutComeRepo;
import com.game.cricketgame.service.OutComeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutComeServiceImpl implements OutComeService {


    @Autowired
    OutComeRepo repo;

    @Override
    public OutCome save(OutCome outCome) {
        return repo.save(outCome);
    }

    @Override
    public OutCome update(OutCome outCome) {
        OutCome updatedData = repo.findById(outCome.getId()).orElse(null);
        if(updatedData != null){
            repo.save(outCome);
        }
        return updatedData;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public OutCome fetch(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<OutCome> fetchAll() {
        return repo.findAll();
    }

    @Override
    public List<OutCome> saveAll(List<OutCome> outCome) {
        return repo.saveAll(outCome);
    }
}
