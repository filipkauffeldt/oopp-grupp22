package com.crocket.model.interfaces;

import java.util.Set;

import com.crocket.model.DrawableEntity;

public interface IModelVisualiser {
    /**
     * Updates the subscriber with a new set of drawable entities.
     * 
     * @param drawableEntities
     */
    public void update(Set<DrawableEntity> drawableEntities);
}
