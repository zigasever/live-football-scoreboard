package com.sever.scoreboard;

import java.util.Objects;

/**
 * Basic class for match participant.
 */
public class Team {

    private final String name;

    /**
     * Create a new team with the given name.
     * @param name the name of the team.
     */
    public Team(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Team name must be provided.");
        }
        this.name = name;
    }

    /**
     * Get the name of the team.
     * @return the name of the team.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
