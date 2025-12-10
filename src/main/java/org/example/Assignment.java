package org.example;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment {
    private final String assignmentId;
    private String assignmentName;
    private double weight;
    @Getter private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("A%03d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * calculates the average score for the assignment
     *
     * @return the average score as a double
     */
    public double calcAssignmentAvg() {
        if (scores.size() == 0) return 0;

        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    /**
     * generates a random score for each student
     */
    public void generateRandomScore() {
        Random rand = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int rangeKey = rand.nextInt(11);
            int score;

            if (rangeKey == 0)
                score = rand.nextInt(60);
            else if (rangeKey <= 2)
                score = 60 + rand.nextInt(10);
            else if (rangeKey <= 4)
                score = 70 + rand.nextInt(10);
            else if (rangeKey <= 8)
                score = 80 + rand.nextInt(10);
            else
                score = 90 + rand.nextInt(11);
            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return assignmentId + " - " + assignmentName + " - Weight: " + weight;
    }
}
