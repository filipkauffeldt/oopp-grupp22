package com.crocket.model;

import java.util.Queue;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;
import com.crocket.model.interfaces.IEventListener;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import com.crocket.model.interfaces.IPowerUp;

public class Player {
    private String name;
    private int strokes;
    private boolean finished;
    private Queue<Entity> remainingTargets; // Queue of hoops and peg that have not been passed yet
    private Ball ball;
    private List<IPowerUp> powerUps;

    public Player(Ball ball, String name) {
        this.remainingTargets = new LinkedList<Entity>();
        this.strokes = 0;
        this.finished = false;
        this.ball = ball;
        this.name = name;
        this.powerUps = new ArrayList<IPowerUp>();

    }

    // Checks if the player has passed through all hoops
    public boolean hasWon() {
        if (this.remainingTargets.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void applyPowerUp(Integer index) {
        IPowerUp powerUp = this.powerUps.get(index);
        powerUp.applyPowerUp(this.ball);
        this.powerUps.remove(powerUp);
    }

    public boolean passTarget(Entity hoop) {
        if (this.remainingTargets.peek() == hoop) {
            this.remainingTargets.poll();
            return true;
        }
        return false;
    }

    public void incrementStrokes() {
        this.strokes++;
    }

    public void resestStrokes() {
        this.strokes = 0;
    }

    public void addTarget(Entity target) {
        this.remainingTargets.add(target);
    }

    public void setTargets(Queue<Entity> targets) {
        this.remainingTargets.clear();
        for (Entity target : targets) {
            this.addTarget(target);
        }

    }

    public void addPowerUp(IPowerUp powerUp) {
        this.powerUps.add(powerUp);
    }

    public void addPowerUps(List<IPowerUp> powerUps) {
        for (IPowerUp powerUp : powerUps) {
            this.addPowerUp(powerUp);
        }
    }

    public void shootBall(double angle, double power) {
        double sinus = Math.sin(angle);
        double cosinus = Math.cos(angle);

        this.ball.startBall(cosinus, sinus, power);

        incrementStrokes();
    }

    public Queue<Entity> getRemainingTargets() {
        return remainingTargets;
    }

    public int getStrokes() {
        return this.strokes;
    }

    public Ball getBall() {
        return ball;
    }
}
