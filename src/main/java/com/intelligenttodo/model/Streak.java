package com.intelligenttodo.model;

import java.time.LocalDate;

public class Streak {

    private double score;               // elastic streak score
    private LocalDate lastUpdatedDate;
    private boolean importantHabit;

    public Streak() {
        this.score = 0.0;
        this.lastUpdatedDate = LocalDate.now();
        this.importantHabit = false;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public boolean isImportantHabit() {
        return importantHabit;
    }

    public void setImportantHabit(boolean importantHabit) {
        this.importantHabit = importantHabit;
    }

    @Override
    public String toString() {
        return "Streak{" +
                "score=" + score +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", importantHabit=" + importantHabit +
                '}';
    }
}
