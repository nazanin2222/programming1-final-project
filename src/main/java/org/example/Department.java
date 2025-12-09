package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * checks if department name is valid
     * @param name the department name
     * @return true if valid, false if not
     */
    public static boolean isDepartmentNameValid(String name) {
        if (name == null || name.isEmpty()) return false;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
}
