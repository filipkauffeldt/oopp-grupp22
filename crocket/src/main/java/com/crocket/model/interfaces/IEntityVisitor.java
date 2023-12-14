package com.crocket.model.interfaces;

import com.crocket.model.DirectionLine;
import com.crocket.model.entity.Entity;
import com.crocket.model.entity.Hoop;

/**
 * This interface is a visitor interface. It is a Visitor design pattern for entities.
 * It declares visit methods for each concrete entity type.
 */

public interface IEntityVisitor {
    
    /**
     * Visit method for a generic Entity object.
     * 
     * Default visit method for an Entity object.
     *  
     * @param entity the Entity object to be visited
     */
    public void visit(Entity entity); 
    
    /**
     * Visit method for a Hoop object.
     *
     * @param hoop the Hoop object to be visited
     */
    public void visit(Hoop hoop);

    /**
     * Visit method for a DirectionLine object.
     *
     * @param directionLine the DirectionLine object to be visited
     */
    public void visit(DirectionLine directionLine);
}