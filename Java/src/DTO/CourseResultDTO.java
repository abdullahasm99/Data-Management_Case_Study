package DTO;

/**
 *
 * @author Abdullah ASM
 */
public class CourseResultDTO {
    
    String courseName;
    int hours;
    int studentCount;
    double avgGPA;

    public CourseResultDTO(String courseName, int hours, int studentCount, double avgGPA) {
        this.courseName = courseName;
        this.hours = hours;
        this.studentCount = studentCount;
        this.avgGPA = avgGPA;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getHours() {
        return hours;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public double getAvgGPA() {
        return avgGPA;
    }
}