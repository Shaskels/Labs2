package Controller;

import View.Graphic.GraphicView;

import Model.*;
import org.example.Listener;

import java.awt.*;

public class GraphicController implements Controller, Listener {

    int fWidth;
    int fHeight;
    int minesCount;
    GraphicView view;
    Model model;
    static boolean gameStopped = false;
    public GraphicController(){
        this.model = new Model();
        model.event.subscribeAll(this);
        view = new GraphicView();
    }

    @Override
    public void newGame() {
        view.newGame(model, this, fWidth, fHeight, minesCount);
    }

    @Override
    public void update(Events eventType, int x, int y) {

    }

    public void cellPressedLeft(int x, int y) {
        model.openCell(new Point(x, y));
    }

    public void cellPressedRight(int x, int y) {
        model.changeCellState(new Point(x, y));
    }

    public void firstMove(int x, int y) {
        gameStopped = false;
        model.newGame(fWidth, fHeight, minesCount, x, y);
        view.setMines();
        startTimer();
        model.openCell(new Point(x, y));
    }

}
