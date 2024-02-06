package DTO;

/**
 *
 * @author Abdullah ASM
 */
public class EnrollmentsDTO {
    
    Integer student_id;
    Integer course_id;
    Integer grade;
    String semester;
    Integer year;

    public EnrollmentsDTO(Integer student_id, Integer course_id, Integer grade, String semester, Integer year) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
        this.semester = semester;
        this.year = year;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
}
