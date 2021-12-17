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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Controller extends Main {

    @FXML
    private AnchorPane greetAnchor; //greeting Page

    @FXML
    private AnchorPane MainBoardAnchor; //main snakes and ladder game

    @FXML
    private Group greetBaseImage;

    @FXML
    private ImageView play;

    @FXML
    private ImageView returnLogo;

    @FXML
    void playGame(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("snakesandladder.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main board Game");
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

    @FXML
    private ImageView exitbutton; //red cross mark in main page

    Random random = new Random();


    @FXML
    void Roll_Dice(MouseEvent event) {
        int rand = (int)(Math.random()*6+1);
        File file = new File("src/sample/dice/dice" + (rand) + ".png");
        dice_image.setImage(new Image(file.toURI().toString()));

    }

    @FXML
    void return_Home(MouseEvent event) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        start(stage);
    }

    @FXML
    void exit_key(MouseEvent event) {
        Stage stage = (Stage) exitbutton.getScene().getWindow();
        stage.close();
    }



}

