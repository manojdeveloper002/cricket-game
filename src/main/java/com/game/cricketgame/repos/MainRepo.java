package com.game.cricketgame.repos;

import com.game.cricketgame.entity.Main;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepo extends JpaRepository<Main, Integer> {
    Main findByName(String name);
}
