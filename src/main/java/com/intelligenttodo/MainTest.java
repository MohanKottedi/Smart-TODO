package com.intelligenttodo;

import java.time.LocalDate;

import com.intelligenttodo.engine.EisenhowerSuggestionEngine;
import com.intelligenttodo.engine.StreakEngine;
import com.intelligenttodo.model.PriorityResult;
import com.intelligenttodo.model.Streak;
import com.intelligenttodo.model.Task;
import com.intelligenttodo.model.enums.Importance;
import com.intelligenttodo.model.enums.TaskType;

public class MainTest {

    public static void main(String[] args) {

        // 🔹 Create Task
        Task task = new Task("Finish DSA Assignment");
        task.setDeadline(LocalDate.now().plusDays(1));
        task.setImportance(Importance.HIGH);
        task.setAssigned(true);
        task.setTaskType(TaskType.STUDY);

        System.out.println("=== TASK CREATED ===");
        System.out.println(task);

        // 🔹 Test Streak Engine
        Streak streak = new Streak();
        streak.setImportantHabit(true);

        StreakEngine streakEngine = new StreakEngine();
        streakEngine.complete(streak);
        streakEngine.complete(streak);
        streakEngine.miss(streak);

        System.out.println("\n=== STREAK RESULT ===");
        System.out.println(streak);

        // 🔹 Test Eisenhower + Priority Engine
        EisenhowerSuggestionEngine eisenhowerEngine = new EisenhowerSuggestionEngine();
        PriorityResult result = eisenhowerEngine.suggest(task);

        System.out.println("\n=== PRIORITY RESULT ===");
        System.out.println(result);
    }
}
