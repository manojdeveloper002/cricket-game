package com.game.cricketgame.service;

import com.game.cricketgame.entity.Main;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService {

    Main saveMain(Main main);
    List<Main> saveAllMain(List<Main> mains);

    List<Main> getAllMain();

    Main getMainById(int id);

    Main getMainByName(String name);

    Main updateMain(Main main);
}
