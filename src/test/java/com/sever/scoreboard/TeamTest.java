package com.sever.scoreboard;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TeamTest {

    @Test
    void testTeamName() {
        Team team = new Team("CE");
        assertEquals("CE", team.getName());
    }

    @Test
    void testInvalidTeamName() {
        assertThrows(IllegalArgumentException.class, () -> new Team(null));
        assertThrows(IllegalArgumentException.class, () -> new Team(""));
        assertThrows(IllegalArgumentException.class, () -> new Team(" "));
    }

    @Test
    void twoEqualTeams_areEqual() {
        Team team1 = new Team("CE");
        Team team2 = new Team("CE");
        assertEquals(true, team1.equals(team2));
    }

    @Test
    void twoEqualTeams_haveEqualHashCode() {
        Team team1 = new Team("CE");
        Team team2 = new Team("CE");
        assertEquals(team1.hashCode(), team2.hashCode());
    }
}
