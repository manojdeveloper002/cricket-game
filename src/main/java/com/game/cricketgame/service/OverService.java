package com.game.cricketgame.service;


import com.game.cricketgame.entities.Over;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OverService {

    Over save(Over over);
    Over update(Over over);
    void delete(Long id);
    Over fetch(Long id);
    List<Over> fetchAll();
    List<Over> saveAll(List<Over> overList);
}
