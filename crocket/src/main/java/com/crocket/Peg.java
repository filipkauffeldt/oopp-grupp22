package crocket.src.main.java.com.crocket;

public class Peg extends Entity {

    private boolean reached;

    public Peg(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
        //TODO Auto-generated constructor stub
    }

    public void reset(){
        reached = false;
    }
    
}
