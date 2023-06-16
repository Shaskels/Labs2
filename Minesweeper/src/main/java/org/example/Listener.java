package org.example;

import model.Events;

public interface Listener {
    void update(Events eventType, int x, int y);
}
