package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }
}
