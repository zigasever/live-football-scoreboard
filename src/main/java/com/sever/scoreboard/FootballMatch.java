package com.sever.scoreboard;

import java.time.LocalDateTime;

public class FootballMatch implements TeamSportMatch {

    public FootballMatch(Team homeTeam, Team awayTeam) {

    }

    @Override
    public Team getHomeTeam() {
        return null;
    }

    @Override
    public Team getAwayTeam() {
        return null;
    }

    @Override
    public int getHomeScore() {
        return 0;
    }

    @Override
    public int getAwayScore() {
        return 0;
    }

    @Override
    public void setScore(int homeScore, int awayScore) {

    }

    @Override
    public int getTotalScore() {
        return 0;
    }

    @Override
    public LocalDateTime getMatchStart() {
        return null;
    }
}
