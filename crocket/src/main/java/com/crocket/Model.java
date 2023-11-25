package com.crocket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model implements IModel {
    private static Model instance = null;
    private List<Player> players;
    private Set<IMovable> movables;
    private Set<Entity> entities;
    private Set<Peg> pegs;
    private Set<Hoop> hoops;
    private ILevel level;

    private Player activePlayer;
    private DirectionLine directionLine;

    private int round;
    private boolean ballIsMoving;

    private Model() {
        activePlayer = new Player(new Ball(0, 0, 0, 0, 0));
        players.add(activePlayer);

        directionLine = new DirectionLine(0, 0, 0, 0, 0);
        round = 0;
        ballIsMoving = false;
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
            drawableEntities.add(new DrawableEntity(entity));
        }

        return drawableEntities;
    }

    public Surface[][] getLevelTilemap() {
        validateLevelIsSet();

        return level.getLevelTilemap();
    }

    public void setLevel(ILevel level) {
        this.level = level;

        entities = level.getEntities();
        movables = level.getMovables();
        pegs = level.getPegs();
        hoops = level.getHoops();

        round = 0;
        ballIsMoving = false;
    }

    public void update() {
        validateLevelIsSet();

        for (IMovable movable : movables) {
            movable.move();
        }

        if (ballIsMoving) {
            if (activePlayer.getBall().getxVelocity() == 0 && activePlayer.getBall().getyVelocity() == 0) {
                ballIsMoving = false;
                nextRound();
            }
        }
    }

    public void shootBall(int power) {
        validateLevelIsSet();

        activePlayer.shootBall(directionLine.getDegreeAngle(), power);
        ballIsMoving = true;
    }

    public void updateAim(int degrees) {
        validateLevelIsSet();

        directionLine.setDegreeAngle(degrees);
    }

}
