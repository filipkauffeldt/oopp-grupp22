package com.crocket;

public class Application {

    private static final int delay = 20;
    private static CroquetView frame = CroquetView.getInstance();
    private static TextureManager textureManager = new TextureManager();
    private static LevelView level1View = new LevelView(new Level1(), textureManager);
    static DrawEntity ballView = new DrawEntity();
    static Ball ball = new Ball(19,19,100,200,2);
    static DirectionLine directionLine = new DirectionLine(90, 120, 120, 10, 3);
    static CroquetController cc = new CroquetController(frame, ball, directionLine);
    


    public static void main( String[] args )
    {
        init(); 
    }

    private static void init(){
        try{
            textureManager.loadTextures();
        }
        catch(Exception ex){
            System.out.println("Error loading textures!");
        }
        frame.setLevelView(level1View);
        frame.setBallToLevel(ballView);
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