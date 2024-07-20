package com.sever.scoreboard;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class InMemoryMatchStorage implements MatchDao {

    /**
     * Add a match to the storage.
     *
     * @param match the match to add.
     */
    @Override
    public void addMatch(TeamSportMatch match) {

    }

    /**
     * Remove a match from the storage.
     *
     * @param match the match to remove.
     */
    @Override
    public void removeMatch(TeamSportMatch match) {

    }

    /**
     * Get all matches in the storage.
     *
     * @return a collection of all matches in the storage.
     */
    @Override
    public Collection<TeamSportMatch> getMatches() {
        return List.of();
    }

    /**
     * Get a match by its id.
     *
     * @param id the id of the match.
     * @return the match with the given id.
     */
    @Override
    public Optional<TeamSportMatch> getMatchById(int id) {
        return null;
    }
}
