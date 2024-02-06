public class CourseInfo {

    private Integer courseId;
    private String courseName;
    private Integer courseHours;
    private String courseGrade;

    public CourseInfo(Integer courseId, String courseName, Integer courseHours, String courseGrade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseHours = courseHours;
        this.courseGrade = courseGrade;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseHours() {
        return courseHours;
    }

    public String getCourseGrade() {
        return courseGrade;
    }
}
