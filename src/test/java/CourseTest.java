import org.example.Address;
import org.example.Course;
import org.example.Department;
import org.example.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    void testCourseMethods() {
        Department dept = new Department("Math");

        Address a = new Address(1, "King", "Toronto", Address.Province.ON, "A1B2C3");
        Student student = new Student("Bob", Student.Gender.MALE, a, dept);

        Course course = new Course("Algebra", 3, dept);
        course.addAssignment("Assignment 1", 50);
        course.addAssignment("Assignment 2", 50);

        course.registerStudent(student);

        course.getAssignments().get(0).getScores().set(0, 80);
        course.getAssignments().get(1).getScores().set(0, 90);

        assertTrue(course.isAssignmentWeightValid());

        course.getAssignments().get(1).setWeight(40);
        assertFalse(course.isAssignmentWeightValid());

        course.getAssignments().get(1).setWeight(50);

        int[] averages = course.calcStudentsAverage();
        assertEquals(1, averages.length);
        assertEquals((int) Math.round(80 * 0.5 + 90 * 0.5), averages[0]);

        boolean added = course.addAssignment("Assignment 3", 10);
        assertTrue(added);
        assertEquals(3, course.getAssignments().size());

        Student newStudent = new Student("Charlie", Student.Gender.MALE, a, dept);
        boolean registered = course.registerStudent(newStudent);
        assertTrue(registered);
        assertTrue(course.getRegisteredStudents().contains(newStudent));

        assertEquals(2, course.getAssignments().get(0).getScores().size());
    }
}
