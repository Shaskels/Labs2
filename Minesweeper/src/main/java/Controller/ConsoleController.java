package Controller;

import Model.Events;
import View.Console.ConsoleView;
import org.example.Listener;
import Model.Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConsoleController implements Controller, Listener {

    int fSizeX = 9;
    int fSizeY = 9;
    int defaultMineCount = 10;
    Properties p;
    Model model;
    ConsoleView view;

    ConsoleController() throws IOException {
        FileReader reader = new FileReader("src/main/recourses/settings.properties");
        p = new Properties();
        p.load(reader);
        try {
            fSizeX = Integer.parseInt(p.getProperty("x"));
            fSizeY = Integer.parseInt(p.getProperty("y"));
            defaultMineCount = Integer.parseInt(p.getProperty("mine_count"));
        }
        catch (NumberFormatException e) {
            fSizeX = 9;
            fSizeY = 9;
            defaultMineCount = 10;
        }
    }

    @Override
    public void newGame() {
        this.model = new Model();
        model.event.subscribeAll(this);
        //model.newGame(fSizeX, fSizeY, defaultMineCount);
        view = new ConsoleView(model, this);
        //SwingUtilities.invokeLater(view::init);

    }

    @Override
    public void update(Events eventType, int x, int y) {
        switch (eventType) {

        }

    }
}
