package crocket.src.main.java.com.crocket;


public abstract class Entity {
    private double xPosition;
    private double yPosition;
    private int width;
    private int height;

    public Entity(int width, int height, double xPosition, double yPosition)
    {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public double getxPosition() {
        return xPosition;
    }
    public double getyPosition() {
        return yPosition;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void setxPosition(double xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition){
        this.yPosition = yPosition;
    }

}