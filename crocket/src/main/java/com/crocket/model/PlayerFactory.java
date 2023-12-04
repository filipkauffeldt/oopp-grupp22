package com.crocket.model;

import com.crocket.model.entity.Ball;


public class PlayerFactory {
    private final EventPublisher eventPublisher;

    protected PlayerFactory(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    public Player createPlayer(Ball playerBall, String playerName) {
        Player player = new Player(playerBall, playerName);
        this.eventPublisher.addListener(player);
        return player;
    }


}
