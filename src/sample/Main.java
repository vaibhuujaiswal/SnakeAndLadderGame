package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.attribute.standard.Media;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        primaryStage.setTitle("Snakes and Ladder");
//        Media
//        Media media= new Media(Paths.get("src/sample/bg_UI.mp3").toUri().toString());
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
