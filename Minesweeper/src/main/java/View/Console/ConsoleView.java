package View.Console;

import Controller.ConsoleController;
import Model.Events;
import Model.Model;
import View.View;
import org.example.Listener;

public class ConsoleView implements View, Listener {

    public ConsoleView(Model model, ConsoleController controller) {
        model.event.subscribeAll(this);
    }

    @Override
    public void update(Events eventType, int x, int y) {

    }

    public void printField() {

    }


    @Override
    public void init() {

    }
}