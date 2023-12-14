package com.crocket.model;


import java.util.HashSet;
import java.util.Set;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;
import com.crocket.model.entity.Hoop;
import com.crocket.model.entity.Peg;
import com.crocket.model.entity.Stone;
import com.crocket.model.interfaces.IEntityVisitor;
import com.crocket.shared.EntityType;
import com.crocket.shared.Direction;

public class EntityDrawableVisitor implements IEntityVisitor { 
    private Set<DrawableEntity> drawableEntities;

    protected EntityDrawableVisitor() {
        drawableEntities = new HashSet<DrawableEntity>();   
    }

    private static EntityType getEntityTypeFromClass(Class<?> type) {
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

    private void addDrawableEntity(Entity entity, int rotation) {
        int xPosition = (int) entity.getxPosition();
        int yPosition = (int) entity.getyPosition();
        int width = entity.getWidth();
        int height = entity.getHeight();
        EntityType type = getEntityTypeFromClass(entity.getClass());
        drawableEntities.add(new DrawableEntity(xPosition, yPosition, width, height, rotation, type));
    }

    private void addDrawableEntity(DirectionLine directionLine, int rotation) {
        int xPosition = (int) directionLine.getxPosition();
        int yPosition = (int) directionLine.getyPosition();
        int width = (int) directionLine.getWidth();
        int height = (int) directionLine.getHeight();
        EntityType type = getEntityTypeFromClass(directionLine.getClass());
        drawableEntities.add(new DrawableEntity(xPosition, yPosition, width, height, rotation, type));
    }

    private int toDegrees(Direction direction) {
        switch (direction) {
            case NORTH  :
                return 0;
            case WEST:
                return 90;
            case SOUTH:
                return 180; 
            case EAST:
                return 270; 
            default:
                throw new IllegalArgumentException("Unknown direction");
        }
    }

    public void visit(Entity entity) {
        addDrawableEntity(entity, 0);
    }

    public void visit(Hoop hoop) {
        int rotation = toDegrees(hoop.getDirection());
        addDrawableEntity(hoop, rotation);
    }

    public void visit(DirectionLine directionLine) {
        int rotation = directionLine.getDegreeAngle();
        addDrawableEntity(directionLine, rotation);
    }

    public Set<DrawableEntity> getDrawableEntities() {
        return drawableEntities;
    }
}

