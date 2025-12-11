package org.example;

public class Main {
    public static void main(String[] args) {
        Department csDept = new Department("Computer Science");
        Department mathDept = new Department("Mathematics");

        Address addr1 = new Address(123, "Main St", "Toronto", Address.Province.ON, "M4B1B3");
        Address addr2 = new Address(456, "Queen St", "Vancouver", Address.Province.BC, "V6B2R5");

        Student student1 = new Student("Ethan Collins", Student.Gender.MALE, addr1, csDept);
        Student student2 = new Student("Ava Harrington", Student.Gender.FEMALE, addr2, mathDept);

        Course prog1 = new Course("Programming 1", 3.0, csDept);
        Course math1 = new Course("Calculus 1", 2.5, mathDept);

        prog1.addAssignment("Assignment 01", 20);
        prog1.addAssignment("Assignment 02", 20);
        prog1.addAssignment("Assignment 03", 20);
        prog1.addAssignment("Exam 01", 20);
        prog1.addAssignment("Exam 02", 20);

        math1.addAssignment("Homework 01", 50);
        math1.addAssignment("Midterm", 50);

        prog1.registerStudent(student1);
        prog1.registerStudent(student2);

        math1.registerStudent(student2);

        prog1.generateScores();
        math1.generateScores();

        System.out.println("=== Programming 1 Scores ===");
        prog1.displayScores();

        System.out.println("\n=== Calculus 1 Scores ===");
        math1.displayScores();

        System.out.println("\n=== Students ===");
        System.out.println(student1);
        System.out.println(student2);

        System.out.println("\n=== Courses Simplified ===");
        System.out.println(prog1.toSimplifiedString());
        System.out.println(math1.toSimplifiedString());
    }
}
