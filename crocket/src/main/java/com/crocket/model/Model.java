package com.crocket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;
import com.crocket.model.entity.Hoop;
import com.crocket.model.entity.Peg;
import com.crocket.model.entity.PowerUpEntity;
import com.crocket.model.entity.Stone;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.model.interfaces.IEventListener;
import com.crocket.model.interfaces.IModel;
import com.crocket.model.interfaces.IModelVisualiser;
import com.crocket.model.interfaces.IMovable;
import com.crocket.model.interfaces.IPowerUp;
import com.crocket.model.surface.SurfaceHandler;
import com.crocket.shared.EntityType;
import com.crocket.shared.SurfaceType;

public class Model implements IModel, IEventListener {
    private static final double NO_MOVEMENT_THRESHOLD = 0.1;

    private static Model instance = null;
    private List<Player> players;
    private Set<IMovable> movables;
    private Set<Entity> entities;
    private Set<ICollidable> collidables;
  
    private Map<Ball, Player> ballOwner;
  
    private Level level;
    private EventPublisher eventPublisher;

    private Set<IModelVisualiser> subscribers;

    private Player activePlayer;
    private DirectionLine directionLine;
    private SurfaceHandler surfaceHandler;

    private int round;
    private boolean ballIsMoving;
    private boolean shotAllowed;

    private boolean running;
    private static final int DELAY = 20;

    private Model() {
        directionLine = new DirectionLine(0, 0, 0, 0, 0);
        surfaceHandler = SurfaceHandler.getInstance();
        round = 0;
        ballIsMoving = false;
        eventPublisher = EventPublisher.getInstance();
        ballOwner = new HashMap<Ball, Player>();
        subscribers = new HashSet<IModelVisualiser>();
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

        player.passTarget(target);
    }

    @Override
    public void handleEvent(HitPowerUpEvent event) {
        Player player = ballOwner.get(event.getBall());
        IPowerUp powerUp = event.getPowerUp();

        player.addPowerUp(powerUp);
    }

    @Override
    public void addSubscriber(IModelVisualiser subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(IModelVisualiser subscriber) {
        subscribers.remove(subscriber);
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

        for (Entity target : level.getTargets()) {
            player.addTarget(target);
        }
    }

    private void populatePowerUpEntities(List<PowerUpEntity> powerUps) {
        for (PowerUpEntity powerUp : powerUps) {
            populatePowerUpEntities(powerUp);
        }
    }

    private void populatePowerUpEntities(PowerUpEntity powerUp) {
        entities.add(powerUp);
        collidables.add(powerUp);
    }

    public static EntityType getEntityTypeFromClass(Class<?> type) {
        if (type == Ball.class) {
            return EntityType.BALL;
        } else if (type == Hoop.class) {
            return EntityType.HOOP;
        } else if (type == Peg.class) {
            return EntityType.PEG;
        } else if (type == Stone.class) {
            return EntityType.STONE;
        } else if (type == DirectionLine.class) {
            return EntityType.DIRECTIONLINE;
        } else {
            throw new IllegalArgumentException("Unknown entity class");
        }
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

        Set<DrawableEntity> drawableEntities = new HashSet<DrawableEntity>();

        for (Entity entity : entities) {
            int xPosition = (int) entity.getxPosition();
            int yPosition = (int) entity.getyPosition();
            int width = entity.getWidth();
            int height = entity.getHeight();
            int rotation = 0;
            EntityType type = getEntityTypeFromClass(entity.getClass());

            drawableEntities.add(new DrawableEntity(xPosition, yPosition, width, height, rotation, type));
        }

        if (shotAllowed) {
            // TODO: Should be fixed. This is an ugly hack to get the direction line to show
            // up. Breaks Law of Demeter.
            directionLine.setxPosition(activePlayer.getBall().getxPosition());
            directionLine.setyPosition(activePlayer.getBall().getyPosition());

            int xPosition = (int) directionLine.getxPosition();
            int yPosition = (int) directionLine.getyPosition();
            int width = (int) directionLine.getWidth();
            int height = (int) directionLine.getHeight();
            int rotation = directionLine.getDegreeAngle();
            EntityType type = getEntityTypeFromClass(directionLine.getClass());

            drawableEntities.add(new DrawableEntity(xPosition, yPosition, width, height, rotation, type));
        }

        return drawableEntities;
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

        for (IModelVisualiser subscriber : subscribers) {
            subscriber.update(getDrawableEntities());
        }
    }

    public void shootBall(int power) {
        validateLevelIsSet();

        activePlayer.shootBall(directionLine.getDegreeAngle(), power);
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
        for (Entity target : level.getTargets()) {
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
