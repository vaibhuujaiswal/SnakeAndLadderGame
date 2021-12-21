package sample;

public class Snakes {
    private int snakeHeadX;
    private int snakeHeadY;
    private int snakeTailX;
    private int snakeTailY;
    private int headTileValue;
    private int tailTileValue;
    private int byX;
    private int byY;
    private int slide;

    public Snakes(int byX, int byY,int headTileValue, int tailTileValue) {
        this.headTileValue = headTileValue;
        this.tailTileValue = tailTileValue;
        this.byX = byX;
        this.byY = byY;
        this.slide = headTileValue - tailTileValue ;
    }

//    public Snakes(int snakeHeadX, int snakeHeadY, int snakeTailX, int snakeTailY, int headTileValue, int tailTileValue) {
//        this.snakeHeadX = snakeHeadX;
//        this.snakeHeadY = snakeHeadY;
//        this.snakeTailX = snakeTailX;
//        this.snakeTailY = snakeTailY;
//        this.headTileValue = headTileValue;
//        this.tailTileValue = tailTileValue;
//        this.byX = (snakeHeadX - snakeTailX);
//        this.byY = (snakeHeadY - snakeTailY);
//        this.slide = headTileValue - tailTileValue ;
//    }

    public int getByX() {
        return byX;
    }

    public int getByY() {
        return byY;
    }

    public int getSlide() {
        return slide;
    }

    public int getSnakeHeadX() {
        return snakeHeadX;
    }

    public int getSnakeHeadY() {
        return snakeHeadY;
    }

    public int getSnakeTailX() {
        return snakeTailX;
    }

    public int getSnakeTailY() {
        return snakeTailY;
    }

    public int getHeadTileValue() {
        return headTileValue;
    }

    public int getTailTileValue() {
        return tailTileValue;
    }
}
