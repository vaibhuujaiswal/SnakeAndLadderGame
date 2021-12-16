package sample;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.text.html.ImageView;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Controller {
    @FXML
    private ImageView playbutton;

    @FXML
    void playGame(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("snakesandladder.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.set("Snakes and Ladder");
        EmbeddedWindow primaryStage;
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    
    }
}
