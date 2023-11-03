package com.game.cricketgame.service.impl;

import com.game.cricketgame.enums.ExtraType;
import com.game.cricketgame.enums.WicketType;
import com.game.cricketgame.model.*;
import com.game.cricketgame.service.InningsService;
import com.game.cricketgame.service.RandomNumberService;
import com.game.cricketgame.service.ScoreBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {
    private static final Logger log = LoggerFactory.getLogger(ScoreBoardServiceImpl.class);

    @Autowired
    InningsService inningsService;

    @Autowired
    RandomNumberService randomNumberService;
    BiPredicate<Integer, Integer> firstInningsWon = (scoreOne, scoreTwo) -> scoreOne >  scoreTwo;
    BiPredicate<Integer, Integer> secondInningsWon = (scoreOne, scoreTwo) -> scoreOne < scoreTwo;

    private static final int bowlersLimit = 5;
    private static final int overBalls = 6;
    private static final int zero = 0;
    private static final int one = 1;
    private static final int out = 7;


    @Override
    public ScoreBoard InitiateMatch(Match match) {
        log.info("Game Started");

        Innings firstInnings = startInnings(match, "1stInnings", match.getTeamA().getName(), match.getTeamA().getPlayersList(),
                match.getTeamB().getPlayersList(), false, 0);
        log.info("FirstInnings Over");
        Innings secondInnings = startInnings(match, "2ndInnings", match.getTeamB().getName(), match.getTeamB().getPlayersList(),
                match.getTeamA().getPlayersList(), true, firstInnings.getTotalScore());
        log.info("SecondInnings Over");
        ScoreBoard sc = createScoreBoard(match, firstInnings, secondInnings);

        sc.getInningsList().addAll(Arrays.asList(firstInnings, secondInnings));
        log.info("ScoreBoard is Ready");

        return sc;

    }

    private ScoreBoard createScoreBoard(Match match, Innings firstInnings, Innings secondInnings){
        ScoreBoard sc = new ScoreBoard();
        sc.setMatch(match);
        if (firstInningsWon.test(firstInnings.getTotalScore(), secondInnings.getTotalScore())) {
            sc.setResult(firstInnings.getBattingTeam() + " Won by " + (firstInnings.getTotalScore() - secondInnings.getTotalScore()) + " runs");
            sc.setDesc(fetchString(firstInnings, secondInnings));
        } else if (secondInningsWon.test(firstInnings.getTotalScore(), secondInnings.getTotalScore())) {
            sc.setResult(secondInnings.getBattingTeam() + " Won by " + secondInnings.getRemainingWickets() + " wickets");
            sc.setDesc(fetchString(firstInnings, secondInnings)+" ::: (" + secondInnings.getRemainingBalls() + " balls Left)");
        } else {
            sc.setResult("Draw");
            sc.setDesc(fetchString(firstInnings, secondInnings));
        }
        sc.setName(match.getName()+" Result");
        sc.setCode(match.getCode()+match.getName());
        return sc;
    }

    private String fetchString(Innings firstInnings, Innings secondInnings){
        return firstInnings.getBattingTeam()+" : "+firstInnings.getTotalScore()+"-"+firstInnings.getTotalWickets()+" [Balls: "+firstInnings.getBallsUsed()+"]"+
                ":::"+secondInnings.getBattingTeam()+":"+secondInnings.getTotalScore()+"-"+secondInnings.getTotalWickets()+" [Balls : "+secondInnings.getBallsUsed()+" ]";
    }

    private Innings startInnings(Match match, String inningsName, String battingTeam, List<Players> batsmenList,
                         List<Players> bowlersList, Boolean isChaser, Integer chasingScore){
        log.info("startInnings "+ inningsName+" overs "+match.getTotalOverByMatchType());
        Innings ing = inningsService.createInnings(match.getTotalOverByMatchType(), inningsName, battingTeam);
        log.info("Innings Created ");
        return matchInitiated(ing, batsmenList, bowlersList, isChaser, chasingScore);
    }

    private Innings matchInitiated(Innings ing, List<Players> batsmenList, List<Players> bowlersList, Boolean isChaser, int chasingScore) {
        int bowlOrd = one;
        int bowlerChange = (int)Math.ceil((double) ing.getOvers() /Math.min(bowlersList.size(), bowlersLimit)) * overBalls;
        int wickets = batsmenList.size();
        log.info("Match Initiated wickets:"+wickets+" bowlerChange: "+ bowlerChange);

        Batsmen batsman = nextBatsmen(batsmenList, wickets, batsmenList.size());
        Bowlers bowler = changeBowler(bowlersList, bowlOrd, bowlersList.size());

        int overChanger = overBalls;
        Over overs = new Over();

        for (int balls = one; balls <= ing.getTotalBalls(); balls++){
            if(wickets == zero){
                break;
            }
            OutCome oc = new OutCome();
            ing.setRemainingBalls(ing.getTotalBalls()-balls);
            ing.setBallsUsed(balls);
            batsman.setBallsPlayed(batsman.getBallsPlayed() + one);
            bowler.setBalls(bowler.getBalls()+one);
            int outcome = randomNumberService.randomOutcomeWithEight();
            log.info("outcome :::: "+outcome);
            if(outcome == out || outcome == out+one){
                bowler.setWickets(bowler.getWickets()+one);
                oc.setOutcome(zero);
                oc.setWicketType(WicketType.WICKET);
                oc.setExtraType(ExtraType.NONE);
                oc.setCurrentRuns(ing.getTotalScore());
                --wickets;
                log.info("wickets :::: "+wickets);
                if(wickets == zero){
                    break;
                }
                ing.getBatsmenList().add(batsman);
                batsman = nextBatsmen(batsmenList, wickets, batsmenList.size());
                overs.setOverWickets(overs.getOverWickets() + one);
            }else {
                batsman.setScored(batsman.getScored() + outcome);
                bowler.setRuns(bowler.getRuns() + outcome);
                ing.setTotalScore(ing.getTotalScore() + outcome);
                oc.setOutcome(outcome);
                oc.setWicketType(WicketType.NONE);
                oc.setExtraType(ExtraType.NONE);
                oc.setCurrentRuns(ing.getTotalScore());
                overs.setOverRuns(overs.getOverRuns() + outcome);

            }
            overs.getOutComesList().add(oc);

            if (isChaser) {
                if (ing.getTotalScore() > chasingScore) {
                    log.info("Is chaser Total Score"+ing.getTotalScore()+" chasingScore "+chasingScore);
                    break;
                }
            }

            if(overChanger == balls){
                log.info("overChanger overChanger "+overChanger+" balls "+balls);
                overChanger += overBalls;
                ing.getOversList().add(overs);
                overs = new Over();
            }
            if(bowlerChange == balls){
                log.info("bowlerChange bowlerChange "+bowlerChange+" balls "+balls);
                bowlerChange += bowlerChange;
                ing.getBowlersList().add(bowler);
                ++bowlOrd;
                bowler = changeBowler(bowlersList, bowlOrd, bowlersList.size());
            }
        }
        ing.getBowlersList().add(bowler);
        ing.getBatsmenList().add(batsman);
        ing.getOversList().add(overs);
        ing.setTotalWickets(batsmenList.size()- wickets);
        ing.setRemainingWickets(batsmenList.size() - (batsmenList.size()- wickets));
        log.info("Innings Completed");
        return ing;
    }

    Batsmen nextBatsmen(List<Players> batsmenList, Integer max, Integer total){
        log.info("Next Batsmen max:"+max+" total: "+ total);
        Batsmen bm = new Batsmen();
        bm.setPlayers(batsmenList.get(total - max));
        log.info("Next Batsmen "+bm.getPlayers().getName());
        return bm;
    }

    Bowlers changeBowler(List<Players> bowlersList,Integer bowlOrd, Integer total){
        log.info("Changed bowler bowlOrd:"+bowlOrd+" total: "+ total);
        Bowlers bw = new Bowlers();
        bw.setPlayers(bowlersList.get(total - bowlOrd));
        log.info("changed bowler "+bw.getPlayers().getName());
        return bw;
    }
}
