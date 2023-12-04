package com.crocket.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import com.crocket.model.DrawableEntity;
import com.crocket.model.interfaces.IModel;
import com.crocket.view.CroquetView;
import com.crocket.view.interfaces.ILevelView;

public class CroquetController implements KeyListener {

    private CroquetView view;
    private ILevelView levelView;
    private IModel model;

    private double power;
    private int maxPower = 40;
    private boolean powerIsMax = false;

    public CroquetController(CroquetView view, ILevelView levelView, IModel model) {
        this.view = view;
        this.levelView = levelView;
        this.model = model;

        view.addKeyListener(this);
    }

    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                model.aimRight();
                break;
            case KeyEvent.VK_D:
                model.aimRight();
                break;
            case KeyEvent.VK_LEFT:
                model.aimLeft();
                break;
            case KeyEvent.VK_A:
                model.aimLeft();
                break;
            case KeyEvent.VK_SPACE:
                if (model.shotAllowed()) {
                    view.setPowerMeterVisibility(true);
                    if (power >= maxPower) {
                        powerIsMax = true;
                    } else if (power <= 1) {
                        powerIsMax = false;
                    }

                    if (!powerIsMax) {
                        power += 1;
                        view.incrementIndicator();
                    } else {
                        power -= 1;
                        view.decrementIndicator();
                    }
                }
                break;
        }
    }

    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE && model.shotAllowed()) {
            model.shootBall((int) power);
            power = 1;
            view.resetIndicator();
        }
    }

    public void keyTyped(KeyEvent ke) {

    }


    public void update() {
        model.update();

        Set<DrawableEntity> drawableEntities = model.getDrawableEntities();

        levelView.drawEntities(drawableEntities);
    }

    

}
