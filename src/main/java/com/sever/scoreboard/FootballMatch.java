package com.sever.scoreboard;

import java.time.LocalDateTime;

public class FootballMatch implements TeamSportMatch {

    private final Team homeTeam;
    private final Team awayTeam;
    private int homeScore = 0;
    private int awayScore = 0;
    private final LocalDateTime matchStart = LocalDateTime.now();

    public FootballMatch(Team homeTeam, Team awayTeam) {
        if(awayTeam == null || homeTeam == null){
            throw new IllegalArgumentException("Teams must be provided");
        }
        if(awayTeam.equals(homeTeam)){
            throw new IllegalArgumentException("Teams must be different");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }

    @Override
    public Team getAwayTeam() {
        return awayTeam;
    }

    @Override
    public int getHomeScore() {
        return homeScore;
    }

    @Override
    public int getAwayScore() {
        return awayScore;
    }

    @Override
    public void setScore(int homeScore, int awayScore) {
        if(homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Score cannot be updated to a negative number");
        }
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public int getTotalScore() {
        return homeScore + awayScore;
    }

    @Override
    public LocalDateTime getMatchStart() {
        return matchStart;
    }
}
