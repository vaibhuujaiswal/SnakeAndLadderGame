package sample;

import javafx.animation.*;

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
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static javafx.animation.Animation.INDEFINITE;

//transition of arrow DONE
//ask senior about how the rubric is for this project (probably the TA or some other TA)
//connect dice movmenent to the pieces
//along with this think how to

public class Controller extends Main {

    public static ArrayList<Player> playerArray = new ArrayList<Player>();

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
        playerArray.add(new Player(player1,1,false,1,38,12,-60));
        playerArray.add(new Player(player2,2,false,1,38,-15,-60));

        System.out.println(playerArray.get(0).getPlayerID());
        System.out.println(playerArray.get(1).isPlayerEntrythrow());
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
    boolean flag3000 = false;

    private TranslateTransition movement;



    TranslateTransition translationFunction(double time, Node object, double x, double y, double z, int count, boolean autoreturn, int playerID){

        if (playerID == 1){
            object = player1;
//            System.out.println(playerArray.get(playerID - 1).getPlayerTileNumber());
        }else if(playerID == 2) {
            object = player2;
//            System.out.println(playerArray.get(playerID - 1).getPlayerTileNumber());
        }else{
            System.out.println("Error in player ID in Translation function");
        }
        System.out.println("For player ID" + playerID + "Image view of" + object);
        TranslateTransition translate;
        translate = new TranslateTransition(Duration.millis(time),object);
        if (count == -1){
            translate.setCycleCount(INDEFINITE);
        }else{
            translate.setCycleCount(count);
        }
        translate.setByX(x);
        translate.setByY(y);
        translate.setByZ(z);
        translate.setAutoReverse(autoreturn);

        return translate;
    }

    //problems with writing entry throw here, or maybe thats the solution of using it this way
    //adding +1 to the tile not everytime a dice is thrown, but everytime the random value is added to the main file

    TranslateTransition playerInformation(int playerID) {
        TranslateTransition t;
        if (playerArray.get(playerID - 1).getPlayerTileNumber() % 10 == 0 && playerArray.get(playerID - 1).getPlayerTileNumber() >= 10) { //in case the tile number is 10,20,30,40,50....60..90
            System.out.println("in 10 for player 1");
            t = translationFunction(300, playerArray.get(playerID - 1).getPlayern(), 0, -50, 0, 1, false,playerID);

        }else {
            if (((playerArray.get(playerID - 1).getPlayerTileNumber()) - 1 % 10) == 0 && playerArray.get(playerID - 1).getPlayerTileNumber() >= 10) { //in case of tile number is 11,21,31,41..91
                System.out.println("in 11 for player 1");
                System.out.println("");
                playerArray.get(playerID - 1).setxAxis(-(playerArray.get(playerID - 1).getxAxis()));
            }
            System.out.println("In other values");
            t = translationFunction(300, playerArray.get(playerID - 1).getPlayern(), playerArray.get(playerID - 1).getxAxis(), 0, 0, 1, false,playerID);
        }
        playerArray.get(playerID - 1).setPlayerTileNumber(playerArray.get(playerID - 1).getPlayerTileNumber() + 1);
        return t;
    }
    boolean diceFinishedFlag = true;

    @FXML
    void Roll_Dice(MouseEvent event) {
        if (diceFinishedFlag) {
            diceFinishedFlag = false;
            if (playerbool) {
                playerID = 1;

            } else {
                playerID = 2; //done
            }
            if (!flag3000) {
                movement = translationFunction(300, arrow, 0, -10, 0, -1, true, 0);
                movement.play();
                flag3000 = true;
            }

            //rolling dice
            int rand = (int) (Math.random() * 6 + 1);
            File file = new File("src/sample/dice/dice" + (rand) + ".png");
            dice_image.setImage(new Image(file.toURI().toString()));
            File pageChange = new File("src/sample/playerDull" + (playerID) + ".png");
            playerbool = !playerbool;
            identificationArea.setImage(new Image(pageChange.toURI().toString()));

            if (!playerArray.get(playerID - 1).isPlayerEntrythrow()) {
                if (rand == 1) {
                    System.out.println("opened the values");
                    int tempX = playerArray.get(playerID - 1).getInitalXforPlayer();
                    int tempY = playerArray.get(playerID - 1).getInitalYforPlayer();
                    System.out.println("Inital X value:" + tempX);
                    System.out.println("Inital Y values" + tempY);
                    translationFunction(300, playerArray.get(playerID - 1).getPlayern(), tempX, tempY, 0, 1, false, playerID).play();
                    playerArray.get(playerID - 1).setPlayerEntrythrow(true);
                }
                diceFinishedFlag = true;
            } else {
                Timeline t = new Timeline(new KeyFrame(Duration.millis(350), e -> {
                    playerInformation(playerID).play();
                }));
                t.setCycleCount(rand);
                t.play();

                t.setOnFinished(e -> diceFinishedFlag = true);
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

