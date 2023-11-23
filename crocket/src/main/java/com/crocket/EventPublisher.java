package com.crocket;

import java.util.HashSet;
import java.util.Set;

public class EventPublisher {
    private static EventPublisher instance = null;
    private Set<IEventListener> listeners;
    
    private EventPublisher() {
        listeners = new HashSet<IEventListener>();
    }

    public static EventPublisher getInstance() {
        if (instance == null) {
            instance = new EventPublisher();
        }
        return instance;
    }

    public void addListener(IEventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IEventListener listener) {
        listeners.remove(listener);
    }

    public void publishEvent(PassTargetEvent event) {
        for (IEventListener listener : listeners) {
            listener.handleEvent(event);
        }
    }
}
