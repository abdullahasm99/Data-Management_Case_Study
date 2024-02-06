
import DB.DatabaseManager;
import DTO.CourseResultDTO;
import DTO.CoursesDTO;
import DTO.DepartmentsDTO;
import DTO.StudentDTO;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeptCourseBase extends AnchorPane {

    protected final StackPane stackPane;
    protected final Text text;
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Button homeBtn;
    protected final TextField deptIDTextArea;
    protected final TextField deptNameTextArea;
    protected final Text text0;
    protected final Text text1;
    protected final TextField courseIDTextArea;
    protected final TextField courseNameTextArea;
    protected final TextField courseHoursTextArea;
    protected final TextField courseGradeTextArea;
    protected final Button selectBtn;
    protected final Button clearBtn;
    protected final Button updateBtn;
    protected final Button addBrn;
    protected final Button deleteBtn;
    protected final TableView deptTableView;
    protected final TableView courseTableView;
    protected final TableView studentTableView;

    public DeptCourseBase() {

        stackPane = new StackPane();
        text = new Text();
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        homeBtn = new Button();
        deptIDTextArea = new TextField();
        deptNameTextArea = new TextField();
        text0 = new Text();
        text1 = new Text();
        courseIDTextArea = new TextField();
        courseNameTextArea = new TextField();
        courseHoursTextArea = new TextField();
        courseGradeTextArea = new TextField();
        selectBtn = new Button();
        clearBtn = new Button();
        updateBtn = new Button();
        addBrn = new Button();
        deleteBtn = new Button();
        deptTableView = new TableView();
        courseTableView = new TableView();
        studentTableView = new TableView();

        setId("AnchorPane");
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

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ATLAS UNIVERSITY");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(900.0);
        text.setFont(new Font("Eras Bold ITC", 26.0));

        anchorPane.setLayoutX(-1.0);
        anchorPane.setLayoutY(-1.0);
        anchorPane.setPrefHeight(87.0);
        anchorPane.setPrefWidth(156.0);

        imageView.setFitHeight(87.0);
        imageView.setFitWidth(156.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        homeBtn.setLayoutX(14.0);
        homeBtn.setLayoutY(87.0);
        homeBtn.setMnemonicParsing(false);
        homeBtn.setPrefHeight(39.0);
        homeBtn.setPrefWidth(97.0);
        homeBtn.setStyle("-fx-background-color: #001F3F;");
        homeBtn.setText("HOME");
        homeBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        homeBtn.setFont(new Font("System Bold", 18.0));

        deptIDTextArea.setLayoutX(37.0);
        deptIDTextArea.setLayoutY(226.0);
        deptIDTextArea.setPrefHeight(30.0);
        deptIDTextArea.setPrefWidth(180.0);
        deptIDTextArea.setPromptText("Enter Department ID*");
        deptIDTextArea.setFont(new Font(14.0));

        deptNameTextArea.setLayoutX(37.0);
        deptNameTextArea.setLayoutY(276.0);
        deptNameTextArea.setPrefHeight(30.0);
        deptNameTextArea.setPrefWidth(180.0);
        deptNameTextArea.setPromptText("Enter Department Name*");
        deptNameTextArea.setFont(new Font(14.0));

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(37.0);
        text0.setLayoutY(196.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Department Section:");
        text0.setWrappingWidth(224.99999545514584);
        text0.setFont(new Font("System Bold", 18.0));

        text1.setFill(javafx.scene.paint.Color.WHITE);
        text1.setLayoutX(37.0);
        text1.setLayoutY(369.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Course Section:");
        text1.setWrappingWidth(225.0);
        text1.setFont(new Font("System Bold", 18.0));

        courseIDTextArea.setLayoutX(37.0);
        courseIDTextArea.setLayoutY(389.0);
        courseIDTextArea.setPrefHeight(30.0);
        courseIDTextArea.setPrefWidth(180.0);
        courseIDTextArea.setPromptText("Enter Course ID*");
        courseIDTextArea.setFont(new Font(14.0));

        courseNameTextArea.setLayoutX(37.0);
        courseNameTextArea.setLayoutY(447.0);
        courseNameTextArea.setPrefHeight(30.0);
        courseNameTextArea.setPrefWidth(180.0);
        courseNameTextArea.setPromptText("Enter Course Name*");
        courseNameTextArea.setFont(new Font(14.0));

        courseHoursTextArea.setLayoutX(37.0);
        courseHoursTextArea.setLayoutY(505.0);
        courseHoursTextArea.setPrefHeight(30.0);
        courseHoursTextArea.setPrefWidth(180.0);
        courseHoursTextArea.setPromptText("Enter Course Hours");
        courseHoursTextArea.setFont(new Font(14.0));

        courseGradeTextArea.setLayoutX(37.0);
        courseGradeTextArea.setLayoutY(563.0);
        courseGradeTextArea.setPrefHeight(30.0);
        courseGradeTextArea.setPrefWidth(180.0);
        courseGradeTextArea.setPromptText("Enter Course Grade");
        courseGradeTextArea.setFont(new Font(14.0));

        selectBtn.setLayoutX(14.0);
        selectBtn.setLayoutY(649.0);
        selectBtn.setMnemonicParsing(false);
        selectBtn.setPrefHeight(37.0);
        selectBtn.setPrefWidth(142.0);
        selectBtn.setText("SHOW");
        selectBtn.setStyle("-fx-background-color: #001F3F;");
        selectBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        selectBtn.setFont(new Font("System Bold", 18.0));

        clearBtn.setLayoutX(195.0);
        clearBtn.setLayoutY(649.0);
        clearBtn.setMnemonicParsing(false);
        clearBtn.setPrefHeight(37.0);
        clearBtn.setPrefWidth(142.0);
        clearBtn.setText("CLEAR");
        clearBtn.setStyle("-fx-background-color: #001F3F;");
        clearBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        clearBtn.setFont(new Font("System Bold", 18.0));

        updateBtn.setLayoutX(379.0);
        updateBtn.setLayoutY(650.0);
        updateBtn.setMnemonicParsing(false);
        updateBtn.setPrefHeight(37.0);
        updateBtn.setPrefWidth(142.0);
        updateBtn.setText("UPDATE");
        updateBtn.setStyle("-fx-background-color: #001F3F;");
        updateBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        updateBtn.setFont(new Font("System Bold", 18.0));

        addBrn.setLayoutX(561.0);
        addBrn.setLayoutY(649.0);
        addBrn.setMnemonicParsing(false);
        addBrn.setPrefHeight(37.0);
        addBrn.setPrefWidth(142.0);
        addBrn.setText("ADD");
        addBrn.setStyle("-fx-background-color: #001F3F;");
        addBrn.setTextFill(javafx.scene.paint.Color.WHITE);
        addBrn.setFont(new Font("System Bold", 18.0));

        deleteBtn.setLayoutX(744.0);
        deleteBtn.setLayoutY(649.0);
        deleteBtn.setMnemonicParsing(false);
        deleteBtn.setPrefHeight(37.0);
        deleteBtn.setPrefWidth(142.0);
        deleteBtn.setText("DELETE");
        deleteBtn.setStyle("-fx-background-color: #001F3F;");
        deleteBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        deleteBtn.setFont(new Font("System Bold", 18.0));

        deptTableView.setLayoutX(288.0);
        deptTableView.setLayoutY(189.0);
        deptTableView.setPrefHeight(200.0);
        deptTableView.setPrefWidth(200.0);

        courseTableView.setLayoutX(493.0);
        courseTableView.setLayoutY(189.0);
        courseTableView.setPrefHeight(200.0);
        courseTableView.setPrefWidth(379.0);

        studentTableView.setLayoutX(288.0);
        studentTableView.setLayoutY(393.0);
        studentTableView.setPrefHeight(200.0);
        studentTableView.setPrefWidth(585.0);

        stackPane.getChildren().add(text);
        getChildren().add(stackPane);
        anchorPane.getChildren().add(imageView);
        getChildren().add(anchorPane);
        getChildren().add(homeBtn);
        getChildren().add(deptIDTextArea);
        getChildren().add(deptNameTextArea);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(courseIDTextArea);
        getChildren().add(courseNameTextArea);
        getChildren().add(courseHoursTextArea);
        getChildren().add(courseGradeTextArea);
        getChildren().add(selectBtn);
        getChildren().add(clearBtn);
        getChildren().add(updateBtn);
        getChildren().add(addBrn);
        getChildren().add(deleteBtn);
        getChildren().add(deptTableView);
        getChildren().add(courseTableView);
        getChildren().add(studentTableView);

        deptTableView.setOnMouseClicked(event -> {
            DepartmentsDTO selectedDepartment = (DepartmentsDTO) deptTableView.getSelectionModel().getSelectedItem();
            if (selectedDepartment != null) {
                int departmentId = selectedDepartment.getDepartment_id();
                try {
                    // Retrieve and display course information based on the selected department
                    List<CourseResultDTO> courseResults = DatabaseManager.getCourseResultsByDepartmentId(departmentId);
                    displayCourseResults(courseResults);

                    // Retrieve and display student information based on the selected department
                    List<StudentDTO> studentInfoList = DatabaseManager.getStudentInfoByDepartmentId(departmentId);
                    displayStudentInfo(studentInfoList);
                } catch (SQLException e) {
                    e.printStackTrace();
                    showErrorDialog("Error retrieving information.");
                }
            }
        });

        selectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Clear existing columns for all tables
                deptTableView.getColumns().clear();
                courseTableView.getColumns().clear();
                studentTableView.getColumns().clear();

                String departmentIdText = deptIDTextArea.getText();
                String courseIdText = courseIDTextArea.getText();

                try {
                    if (!departmentIdText.isEmpty() && !courseIdText.isEmpty()) {
                        // Both department ID and course ID are filled, show an error message
                        showErrorDialog("Please enter either Department ID or Course ID, not both.");
                    } else if (!departmentIdText.isEmpty()) {
                        // Department ID is entered, retrieve and display department information
                        int departmentId = Integer.parseInt(departmentIdText);

                        if (!DatabaseManager.departmentExists(departmentId)) {
                            showErrorDialog("Department with ID " + departmentId + " does not exist.");
                            return;
                        }

                        // Retrieve department information from the database
                        DepartmentsDTO department = DatabaseManager.getDepartmentById(departmentId);

                        if (department != null) {
                            // Create the data for the Department TableView
                            ObservableList<DepartmentsDTO> deptData = FXCollections.observableArrayList(department);

                            // Create TableColumn for Department Name
                            TableColumn<DepartmentsDTO, String> columnName = new TableColumn<>("Department Name");
                            columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
                            deptTableView.getColumns().add(columnName);

                            // Create TableColumn for Average GPA (assuming the DTO has this property)
                            TableColumn<DepartmentsDTO, Double> columnAvgGPA = new TableColumn<>("Average GPA");
                            columnAvgGPA.setCellValueFactory(new PropertyValueFactory<>("avg_gpa"));
                            deptTableView.getColumns().add(columnAvgGPA);

                            deptTableView.setItems(deptData);
                        } else {
                            showErrorDialog("Error retrieving department information.");
                        }
                    } else if (!courseIdText.isEmpty()) {
                        // Course ID is entered, retrieve and display information
                        int courseId = Integer.parseInt(courseIdText);

                        // Check if the course exists
                        if (!DatabaseManager.courseExists(courseId)) {
                            showErrorDialog("Course with ID " + courseId + " does not exist.");
                            return;
                        }

                        // Retrieve course information from the database
                        CoursesDTO course = DatabaseManager.getCourseById(courseId);

                        if (course != null) {
                            // Create the data for the Course TableView
                            ObservableList<CoursesDTO> courseData = FXCollections.observableArrayList(course);

                            TableColumn<CoursesDTO, String> columnName = new TableColumn<>("Course Name");
                            columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

                            TableColumn<CoursesDTO, Integer> columnHours = new TableColumn<>("Hours");
                            columnHours.setCellValueFactory(new PropertyValueFactory<>("hours"));

                            TableColumn<CoursesDTO, Integer> columnMaxGrade = new TableColumn<>("Grade");
                            columnMaxGrade.setCellValueFactory(new PropertyValueFactory<>("max_grade"));

                            TableColumn<CoursesDTO, Integer> columnStudentCount = new TableColumn<>("Student Count");
                            columnStudentCount.setCellValueFactory(new PropertyValueFactory<>("student_count"));

                            TableColumn<CoursesDTO, Double> columnAvgGPA = new TableColumn<>("Average GPA");
                            columnAvgGPA.setCellValueFactory(new PropertyValueFactory<>("avg_gpa"));

                            courseTableView.getColumns().addAll(columnName, columnHours, columnMaxGrade, columnStudentCount, columnAvgGPA);

                            courseTableView.setItems(courseData);

                            // Retrieve and display departments based on the selected course
                            List<DepartmentsDTO> departmentsByCourse = DatabaseManager.getDepartmentsByCourseId(courseId);
                            displayDepartments(departmentsByCourse);

                            // Retrieve and display students based on the selected course
                            List<StudentDTO> studentsByCourse = DatabaseManager.getStudentsByCourseId(courseId);
                            displayStudents(studentsByCourse);
                        } else {
                            showErrorDialog("Error retrieving course information.");
                        }
                    } else {
                        showErrorDialog("Please enter a Department ID or a Course ID.");
                    }
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid input for Department ID or Course ID.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    showErrorDialog("Error retrieving information.");
                }
            }
        });

        clearBtn.setOnAction(event -> {
            // Clear all text fields
            deptIDTextArea.clear();
            deptNameTextArea.clear();
            courseIDTextArea.clear();
            courseNameTextArea.clear();
            courseHoursTextArea.clear();
            courseGradeTextArea.clear();

            // Clear all table views
            deptTableView.getItems().clear();
            courseTableView.getItems().clear();
            studentTableView.getItems().clear();

            showInfoDialog("The scene is cleared.");

        });

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String departmentIdText = deptIDTextArea.getText();
                String courseIdText = courseIDTextArea.getText();

                if (!departmentIdText.isEmpty() && !courseIdText.isEmpty()) {
                    showErrorDialog("Please enter either a Department ID or a Course ID, not both.");
                    return;
                }

                try {
                    if (!departmentIdText.isEmpty()) {
                        // Updating Department
                        int departmentId = Integer.parseInt(departmentIdText);
                        String newDepartmentName = deptNameTextArea.getText();

                        if (!DatabaseManager.departmentExists(departmentId)) {
                            showErrorDialog("Department with ID " + departmentId + " does not exist.");
                            return;
                        }

                        // Update department information in the database
                        boolean success = DatabaseManager.updateDepartment(departmentId, newDepartmentName);

                        if (success) {
                            showInfoDialog("Department updated successfully.");
                        } else {
                            showErrorDialog("Error updating department information.");
                        }
                    } else if (!courseIdText.isEmpty()) {
                        // Updating Course
                        int courseId = Integer.parseInt(courseIdText);

                        // Check if the course exists
                        if (!DatabaseManager.courseExists(courseId)) {
                            showErrorDialog("Course with ID " + courseId + " does not exist.");
                            return;
                        }

                        String newCourseName = courseNameTextArea.getText();
                        int newCourseHours = Integer.parseInt(courseHoursTextArea.getText());
                        int newMaxGrade = Integer.parseInt(courseGradeTextArea.getText());

                        // Update course information in the database
                        boolean success = DatabaseManager.updateCourse(courseId, newCourseName, newCourseHours, newMaxGrade);

                        if (success) {
                            showInfoDialog("Course updated successfully.");
                        } else {
                            showErrorDialog("Error updating course information.");
                        }
                    } else {
                        showErrorDialog("Please enter a Department ID or a Course ID.");
                    }
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid input for Department ID, Course ID, or numeric fields.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    showErrorDialog("Error updating information.");
                }
            }
        });

        addBrn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String departmentIdText = deptIDTextArea.getText();
                String courseIdText = courseIDTextArea.getText();

                if (!departmentIdText.isEmpty() && !courseIdText.isEmpty()) {
                    showErrorDialog("Please enter either a Department ID or a Course ID, not both.");
                    return;
                }

                try {
                    if (!departmentIdText.isEmpty()) {
                        // Adding Department
                        int departmentId = Integer.parseInt(departmentIdText);
                        String newDepartmentName = deptNameTextArea.getText();

                        // Check if the department already exists
                        if (DatabaseManager.departmentExists(departmentId)) {
                            showErrorDialog("Department with ID " + departmentId + " already exists.");
                            return;
                        }

                        // Add department information to the database
                        boolean success = DatabaseManager.addDepartment(departmentId, newDepartmentName);

                        if (success) {
                            showInfoDialog("Department added successfully.");
                        } else {
                            showErrorDialog("Error adding department information.");
                        }
                    } else if (!courseIdText.isEmpty()) {
                        // Adding Course
                        int courseId = Integer.parseInt(courseIdText);
                        String newCourseName = courseNameTextArea.getText();
                        int newCourseHours = Integer.parseInt(courseHoursTextArea.getText());
                        int newMaxGrade = Integer.parseInt(courseGradeTextArea.getText());

                        // Check if the course already exists
                        if (DatabaseManager.courseExists(courseId)) {
                            showErrorDialog("Course with ID " + courseId + " already exists.");
                            return;
                        }

                        // Add course information to the database
                        boolean success = DatabaseManager.addCourse(courseId, newCourseName, newCourseHours, newMaxGrade);

                        if (success) {
                            showInfoDialog("Course added successfully.");
                        } else {
                            showErrorDialog("Error adding course information.");
                        }
                    } else {
                        showErrorDialog("Please enter a Department ID or a Course ID.");
                    }
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid input for Department ID, Course ID, or numeric fields.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    showErrorDialog("Error adding information.");
                }
            }
        });

        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String departmentIdText = deptIDTextArea.getText();
                String courseIdText = courseIDTextArea.getText();

                if (!departmentIdText.isEmpty() && !courseIdText.isEmpty()) {
                    showErrorDialog("Please enter either a Department ID or a Course ID, not both.");
                    return;
                }

                try {
                    if (!departmentIdText.isEmpty()) {
                        // Deleting Department
                        int departmentId = Integer.parseInt(departmentIdText);

                        if (!DatabaseManager.departmentExists(departmentId)) {
                            showErrorDialog("Department with ID " + departmentId + " does not exist.");
                            return;
                        }

                        // Delete department from the database
                        boolean success = DatabaseManager.deleteDepartment(departmentId);

                        if (success) {
                            showInfoDialog("Department deleted successfully.");
                        } else {
                            showErrorDialog("Error deleting department.");
                        }
                    } else if (!courseIdText.isEmpty()) {
                        // Deleting Course
                        int courseId = Integer.parseInt(courseIdText);

                        if (!DatabaseManager.courseExists(courseId)) {
                            showErrorDialog("Course with ID " + courseId + " does not exist.");
                            return;
                        }

                        // Delete course from the database
                        boolean success = DatabaseManager.deleteCourse(courseId);

                        if (success) {
                            showInfoDialog("Course deleted successfully.");
                        } else {
                            showErrorDialog("Error deleting course.");
                        }
                    } else {
                        showErrorDialog("Please enter a Department ID or a Course ID.");
                    }
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid input for Department ID, Course ID, or numeric fields.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    showErrorDialog("Error deleting information.");
                }
            }
        });

        homeBtn.addEventFilter(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                Parent root = null;
                root = new MainPageBase();

                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);
                stage.setMaxHeight(800);
                stage.setMaxWidth(950);
                stage.show();
            }
        });

    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    private void showInfoDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
    }

    private void displayCourseResults(List<CourseResultDTO> courseResults) {
        // Clear existing columns for the courseTableView
        courseTableView.getColumns().clear();

        // Create the data for the Course TableView
        ObservableList<CourseResultDTO> courseData = FXCollections.observableArrayList(courseResults);

        // Create TableColumn for Course Name
        TableColumn<CourseResultDTO, String> courseNameColumn = new TableColumn<>("Course Name");
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        // Create TableColumn for Course Hours
        TableColumn<CourseResultDTO, Integer> hoursColumn = new TableColumn<>("Hours");
        hoursColumn.setCellValueFactory(new PropertyValueFactory<>("hours"));

        // Create TableColumn for Student Count
        TableColumn<CourseResultDTO, Integer> studentCountColumn = new TableColumn<>("Student Count");
        studentCountColumn.setCellValueFactory(new PropertyValueFactory<>("studentCount"));

        // Create TableColumn for Avg GPA
        TableColumn<CourseResultDTO, Double> avgGPAColumn = new TableColumn<>("Average GPA");
        avgGPAColumn.setCellValueFactory(new PropertyValueFactory<>("avgGPA"));

        // Add columns to the courseTableView
        courseTableView.getColumns().addAll(courseNameColumn, hoursColumn, studentCountColumn, avgGPAColumn);

        // Set the data to the courseTableView
        courseTableView.setItems(courseData);
    }

    private void displayStudentInfo(List<StudentDTO> studentInfoList) {
        // Clear existing columns
        studentTableView.getColumns().clear();

        // Create the data for the Student TableView
        ObservableList<StudentDTO> studentData = FXCollections.observableArrayList(studentInfoList);

        // Create TableColumn for Student Name
        TableColumn<StudentDTO, String> columnName = new TableColumn<>("Student Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Create TableColumn for Student Year
        TableColumn<StudentDTO, Integer> columnYear = new TableColumn<>("Year");
        columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        // Create TableColumn for Course Count
        TableColumn<StudentDTO, Integer> columnCourseCount = new TableColumn<>("Course Count");
        columnCourseCount.setCellValueFactory(new PropertyValueFactory<>("courseCount"));

        // Create TableColumn for Student Avg GPA
        TableColumn<StudentDTO, Double> columnStudentAvgGPA = new TableColumn<>("Student Avg GPA");
        columnStudentAvgGPA.setCellValueFactory(new PropertyValueFactory<>("studentAvgGPA"));

        studentTableView.getColumns().addAll(columnName, columnYear, columnCourseCount, columnStudentAvgGPA);

        studentTableView.setItems(studentData);
    }

    private void displayDepartments(List<DepartmentsDTO> departments) {
        // Clear existing columns
        deptTableView.getColumns().clear();

        // Create the data for the TableView
        ObservableList<DepartmentsDTO> data = FXCollections.observableArrayList(departments);

        // Create TableColumn for Department Name
        TableColumn<DepartmentsDTO, String> columnName = new TableColumn<>("Department Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        deptTableView.getColumns().add(columnName);

        deptTableView.setItems(data);
    }

    private void displayStudents(List<StudentDTO> students) {
        // Clear existing columns
        studentTableView.getColumns().clear();

        // Create the data for the TableView
        ObservableList<StudentDTO> data = FXCollections.observableArrayList(students);

        // Create TableColumn for Student Name
        TableColumn<StudentDTO, String> columnName = new TableColumn<>("Student Name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Create TableColumn for Year
        TableColumn<StudentDTO, Integer> columnYear = new TableColumn<>("Year");
        columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        // Create TableColumn for Semester
        TableColumn<StudentDTO, String> columnSemester = new TableColumn<>("Semester");
        columnSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));

        // Create TableColumn for GPA
        TableColumn<StudentDTO, Double> columnGPA = new TableColumn<>("GPA");
        columnGPA.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        // Add all columns to the TableView
        studentTableView.getColumns().addAll(columnName, columnYear, columnSemester, columnGPA);

        // Set data to the TableView
        studentTableView.setItems(data);
    }

}
