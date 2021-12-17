package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Controller {

    @FXML
    private Group greetBaseImage;

    @FXML
    private ImageView play;

    @FXML
    void playGame(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("snakesandladder.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ImageView dice_image;

    @FXML
    private ImageView identificationArea;

    @FXML
    private ImageView player1;

    @FXML
    private ImageView player2;

    Random random = new Random();

    @FXML
    void Roll_Dice(MouseEvent event) {
        ImageView dice_img = new ImageView();
        dice_img.setDisable(true);

        Thread thr = new Thread() {
            public void roll() {
                int side = 6;
                int i = 0;
                System.out.println("Runnning");
                try {
                    while (i != 15) {
                        File file = new File("src/sample/dice/dice" + (random.nextInt(side) + 1) + ".png");
                        dice_img.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                        i++;
                    }
                    dice_img.setDisable(false);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thr.start();

    }
}

