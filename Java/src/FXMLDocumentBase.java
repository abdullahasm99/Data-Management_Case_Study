
import DB.DatabaseManager;
import DTO.DepartmentsDTO;
import DTO.StudentDTO;
import DTO.EnrollmentsDTO;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;
import javax.swing.JOptionPane;

public class FXMLDocumentBase extends AnchorPane {

    protected final StackPane banner;
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Text text;
    protected final Button selectBtn;
    protected final Button deleteBtn;
    protected final Button updateBtn;
    protected final Button insertBtn;
    protected final Button gpaBtn;
    protected final TextField yearTextArea;
    protected final TextField dobTextArea;
    protected final TextField nameTextArea;
    protected final TextField idTextArea;
    protected final TextField joinDateTextArea;
    protected final TextField streetTextArea;
    protected final TextField cityTextArea;
    protected final TextField departmentTextArea;
    protected final TextField semesterTextArea;
    protected final Button homeBtn;
    //protected final Button analysisBtn;
    protected final TextField gpaTextArea;
    protected final TextField gpaYearTextArea;
    protected final TextField coursesNumTextArea;

    public FXMLDocumentBase() {

        banner = new StackPane();
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        text = new Text();
        selectBtn = new Button();
        deleteBtn = new Button();
        updateBtn = new Button();
        insertBtn = new Button();
        gpaBtn = new Button();
        yearTextArea = new TextField();
        dobTextArea = new TextField();
        nameTextArea = new TextField();
        idTextArea = new TextField();
        joinDateTextArea = new TextField();
        streetTextArea = new TextField();
        cityTextArea = new TextField();
        departmentTextArea = new TextField();
        semesterTextArea = new TextField();
        homeBtn = new Button();
        //analysisBtn = new Button();
        gpaTextArea = new TextField();
        gpaYearTextArea = new TextField();
        coursesNumTextArea = new TextField();

        setMaxHeight(700.0);
        setMaxWidth(900.0);
        setMinHeight(700.0);
        setMinWidth(900.0);
        setPrefHeight(700.0);
        setPrefWidth(900.0);
        setStyle("-fx-background-color: #001F3F;");

        banner.setPrefHeight(87.0);
        banner.setPrefWidth(900.0);
        banner.setStyle("-fx-background-color: #001F30;");

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

        selectBtn.setLayoutX(14.0);
        selectBtn.setLayoutY(649.0);
        selectBtn.setMnemonicParsing(false);
        selectBtn.setPrefHeight(37.0);
        selectBtn.setPrefWidth(142.0);
        selectBtn.setText("SHOW");
        selectBtn.setStyle("-fx-background-color: #001F3F;");
        selectBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        selectBtn.setFont(new Font("System Bold", 18.0));

        deleteBtn.setLayoutX(195.0);
        deleteBtn.setLayoutY(649.0);
        deleteBtn.setMnemonicParsing(false);
        deleteBtn.setPrefHeight(37.0);
        deleteBtn.setPrefWidth(142.0);
        deleteBtn.setText("CLEAR");
        deleteBtn.setStyle("-fx-background-color: #001F3F;");
        deleteBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        deleteBtn.setFont(new Font("System Bold", 18.0));

        updateBtn.setLayoutX(379.0);
        updateBtn.setLayoutY(649.0);
        updateBtn.setMnemonicParsing(false);
        updateBtn.setPrefHeight(37.0);
        updateBtn.setPrefWidth(142.0);
        updateBtn.setText("UPDATE");
        updateBtn.setStyle("-fx-background-color: #001F3F;");
        updateBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        updateBtn.setFont(new Font("System Bold", 18.0));

        insertBtn.setLayoutX(561.0);
        insertBtn.setLayoutY(649.0);
        insertBtn.setMnemonicParsing(false);
        insertBtn.setPrefHeight(37.0);
        insertBtn.setPrefWidth(142.0);
        insertBtn.setText("ADD");
        insertBtn.setStyle("-fx-background-color: #001F3F;");
        insertBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        insertBtn.setFont(new Font("System Bold", 18.0));

        gpaBtn.setLayoutX(744.0);
        gpaBtn.setLayoutY(649.0);
        gpaBtn.setMnemonicParsing(false);
        gpaBtn.setPrefHeight(37.0);
        gpaBtn.setPrefWidth(142.0);
        gpaBtn.setText("GPA");
        gpaBtn.setStyle("-fx-background-color: #001F3F;");
        gpaBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        gpaBtn.setFont(new Font("System Bold", 18.0));

        yearTextArea.setLayoutX(618.0);
        yearTextArea.setLayoutY(249.0);
        yearTextArea.setPrefHeight(30.0);
        yearTextArea.setPrefWidth(253.0);
        yearTextArea.setPromptText("Year");
        yearTextArea.setFont(new Font(14.0));

        dobTextArea.setLayoutX(324.0);
        dobTextArea.setLayoutY(249.0);
        dobTextArea.setPrefHeight(30.0);
        dobTextArea.setPrefWidth(253.0);
        dobTextArea.setPromptText("Date Of Birth");
        dobTextArea.setFont(new Font(14.0));

        nameTextArea.setLayoutX(30.0);
        nameTextArea.setLayoutY(249.0);
        nameTextArea.setPrefHeight(30.0);
        nameTextArea.setPrefWidth(253.0);
        nameTextArea.setPromptText("Student Name");
        nameTextArea.setFont(new Font(14.0));

        idTextArea.setLayoutX(30.0);
        idTextArea.setLayoutY(167.0);
        idTextArea.setPrefHeight(30.0);
        idTextArea.setPrefWidth(253.0);
        idTextArea.setPromptText("Enter the Student ID*");
        idTextArea.setFont(new Font(14.0));

        joinDateTextArea.setLayoutX(30.0);
        joinDateTextArea.setLayoutY(420.0);
        joinDateTextArea.setPrefHeight(30.0);
        joinDateTextArea.setPrefWidth(403.0);
        joinDateTextArea.setPromptText("Join Date");
        joinDateTextArea.setFont(new Font(14.0));

        streetTextArea.setLayoutX(324.0);
        streetTextArea.setLayoutY(334.0);
        streetTextArea.setPrefHeight(30.0);
        streetTextArea.setPrefWidth(546.0);
        streetTextArea.setPromptText("Street");
        streetTextArea.setFont(new Font(14.0));

        cityTextArea.setLayoutX(30.0);
        cityTextArea.setLayoutY(334.0);
        cityTextArea.setPrefHeight(30.0);
        cityTextArea.setPrefWidth(253.0);
        cityTextArea.setPromptText("City");
        cityTextArea.setFont(new Font(14.0));

        departmentTextArea.setLayoutX(468.0);
        departmentTextArea.setLayoutY(420.0);
        departmentTextArea.setPrefHeight(30.0);
        departmentTextArea.setPrefWidth(403.0);
        departmentTextArea.setPromptText("Department");
        departmentTextArea.setFont(new Font(14.0));

        semesterTextArea.setLayoutX(324.0);
        semesterTextArea.setLayoutY(167.0);
        semesterTextArea.setPrefHeight(30.0);
        semesterTextArea.setPrefWidth(253.0);
        semesterTextArea.setPromptText("Enter Semester(Fall/Spring) for GPA");
        semesterTextArea.setFont(new Font(14.0));

        homeBtn.setLayoutY(87.0);
        homeBtn.setMnemonicParsing(false);
        homeBtn.setPrefHeight(39.0);
        homeBtn.setPrefWidth(122.0);
        homeBtn.setStyle("-fx-background-color: #001F3F;");
        homeBtn.setText("HOME");
        homeBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        homeBtn.setFont(new Font("System Bold", 18.0));

        /*analysisBtn.setLayoutX(778.0);
        analysisBtn.setLayoutY(87.0);
        analysisBtn.setMnemonicParsing(false);
        analysisBtn.setPrefHeight(39.0);
        analysisBtn.setPrefWidth(122.0);
        analysisBtn.setStyle("-fx-background-color: #001F3F;");
        analysisBtn.setText("ANALYSIS");
        analysisBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        analysisBtn.setFont(new Font("System Bold", 18.0));*/
        gpaTextArea.setLayoutX(618.0);
        gpaTextArea.setLayoutY(500.0);
        gpaTextArea.setPrefHeight(30.0);
        gpaTextArea.setPrefWidth(253.0);
        gpaTextArea.setPromptText("GPA");
        gpaTextArea.setFont(new Font(14.0));

        gpaYearTextArea.setLayoutX(618.0);
        gpaYearTextArea.setLayoutY(167.0);
        gpaYearTextArea.setPrefHeight(30.0);
        gpaYearTextArea.setPrefWidth(253.0);
        gpaYearTextArea.setPromptText("Enter Year for GPA");
        gpaYearTextArea.setFont(new Font(14.0));

        coursesNumTextArea.setLayoutX(30.0);
        coursesNumTextArea.setLayoutY(500.0);
        coursesNumTextArea.setPrefHeight(30.0);
        coursesNumTextArea.setPrefWidth(253.0);
        coursesNumTextArea.setPromptText("Number of Courses");
        coursesNumTextArea.setFont(new Font(14.0));

        anchorPane.getChildren().add(imageView);
        banner.getChildren().add(anchorPane);
        banner.getChildren().add(text);
        getChildren().add(banner);
        getChildren().add(selectBtn);
        getChildren().add(deleteBtn);
        getChildren().add(updateBtn);
        getChildren().add(insertBtn);
        getChildren().add(gpaBtn);
        getChildren().add(yearTextArea);
        getChildren().add(dobTextArea);
        getChildren().add(nameTextArea);
        getChildren().add(idTextArea);
        getChildren().add(joinDateTextArea);
        getChildren().add(streetTextArea);
        getChildren().add(cityTextArea);
        getChildren().add(departmentTextArea);
        getChildren().add(semesterTextArea);
        getChildren().add(homeBtn);
        //getChildren().add(analysisBtn);
        getChildren().add(gpaTextArea);
        getChildren().add(gpaYearTextArea);
        getChildren().add(coursesNumTextArea);

        try {
            DatabaseManager.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        homeBtn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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

        selectBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Retrieve the student ID from the text field
                    int student_id = Integer.parseInt(idTextArea.getText());

                    // Perform a database query to fetch the student, department, and course count data for the given ID
                    DTO.StudentDepartmentPair result = DatabaseManager.getStudentById(student_id);

                    // Update the text fields with the retrieved data
                    if (result.getStudent() != null) {
                        StudentDTO student = result.getStudent();
                        DepartmentsDTO department = result.getDepartment();
                        int courseCount = result.getCourseCount();

                        idTextArea.setText(String.valueOf(student.getId()));
                        nameTextArea.setText(student.getName());
                        dobTextArea.setText(student.getDob());
                        cityTextArea.setText(student.getCity());
                        streetTextArea.setText(student.getStreet());
                        yearTextArea.setText(String.valueOf(student.getYear()));
                        joinDateTextArea.setText(student.getJoin_date());
                        departmentTextArea.setText(department.getName());
                        coursesNumTextArea.setText(String.valueOf(courseCount));

                    } else {
                        JOptionPane.showMessageDialog(null, "No student found for ID: " + student_id, "NOT FOUND", JOptionPane.ERROR_MESSAGE);
                        System.out.println("No student found for ID: " + student_id);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid student ID. Enter a number!", "ENTER A NUMBER", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Invalid student ID");
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        insertBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (idTextArea.getText().isEmpty() && nameTextArea.getText().isEmpty()
                        && dobTextArea.getText().isEmpty() && cityTextArea.getText().isEmpty()
                        && streetTextArea.getText().isEmpty() && yearTextArea.getText().isEmpty()
                        && joinDateTextArea.getText().isEmpty() && departmentTextArea.getText().isEmpty()
                        && gpaTextArea.getText().isEmpty() && coursesNumTextArea.getText().isEmpty()
                        && semesterTextArea.getText().isEmpty() && gpaYearTextArea.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Fields are empty.", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    try {
                        int student_id;
                        try {
                            student_id = Integer.parseInt(idTextArea.getText());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid input for Student ID. Please enter a valid integer.");
                        }

                        if (nameTextArea.getText().isEmpty() || dobTextArea.getText().isEmpty()
                                || cityTextArea.getText().isEmpty() || streetTextArea.getText().isEmpty()
                                || yearTextArea.getText().isEmpty() || joinDateTextArea.getText().isEmpty()
                                || departmentTextArea.getText().isEmpty()) {
                            throw new IllegalArgumentException("Please fill in all the required fields.");
                        }

                        if (DatabaseManager.studentExists(student_id)) {
                            throw new IllegalArgumentException("Student with ID " + student_id + " already exists.");
                        }

                        String name = nameTextArea.getText();
                        String dob = dobTextArea.getText();

                        if (!isValidDateFormat(dob)) {
                            throw new IllegalArgumentException("Invalid date format. Please enter the date in yyyy-mm-dd format.");
                        }

                        String city = cityTextArea.getText();
                        String street = streetTextArea.getText();

                        int year;
                        try {
                            year = Integer.parseInt(yearTextArea.getText());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid input for Year. Please enter a valid integer.");
                        }

                        String joinDate = joinDateTextArea.getText();
                        if (!isValidDateFormat(joinDate)) {
                            throw new IllegalArgumentException("Invalid date format. Please enter the date in yyyy-mm-dd format.");
                        }

                        int departmentId;
                        try {
                            departmentId = Integer.parseInt(departmentTextArea.getText());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid input for Department ID. Please enter a valid integer.");
                        }

                        if (!DatabaseManager.departmentExists(departmentId)) {
                            throw new IllegalArgumentException("Department with ID " + departmentId + " does not exist.");
                        }

                        StudentDTO newStudent = new StudentDTO(student_id, name, dob, city, street, year, joinDate, departmentId);

                        DatabaseManager.insertStudent(newStudent);

                        idTextArea.clear();
                        nameTextArea.clear();
                        dobTextArea.clear();
                        cityTextArea.clear();
                        streetTextArea.clear();
                        yearTextArea.clear();
                        joinDateTextArea.clear();
                        departmentTextArea.clear();
                        JOptionPane.showMessageDialog(null, "Student inserted successfully!", "Successful Insert", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Student inserted successfully!");
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Insert Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error: " + e.getMessage());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            private boolean isValidDateFormat(String date) {
                String regex = "\\d{4}-\\d{2}-\\d{2}";
                return date.matches(regex);
            }
        });

        deleteBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (idTextArea.getText().isEmpty() && nameTextArea.getText().isEmpty()
                        && dobTextArea.getText().isEmpty() && cityTextArea.getText().isEmpty()
                        && streetTextArea.getText().isEmpty() && yearTextArea.getText().isEmpty()
                        && joinDateTextArea.getText().isEmpty() && departmentTextArea.getText().isEmpty()
                        && gpaTextArea.getText().isEmpty() && coursesNumTextArea.getText().isEmpty()
                        && semesterTextArea.getText().isEmpty() && gpaYearTextArea.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Fields are already empty.", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    idTextArea.clear();
                    nameTextArea.clear();
                    dobTextArea.clear();
                    cityTextArea.clear();
                    streetTextArea.clear();
                    yearTextArea.clear();
                    joinDateTextArea.clear();
                    departmentTextArea.clear();
                    gpaTextArea.clear();
                    coursesNumTextArea.clear();
                    semesterTextArea.clear();
                    gpaYearTextArea.clear();

                    JOptionPane.showMessageDialog(null, "Fields cleared. Ready for new input.", "Fields Cleared", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        updateBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (idTextArea.getText().isEmpty() && nameTextArea.getText().isEmpty()
                        && dobTextArea.getText().isEmpty() && cityTextArea.getText().isEmpty()
                        && streetTextArea.getText().isEmpty() && yearTextArea.getText().isEmpty()
                        && joinDateTextArea.getText().isEmpty() && departmentTextArea.getText().isEmpty()
                        && gpaTextArea.getText().isEmpty() && coursesNumTextArea.getText().isEmpty()
                        && semesterTextArea.getText().isEmpty() && gpaYearTextArea.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Fields are empty.", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    try {
                        // Gather data from your input fields or text areas
                        int student_id;
                        try {
                            student_id = Integer.parseInt(idTextArea.getText());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid input for Student ID. Please enter a valid integer.");
                        }

                        // Check if the provided student ID exists
                        if (!DatabaseManager.studentExists(student_id)) {
                            throw new IllegalArgumentException("Student with ID " + student_id + " does not exist. Cannot update.");
                        }

                        String name = nameTextArea.getText();
                        String street = streetTextArea.getText();
                        String dob = dobTextArea.getText();
                        String city = cityTextArea.getText();

                        // Check if the date format is valid
                        if (!isValidDateFormat(dob)) {
                            throw new IllegalArgumentException("Invalid date format. Please enter the date in yyyy-mm-dd format.");
                        }

                        int year;
                        try {
                            year = Integer.parseInt(yearTextArea.getText());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid input for Year. Please enter a valid integer.");
                        }

                        String joinDate = joinDateTextArea.getText();

                        // Check if the date format for joinDate is valid
                        if (!isValidDateFormat(joinDate)) {
                            throw new IllegalArgumentException("Invalid date format. Please enter the date in yyyy-mm-dd format.");
                        }

                        int departmentId;
                        try {
                            departmentId = Integer.parseInt(departmentTextArea.getText());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Invalid input for Department ID. Please enter a valid integer.");
                        }

                        // Check if the provided department ID exists
                        if (!DatabaseManager.departmentExists(departmentId)) {
                            throw new IllegalArgumentException("Department with ID " + departmentId + " does not exist.");
                        }

                        // Call the stored procedure
                        DatabaseManager.updateStudentInfo(student_id, name, street, dob, city, year, joinDate, departmentId);

                        // Optionally, you can clear the input fields or display a success message
                        idTextArea.clear();
                        nameTextArea.clear();
                        dobTextArea.clear();
                        cityTextArea.clear();
                        streetTextArea.clear();
                        yearTextArea.clear();
                        joinDateTextArea.clear();
                        departmentTextArea.clear();

                        JOptionPane.showMessageDialog(null, "Student information updated successfully!", "Successful Update", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Student information updated successfully!");
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error: " + e.getMessage());
                    } catch (SQLException ex) {
                        ex.printStackTrace(); // Handle more gracefully in a real application
                    }
                }
            }

            private boolean isValidDateFormat(String date) {
                String regex = "\\d{4}-\\d{2}-\\d{2}";
                return date.matches(regex);
            }
        });

        gpaBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Gather data from input fields
                    String studentIdText = idTextArea.getText();
                    String semester = semesterTextArea.getText();
                    String yearText = gpaYearTextArea.getText();

                    if (studentIdText.isEmpty() || semester.isEmpty() || yearText.isEmpty()) {
                        showErrorDialog("Please fill in all the required fields.");
                        return;
                    }

                    int student_id = Integer.parseInt(studentIdText);
                    int year = Integer.parseInt(yearText);

                    if (!DatabaseManager.yearExists(year)) {
                        showErrorDialog("Year " + year + " does not exist in the database.");
                        return;
                    }

                    if (!semester.equalsIgnoreCase("Fall") && !semester.equalsIgnoreCase("Spring")) {
                        showErrorDialog("Invalid semester. Please enter 'Fall' or 'Spring'.");
                        return;
                    }

                    Double gpa = DatabaseManager.calculateGPA(student_id, semester, year);

                    if (gpa != null) {
                        gpaTextArea.setText("GPA: " + gpa);
                    } else {
                        gpaTextArea.setText("GPA information not available.");
                    }
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid input for student ID or year");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            private void showErrorDialog(String message) {
                JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}
