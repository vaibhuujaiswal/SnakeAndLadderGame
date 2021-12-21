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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static javafx.animation.Animation.INDEFINITE;

//transition of arrow DONE
//ask senior about how the rubric is for this project (probably the TA or some other TA)
//connect dice movmenent to the pieces
//along with this think how to

public class Controller extends Main {

    public static ArrayList<Player> playerArray = new ArrayList<Player>();
    public static HashMap<Integer,Snakes> snakesHashMap = new HashMap<Integer,Snakes>();
    public static HashMap<Integer,Ladder> ladderHashMap = new HashMap<Integer,Ladder>();

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
        initalize();
        Parent root = FXMLLoader.load(getClass().getResource("snakesandladder.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main board Game");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void initalize(){
        playerArray.clear();
        playerArray.add(new Player(player1,1,false,1,38,12,-60));
        playerArray.add(new Player(player2,2,false,1,38,-15,-60));
        snakesHashMap.put(23,new Snakes(142,374,217,484,23,5));
        snakesHashMap.put(32,new Snakes(368,332,370,480,32,9));
        snakesHashMap.put(51,new Snakes(406,238,407,428,51,11));
        snakesHashMap.put(46,new Snakes(253,290,218,384,46,25));
        snakesHashMap.put(59,new Snakes(104,238,65,338,59,40));
        snakesHashMap.put(81,new Snakes(65,93,104,190,81,62));
        snakesHashMap.put(66,new Snakes(254,192,218,237,66,56));
        snakesHashMap.put(92,new Snakes(367,48,329,290,92,48));
        snakesHashMap.put(95,new Snakes(253,48,294,238,95,54));
        snakesHashMap.put(98,new Snakes(142,48,218,194,98,65));



        //Hardcode Hashmap of ladder
        ladderHashMap.put(2,new Ladder(104,479,65,380,21,2));       //1
        ladderHashMap.put(6,new Ladder(253,479,293,384,27,6));      //2
        ladderHashMap.put(8,new Ladder(333,479,332,329,33,8));      //3
        ladderHashMap.put(16,new Ladder(217,429,293,330,34,16));    //4
        ladderHashMap.put(24,new Ladder(177,383,177,190,64,24));    //5
        ladderHashMap.put(38,new Ladder(143,337,142,242,58,38));    //6
        ladderHashMap.put(63,new Ladder(141,189,105,90,82,63));     //7
        ladderHashMap.put(85,new Ladder(218,95,180,43,97,85));      //8
        ladderHashMap.put(73,new Ladder(332,142,293,43,94,73));     //9
        ladderHashMap.put(70,new Ladder(408,190,407,47,91,70));     //10




//        ladderHashMap.put()

//        ladderHashMap.put()
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
        }else if(playerID == 2) {
            object = player2;
        }else{
            System.out.println("Error in player ID in Translation function");
        }
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


    TranslateTransition playerInformation(int playerID,int tileCount) {
        TranslateTransition t;
        if (playerArray.get(playerID - 1).getPlayerTileNumber() % 10 == 0 && playerArray.get(playerID - 1).getPlayerTileNumber() >= 10) { //in case the tile number is 10,20,30,40,50....60..90
            System.out.println("in 10 for player 1");
            t = translationFunction(300, playerArray.get(playerID - 1).getPlayern(), 0, -45, 0, 1, false,playerID);
            int tempValue = playerArray.get(playerID - 1).getxAxis();
            tempValue = tempValue*-1;
            playerArray.get(playerID - 1).setxAxis(tempValue);

        }else {
//            if (((playerArray.get(playerID - 1).getPlayerTileNumber() - 1) % 10) == 0 && playerArray.get(playerID - 1).getPlayerTileNumber() >= 10) { //in case of tile number is 11,21,31,41..91
//                System.out.println("in 11 for player 1");
//                int tempValue = playerArray.get(playerID - 1).getxAxis();
//                tempValue = tempValue*-1;
//                playerArray.get(playerID - 1).setxAxis(tempValue);
//            }
            System.out.println("In other values");
            t = translationFunction(300, playerArray.get(playerID - 1).getPlayern(), playerArray.get(playerID - 1).getxAxis(), 0, 0, 1, false,playerID);
        }
        playerArray.get(playerID - 1).setPlayerTileNumber(playerArray.get(playerID - 1).getPlayerTileNumber() + tileCount);
        System.out.println("Tile in Player Information" + playerArray.get(playerID - 1).getPlayerTileNumber());
        return t;
    }
    boolean diceFinishedFlag = true;

    int dice(){
        int rand = (int) (Math.random() * 3 + 1);
        File file = new File("src/sample/dice/dice" + (rand) + ".png");
        dice_image.setImage(new Image(file.toURI().toString()));
        return rand;
    }

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
            if (playerArray.get(playerID - 1).getPlayerTileNumber() == 100){
                System.out.println("Game over");
            }

            int rand;
            rand = dice(); //random number generated and dice image found!

            File pageChange = new File("src/sample/playerDull" + (playerID) + ".png");
            identificationArea.setImage(new Image(pageChange.toURI().toString()));
            playerbool = !playerbool;


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
//                TranslateTransition tempTranslate = playerInformation(playerID,1);
//                Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(350), e -> {
//                    playerInformation(playerID,1).play();
//                }));
//
//
//
//                timeLine.setCycleCount(rand);
//                timeLine.play();
                Thread thread= new Thread(){
                    @Override
                    public void run() {
                        for(int i=0;i<rand;i++){
                            playerInformation(playerID,1).play();
                            try {
                                Thread.sleep(325);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        int beforeSnakeOrLadder=playerArray.get(playerID-1).getPlayerTileNumber();
                        if (snakesHashMap.containsKey(playerArray.get(playerID - 1).getPlayerTileNumber())) {
                            int snakeX = -snakesHashMap.get(playerArray.get(playerID - 1).getPlayerTileNumber()).getByX();
                            int snakeY = -snakesHashMap.get(playerArray.get(playerID - 1).getPlayerTileNumber()).getByY();
                            System.out.println("Snakes X position" + snakeX);
                            System.out.println("Snakes Y position" + snakeY);
                            System.out.println("Tile number previously for snakes is : " + playerArray.get(playerID - 1).getPlayerTileNumber());
                            playerArray.get(playerID - 1).setPlayerTileNumber(playerArray.get(playerID - 1).getPlayerTileNumber() - snakesHashMap.get(playerArray.get(playerID - 1).getPlayerTileNumber()).getSlide());
                            System.out.println("Tile number new for snake is : " + playerArray.get(playerID - 1).getPlayerTileNumber());
                            translationFunction(300, playerArray.get(playerID - 1).getPlayern(), snakeX, snakeY, 0, 1, false, playerID).play();


                        } else if (ladderHashMap.containsKey(playerArray.get(playerID - 1).getPlayerTileNumber())) {
                            int ladderX = ladderHashMap.get(playerArray.get(playerID - 1).getPlayerTileNumber()).getByX();
                            int ladderY = ladderHashMap.get(playerArray.get(playerID - 1).getPlayerTileNumber()).getByY();

                            System.out.println("Ladder X position" + ladderX);
                            System.out.println("Ladder Y position" + ladderY);
                            System.out.println("Tile number previously for ladder is : " + playerArray.get(playerID - 1).getPlayerTileNumber());
                            translationFunction(300, playerArray.get(playerID - 1).getPlayern(), ladderX, ladderY, 0, 1, false, playerID).play();
                            playerArray.get(playerID - 1).setPlayerTileNumber(playerArray.get(playerID - 1).getPlayerTileNumber() + ladderHashMap.get(playerArray.get(playerID - 1).getPlayerTileNumber()).getSlide());
                            System.out.println("Tile number current for ladder is : " + playerArray.get(playerID - 1).getPlayerTileNumber());
                        }
                        if(((beforeSnakeOrLadder)/10)%2!=((playerArray.get(playerID-1).getPlayerTileNumber())/10)%2){
                            playerArray.get(playerID-1).setxAxis(-playerArray.get(playerID-1).getxAxis());
                            if (playerArray.get(playerID-1).getPlayerTileNumber() == 91){
                                playerArray.get(playerID-1).setxAxis(playerArray.get(playerID-1).getxAxis());
                            }
                        }

                        diceFinishedFlag = true;
                    }
                };
                thread.start();

//                timeLine.setOnFinished(e -> diceFinishedFlag = true);
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

