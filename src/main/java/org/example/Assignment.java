package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment {
    private final String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("A%03d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * calculates the average score for the assignment
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

    public void generateRandomScore(int studentCount) {
        Random rand = new Random();

    }
}
