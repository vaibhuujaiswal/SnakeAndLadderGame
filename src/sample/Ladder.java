package sample;

public class Ladder {
    private int ladderBaseX;
    private int ladderBaseY;
    private int ladderTopX;
    private int ladderTopY;
    private int ladderValueSetByX;
    private int ladderValueSetByY;
    private int ladderTopTileValue;
    private int ladderBaseTileValue;
    private int byX;
    private int byY;
    private int slide;

    public int getByX() {
        return byX;
    }

    public int getByY() {
        return byY;
    }



    public int getLadderBaseX() {
        return ladderBaseX;
    }

    public int getLadderBaseY() {
        return ladderBaseY;
    }

    public int getLadderTopX() {
        return ladderTopX;
    }

    public int getLadderTopY() {
        return ladderTopY;
    }

    public int getLadderTopTileValue() {
        return ladderTopTileValue;
    }

    public int getLadderBaseTileValue() {
        return ladderBaseTileValue;
    }

    public int getSlide() {
        return slide;
    }

    public Ladder(int ladderBaseX, int ladderBaseY, int ladderTopX, int ladderTopY, int ladderTopTileValue, int ladderBaseTileValue) {
        this.ladderBaseX = ladderBaseX;
        this.ladderBaseY = ladderBaseY;
        this.ladderTopX = ladderTopX;
        this.ladderTopY = ladderTopY;
        this.ladderTopTileValue = ladderTopTileValue;
        this.ladderBaseTileValue = ladderBaseTileValue;
        this.byX = (ladderBaseX - ladderBaseY);
        this.byY = (ladderBaseX - ladderBaseY);
        this.slide = ladderTopTileValue - ladderBaseTileValue;
    }


}
