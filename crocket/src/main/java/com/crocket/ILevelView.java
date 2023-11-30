
package com.crocket;
import java.util.Set; 


public interface ILevelView {
    public void drawEntities(Set<DrawableEntity> drawableEntities);
    public void setSurfaceMap(Surface[][] levelSurfacemap, int levelHeight, int levelWidth);
}
