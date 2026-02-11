package com.intelligenttodo.engine;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.intelligenttodo.model.Task;
import com.intelligenttodo.model.PriorityResult;
import com.intelligenttodo.model.enums.EisenhowerCategory;
import com.intelligenttodo.model.enums.Importance;
import com.intelligenttodo.model.enums.PriorityLevel;

public class EisenhowerSuggestionEngine {

    private final PriorityCalculator priorityCalculator;

    public EisenhowerSuggestionEngine() {
        this.priorityCalculator = new PriorityCalculator();
    }

    public PriorityResult suggest(Task task) {

        PriorityLevel priorityLevel = priorityCalculator.evaluate(task);

        boolean urgent = isUrgent(task);
        boolean important = task.getImportance() == Importance.HIGH;

        EisenhowerCategory category;
        String reason;

        if (urgent && important) {
            category = EisenhowerCategory.DO_NOW;
            reason = "Urgent and important task.";
        } 
        else if (!urgent && important) {
            category = EisenhowerCategory.SCHEDULE;
            reason = "Important but not urgent.";
        } 
        else if (urgent && !important && task.isAssigned()) {
            category = EisenhowerCategory.DELEGATE;
            reason = "Urgent but low importance and assigned.";
        } 
        else {
            category = EisenhowerCategory.ELIMINATE;
            reason = "Not urgent and not important.";
        }

        return new PriorityResult(priorityLevel, category, reason);
    }

    private boolean isUrgent(Task task) {

        if (task.getDeadline() == null) {
            return false;
        }

        long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), task.getDeadline());

        return daysLeft <= 2;
    }
}
