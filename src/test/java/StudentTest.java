import org.example.Course;
import org.example.Department;
import org.example.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    @Test
    void testRegisterAndDropCourse() {
        Department dept = new Department("CS");
        Student student = new Student("Alice", Student.Gender.FEMALE, null, dept);
        Course course = new Course("Programming 1", 3, dept);
        course.addAssignment("Assignment 1", 50);
        course.addAssignment("Assignment 2", 50);

        boolean regResult = student.registerCourse(course);
        assertTrue(regResult);
        assertTrue(student.getRegisteredCourses().contains(course));
        assertTrue(course.getRegisteredStudents().contains(student));

        boolean dropResult = student.dropCourse(course);
        assertTrue(dropResult);
        assertFalse(student.getRegisteredCourses().contains(course));
        assertFalse(course.getRegisteredStudents().contains(student));
    }
}
