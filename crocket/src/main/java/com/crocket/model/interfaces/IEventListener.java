package com.crocket.model.interfaces;

import com.crocket.model.PassTargetEvent;

public interface IEventListener {
    public void handleEvent(PassTargetEvent event);
}
