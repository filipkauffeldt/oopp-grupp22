public class BowGoal extends Goal {

    private double innerHitbox;

    public BowGoal(int width, int height, Color color, Texture texture) {
        super(width, height, color, texture);
        //TODO Auto-generated constructor stub
    }
    
    public double geInnerHitbox(){
        return innerHitbox;
    }

}
