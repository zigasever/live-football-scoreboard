package com.sever.scoreboard;

import java.util.*;

public class WorldCupScoreBoard implements ScoreBoard {

    private MatchDao matches;

    public WorldCupScoreBoard(MatchDao matches) {
        this.matches = matches;
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
    public FootballMatch startMatch(int id, Team homeTeam, Team awayTeam) {
        FootballMatch match = new FootballMatch(id, homeTeam, awayTeam);
        if(matches.getMatches().stream()
                .flatMap(m -> Set.of(m.getAwayTeam(), m.getHomeTeam()).stream())
                .anyMatch(t -> t.equals(match.getAwayTeam()) || t.equals(match.getHomeTeam()))){
            throw new IllegalArgumentException("One of the teams is already participating in another match.");
        }
        matches.addMatch(match);
        return match;
    }

    /**
     * End the match and remove it from the scoreboard.
     *
     * @param match the match to end.
     */
    @Override
    public void removeMatch(TeamSportMatch match) {
        matches.removeMatch(match);
    }

    /**
     * Get the match with the given id.
     *
     * @param id the id of the match.
     * @return the match with the given id.
     */
    @Override
    public TeamSportMatch getMatch(int id) {
        return matches.getMatchById(id)
                .orElse(null);
    }

    /**
     * Get a summary of all currently in progress
     *
     * @return a collection of all matches on the scoreboard.
     */
    @Override
    public Collection<TeamSportMatch> getMatchSummary() {
        return matches.getMatches().stream()
                .sorted(Comparator
                        .comparing(TeamSportMatch::getTotalScore)
                        .thenComparing(TeamSportMatch::getMatchStart)
                        .reversed())
                .toList();
    }
}
