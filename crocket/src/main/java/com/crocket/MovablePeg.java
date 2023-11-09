package crocket.src.main.java.com.crocket;

public class MovablePeg extends Peg implements IMovable{
    private double xVelocity;
    private double yVelocity;

    public MovablePeg(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
        //TODO Auto-generated constructor stub
    }

    public void move(){
        this.setxPosition((this.getxPosition()+xVelocity));
        this.setyPosition((this.getyPosition()+yVelocity));
    }
}
