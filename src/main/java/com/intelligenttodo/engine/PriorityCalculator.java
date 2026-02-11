package com.intelligenttodo.engine;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.intelligenttodo.model.Task;
import com.intelligenttodo.model.enums.Importance;
import com.intelligenttodo.model.enums.PriorityLevel;

public class PriorityCalculator {

    /**
     * Calculates a numeric priority score based on
     * deadline, importance, and assignment.
     */
    public int calculateScore(Task task) {

        int score = 0;

        // 🔹 Deadline urgency
        if (task.getDeadline() != null) {
            long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), task.getDeadline());

            if (daysLeft < 0) {
                score += 5; // overdue
            } else if (daysLeft <= 1) {
                score += 4;
            } else if (daysLeft <= 3) {
                score += 3;
            }
        }

        // 🔹 Importance weight
        if (task.getImportance() == Importance.HIGH) {
            score += 3;
        } else if (task.getImportance() == Importance.MEDIUM) {
            score += 2;
        }

        // 🔹 Assigned task boost
        if (task.isAssigned()) {
            score += 2;
        }

        return score;
    }

    /**
     * Converts numeric score into PriorityLevel.
     */
    public PriorityLevel determineLevel(int score) {

        if (score >= 7) {
            return PriorityLevel.HIGH;
        } else if (score >= 4) {
            return PriorityLevel.MEDIUM;
        } else {
            return PriorityLevel.LOW;
        }
    }

    /**
     * Convenience method for full evaluation.
     */
    public PriorityLevel evaluate(Task task) {
        int score = calculateScore(task);
        return determineLevel(score);
    }
}
