
import DTO.DepartmentsDTO;
import DTO.StudentDTO;
/**
 *
 * @author Abdullah ASM
 */
public class StudentDepartmentPair {
    private final StudentDTO student;
    private final DepartmentsDTO department;

    public StudentDepartmentPair(StudentDTO student, DepartmentsDTO department) {
        this.student = student;
        this.department = department;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public DepartmentsDTO getDepartment() {
        return department;
    }
}