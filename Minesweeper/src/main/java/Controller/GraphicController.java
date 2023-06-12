package Controller;

import View.Graphic.View;

import java.io.IOException;
import Model.Model;

public class GraphicController implements Controller{

    int fWidth;
    int fHeight;
    int minesCount;
    View view;
    Model model;
    public GraphicController() throws IOException {
        this.model = new Model();
        model.events.subscribeAll(this);
        view = new View();
    }

    @Override
    public void newGame() {
        view.newGame(model, this, fWidth, fHeight, minesCount);
    }

}
