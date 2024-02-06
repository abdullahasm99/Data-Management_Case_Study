package DTO;

import DTO.DepartmentsDTO;
import DTO.StudentDTO;

/**
 *
 * @author Abdullah ASM
 */
public class StudentDepartmentPair {

    private final StudentDTO student;
    private final DepartmentsDTO department;
    private final int courseCount; 

    public StudentDepartmentPair(StudentDTO student, DepartmentsDTO department, int courseCount) {
        this.student = student;
        this.department = department;
        this.courseCount = courseCount;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public DepartmentsDTO getDepartment() {
        return department;
    }

    public int getCourseCount() {
        return courseCount;
    }
}