package com.crocket.model.interfaces;

/**
 * 
 * The IMovable includes methods for getting and setting the x and y velocities of the object, 
 * which represent the speed and direction of the object's movement along the x and y axes respectively.
 * 
 * It also includes methods for getting the x and y positions of the object, 
 * which represent the current coordinates of the object within the 2D space.
 * 
 * The move method is expected to update the object's position based on its current velocities.
 */
public interface IMovable {
    /**
     * Returns the x velocity of the object.
     * 
     * @return double representing the x velocity
     */
    public double getxVelocity();

    /**
     * Returns the y velocity of the object.
     * 
     * @return double representing the y velocity
     */
    public double getyVelocity();

    /**
     * Sets the x velocity of the object.
     * 
     * @param xVelocity The new x velocity
     */
    public void setxVelocity(double xVelocity);

    /**
     * Sets the y velocity of the object.
     * 
     * @param yVelocity The new y velocity
     */
    public void setyVelocity(double yVelocity);

    /**
     * Returns the x position of the object.
     * 
     * @return double representing the x position
     */
    public double getxPosition();

    /**
     * Returns the y position of the object.
     * 
     * @return double representing the y position
     */
    public double getyPosition();

    /**
     * Updates the object's position based on its current velocities.
     */
    public void move();
}