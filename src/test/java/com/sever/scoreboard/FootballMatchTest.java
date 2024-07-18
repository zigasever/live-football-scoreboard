package com.sever.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FootballMatchTest {

    @Test
    void testMatch() {
        Team team1 = new Team("Italy");
        Team team2 = new Team("Switzerland");
        FootballMatch match = new FootballMatch(team1, team2);
        assertEquals("Italy", match.getHomeTeam().getName());
        assertEquals("Switzerland", match.getAwayTeam().getName());
    }

    @Test
    void testMatchTotalScore() {
        Team team1 = new Team("Italy");
        Team team2 = new Team("Switzerland");
        FootballMatch match = new FootballMatch(team1, team2);
        match.setScore(1, 2);
        assertEquals(3, match.getTotalScore());
    }

    @Test
    void matchShouldStartwithZeroScore() {
        Team team1 = new Team("Italy");
        Team team2 = new Team("Switzerland");
        FootballMatch match = new FootballMatch(team1, team2);
        assertEquals(0, match.getAwayScore());
        assertEquals(0, match.getHomeScore());
    }

    @Test
    void teamShouldNotPlayItself() {
        Team team1 = new Team("Italy");
        try {
            new FootballMatch(team1, team1);
        } catch (IllegalArgumentException e) {
            assertEquals("Teams must be different", e.getMessage());
        }
    }

    @Test
    void teamsShouldNotBeNull() {
        try {
            new FootballMatch(null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Teams must be provided", e.getMessage());
        }
    }

    @Test
    void invalidScoreUpdate() {
        Team team1 = new Team("Italy");
        Team team2 = new Team("Switzerland");

        FootballMatch match = new FootballMatch(team1, team2);

        try {
            match.setScore(-1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("Score cannot be updated to a negative number", e.getMessage());
        }
    }
}
