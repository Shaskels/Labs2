package org.example;

import Model.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<Events, List<Listener>> listeners = new HashMap<>();

    public EventManager(List<Events> events) {
        for (Events operation : events) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(Events eventType, Listener listener) {
        List<Listener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void subscribeAll(Listener listener) {
        for (Events event :Events.values()) {
            listeners.get(event).add(listener);
        }
    }
}
