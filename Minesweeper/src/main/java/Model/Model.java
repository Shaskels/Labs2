package Model;

import org.example.EventManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    public EventManager event;
    private List<Events> operations;
    public Model() {
        this.operations = new ArrayList<>();
        this.operations.addAll(Arrays.asList(Events.values()));
        this.event = new EventManager(operations);
    }
}
