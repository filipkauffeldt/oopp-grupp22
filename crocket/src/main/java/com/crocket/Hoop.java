package crocket.src.main.java.com.crocket;
public class Hoop extends Entity {

    private boolean reached;

    public Hoop(int width, int height, double xPosition, double yPosition, Direction dir) {
        super(width, height, xPosition, yPosition);
        //TODO Auto-generated constructor stub
    }
    
    public void reset(){
        reached = false;
    }

}
