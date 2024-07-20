package com.sever.scoreboard;

import java.util.*;
import java.util.stream.Collectors;

public class WorldCupScoreBoard implements ScoreBoard {

    private Set<FootballMatch> matches = new HashSet<>();

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
    public FootballMatch startMatch(int id, Team homeTeam, Team awayTeam) {
        FootballMatch match = new FootballMatch(id, homeTeam, awayTeam);
        if(matches.stream()
                .flatMap(m -> Set.of(m.getAwayTeam(), m.getHomeTeam()).stream())
                .anyMatch(t -> t.equals(match.getAwayTeam()) || t.equals(match.getHomeTeam()))){
            throw new IllegalArgumentException("One of the teams is already participating in another match.");
        }
        matches.add(match);
        return match;
    }

    /**
     * End the match and remove it from the scoreboard.
     *
     * @param match the match to end.
     */
    @Override
    public void removeMatch(TeamSportMatch match) {
        matches.remove(match);
    }

    /**
     * Get the match with the given id.
     *
     * @param id the id of the match.
     * @return the match with the given id.
     */
    @Override
    public TeamSportMatch getMatch(int id) {
        return matches.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Get a summary of all currently in progress
     *
     * @return a collection of all matches on the scoreboard.
     */
    @Override
    public Collection<TeamSportMatch> getMatchSummary() {
        return matches.stream()
                .sorted(Comparator
                        .comparing(TeamSportMatch::getTotalScore)
                        .thenComparing(TeamSportMatch::getMatchStart)
                        .reversed())
                .collect(Collectors.toList());
    }
}
