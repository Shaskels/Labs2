package Controller;

import View.Graphic.GraphicView;

import Model.*;
import org.example.Listener;
import Model.Point;

public class GraphicController implements Controller, Listener {

    int fWidth;
    int fHeight;
    int minesCount;
    GraphicView view;
    Model model;
    static boolean gameStopped = false;
    Thread timer;
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

    public int getNumOfMines(int x, int y) {
        return model.getNumOfMines(x, y);
    }

    private void startTimer() {
        timer = new Thread(() -> {
            int second = 0;
            while (!gameStopped) {
                try {
                    view.setTime(second);
                    Thread.sleep(1000);
                    if (second < 999) second++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timer.start();

    }

}
