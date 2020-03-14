public abstract class Entity {

    protected Vec2d s;
    protected Vec2d v;
    protected Vec2d a;
    protected int width;
    protected int height;

    Entity(double x, double y, int w, int h) {
        s = new Vec2d(x,y);
        v = new Vec2d(0,0);
        a = new Vec2d(0,0);
        this.width = w;
        this.height = h;
    }

    Entity(double x, double y){
        this(x, y, 100, 100);
    }

     Entity() {
        this(0,0);
     }

     void update() {
        this.v.add(a);
        this.s.add(v);


     }
}