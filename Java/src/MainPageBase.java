
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPageBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView imageFrame;
    protected final Text text;
    protected final Button studentBtn;
    protected final Button analysisBtn;
    protected final Button manageBtn;

    public MainPageBase() {

        anchorPane = new AnchorPane();
        imageFrame = new ImageView();
        text = new Text();
        studentBtn = new Button();
        analysisBtn = new Button();
        manageBtn = new Button();

        setMaxHeight(700.0);
        setMaxWidth(900.0);
        setMinHeight(700.0);
        setMinWidth(900.0);
        setPrefHeight(700.0);
        setPrefWidth(900.0);
        setStyle("-fx-background-color: #001F3F;");

        anchorPane.setMaxHeight(350.0);
        anchorPane.setMaxWidth(900.0);
        anchorPane.setMinHeight(350.0);
        anchorPane.setMinWidth(900.0);
        anchorPane.setPrefHeight(350.0);
        anchorPane.setPrefWidth(900.0);
        anchorPane.setStyle("-fx-background-color: #001F30;");

        imageFrame.setFitHeight(138.0);
        imageFrame.setFitWidth(170.0);
        imageFrame.setLayoutX(14.0);
        imageFrame.setLayoutY(14.0);
        imageFrame.setPickOnBounds(true);
        imageFrame.setPreserveRatio(true);
        Image image = new Image("atlas.png");
        imageFrame.setImage(image);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutY(362.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ATLAS UNIVERSITY");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(900.0);
        text.setFont(new Font("Eras Bold ITC", 36.0));

        studentBtn.setLayoutX(57.0);
        studentBtn.setLayoutY(576.0);
        studentBtn.setMnemonicParsing(false);
        studentBtn.setPrefHeight(42.0);
        studentBtn.setPrefWidth(125.0);
        studentBtn.setText("Students");
        studentBtn.setStyle("-fx-background-color: #001F3F;");
        studentBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        studentBtn.setFont(new Font("System Bold", 18.0));
        
        analysisBtn.setLayoutX(718.0);
        analysisBtn.setLayoutY(576.0);
        analysisBtn.setMnemonicParsing(false);
        analysisBtn.setPrefHeight(42.0);
        analysisBtn.setPrefWidth(125.0);
        analysisBtn.setText("Analysis");
        analysisBtn.setStyle("-fx-background-color: #001F3F;");
        analysisBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        analysisBtn.setFont(new Font("System Bold", 18.0));

        manageBtn.setLayoutX(380.0);
        manageBtn.setLayoutY(576.0);
        manageBtn.setMnemonicParsing(false);
        manageBtn.setPrefHeight(42.0);
        manageBtn.setPrefWidth(145.0);
        manageBtn.setText("Management");
        manageBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        manageBtn.setStyle("-fx-background-color: #001F3F;");
        manageBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        manageBtn.setFont(new Font("System Bold", 18.0));
        
        anchorPane.getChildren().add(imageFrame);
        getChildren().add(anchorPane);
        getChildren().add(text);
        getChildren().add(studentBtn);
        getChildren().add(analysisBtn);
        getChildren().add(manageBtn);
        
        analysisBtn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                
                try {
                    root = new AnalysisBase();
                } catch (SQLException ex) {
                    Logger.getLogger(MainPageBase.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);
                stage.setMaxHeight(800);
                stage.setMaxWidth(950);
                stage.show();
            }
        });
        
        studentBtn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                root = new FXMLDocumentBase();

                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);
                stage.setMaxHeight(800);
                stage.setMaxWidth(950);
                stage.show();
            }
        });
        
        
        manageBtn.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                root = new DeptCourseBase();

                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);
                stage.setMaxHeight(800);
                stage.setMaxWidth(950);
                stage.show();
            }
        });

    }
}
