package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Abdullah ASM
 */
public class StudentDTO {

    Integer student_id;
    String name;
    String dob;
    String city;
    String street;
    Integer year;
    String join_date;
    Integer department_id;
    Integer courseCount;
    Double studentAvgGPA;
    String semester;
    Integer course_year;
    Double gpa;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public StudentDTO(String name, int year, String semester, int course_year, double gpa) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.course_year = course_year;
        this.gpa = gpa;
    }

    public StudentDTO(String name, int year, int courseCount, double studentAvgGPA) {
        this.name = name;
        this.year = year;
        this.courseCount = courseCount;
        this.studentAvgGPA = studentAvgGPA;
    }

    public StudentDTO(Integer student_id, String name, String dob, String city, String street, Integer year, String join_date) {
        this.student_id = student_id;
        this.name = name;
        this.dob = formatDateString(dob);
        this.city = city;
        this.street = street;
        this.year = year;
        this.join_date = formatDateString(join_date);
    }

    public StudentDTO(Integer student_id, String name, String dob, String city, String street, Integer year, String join_date, Integer department_id) {
        this.student_id = student_id;
        this.name = name;
        this.dob = formatDateString(dob);
        this.city = city;
        this.street = street;
        this.year = year;
        this.join_date = formatDateString(join_date);
        this.department_id = department_id;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public Double getStudentAvgGPA() {
        return studentAvgGPA;
    }

    public void setStudentAvgGPA(Double studentAvgGPA) {
        this.studentAvgGPA = studentAvgGPA;
    }

    public Integer getId() {
        return student_id;
    }

    public void setId(Integer id) {
        this.student_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getCourse_year() {
        return course_year;
    }

    public void setCourse_year(Integer course_year) {
        this.course_year = course_year;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    private String formatDateString(String dateStr) {
        try {
            Date date = DATE_FORMAT.parse(dateStr);
            return DATE_FORMAT.format(date);
        } catch (ParseException e) {
            // Handle the exception or log it as needed
            e.printStackTrace();
            return dateStr; // Return the original date string in case of an error
        }
    }
}
