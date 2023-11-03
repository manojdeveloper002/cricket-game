package com.game.cricketgame.controller;

import com.game.cricketgame.entity.Main;
import com.game.cricketgame.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main-test")
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private MainService mainService;
    @PostMapping("/create/main")
    public Main insertMain(@RequestBody Main main){
        return mainService.saveMain(main);
    }

    @PostMapping("/create/main/all")
    public List<Main> insertAllMain(@RequestBody List<Main> main){
        return mainService.saveAllMain(main);
    }

    @GetMapping("/ main/{id}")
    public Main fetchMain(@PathVariable int id){
        return mainService.getMainById(id);
    }

    @GetMapping("/main/all")
    public List<Main> fetchAllMain(@PathVariable int id){
        return mainService.getAllMain();
    }
}
