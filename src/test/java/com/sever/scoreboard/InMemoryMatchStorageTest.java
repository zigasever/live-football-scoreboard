package com.sever.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryMatchStorageTest {

    private InMemoryMatchStorage inMemoryMatchStorage;

    @BeforeEach
    public void init() {
        inMemoryMatchStorage = new InMemoryMatchStorage();
    }

    @Test
    void testAdd_andRetrieveMatch() {
        int id = 1;
        Team team1 = new Team("Colombia");
        Team team2 = new Team("Ecuador");
        FootballMatch match = new FootballMatch(1, team1, team2);
        inMemoryMatchStorage.addMatch(match);
        assertEquals(match, inMemoryMatchStorage.getMatchById(id).get());
    }

    @Test
    void testRemoveMatch() {
        int id = 1;
        Team team1 = new Team("Colombia");
        Team team2 = new Team("Ecuador");
        FootballMatch match = new FootballMatch(1, team1, team2);
        inMemoryMatchStorage.addMatch(match);
        inMemoryMatchStorage.removeMatch(match);
        assertEquals(Optional.empty(), inMemoryMatchStorage.getMatchById(id));
    }

    @Test
    void testGetMatches() {
        FootballMatch match1 = new FootballMatch(1, new Team("Colombia"), new Team("Ecuador"));
        FootballMatch match2 = new FootballMatch(2, new Team("Brazil"), new Team("Mexico"));
        inMemoryMatchStorage.addMatch(match1);
        inMemoryMatchStorage.addMatch(match2);
        assertEquals(2, inMemoryMatchStorage.getMatches().size());
        assertEquals(List.of(match1, match2), inMemoryMatchStorage.getMatches());
    }

    @Test
    void twoMatchesWithSameId_shouldThrowException() {
        Team team1 = new Team("Colombia");
        Team team2 = new Team("Ecuador");
        FootballMatch match1 = new FootballMatch(1, team1, team2);
        FootballMatch match2 = new FootballMatch(1, team1, team2);
        inMemoryMatchStorage.addMatch(match1);
        assertThrows(IllegalArgumentException.class, () -> inMemoryMatchStorage.addMatch(match2));
    }

    @Test
    void nonExistantId_sohouldReturnEmpty() {
        assertEquals(Optional.empty(), inMemoryMatchStorage.getMatchById(1));
    }
}
