package com.sever.scoreboard;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WorldCupScoreboardTest {

    private WorldCupScoreBoard createScoreboard() {
        return new WorldCupScoreBoard();
    }

    @Test
    void testAddStartMatch() {
        WorldCupScoreBoard scoreboard = createScoreboard();
        TeamSportMatch match = scoreboard.startMatch(1, new Team("Ecuador"), new Team("Colombia"));
        assertEquals(match, scoreboard.getMatch(1));
    }

    @Test
    void teamShoudNotPlayItself() {
        WorldCupScoreBoard scoreboard = createScoreboard();
        try {
            scoreboard.startMatch(1, new Team("Ecuador"), new Team("Ecuador"));
        } catch (IllegalArgumentException e) {
            assertEquals("Teams must be different", e.getMessage());
        }
    }

    @Test
    void teamsShouldBeValid() {
        WorldCupScoreBoard scoreboard = createScoreboard();
        try {
            scoreboard.startMatch(1, null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Teams must be provided", e.getMessage());
        }

        try {
            scoreboard.startMatch(1, new Team("Ecuador"), null);
        } catch (IllegalArgumentException e) {
            assertEquals("Teams must be provided", e.getMessage());
        }

        try {
            scoreboard.startMatch(1, new Team("Colombia"), new Team(""));
        } catch (IllegalArgumentException e) {
            assertEquals("Team name must be provided.", e.getMessage());
        }
    }

    @Test
    void removeMatch_shouldRemoveMatch() {
        int matchId = 1;
        WorldCupScoreBoard scoreboard = createScoreboard();
        TeamSportMatch match = scoreboard.startMatch(matchId, new Team("Ecuador"), new Team("Colombia"));
        scoreboard.removeMatch(match);
        assertEquals(null, scoreboard.getMatch(matchId));
    }

    private void mockStartTime(TeamSportMatch match, int delay) {
        Field matchStartField = ReflectionUtils
                .findFields(FootballMatch.class, f -> f.getName().equals("matchStart"),
                        ReflectionUtils.HierarchyTraversalMode.BOTTOM_UP)
                .get(0);
        matchStartField.setAccessible(true);
        try {
            matchStartField.set(match, LocalDateTime.now().plusMinutes(delay));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMatchSummary_shouldReturnInCorrectOrder() {
        WorldCupScoreBoard scoreboard = createScoreboard();
        int delayMinute = 0;
        TeamSportMatch match1 = scoreboard.startMatch(1, new Team("Mexico"), new Team("Canada"));
        match1.setScore(0, 5);
        mockStartTime(match1, delayMinute++);
        TeamSportMatch match2 = scoreboard.startMatch(2, new Team("Spain"), new Team("Brazil"));
        match2.setScore(10, 2);
        mockStartTime(match2, delayMinute++);
        TeamSportMatch match3 = scoreboard.startMatch(3, new Team("Germany"), new Team("France"));
        match3.setScore(2, 2);
        mockStartTime(match3, delayMinute++);
        TeamSportMatch match4 = scoreboard.startMatch(4, new Team("Uruguay"), new Team("Italy"));
        match4.setScore(6, 6);
        mockStartTime(match4, delayMinute++);
        TeamSportMatch match5 = scoreboard.startMatch(5, new Team("Argentina"), new Team("Australia"));
        match5.setScore(3, 1);
        mockStartTime(match5, delayMinute);

        final Collection correctOrder = List.of(match4, match2, match1, match5, match3);

        assertEquals(correctOrder, scoreboard.getMatchSummary());
    }

    @Test
    void teamShouldNotPlayMultipleMatchesAtOnce () {
        WorldCupScoreBoard scoreboard = createScoreboard();
        scoreboard.startMatch(1, new Team("Mexico"), new Team("Canada"));

        Team t1 = new Team("Mexico");
        Team t2 = new Team("Brazil");

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> scoreboard.startMatch(2, t1, t2),
                "Expected startMatch() to throw IllegalArgumentException, but nothing was thrown.");

        assertEquals("One of the teams is already participating in another match.", e.getMessage());

    }

    @Test
    void matchesShouldHaveUniqueIds() {
        WorldCupScoreBoard scoreboard = createScoreboard();
        scoreboard.startMatch(1, new Team("Mexico"), new Team("Canada"));

        Team t1 = new Team("Brazil");
        Team t2 = new Team("Argentina");

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> scoreboard.startMatch(1, t1, t2),
                "Expected startMatch() to throw IllegalArgumentException, but nothing was thrown.");

        assertEquals("Match with id 1 already exists.", e.getMessage());
    }


}
