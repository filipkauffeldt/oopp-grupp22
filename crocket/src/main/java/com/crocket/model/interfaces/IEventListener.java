package com.crocket.model.interfaces;

import com.crocket.model.PassTargetEvent;
import com.crocket.model.HitPowerUpEvent;

public interface IEventListener {
    public void handleEvent(PassTargetEvent event);
    
    public void handleEvent(HitPowerUpEvent event);
}
