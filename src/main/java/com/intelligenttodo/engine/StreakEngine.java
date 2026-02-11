package com.intelligenttodo.engine;

import java.time.LocalDate;

import com.intelligenttodo.model.Streak;

public class StreakEngine {

    private static final double NORMAL_DECAY = 0.85;
    private static final double IMPORTANT_DECAY = 0.75;

    /**
     * Call when habit is completed fully.
     */
    public void complete(Streak streak) {
        streak.setScore(streak.getScore() + 1.0);
        streak.setLastUpdatedDate(LocalDate.now());
    }

    /**
     * Call when habit is partially completed.
     */
    public void partialComplete(Streak streak) {
        streak.setScore(streak.getScore() + 0.5);
        streak.setLastUpdatedDate(LocalDate.now());
    }

    /**
     * Call when habit is missed for the day.
     */
    public void miss(Streak streak) {

        double decayFactor = streak.isImportantHabit()
                ? IMPORTANT_DECAY
                : NORMAL_DECAY;

        double newScore = streak.getScore() * decayFactor;

        streak.setScore(newScore);
        streak.setLastUpdatedDate(LocalDate.now());
    }
}
