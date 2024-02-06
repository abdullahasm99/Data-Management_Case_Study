package DTO;

/**
 *
 * @author Abdullah ASM
 */
public class Dep_CourDTO {
    
    Integer department_id;
    Integer course_id;

    public Dep_CourDTO(Integer department_id, Integer course_id) {
        this.department_id = department_id;
        this.course_id = course_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }
    
}
