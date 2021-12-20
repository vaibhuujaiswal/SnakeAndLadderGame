package sample;

import javafx.scene.Node;

public class Player {
    private Node playern;
    private int playerID;
    private boolean playerEntrythrow;
    private int playerTileNumber;
    private int xAxis;
    private int initalXforPlayer; //= 12;
    private int initalYforPlayer; //= -15; //= -60;

    public Player(Node playern, int playerID, boolean playerEntrythrow, int playerTileNumber, int xAxis, int initalXforPlayer, int initalYforPlayer) {
        this.playern = playern;
        this.playerID = playerID;
        this.playerEntrythrow = playerEntrythrow;
        this.playerTileNumber = playerTileNumber;
        this.xAxis = xAxis;
        this.initalXforPlayer = initalXforPlayer;
        this.initalYforPlayer = initalYforPlayer;
    }

    public Node getPlayern() {
        return playern;
    }

    public boolean isPlayerEntrythrow() {
        return playerEntrythrow;
    }

    public int getInitalXforPlayer() {
        return initalXforPlayer;
    }

    public int getInitalYforPlayer() {
        return initalYforPlayer;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getPlayerTileNumber() {
        return playerTileNumber;
    }

    public void setPlayerEntrythrow(boolean playerEntrythrow) {
        this.playerEntrythrow = playerEntrythrow;
    }

    public void setPlayerTileNumber(int playerTileNumber) {
        this.playerTileNumber = playerTileNumber;
    }
}
