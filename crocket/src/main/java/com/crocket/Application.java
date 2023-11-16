package com.crocket;
import javax.swing.*;

public class Application extends JComponent{

    static CroquetView frame = new CroquetView();
      
    static Ball ball = new Ball(19,19,100,200,2);
    static CroquetController cc = new CroquetController(frame, ball);
    
    public static void main( String[] args ){
        init();   
    }
    
    private static void init(){
        
        Thread run = new Thread();
        run.start();
        while(true){
            try{
                Thread.sleep(20);
            }
            catch(Exception ex){}
            cc.update();
        }
    }
}
 