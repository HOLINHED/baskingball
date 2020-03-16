import java.awt.*;

public abstract class Entity {

    public static final double gravity = 0.08;
    public static final double YFALLOFF = 0.4;
    public static final double friction = 0.99;

    protected Vec2d s;
    protected Vec2d v;
    protected Vec2d a;
    protected int width;
    protected int height;
    private double yFalloff;

    Entity(double x, double y, int w, int h, double yFalloff) {
        s = new Vec2d(x, y);
        v = new Vec2d(0, 0);
        a = new Vec2d(0, gravity);
        this.width = w;
        this.height = h;
        this.yFalloff = yFalloff;
    }

    Entity(double x, double y, int w, int h) {
        this(x,y,w,h,YFALLOFF);
    }

    Entity(double x, double y) {
        this(x,y,100,100);
    }

    Entity(){
        this(0,0);
    }

     void update() {
        this.v.add(a);
        this.s.add(v);

        v.mulX(friction);

        if (s.getX() < 0) {
             s.setX(0);
             v.invertX();
             hitLeftWall();
         }

        if (s.getX() + width > 1250) {
            s.setX(1250 - width);
            v.invertX();
            hitRightWall();
        }

        if (s.getY() < 0) {
            s.setY(0);
            v.mulY(-yFalloff);
            hitCeiling();
        }

        if (s.getY() + height > 720) {
            s.setY(720 - height);
            v.mulY(-yFalloff);
            hitFloor();
        }

     }

     public void hitFloor() { }
     public void hitCeiling() { }
     public void hitLeftWall() { }
     public void hitRightWall() { }

     abstract void draw(Graphics g);
}