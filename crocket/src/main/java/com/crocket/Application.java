package com.crocket;
import javax.swing.*;

public class Application {
    public static void main( String[] args )
    {
        init(); 
    }

    private static void init(){
        LevelView level1View = new LevelView(new Level1());
        CroquetView croquetView = new CroquetView();
        croquetView.drawLevel(level1View);
    }

}
