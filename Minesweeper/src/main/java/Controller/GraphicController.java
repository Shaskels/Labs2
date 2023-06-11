package Controller;

import View.Graphic.View;
public class GraphicController implements Controller{

    View view;
    public GraphicController() {
        view = new View();
    }

    @Override
    public void newGame() {
        view.newGame();
    }

}
