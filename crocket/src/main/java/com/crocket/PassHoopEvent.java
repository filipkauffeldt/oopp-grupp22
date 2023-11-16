package com.crocket;

public class PassHoopEvent {
    private Ball ball;
    private Hoop hoop;

    public PassHoopEvent(Ball ball, Hoop hoop) {
        this.ball = ball;
        this.hoop = hoop;
    }

    public Ball getBall() {
        return ball;
    }

    public Hoop getHoop() {
        return hoop;
    }
}
