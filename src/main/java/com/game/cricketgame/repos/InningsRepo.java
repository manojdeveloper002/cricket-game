package com.game.cricketgame.repos;

import com.game.cricketgame.entities.Innings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InningsRepo extends JpaRepository<Innings, Long> {
}
