package DTO;

/**
 *
 * @author Abdullah ASM
 */
public class CoursesDTO {
    
    Integer course_id;
    String name;
    Integer hours;
    Integer max_grade;
    Integer student_count;
    Double avg_gpa;

    public CoursesDTO(String name, int hours, int max_grade, int student_count, double avg_gpa) {
        this.name = name;
        this.hours = hours;
        this.max_grade = max_grade;
        this.student_count = student_count;
        this.avg_gpa = avg_gpa;
    }

    public CoursesDTO(Integer course_id, String name, Integer hours, Integer max_grade) {
        this.course_id = course_id;
        this.name = name;
        this.hours = hours;
        this.max_grade = max_grade;
    }

    public Integer getStudent_count() {
        return student_count;
    }

    public void setStudent_count(Integer student_count) {
        this.student_count = student_count;
    }

    public Double getAvg_gpa() {
        return avg_gpa;
    }

    public void setAvg_gpa(Double avg_gpa) {
        this.avg_gpa = avg_gpa;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMax_grade() {
        return max_grade;
    }

    public void setMax_grade(Integer max_grade) {
        this.max_grade = max_grade;
    }
    
}