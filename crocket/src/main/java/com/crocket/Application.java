package com.crocket;
import javax.swing.*;

public class Application {

    private static final int delay = 20;
    private static CroquetView frame = CroquetView.getInstance();
    private static ILevel Level1 = new Level1();
    private static LevelView level1View = new LevelView();
    static DrawEntity ballView = new DrawEntity();
    static DrawStone stoneView = new DrawStone();
    static Ball ball = new Ball(19,19,100,200,2);
    static Stone stone = new Stone(25, 25, 200, 300);
    static DirectionLine directionLine = new DirectionLine(90, 120, 120, 10, 3);
    static CroquetController cc = new CroquetController(frame, ball, stone, directionLine);
    


    public static void main( String[] args )
    {
        init(); 
    }

    private static void init(){
        level1View.setSurfaceMap(Level1.getLevelSurfacemap(), Level1.getLevelHeight(), Level1.getLevelWidth());
        frame.setLevelView(level1View);
        frame.setBallToLevel(ballView);
        frame.setStoneToLevel(stoneView);
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