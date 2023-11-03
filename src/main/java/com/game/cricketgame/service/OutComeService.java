package com.game.cricketgame.service;

import com.game.cricketgame.entities.OutCome;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OutComeService {
    OutCome save(OutCome outCome);
    OutCome update(OutCome outCome);
    void delete(Long id);
    OutCome fetch(Long id);
    List<OutCome> fetchAll();
    List<OutCome> saveAll(List<OutCome> outComeList);
}
