
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnalysisBase extends AnchorPane {

    protected final StackPane stackPane;
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Text text;
    protected final Button button;
    //protected final Button button0;
    protected final CategoryAxis barChart;
    protected final NumberAxis numberAxis;
    protected final BarChart depCoursesBarChart;
    protected final CategoryAxis categoryAxis;
    protected final NumberAxis numberAxis0;
    protected final BarChart stuGPALinearChart;
    protected final CategoryAxis categoryAxis0;
    protected final NumberAxis numberAxis1;
    protected final BarChart stuYearBarChart;
    protected final CategoryAxis categoryAxis1;
    protected final NumberAxis numberAxis2;
    protected final BarChart stuDepartBarChart;

    public AnalysisBase() throws SQLException {

        stackPane = new StackPane();
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        text = new Text();
        button = new Button();
        //button0 = new Button();
        barChart = new CategoryAxis();
        numberAxis = new NumberAxis();
        depCoursesBarChart = new BarChart(barChart, numberAxis);
        categoryAxis = new CategoryAxis();
        numberAxis0 = new NumberAxis();
        stuGPALinearChart = new BarChart(categoryAxis, numberAxis0);
        categoryAxis0 = new CategoryAxis();
        numberAxis1 = new NumberAxis();
        stuYearBarChart = new BarChart(categoryAxis0, numberAxis1);
        categoryAxis1 = new CategoryAxis();
        numberAxis2 = new NumberAxis();
        stuDepartBarChart = new BarChart(categoryAxis1, numberAxis2);

        setMaxHeight(700.0);
        setMaxWidth(900.0);
        setMinHeight(700.0);
        setMinWidth(900.0);
        setPrefHeight(700.0);
        setPrefWidth(900.0);
        setStyle("-fx-background-color: #001F3F;");

        stackPane.setPrefHeight(87.0);
        stackPane.setPrefWidth(900.0);
        stackPane.setStyle("-fx-background-color: #001F30;");

        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        imageView.setFitHeight(87.0);
        imageView.setFitWidth(156.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image("atlas.png");
        imageView.setImage(image);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ATLAS UNIVERSITY");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(900.0);
        text.setFont(new Font("Eras Bold ITC", 26.0));

        button.setLayoutX(14.0);
        button.setLayoutY(87.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(39.0);
        button.setPrefWidth(92.0);
        button.setStyle("-fx-background-color: #001F3F;");
        button.setText("HOME");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("System Bold", 18.0));

        /*button0.setLayoutX(778.0);
        button0.setLayoutY(87.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(39.0);
        button0.setPrefWidth(122.0);
        button0.setStyle("-fx-background-color: #001F3F;");
        button0.setText("ANALYSIS");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("System Bold", 18.0));*/
        barChart.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis.setSide(javafx.geometry.Side.LEFT);
        depCoursesBarChart.setBarGap(7.0);
        depCoursesBarChart.setLayoutX(60.0);
        depCoursesBarChart.setLayoutY(141.0);
        depCoursesBarChart.setPrefHeight(249.0);
        depCoursesBarChart.setPrefWidth(365.0);
        depCoursesBarChart.setStyle("-fx-background-color: #ffffff;");
        depCoursesBarChart.setTitle("Courses per Department");

        categoryAxis.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis0.setSide(javafx.geometry.Side.LEFT);
        stuGPALinearChart.setBarGap(0.0);
        stuGPALinearChart.setLayoutX(474.0);
        stuGPALinearChart.setLayoutY(141.0);
        stuGPALinearChart.setPrefHeight(249.0);
        stuGPALinearChart.setPrefWidth(365.0);
        stuGPALinearChart.setStyle("-fx-background-color: #ffffff;");
        stuGPALinearChart.setTitle("Courses' Avg GPA");

        categoryAxis0.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis1.setSide(javafx.geometry.Side.LEFT);
        stuYearBarChart.setBarGap(7.0);
        stuYearBarChart.setLayoutX(60.0);
        stuYearBarChart.setLayoutY(428.0);
        stuYearBarChart.setPrefHeight(249.0);
        stuYearBarChart.setPrefWidth(365.0);
        stuYearBarChart.setStyle("-fx-background-color: #ffffff;");
        stuYearBarChart.setTitle("Students per Study Year");

        categoryAxis1.setSide(javafx.geometry.Side.BOTTOM);

        numberAxis2.setSide(javafx.geometry.Side.LEFT);
        stuDepartBarChart.setBarGap(7.0);
        stuDepartBarChart.setLayoutX(474.0);
        stuDepartBarChart.setLayoutY(428.0);
        stuDepartBarChart.setPrefHeight(249.0);
        stuDepartBarChart.setPrefWidth(365.0);
        stuDepartBarChart.setStyle("-fx-background-color: #ffffff;");
        stuDepartBarChart.setTitle("Students per Department");

        anchorPane.getChildren().add(imageView);
        stackPane.getChildren().add(anchorPane);
        stackPane.getChildren().add(text);
        getChildren().add(stackPane);
        getChildren().add(button);
        //getChildren().add(button0);
        getChildren().add(depCoursesBarChart);
        getChildren().add(stuGPALinearChart);
        getChildren().add(stuYearBarChart);
        getChildren().add(stuDepartBarChart);

        // Populate the bar chart with the data
        ObservableList<XYChart.Series<String, Number>> seriesList = fetchDataFromDatabase();
        ObservableList<XYChart.Series<String, Number>> seriesList2 = fetchStudentDataFromDatabase();
        ObservableList<XYChart.Series<String, Number>> seriesList3 = fetchAvgGpaFromDatabase();
        ObservableList<XYChart.Series<String, Number>> seriesList4 = fetchStudentDataFromDatabaseByYear();

        depCoursesBarChart.getData().addAll(seriesList);
        stuDepartBarChart.getData().addAll(seriesList2);
        stuGPALinearChart.getData().addAll(seriesList3);
        stuYearBarChart.getData().addAll(seriesList4);

        button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new MainPageBase();

                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);
                stage.setMaxHeight(800);
                stage.setMaxWidth(950);
                stage.show();
            }
        });

    }

    private ObservableList<XYChart.Series<String, Number>> fetchDataFromDatabase() throws SQLException {
        ObservableList<XYChart.Series<String, Number>> seriesList = FXCollections.observableArrayList();

        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "admin", "root");

            // SQL query to retrieve department names and course counts
            String query = "SELECT d.name as department_name, COUNT(c.course_id) as course_count "
                    + "FROM departments d "
                    + "LEFT JOIN department_courses dc ON d.department_id = dc.department_id "
                    + "LEFT JOIN courses c ON dc.course_id = c.course_id "
                    + "GROUP BY d.name";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String departmentName = resultSet.getString("department_name");
                int courseCount = resultSet.getInt("course_count");

                // Create a series for each department
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(departmentName);
                series.getData().add(new XYChart.Data<>("Courses", courseCount));

                seriesList.add(series);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return seriesList;
    }

    private ObservableList<XYChart.Series<String, Number>> fetchStudentDataFromDatabase() {
        ObservableList<XYChart.Series<String, Number>> seriesList = FXCollections.observableArrayList();

        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "admin", "root");

            // SQL query to retrieve department names and student counts
            String query = "SELECT d.name as department_name, COUNT(s.student_id) as student_count "
                    + "FROM departments d "
                    + "LEFT JOIN students s ON d.department_id = s.department_id "
                    + "GROUP BY d.name";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String departmentName = resultSet.getString("department_name");
                int studentCount = resultSet.getInt("student_count");

                // Create a series for each department
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(departmentName);
                series.getData().add(new XYChart.Data<>("Students", studentCount));

                seriesList.add(series);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return seriesList;
    }

    private ObservableList<XYChart.Series<String, Number>> fetchAvgGpaFromDatabase() {
        ObservableList<XYChart.Series<String, Number>> seriesList = FXCollections.observableArrayList();

        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "admin", "root");

            // SQL query to retrieve course names and average GPA
            String query = "SELECT e.course_id, c.name, ROUND(AVG(e.grade) * 0.04, 2) AS avg_gpa "
                    + "FROM enrollments e "
                    + "JOIN courses c ON e.course_id = c.course_id "
                    + "GROUP BY e.course_id, c.name";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String courseName = resultSet.getString("name");
                double avgGpa = resultSet.getDouble("avg_gpa");

                // Create a series for each course
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(courseName);
                series.getData().add(new XYChart.Data<>(courseName, avgGpa));

                seriesList.add(series);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return seriesList;
    }

    private ObservableList<XYChart.Series<String, Number>> fetchStudentDataFromDatabaseByYear() {
        ObservableList<XYChart.Series<String, Number>> seriesList = FXCollections.observableArrayList();

        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "admin", "root");

            // SQL query to retrieve years and student counts
            String query = "SELECT year, COUNT(student_id) as student_count "
                    + "FROM students "
                    + "GROUP BY year";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String year = resultSet.getString("year");
                int studentCount = resultSet.getInt("student_count");

                // Create a series for each year
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(year);
                series.getData().add(new XYChart.Data<>("Students", studentCount));

                seriesList.add(series);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return seriesList;
    }

}
