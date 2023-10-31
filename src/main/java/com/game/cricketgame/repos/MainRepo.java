package com.game.cricketgame.repos;

import com.game.cricketgame.entities.Main;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepo extends JpaRepository<Main, Integer> {
    Main findByName(String name);
}
