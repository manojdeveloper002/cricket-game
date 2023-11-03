package com.game.cricketgame.repos;

import com.game.cricketgame.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match, Long> {
}
