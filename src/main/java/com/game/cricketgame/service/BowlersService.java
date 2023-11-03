package com.game.cricketgame.service;

import com.game.cricketgame.entities.Bowlers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BowlersService {
    Bowlers save(Bowlers bowlers);
    Bowlers update(Bowlers bowlers);
    void delete(Long id);
    Bowlers fetch(Long id);
    List<Bowlers> fetchAll();
    List<Bowlers> saveAll(List<Bowlers> bowlersList);
}
