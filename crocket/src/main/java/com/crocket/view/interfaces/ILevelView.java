
package com.crocket.view.interfaces;
import java.util.Set;

import com.crocket.model.DrawableEntity;
import com.crocket.shared.SurfaceType; 


public interface ILevelView {
    public void drawEntities(Set<DrawableEntity> drawableEntities);
    public void setSurfaceMap(SurfaceType[][] levelSurfacemap, int levelHeight, int levelWidth);
}
