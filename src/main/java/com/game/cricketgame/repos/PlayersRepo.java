package com.game.cricketgame.repos;

import com.game.cricketgame.entities.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepo extends JpaRepository<Players, Long> {
}
