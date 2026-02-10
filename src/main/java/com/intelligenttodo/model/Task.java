package com.intelligenttodo.model;

import java.time.LocalDate;
import java.util.UUID;

import com.intelligenttodo.model.enums.Effort;
import com.intelligenttodo.model.enums.EisenhowerCategory;
import com.intelligenttodo.model.enums.Importance;
import com.intelligenttodo.model.enums.TaskStatus;
import com.intelligenttodo.model.enums.TaskType;

public class Task {

    // 🔹 Identity
    private final String id;

    // 🔹 Basic info
    private String title;
    private String description;

    // 🔹 Planning inputs
    private LocalDate deadline;          // nullable
    private Importance importance;        // LOW, MEDIUM, HIGH
    private Effort effort;                // EASY, MEDIUM, HARD
    private TaskType taskType;            // STUDY, WORK, PERSONAL, HABIT

    // 🔹 Meta flags
    private boolean assigned;             // assigned by someone else?
    private boolean habit;                // is this a habit task?

    // 🔹 Status & categorization
    private TaskStatus status;             // TODO, DONE
    private EisenhowerCategory eisenhowerCategory; // suggested by engine

    // 🔹 Habit tracking
    private Streak streak;                 // null if not a habit

    // 🔹 Constructor (minimum required)
    public Task(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;

        // sensible defaults
        this.status = TaskStatus.TODO;
        this.importance = Importance.MEDIUM;
        this.effort = Effort.MEDIUM;
        this.taskType = TaskType.PERSONAL;
        this.assigned = false;
        this.habit = false;
    }

    // ---------------- GETTERS & SETTERS ----------------

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public Effort getEffort() {
        return effort;
    }

    public void setEffort(Effort effort) {
        this.effort = effort;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public boolean isHabit() {
        return habit;
    }

    public void setHabit(boolean habit) {
        this.habit = habit;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public EisenhowerCategory getEisenhowerCategory() {
        return eisenhowerCategory;
    }

    public void setEisenhowerCategory(EisenhowerCategory eisenhowerCategory) {
        this.eisenhowerCategory = eisenhowerCategory;
    }

    public Streak getStreak() {
        return streak;
    }

    public void setStreak(Streak streak) {
        this.streak = streak;
    }

    // ---------------- UTILITY ----------------

    public boolean hasDeadline() {
        return deadline != null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", deadline=" + deadline +
                ", importance=" + importance +
                ", effort=" + effort +
                ", taskType=" + taskType +
                ", assigned=" + assigned +
                ", habit=" + habit +
                ", status=" + status +
                ", eisenhowerCategory=" + eisenhowerCategory +
                '}';
    }
}
