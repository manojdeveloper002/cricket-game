package com.game.cricketgame.service.impl;

import com.game.cricketgame.entities.Main;
import com.game.cricketgame.repos.MainRepo;
import com.game.cricketgame.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private MainRepo mainRepo;

    public Main saveMain(Main main){
        return mainRepo.save(main);
    }
    public List<Main> saveAllMain(List<Main> mains){
        return mainRepo.saveAll(mains);
    }

    public List<Main> getAllMain(){
        return mainRepo.findAll();
    }

    public Main getMainById(int id){
        return mainRepo.findById(id).orElse(null);
    }

    public Main getMainByName(String name){
        return mainRepo.findByName(name);
    }

    public Main updateMain(Main main){
        Main mainUpdate = mainRepo.findById(main.getId()).orElse(null);
        if (mainUpdate != null) {
            mainUpdate.setName(main.getName());
            mainRepo.save(mainUpdate);
        }
        return mainUpdate;
    }



}
