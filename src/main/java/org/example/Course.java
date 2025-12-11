package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Course {
    private final String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.courseId = String.format("C-%s-%02d",
                department != null ? department.getDepartmentId() : "D00", nextId++);
    }

    /**
     * checks if the sum of the assignment weights equals 100
     * @return true if sum is 100, false if not
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment a : assignments) {
            sum += a.getWeight();
        }
        return Math.abs(sum - 100) < 0.0001;
    }

    /**
     * registers a student to the course
     * @param student the student
     * @return true if success, false if already registered
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) return false;

        registeredStudents.add(student);
        student.getRegisteredCourses().add(this);

        for (Assignment a : assignments) {
            a.getScores().add(null);
        }

        return true;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the name
     * @param weight the weight
     * @return true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment a = new Assignment(assignmentName, weight);
        assignments.add(a);

        for (Student s : registeredStudents) {
            a.getScores().add(null);
        }

        return true;
    }

    /**
     * calculates the weighted averages for each student
     * @return array of averages in the order of registered students
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;
            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                if (score != null) {
                    total += score * (a.getWeight() / 100.0);
                }
            }
            averages[i] = (int) Math.round(total);
        }

        return averages;
    }

    public void generateScores() {
        for (Assignment a : assignments) {
                a.generateRandomScore();
        }
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + "(" + courseId + ")");
        System.out.print(String.format("%-20s", ""));
        for (Assignment a : assignments) {
            System.out.print(String.format("%-15s", a.getAssignmentId()));
        }
        System.out.println("Final Score");

        int[] finalScores = calcStudentsAverage();
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            System.out.print(String.format("%-20s", s.getStudentName()));
            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                System.out.print(String.format("%-15s", score != null ? score : "-"));
            }
            System.out.println(finalScores[i]);
        }

        System.out.print(String.format("%-20s", "Average"));
        for (Assignment a : assignments) {
            double sum = 0;
            int count = 0;
            for (Integer score : a.getScores()) {
                if (score != null) {
                    sum += score;
                    count++;
                }
            }
            int avg = count > 0 ? (int) Math.round(sum / count) : 0;
            System.out.print(String.format("%-15s", avg));
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return courseId + " - " + courseName + " - " + credits + " - " +
                (department != null ? department.getDepartmentName() : "No Department");
    }

    @Override
    public String toString() {
        String str = "Course ID: " + courseId + "\n" +
                "Course Name: " + courseName + "\n" +
                "Credits: " + credits + "\n" +
                "Department: " + department + "\n" +
                "Assignments: " + assignments + "\n" +
                "Registered Students:\n";

        for (Student s : registeredStudents) {
            str += "   - " + s.toSimplifiedString() + "\n";
        }

        str += "Assignment weights valid? " + isAssignmentWeightValid();
        return str;
    }
}
