package com.game.cricketgame.repos;


import com.game.cricketgame.entities.Batsmen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatsmenRepo extends JpaRepository<Batsmen, Long> {
}
