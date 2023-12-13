package com.crocket.model.interfaces;

/**
 * The IEntityVisitable interface represents objects that can accept an IEntityVisitor.
 * This is part of the Visitor design pattern, allowing different operations to be performed
 * on an object without modifying its class.
 */
public interface IEntityVisitable {

    /**
     * Accepts a visitor, allowing it to perform operations on the implementing object.
     *
     * @param visitor the IEntityVisitor to accept
     */
    public void accept(IEntityVisitor visitor);
}