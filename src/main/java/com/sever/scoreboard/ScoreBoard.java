package com.sever.scoreboard;

import java.util.Collection;

public interface ScoreBoard {

    /**
     * Start a new match between the given teams.
     * @param id the id of the match.
     * @param homeTeam the home team.
     * @param awayTeam the away team.
     * @return the match that was started.
     */
    public TeamSportMatch startMatch(int id, Team homeTeam, Team awayTeam);

    /**
     * End the match and remove it from the scoreboard.
     * @param match the match to end.
     */
    public void removeMatch(TeamSportMatch match);

    /**
     * Get the match with the given id.
     * @param id the id of the match.
     * @return the match with the given id.
     */
    public TeamSportMatch getMatch(int id);

    /**
     * Get a summary of all currently in progress
     * @return a collection of all matches on the scoreboard.
     */
    public Collection<TeamSportMatch> getMatchSummary();


}
