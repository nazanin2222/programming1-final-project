package org.example;

import java.util.ArrayList;
import java.util.List;

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
        int sum = 0;
        int count = 0;
        for (Integer s : scores) {
            if (s != null) {
                sum += s;
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }
}
