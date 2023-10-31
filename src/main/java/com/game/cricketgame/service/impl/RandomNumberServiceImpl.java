package com.game.cricketgame.service.impl;


import com.game.cricketgame.service.RandomNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    private static final Logger log = LoggerFactory.getLogger(RandomNumberServiceImpl.class);
    private static final int EIGHT = 8;
    @Override
    public Integer randomOutcomeWithEight() {
        Random rand = new Random();
        return rand.nextInt(EIGHT);
    }
}
