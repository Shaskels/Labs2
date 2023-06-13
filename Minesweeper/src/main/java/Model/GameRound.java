package Model;

import java.awt.*;
import java.util.Vector;

public class GameRound {

    private final int fWidth;
    private final int fHeight;
    private final int minesCount;
    private int leftToOpen;
    private Vector<Point> notMinedPoints;
    private Field field;
    private final Point[] offsets = {
            new Point(-1, -1),
            new Point(-1, 0),
            new Point(-1, 1),
            new Point(0, -1),
            new Point(0, 1),
            new Point(1, -1),
            new Point(1, 0),
            new Point(1, 1)
    };


    public GameRound(int width, int height, int minesCount) {
        notMinedPoints = new Vector<>();
        this.fWidth = width;
        this.fHeight = height;
        this.minesCount = minesCount;
        this.leftToOpen = fHeight * fWidth - minesCount;
    }

    public void openCell(Point p) {

        field.open(p);
        leftToOpen--;
    }

    public int getNumOfMines(Point p) {
        return field.getNumOfMines(p);
    }

    public boolean checkWin() {
        return (leftToOpen == 0);
    }

    public State getState(Point p) {
        return field.getState(p);
    }

    public boolean getIsMined(Point p) {
        return field.getIsMined(p);
    }

    public Cell getCell(Point p) {
        return field.getCell(p);
    }

}
