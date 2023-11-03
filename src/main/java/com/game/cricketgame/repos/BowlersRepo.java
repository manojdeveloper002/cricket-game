package com.game.cricketgame.repos;


import com.game.cricketgame.entities.Bowlers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BowlersRepo extends JpaRepository<Bowlers, Long> {
}
