package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.util.Random;

import static javafx.animation.Animation.INDEFINITE;

//transition of arrow
//ask senior about how the rubric is for this project (probably the TA or some other TA)
//connect dice movmenent to the pieces
//along with this think how to

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

    @FXML
    private ImageView arrow; //yellow arrow

    Random random = new Random();
    boolean playerbool = true;
    int playerID = 1;

    private TranslateTransition movement;
    private boolean flag3000 = false;

    TranslateTransition translationFunction(double time, Node object, double x, double y, double z, int count, boolean autoreturn){
        TranslateTransition translate;
        translate = new TranslateTransition(Duration.millis(time),object);
        if (count == -1){
            translate.setCycleCount(INDEFINITE);
        }else{
            translate.setCycleCount(count);
        }
        translate.setToX(x);
        translate.setToY(y);
        translate.setToX(z);
        translate.setAutoReverse(autoreturn);

        return translate;
    }



    @FXML
    void Roll_Dice(MouseEvent event) {

        //switching of player
        if (playerbool == true){
            playerID = 1;
        }else{
            playerID = 2;
        }
        if(flag3000 == false) {
            movement = translationFunction(300, arrow, 0, -10, 0, -1, true);
            movement.play();
            flag3000 = true;
        }

        //rolling dice
        int rand = (int)(Math.random()*6+1);
        File file = new File("src/sample/dice/dice" + (rand) + ".png");
        dice_image.setImage(new Image(file.toURI().toString()));
        File pageChange = new File("src/sample/playerDull" + (playerID) + ".png");
        playerbool = !playerbool;
        identificationArea.setImage(new Image(pageChange.toURI().toString()));

//        movement.stop();

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

