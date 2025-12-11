import org.example.Department;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartmentTest {

    @Test
    void testValidDepartmentName() {
        assertTrue(Department.isDepartmentNameValid("Computer Science"));
        assertTrue(Department.isDepartmentNameValid("Mathematics"));
    }

    @Test
    void testInvalidDepartmentName() {
        assertFalse(Department.isDepartmentNameValid("Comp Sci 101"));
        assertFalse(Department.isDepartmentNameValid("Math!"));
        assertFalse(Department.isDepartmentNameValid(""));
        assertFalse(Department.isDepartmentNameValid(null));
    }
}
