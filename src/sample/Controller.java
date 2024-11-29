package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class Controller { // sign in page Java
    @FXML
    private Button close;

    @FXML
    private Button login;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    Alert alert;// for
    //for changing the Scene
    private Stage stage;
    private Scene scene;
    private Parent root;
    /*public void switchScene(ActionEvent event){
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        Stage.setScene(scene);
        stage.show();
    }*/

    //simple method to exit the window join it with Javafx button
    public void setClose(){
        System.exit(0);
    }
    @FXML
    private void handleLoginButtonAction() throws IOException {
        // Retrieve the input from the username and password fields
        String user = username.getText();//variable name
        String pass = password.getText();//fxid set in the scene builder, .getText() for taking the string

        // Check if the username and password are correct
        if (isValidLogin(user, pass)) { //applying check jani
            System.out.println("Login successful");
            //create a method to switch Scene
//            alert system
//            Alert alert = new Alert();
            alert =  new Alert(Alert.AlertType.INFORMATION);//type of alert you can create
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Welcome Admin ");
            alert.getDialogPane().setStyle("-fx-background-color: #f0cb35; -fx-font-size: 14px;");
//            ----------------------------------------
            // Create a label to display additional information
            Label additionalInfo = new Label("Click the button below to close the alert.");

            // Create a button to close the alert
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> {
                alert.close();
            });
            // Animate the alert window
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(alert.getDialogPane().scaleXProperty(), 0),
                            new KeyValue(alert.getDialogPane().scaleYProperty(), 0)),
                    new KeyFrame(Duration.seconds(5), new KeyValue(alert.getDialogPane().scaleXProperty(), 1),
                            new KeyValue(alert.getDialogPane().scaleYProperty(), 1))
            );
            timeline.setAutoReverse(true);
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();

//            ---------------------------------------
            alert.showAndWait();//use for to wait for the window to displayed
            // hide the login Scene once the admin is login login btn = fxid in scene builder
            login.getScene().getWindow().hide();//.window().hide(); is use to hide the previous window
//            Now link your scene together
          Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
          Stage stage = new Stage();
          Scene scene= new Scene(root);
          stage.initStyle(StageStyle.TRANSPARENT);// for hiding the window close and minimize button. upper things
          stage.setScene(scene);
            stage.show();

        } else {
            System.out.println("Invalid username or password");
            //if wrong this will run
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message ");
            alert.setHeaderText(null);
            alert.setContentText(" wrong password or username,Please contact the admin()");
            alert.showAndWait();
        }
    }

    // Dummy method to check if the username and password are correct
    private boolean isValidLogin(String username, String password) {
        return username.equals("admin") && password.equals("abc.123");
    }
}
