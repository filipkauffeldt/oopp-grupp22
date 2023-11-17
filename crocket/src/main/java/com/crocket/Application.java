package com.crocket;
import javax.swing.*;

public class Application {

    private static final int delay = 20;
    private static CroquetView frame = CroquetView.getInstance();
    private static LevelView level1View = new LevelView(new Level1());
    static Ball ball = new Ball(19,19,100,200,2);
    static CroquetController cc = new CroquetController(frame, ball);
    


    public static void main( String[] args )
    {
        init(); 
    }

    private static void init(){
        frame.drawLevel(level1View);
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