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

//transition of arrow DONE
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
    boolean player1EntryThrow = false;
    boolean player2EntryThrow = false;
    int tileValuePlayer1 = 1;
    int tileValuePlayer2 = 1;



    TranslateTransition translationFunction(double time, Node object, double x, double y, double z, int count, boolean autoreturn){
        TranslateTransition translate;
        translate = new TranslateTransition(Duration.millis(time),object);
        if (count == -1){
            translate.setCycleCount(INDEFINITE);
        }else{
            translate.setCycleCount(count);
        }
        //translate.setFromX(object.getTranslateX());
        translate.setByX(x);
        translate.setByY(y);
        translate.setByZ(z);
        translate.setAutoReverse(autoreturn);

        return translate;
    }

    int x = 38;
    //problems with writing entry throw here, or maybe thats the solution of using it this way
    //adding +1 to the tile not everytime a dice is thrown, but everytime the random value is added to the main file

    void playerInformation(Node player,int playerID, int rand,int currentX, int currentY, int currentZ,int tileValue) {
            if (playerID == 1) {
                if (tileValuePlayer1 % 10 == 0 && tileValuePlayer1>=10) { //in case the tile number is 10,20,30,40,50....60..90
                    System.out.println("in 10");
                    translationFunction(300, player, 0, -60, 0, 1, false).play();


                } else {
                    if ((tileValuePlayer1 % 10) - 1 == 0 && tileValuePlayer1 >= 10 ) { //in case of tile number is 11,21,31,41..91
                        x = -x;
                    }
                    translationFunction(300, player, x, 0, 0, 1, false).play();
                }
                ++tileValuePlayer1;

            } else {
                if (tileValuePlayer2 % 10 == 0 && tileValuePlayer2 >= 10) { //in case the tile number is 10,20,30,40,50....60
                    translationFunction(300, player, 0, -60, 0, 1, false).play();

                } else {
                    if ((tileValuePlayer2 - 1) % 10  == 0 && tileValuePlayer2 >= 10) { //in case of tile number is 11,12,13,14,
                        x = -x;
                    }
                    translationFunction(300, player, x, 0, 0, 1, false).play();

                }
                ++tileValuePlayer2;
            }
        }

    //create a int that keeps a track of the positon of the dices in the gamei

    @FXML
    void Roll_Dice(MouseEvent event) {

        Node n;
        boolean entryThrowRegister;
        int tileValue;
        //switching of player
        if (playerbool){
            playerID = 1;
            n = player1;
            entryThrowRegister = player1EntryThrow;
            tileValue = tileValuePlayer1;


        }else{
            playerID = 2; //done
            n = player2;
            entryThrowRegister = player2EntryThrow;
            tileValue = tileValuePlayer2;
        }
        if(!flag3000) {
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

        if (!entryThrowRegister) {
            if (rand == 1) {
                if (playerID == 1) {
                    translationFunction(300, n, 12, -60, 0, 1, false).play();
                    player1EntryThrow = true;
                } else {
                    translationFunction(300, n, -15, -60, 0, 1, false).play();
                    player2EntryThrow = true;
                }
            }
        }
        else {
            for (int i = 0; i < rand; i++) {
                playerInformation(n, playerID, rand, 0, 0, 0, tileValue);
            }
        }


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

