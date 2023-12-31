package com.game.cricketgame.service;

import org.springframework.stereotype.Service;

@Service
public interface RandomNumberService {

    Integer randomOutcomeWithEight();

    Integer randomOutcomeWithRange(int start, int end);
}
