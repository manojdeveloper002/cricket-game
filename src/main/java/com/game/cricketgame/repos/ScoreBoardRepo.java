package com.game.cricketgame.repos;

import com.game.cricketgame.entities.ScoreBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreBoardRepo extends JpaRepository<ScoreBoard, Long> {

    @Query("from ScoreBoard where match.id=:matchId")
    ScoreBoard findScoreBoardByMatchId(@Param("matchId") Long matchId);
}
