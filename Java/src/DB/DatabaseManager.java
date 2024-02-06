package DB;

import DTO.CourseResultDTO;
import DTO.CoursesDTO;
import DTO.StudentDepartmentPair;
import DTO.StudentDTO;
import DTO.EnrollmentsDTO;
import DTO.DepartmentsDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import oracle.jdbc.OracleDriver;

public class DatabaseManager {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "admin";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static StudentDepartmentPair getStudentById(int student_id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StudentDTO student = null;
        DepartmentsDTO department = null;
        int courseCount = 0;  // Added variable to store the course count

        try {
            connection = getConnection();

            // Query to retrieve student and department information along with the count of course IDs
            String sql = "SELECT s.STUDENT_ID, s.NAME, s.DOB, s.CITY, s.STREET, s.YEAR, s.JOIN_DATE, s.DEPARTMENT_ID, d.name as department_name, COUNT(e.course_id) as course_count "
                    + "FROM students s Left JOIN departments d ON s.department_id = d.department_id Left JOIN enrollments e ON s.student_id = e.student_id "
                    + "WHERE s.student_id = ? "
                    + "GROUP BY s.STUDENT_ID, s.NAME, s.DOB, s.CITY, s.STREET, s.YEAR, s.JOIN_DATE, s.DEPARTMENT_ID, d.name";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student_id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve data from the result set and create a StudentDTO object
                student = new StudentDTO(
                        resultSet.getInt("student_id"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("year"),
                        resultSet.getString("join_date")
                );

                // Create a DepartmentsDTO object
                department = new DepartmentsDTO(
                        resultSet.getString("department_name")
                );

                // Get the count of course IDs
                courseCount = resultSet.getInt("course_count");
            }
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        // Return a Pair containing both StudentDTO, DepartmentsDTO, and the course count
        return new StudentDepartmentPair(student, department, courseCount);
    }

    public static boolean studentExists(int studentId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT COUNT(*) FROM students WHERE student_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, studentId);
            resultSet = statement.executeQuery();

            // If there is at least one row, the student exists
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

            return false;
        } finally {
            // Close resources in the finally block
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static boolean departmentExists(int departmentId) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM departments WHERE department_id = ?");) {
            statement.setInt(1, departmentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() && resultSet.getInt(1) > 0;
            }
        }
    }

    public static void insertStudent(StudentDTO student) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO STUDENTS (student_id, name, dob, city, street, year, join_date, department_id) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDob());
            preparedStatement.setString(4, student.getCity());
            preparedStatement.setString(5, student.getStreet());
            preparedStatement.setInt(6, student.getYear());
            preparedStatement.setString(7, student.getJoin_date());
            preparedStatement.setInt(8, student.getDepartment_id());

            preparedStatement.executeUpdate();
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    public static void updateStudentInfo(int student_id, String name, String street, String dob, String city, int year, String joinDate, int departmentId) throws SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = getConnection();
            String sql = "{call update_stud_info(?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)}";
            callableStatement = connection.prepareCall(sql);

            callableStatement.setInt(1, student_id);
            callableStatement.setString(2, name);
            callableStatement.setString(3, street);
            callableStatement.setString(4, dob);
            callableStatement.setString(5, city);
            callableStatement.setInt(6, year);
            callableStatement.setString(7, joinDate);
            callableStatement.setInt(8, departmentId);

            callableStatement.executeUpdate();
        } finally {
            closeResources1(callableStatement, connection);
        }
    }

    public static boolean yearExists(int year) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM enrollments WHERE year = ?")) {
            preparedStatement.setInt(1, year);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    public static Double calculateGPA(int student_id, String semester, int year) throws SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Double gpa = null;

        try {
            connection = getConnection();
            String sql = "{ ? = call gpa_stud_info(?, ?, ?) }";
            callableStatement = connection.prepareCall(sql);

            // Register the output parameter for the function return value
            callableStatement.registerOutParameter(1, Types.DOUBLE);

            callableStatement.setInt(2, student_id);
            callableStatement.setString(3, semester);
            callableStatement.setInt(4, year);

            System.out.println("Debug: Executing stored function...");

            // Execute the stored function
            callableStatement.executeUpdate();

            // Retrieve the calculated GPA from the output parameter
            gpa = callableStatement.getDouble(1);

            System.out.println("Debug: Retrieved GPA: " + gpa);

        } finally {
            closeResources1(callableStatement, connection);
        }

        return gpa;
    }

    public static DepartmentsDTO getDepartmentById(int departmentId) throws SQLException {
        DepartmentsDTO department = null;

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT d.name, ROUND(AVG(e.grade*0.04), 2) AS avg_gpa "
                        + "FROM departments d "
                        + "Left JOIN department_courses dc ON d.department_id = dc.department_id "
                        + "Left JOIN enrollments e ON dc.course_id = e.course_id "
                        + "WHERE d.department_id = ? "
                        + "GROUP BY d.name")) {

            preparedStatement.setInt(1, departmentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    department = new DepartmentsDTO(
                            departmentId,
                            resultSet.getString("name"),
                            resultSet.getDouble("avg_gpa")
                    );
                }
            }
        }

        return department;
    }

    public static List<CourseResultDTO> getCourseResultsByDepartmentId(int departmentId) throws SQLException {
        List<CourseResultDTO> courseResults = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "select c.name as courseName, c.hours, count(e.course_id) as studentCount, "
                        + "round(avg(e.grade * 0.04), 2) as avgGPA "
                        + "from departments d "
                        + "join department_courses dc on d.department_id = dc.department_id "
                        + "join courses c on dc.course_id = c.course_id "
                        + "join enrollments e on c.course_id = e.course_id "
                        + "where d.department_id = ? "
                        + "group by d.name, c.name, c.hours")) {

            statement.setInt(1, departmentId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String courseName = resultSet.getString("courseName");
                    int hours = resultSet.getInt("hours");
                    int studentCount = resultSet.getInt("studentCount");
                    double avgGPA = resultSet.getDouble("avgGPA");

                    CourseResultDTO courseResult = new CourseResultDTO(courseName, hours, studentCount, avgGPA);
                    courseResults.add(courseResult);
                }
            }
        }

        return courseResults;
    }

    public static List<StudentDTO> getStudentInfoByDepartmentId(int departmentId) throws SQLException {
        List<StudentDTO> studentInfoList = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT s.name, s.year, COUNT(e.student_id) as course_count, ROUND(AVG(e.grade * 0.04), 2) as student_avg_gpa "
                        + "FROM students s "
                        + "JOIN enrollments e ON s.student_id = e.student_id "
                        + "WHERE s.department_id = ? "
                        + "GROUP BY s.name, s.year")) {

            preparedStatement.setInt(1, departmentId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int year = resultSet.getInt("year");
                    int courseCount = resultSet.getInt("course_count");
                    double studentAvgGPA = resultSet.getDouble("student_avg_gpa");

                    StudentDTO studentDTO = new StudentDTO(name, year, courseCount, studentAvgGPA);
                    studentInfoList.add(studentDTO);
                }
            }
        }

        return studentInfoList;
    }

    public static CoursesDTO getCourseById(int courseId) throws SQLException {
        CoursesDTO course = null;

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT c.name, c.hours, c.max_grade, COUNT(e.student_id) AS student_count, ROUND(AVG(e.grade*0.04), 2) AS avg_gpa "
                        + "FROM courses c "
                        + "Left JOIN enrollments e ON c.course_id = e.course_id "
                        + "WHERE c.course_id = ? "
                        + "GROUP BY c.name, c.hours, c.max_grade")) {

            preparedStatement.setInt(1, courseId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    course = new CoursesDTO(
                            resultSet.getString("name"),
                            resultSet.getInt("hours"),
                            resultSet.getInt("max_grade"),
                            resultSet.getInt("student_count"),
                            resultSet.getDouble("avg_gpa")
                    );
                }
            }
        }

        return course;
    }

    public static List<DepartmentsDTO> getDepartmentsByCourseId(int courseId) throws SQLException {
        List<DepartmentsDTO> departments = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT d.name FROM courses c "
                        + "JOIN department_courses dc ON c.course_id = dc.course_id "
                        + "JOIN departments d ON dc.department_id = d.department_id "
                        + "WHERE c.course_id = ?")) {

            preparedStatement.setInt(1, courseId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    DepartmentsDTO department = new DepartmentsDTO(resultSet.getString("name"));
                    departments.add(department);
                }
            }
        }

        return departments;
    }

    public static List<StudentDTO> getStudentsByCourseId(int courseId) throws SQLException {
        List<StudentDTO> students = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT s.name, s.year, e.semester, e.year as course_year, ROUND(e.grade * 0.04, 2) as gpa "
                        + "FROM courses c "
                        + "JOIN enrollments e ON c.course_id = e.course_id "
                        + "JOIN students s ON e.student_id = s.student_id "
                        + "WHERE c.course_id = ?")) {

            preparedStatement.setInt(1, courseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    StudentDTO student = new StudentDTO(
                            resultSet.getString("name"),
                            resultSet.getInt("year"),
                            resultSet.getString("semester"),
                            resultSet.getInt("course_year"),
                            resultSet.getDouble("gpa")
                    );
                    students.add(student);
                }
            }
        }

        return students;
    }

    public static boolean updateDepartment(int departmentId, String newDepartmentName) throws SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = getConnection();
            String sql = "{call update_department(?, ?)}";
            callableStatement = connection.prepareCall(sql);

            callableStatement.setInt(1, departmentId);
            callableStatement.setString(2, newDepartmentName);

            callableStatement.executeUpdate();

            return true;
        } finally {
            closeResources1(callableStatement, connection);
        }
    }

    public static boolean updateCourse(int courseId, String newName, int newHours, int newMaxGrade) throws SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = getConnection();
            String sql = "{call update_course(?, ?, ?, ?)}";
            callableStatement = connection.prepareCall(sql);

            callableStatement.setInt(1, courseId);
            callableStatement.setString(2, newName);
            callableStatement.setInt(3, newHours);
            callableStatement.setInt(4, newMaxGrade);

            callableStatement.executeUpdate();

            return true;

        } finally {
            closeResources1(callableStatement, connection);
        }
    }

    public static boolean addDepartment(int departmentId, String departmentName) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO DEPARTMENTS (department_id, name) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, departmentId);
            preparedStatement.setString(2, departmentName);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    public static boolean addCourse(int courseId, String courseName, int hours, int maxGrade) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO COURSES (course_id, name, hours, max_grade) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setString(2, courseName);
            preparedStatement.setInt(3, hours);
            preparedStatement.setInt(4, maxGrade);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    public static boolean deleteCourse(int courseId) throws SQLException {
        if (!courseExists(courseId)) {
            return false;  // Course does not exist
        }

        try (Connection connection = getConnection();
                CallableStatement callableStatement = connection.prepareCall("{call delete_course(?)}")) {

            callableStatement.setInt(1, courseId);
            callableStatement.executeUpdate();
            return true;
        }
    }

    public static boolean courseExists(int courseId) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM courses WHERE course_id = ?")) {

            preparedStatement.setInt(1, courseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() && resultSet.getInt(1) > 0;
            }
        }
    }

    public static boolean deleteDepartment(int departmentId) throws SQLException {
        if (!departmentExists(departmentId)) {
            return false;  // Department does not exist
        }

        try (Connection connection = getConnection();
                CallableStatement callableStatement = connection.prepareCall("{call delete_department(?)}")) {

            callableStatement.setInt(1, departmentId);
            callableStatement.executeUpdate();
            return true;
        }
    }
    
    private static void closeResources1(CallableStatement callableStatement, Connection connection) throws SQLException {
        if (callableStatement != null){
            callableStatement.close();
        }
        
        if (connection != null) {
            connection.close();
        }
    }

    private static void closeResources(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}