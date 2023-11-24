package com.crocket;

import java.util.Set;

public interface IModel {
    public Set<Player> getPlayers();
    public Set<Entity> getEntities();

    public Surface[][] getLevelTilemap();

    public void setLevel(ILevel level);

    public void update();
    public void shootBall(int power);
    public void updateAim(int degrees);
}
