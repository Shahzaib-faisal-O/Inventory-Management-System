package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;

public class Main extends Application {
   /* static {
        Font.loadFont(Main.class.getResource("/font/fontawesome-webfont.ttf").toExternalForm(),10);
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));//only root to eliminate height and width
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
