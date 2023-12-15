package com.crocket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;
import com.crocket.model.entity.PowerUpEntity;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.model.interfaces.IEventListener;
import com.crocket.model.interfaces.IModel;
import com.crocket.model.interfaces.IModelVisualiser;
import com.crocket.model.interfaces.IMovable;
import com.crocket.model.interfaces.IPowerUp;
import com.crocket.model.surface.SurfaceHandler;
import com.crocket.shared.SurfaceType;

public class Model implements IModel, IEventListener {
    private static final double NO_MOVEMENT_THRESHOLD = 0.5;

    private static Model instance = null;
    private List<Player> players;
    private List<Entity> targets;
    private Set<IMovable> movables;
    private Set<Entity> entities;
    private Set<ICollidable> collidables;
  
    private Map<Ball, Player> ballOwner;
  
    private Level level;

    private Set<IModelVisualiser> visualizerSubscribers;

    private Player activePlayer;
    private DirectionLine directionLine;
    private SurfaceHandler surfaceHandler;

    private int round;
    private boolean ballIsMoving;
    private boolean shotAllowed;

    private boolean running;
    private static final int DELAY = 20;

    private Model() {
        directionLine = new DirectionLine(0, 0, 0);
        surfaceHandler = SurfaceHandler.getInstance();
        round = 0;
        ballIsMoving = false;
        ballOwner = new HashMap<Ball, Player>();
        visualizerSubscribers = new HashSet<IModelVisualiser>();
    }

    public void start() {
        running = true;

        while (running) {
            try {
                Thread.sleep(DELAY);
            } catch (Exception ex) {
            }
            update();
        }
    }

    public void stop() {
        running = false;
    }

    private void validateLevelIsSet() {
        if (level == null) {
            throw new IllegalStateException("Level has not been set");
        }
    }

    private void nextRound() {
        validateLevelIsSet();

        round++;

        activePlayer = players.get(round % players.size());

        shotAllowed = true;
    }

    @Override
    public void handleEvent(PassTargetEvent event) {
        Player player = ballOwner.get(event.getBall());
        Entity target = event.getTarget();

        boolean passed = player.passTarget(target);

        if (!passed) {
            return;
        }

        if (player.hasWon()) {
            System.out.println(player.getName() + " has won!");
            stop();
            for (IModelVisualiser subscriber : visualizerSubscribers) {
                subscriber.notifyPlayerWon(player.getName());
            }
            System.exit(0);
        }
    }

    @Override
    public void handleEvent(HitPowerUpEvent event) {
        Player player = ballOwner.get(event.getBall());
        IPowerUp powerUp = event.getPowerUp();

        player.addPowerUp(powerUp);
    }

    @Override
    public void addSubscriber(IModelVisualiser subscriber) {
        visualizerSubscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(IModelVisualiser subscriber) {
        visualizerSubscribers.remove(subscriber);
    }

    private void populatePlayerEntities(List<Player> players) {
        for (Player player : players) {
            populatePlayerEntities(player);
        }
    }

    private void populatePlayerEntities(Player player) {
        entities.add(player.getBall());
        movables.add(player.getBall());
        ballOwner.put(player.getBall(), player);

        for (Entity target : targets) {
            player.addTarget(target);
        }
    }

    private void populatePowerUpEntities(List<PowerUpEntity> powerUps) {
        for (PowerUpEntity powerUp : powerUps) {
            populatePowerUpEntities(powerUp);
        }
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    private void populatePowerUpEntities(PowerUpEntity powerUp) {
        entities.add(powerUp);
        collidables.add(powerUp);
    }

    public void restartLevel() {
        validateLevelIsSet();

        setLevel(level);
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public List<Player> getPlayers() {
        validateLevelIsSet();

        return players;
    }

    public Set<DrawableEntity> getDrawableEntities() {
        validateLevelIsSet();

        EntityDrawableVisitor visitor = new EntityDrawableVisitor();
        for (Entity entity : entities) {
            entity.accept(visitor); 
        }

        if (shotAllowed) {
            directionLine.setPositionToBall(activePlayer.getBall());
            directionLine.accept(visitor);
        }
        return visitor.getDrawableEntities();
    }

    public SurfaceType[][] getLevelSurfacemap() {
        validateLevelIsSet();

        return level.getLevelSurfacemap();
    }

    public void setLevel(Level level) {
        this.level = level;

        entities = level.getEntities();
        movables = level.getMovables();
        collidables = level.getCollidables();
        targets = level.getTargets();

        if (players != null) 
            setPlayers(players);

        surfaceHandler.setSurfaceMap(level.getLevelSurfacemap());

        round = 0;
        ballIsMoving = false;
        shotAllowed = true;
    }

    public void update() {
        validateLevelIsSet();
        surfaceHandler.updateFriction(activePlayer.getBall());

        for (IMovable movable : movables) {
            movable.move();
        }

        for (ICollidable collidable : collidables) {
            collidable.collideWithBall(activePlayer.getBall());
        }

        if (ballIsMoving) {
            if (Math.abs(activePlayer.getBall().getxVelocity()) <= NO_MOVEMENT_THRESHOLD &&
                    Math.abs(activePlayer.getBall().getyVelocity()) <= NO_MOVEMENT_THRESHOLD) {
                ballIsMoving = false;
                activePlayer.getBall().setxVelocity(0);
                activePlayer.getBall().setyVelocity(0);
                nextRound();
            }
        }

        for (IModelVisualiser subscriber : visualizerSubscribers) {
            subscriber.update(getDrawableEntities());
        }
    }

    public void shootBall(int power) {
        validateLevelIsSet();

        activePlayer.shootBall(Math.toRadians(directionLine.getDegreeAngle()), power);
        ballIsMoving = true;
        shotAllowed = false;
    }

    public void updateAim(int degrees) {
        validateLevelIsSet();

        directionLine.setDegreeAngle(degrees);
    }

    public void aimRight() {
        directionLine.incrementDegreeAngle();
    }

    public void aimLeft() {
        directionLine.decrementDegreeAngle();
    }

    public void setPlayers(List<Player> players) {
        if (players == null) {
            throw new IllegalArgumentException("Players cannot be null");
        }

        if (players.size() < 1) {
            throw new IllegalArgumentException("There must be at least one player");
        }
        this.players = players;

        activePlayer = players.get(0);

        populatePlayerEntities(players);

    }

    public void addPlayer(Player player) {
        if (players == null) {
            players = new ArrayList<Player>();
        }

        players.add(player);

        if (activePlayer == null) {
            activePlayer = player;
        }

        populatePlayerEntities(player);
        for (Entity target : targets) {
            player.addTarget(target);
        }
    }

    public void clearPlayers() {
        players.clear();

        for (Player player : players) {
            entities.remove(player.getBall());
            movables.remove(player.getBall());
            ballOwner.remove(player.getBall());
        }

        activePlayer = null;
    }

    public boolean shotAllowed() {
        return shotAllowed;
    }
}
