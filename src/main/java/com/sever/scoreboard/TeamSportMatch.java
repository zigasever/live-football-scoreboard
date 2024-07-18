package com.sever.scoreboard;

import java.time.LocalDateTime;

/**
 * Represents a match between two teams in a team sport.
 */
public interface TeamSportMatch {

        /**
         * @return the home team.
         */
        public Team getHomeTeam();

        /**
         * @return the away team.
         */
        public Team getAwayTeam();

        /**
         * @return the score of the home team.
         */
        public int getHomeScore();

        /**
         * @return the score of the away team.
         */
        public int getAwayScore();

        /**
         * Sets the score of the match.
         * @param homeScore the score of the home team.
         * @param awayScore the score of the away team.
         */
        public void setScore(int homeScore, int awayScore);

        /**
         * @return the total score of the match.
         */
        public int getTotalScore();

        /**
         * @return the start time of the match.
         */
        public LocalDateTime getMatchStart();
}
