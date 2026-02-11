package com.intelligenttodo.model;

import com.intelligenttodo.model.enums.PriorityLevel;
import com.intelligenttodo.model.enums.EisenhowerCategory;

public class PriorityResult {

    private PriorityLevel priorityLevel;
    private EisenhowerCategory suggestedCategory;
    private String reason;

    public PriorityResult(PriorityLevel priorityLevel,
                          EisenhowerCategory suggestedCategory,
                          String reason) {
        this.priorityLevel = priorityLevel;
        this.suggestedCategory = suggestedCategory;
        this.reason = reason;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public EisenhowerCategory getSuggestedCategory() {
        return suggestedCategory;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "PriorityResult{" +
                "priorityLevel=" + priorityLevel +
                ", suggestedCategory=" + suggestedCategory +
                ", reason='" + reason + '\'' +
                '}';
    }
}
