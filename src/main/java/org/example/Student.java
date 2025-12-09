package org.example;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Student {
    private final String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%05d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public void setStudentName(String studentName) {
        this.studentName = Util.toTitleCase(studentName);
    }

    /**
     * registers a student to a course
     * @param course course to register to
     * @return true if the registration is successful, false if already registered
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) return false;

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment a : course.getAssignments()) {
            a.getScores().add(null);
        }

        return true;
    }
}
