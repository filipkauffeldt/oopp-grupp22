
package com.crocket.view.interfaces;
import java.util.Set;

import com.crocket.model.DrawableEntity;
import com.crocket.shared.Surface; 


public interface ILevelView {
    public void drawEntities(Set<DrawableEntity> drawableEntities);
    public void setSurfaceMap(Surface[][] levelSurfacemap, int levelHeight, int levelWidth);
}
