package com.game.cricketgame.repos;

import com.game.cricketgame.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
