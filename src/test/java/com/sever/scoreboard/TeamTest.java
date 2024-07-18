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
}
