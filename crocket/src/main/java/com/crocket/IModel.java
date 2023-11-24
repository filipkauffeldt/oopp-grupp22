package com.crocket;

import java.util.Set;

public interface IModel {
    public Set<DrawableEntity> getDrawableEntities();

    public Surface[][] getLevelTilemap();

    public void setLevel(ILevel level);
    public void restartLevel();

    public void update();
    public void shootBall(int power);
    public void updateAim(int degrees);
}
