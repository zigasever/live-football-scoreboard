package com.sever.scoreboard;

import java.util.Collection;
import java.util.Optional;

public interface MatchDao {

    /**
     * Add a match to the storage.
     * @param match the match to add.
     */
    public void addMatch(TeamSportMatch match);

    /**
     * Remove a match from the storage.
     * @param match the match to remove.
     */
    public void removeMatch(TeamSportMatch match);

    /**
     * Get all matches in the storage.
     * @return a collection of all matches in the storage.
     */
    public Collection<TeamSportMatch> getMatches();

    /**
     * Get a match by its id.
     * @param id the id of the match.
     * @return the match with the given id.
     */
    public Optional<TeamSportMatch> getMatchById(int id);
}
