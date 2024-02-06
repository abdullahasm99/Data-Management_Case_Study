package DTO;

/**
 *
 * @author Abdullah ASM
 */
public class DepartmentsDTO {

    Integer department_id;
    String department_name;
    Double avg_gpa;

    public DepartmentsDTO(String department_name) {
        this.department_name = department_name;
    }

    public DepartmentsDTO(Integer department_id, String department_name, Double avg_gpa) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.avg_gpa = avg_gpa;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return department_name;
    }

    public void setName(String name) {
        this.department_name = name;
    }

    public Double getAvg_gpa() {
        return avg_gpa;
    }

    public void setAvg_gpa(Double avg_gpa) {
        this.avg_gpa = avg_gpa;
    }

}
