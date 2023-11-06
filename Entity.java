public abstract class Entity {
    // private Color color; // should add this class/interface
    private double xPosition;
    private double yPosition;
    // private Texture texture; // should add this class/interface
    private int width;
    private int height;

    public Entity(int width, int height, Color color, Texture texture)
    {
        this.width = width;
        this.height = height;
        // this.color = color; // should add after the class/interface is done
        // this.texture = texture; // should add after the class/interface is done
    }

    public double getxPosition() {
        return xPosition;
    }
    public double getyPosition() {
        return yPosition;
    }

    public void setCoordinates(double xPosition, double yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void setCollidablePossbilityX(int width, double xPosition){
        
    }

}