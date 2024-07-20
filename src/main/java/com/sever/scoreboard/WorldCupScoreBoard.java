package com.sever.scoreboard;

import java.util.Collection;
import java.util.List;

public class WorldCupScoreBoard implements ScoreBoard {

    public WorldCupScoreBoard() {
    }

    /**
     * Start a new match between the given teams.
     *
     * @param id       the id of the match.
     * @param homeTeam the home team.
     * @param awayTeam the away team.
     * @return the match that was started.
     */
    @Override
    public TeamSportMatch startMatch(int id, Team homeTeam, Team awayTeam) {
        return null;
    }

    /**
     * End the match and remove it from the scoreboard.
     *
     * @param match the match to end.
     */
    @Override
    public void removeMatch(TeamSportMatch match) {

    }

    /**
     * Get the match with the given id.
     *
     * @param id the id of the match.
     * @return the match with the given id.
     */
    @Override
    public TeamSportMatch getMatch(int id) {
        return null;
    }

    /**
     * Get a summary of all currently in progress
     *
     * @return a collection of all matches on the scoreboard.
     */
    @Override
    public Collection<TeamSportMatch> getMatchSummary() {
        return List.of();
    }
}
