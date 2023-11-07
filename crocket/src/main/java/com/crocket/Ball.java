package crocket.src.main.java.com.crocket;
public class Ball extends Entity implements IMovable{
    private double power;
    private double mass;
    private String powerUp;
    private double xVelocity;
    private double yVelocity;

    public Ball(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
        //TODO Auto-generated constructor stub
    }

    public void move(){
        
    }
}
