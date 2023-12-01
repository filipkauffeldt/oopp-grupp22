package com.crocket;

import java.util.HashSet;
import java.util.Set;

public class Application {

    private static final int delay = 20;
    private static CroquetView frame = CroquetView.getInstance();
    private static TextureManager textureManager = new TextureManager();
    private static LevelView level1View = new LevelView(textureManager);
    static DrawBall ballView = new DrawBall();

    static DrawStone stoneView = new DrawStone();
    static Ball ball = new Ball(19,19,100,200,2);
    static Stone stone = new Stone(25, 25, 200, 300);
    static DirectionLine directionLine = new DirectionLine(90, 120, 120, 10, 3);
    static CroquetController cc = new CroquetController(frame, ball, stone, directionLine);
    


    public static void main( String[] args)
    {
        init(); 
    }

    private static void init(){
        try{
             textureManager.loadTextures();
        }
        catch(Exception ex){}
        Set<DrawableEntity> drawables = new HashSet<DrawableEntity>();
        DrawableEntity test = new DrawableEntity(100, 100, 30, 30, 90, EntityType.HOOP);
        DrawableEntity test2 = new DrawableEntity(180, 100, 30, 30, 90, EntityType.HOOP);
        DrawableEntity test3 = new DrawableEntity(200, 200, 30, 30, 180, EntityType.HOOP);
        DrawableEntity test4 = new DrawableEntity(300, 280, 30, 30, 270, EntityType.HOOP);
        drawables.add(test);
        drawables.add(test2);
        drawables.add(test3);
        drawables.add(test4);
        Level1 level1 = new Level1(); 
        level1View.setSurfaceMap(level1.getLevelSurfacemap(), level1.getLevelHeight(), level1.getLevelWidth());
        frame.setLevelView(level1View);
        frame.setBallToLevel(ballView);
        frame.setStoneToLevel(stoneView);
        level1View.drawEntities(drawables);
        Thread run = new Thread();
        run.start();
        
        while(true){
            try{
                Thread.sleep(delay);
            }
            catch(Exception ex){}
            cc.update();
        }   

    }
}