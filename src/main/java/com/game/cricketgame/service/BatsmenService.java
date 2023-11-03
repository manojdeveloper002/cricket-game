package com.game.cricketgame.service;

import com.game.cricketgame.entities.Batsmen;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatsmenService {
    Batsmen save(Batsmen batsmen);
    Batsmen update(Batsmen batsmen);
    void delete(Long id);
    Batsmen fetch(Long id);
    List<Batsmen> fetchAll();
    List<Batsmen> saveAll(List<Batsmen> batsmenList);
}
