package view.graphic;

import controller.GraphicController;
import model.Model;
import model.Events;
import view.View;
import org.example.Listener;

import javax.swing.*;

public class GraphicView extends JFrame implements View, Listener{
    private MainGameFrame frame;

    public void newGame(Model model, GraphicController controller, int fWidth, int fHeight, int mineCount) {
        if (frame != null) {
            frame.endGame();
        }
        frame = new MainGameFrame(model, controller, fWidth, fHeight, mineCount);
    }

    public void setMines() {
        frame.setMines();
    }

    @Override
    public void init() {
        frame.init();
    }

    @Override
    public void update(Events eventType, int x, int y) {
        frame.update(eventType, x, y);
    }

    public Runnable setTime(int seconds) {
        frame.setTime(seconds);
        return null;
    }
}
