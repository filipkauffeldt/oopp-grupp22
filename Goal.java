public class Goal extends Entity {

    private boolean scored;
    private double outerHitboxR;
    private double outerHitboxL;

    public Goal(int width, int height, Color color, Texture texture) {
        super(width, height, color, texture);
        //TODO Auto-generated constructor stub
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    public double getOuterHitboxR() {
        return outerHitboxR;
    }

    public void setOuterHitboxR(double outerHitboxR) {
        this.outerHitboxR = outerHitboxR;
    }

    public double getOuterHitboxL() {
        return outerHitboxL;
    }

    public void setOuterHitboxL(double outerHitboxL) {
        this.outerHitboxL = outerHitboxL;
    }
    
}
