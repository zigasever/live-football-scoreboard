package com.sever.scoreboard;

import java.time.LocalDateTime;
import java.util.Objects;

public class FootballMatch implements TeamSportMatch {

    private final int id;
    private final Team homeTeam;
    private final Team awayTeam;
    private int homeScore = 0;
    private int awayScore = 0;
    private final LocalDateTime matchStart = LocalDateTime.now();

    /**
     * Create a new football match with the given teams.
     * @param id the unique identifier of the match.
     * @param homeTeam the home team.
     * @param awayTeam the away team.
     */
    public FootballMatch(int id, Team homeTeam, Team awayTeam) {
        if(awayTeam == null || homeTeam == null){
            throw new IllegalArgumentException("Teams must be provided");
        }
        if(awayTeam.equals(homeTeam)){
            throw new IllegalArgumentException("Teams must be different");
        }
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    /**
     * Get the unique identifier of the match.
     * @return the unique identifier of the match.
     */
    @Override
    public int getId() {
        return 0;
    }

    /**
     * Get the home team.
     * @return the home team.
     */
    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * Get the away team.
     * @return the away team.
     */
    @Override
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * Get the score of the home team.
     * @return the score of the home team.
     */
    @Override
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * Get the score of the away team.
     * @return the score of the away team.
     */
    @Override
    public int getAwayScore() {
        return awayScore;
    }

    /**
     * Set the score of the match.
     * @param homeScore the score of the home team.
     * @param awayScore the score of the away team.
     */
    @Override
    public void setScore(int homeScore, int awayScore) {
        if(homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Score cannot be updated to a negative number");
        }
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    /**
     * Get the total score of the match.
     * @return the total score of the match.
     */
    @Override
    public int getTotalScore() {
        return homeScore + awayScore;
    }

    /**
     * Get the start time of the match.
     * @return the start time of the match.
     */
    @Override
    public LocalDateTime getMatchStart() {
        return matchStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballMatch that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
