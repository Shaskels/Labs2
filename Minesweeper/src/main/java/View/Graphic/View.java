package View.Graphic;

import Controller.GraphicController;
import Model.Model;

import javax.swing.*;

public class View extends JFrame {
    private MainGameFrame frame;

    public void newGame(Model model, GraphicController controller, int fWidth, int fHeight, int mineCount){
        frame = new MainGameFrame(/*model*/ controller, fWidth, fHeight, mineCount);
    }
}
