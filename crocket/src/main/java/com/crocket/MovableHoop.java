package crocket.src.main.java.com.crocket;

public class MovableHoop extends Hoop implements IMovable {

    private double xVelocity;
    private double yVelocity;

    public MovableHoop(int width, int height, double xPosition, double yPosition, Direction dir) {
        super(width, height, xPosition, yPosition, dir);
        //TODO Auto-generated constructor stub
    }

    public void move(){
        this.setxPosition((this.getxPosition()+xVelocity));
        this.setyPosition((this.getyPosition()+yVelocity));
    }
    
}
