package com.sever.scoreboard;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMatchStorage implements MatchDao {

    private Collection<TeamSportMatch> matches = ConcurrentHashMap.newKeySet();

    /**
     * Add a match to the storage.
     *
     * @param match the match to add.
     */
    @Override
    public void addMatch(TeamSportMatch match) {
        if(!matches.add(match)) {
            throw new IllegalArgumentException(String.format("Match with id %d already exists.", match.getId()));
        }
    }

    /**
     * Remove a match from the storage.
     *
     * @param match the match to remove.
     */
    @Override
    public void removeMatch(TeamSportMatch match) {
        matches.remove(match);
    }

    /**
     * Get all matches in the storage.
     *
     * @return a collection of all matches in the storage.
     */
    @Override
    public Collection<TeamSportMatch> getMatches() {
        return matches.stream().toList();
    }

    /**
     * Get a match by its id.
     *
     * @param id the id of the match.
     * @return the match with the given id.
     */
    @Override
    public Optional<TeamSportMatch> getMatchById(int id) {
        return matches.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
    }
}
