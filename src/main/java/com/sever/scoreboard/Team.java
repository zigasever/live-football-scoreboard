package com.sever.scoreboard;

/**
 * Basic class for match participant.
 */
public class Team {

    private String name;

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
}
