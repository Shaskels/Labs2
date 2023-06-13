package Controller;

import View.Graphic.View;

import java.io.IOException;
import Model.*;
import org.example.Listener;

public class GraphicController implements Controller, Listener {

    int fWidth;
    int fHeight;
    int minesCount;
    View view;
    Model model;
    public GraphicController(){
        this.model = new Model();
        model.event.subscribeAll(this);
        view = new View();
    }

    @Override
    public void newGame() {
        view.newGame(model, this, fWidth, fHeight, minesCount);
    }

    @Override
    public void update(Events eventType, int x, int y) {

    }


}
