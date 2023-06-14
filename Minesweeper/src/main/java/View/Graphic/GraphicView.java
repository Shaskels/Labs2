package View.Graphic;

import Controller.GraphicController;
import Model.Model;

import javax.swing.*;

public class GraphicView extends JFrame {
    private MainGameFrame frame;

    public void newGame(Model model, GraphicController controller, int fWidth, int fHeight, int mineCount){
        frame = new MainGameFrame(model, controller, fWidth, fHeight, mineCount);
    }

    public void setMines() {
        frame.setMines();
    }

    public Runnable setTime(int seconds) {
        frame.setTime(seconds);
        return null;
    }
}
