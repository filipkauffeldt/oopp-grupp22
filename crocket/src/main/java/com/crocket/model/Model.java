package com.crocket.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;
import com.crocket.model.entity.Hoop;
import com.crocket.model.entity.Peg;
import com.crocket.model.entity.PowerUpEntity;
import com.crocket.model.entity.Stone;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.model.interfaces.ILevel;
import com.crocket.model.interfaces.IModel;
import com.crocket.model.interfaces.IMovable;
import com.crocket.shared.EntityType;
import com.crocket.shared.Surface;

public class Model implements IModel {
    private static final double NO_MOVEMENT_THRESHOLD = 0.1;
    
    private static Model instance = null;
    private List<Player> players;
    private Set<IMovable> movables;
    private Set<Entity> entities;
    private Set<ICollidable> collidables;
    private ILevel level;
    private EventPublisher eventPublisher;

    private Player activePlayer;
    private DirectionLine directionLine;

    private int round;
    private boolean ballIsMoving;
    private boolean shotAllowed;

    private Model() {
        directionLine = new DirectionLine(0, 0, 0, 0, 0);
        round = 0;
        ballIsMoving = false;
        eventPublisher = EventPublisher.getInstance();
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

    private void populatePlayerEntities(List<Player> players) {
        for (Player player : players) {
            entities.add(player.getBall());
            movables.add(player.getBall());
            eventPublisher.addListener(player);
        }
    }

    private void populatePlayerEntities(Player player) {
        entities.add(player.getBall());
        movables.add(player.getBall());
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
            // TODO: Should be fixed. This is an ugly hack to get the direction line to show up. Breaks Law of Demeter.
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

    public Surface[][] getLevelSurfacemap() {
        validateLevelIsSet();

        return level.getLevelSurfacemap();
    }

    public void setLevel(ILevel level) {
        this.level = level;

        entities = level.getEntities();
        movables = level.getMovables();
        collidables = level.getCollidables();

        round = 0;
        ballIsMoving = false;
        shotAllowed = true;
    }

    public void update() {
        validateLevelIsSet();

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
        eventPublisher.addListener(player);
    }

    public void clearPlayers() {
        players.clear();

        for (Player player : players) {
            entities.remove(player.getBall());
            movables.remove(player.getBall());
            eventPublisher.removeListener(player);
        }

        activePlayer = null;
    }

    public boolean shotAllowed() {
        return shotAllowed;
    }

}
