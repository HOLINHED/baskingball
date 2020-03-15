public class Vec2d {

    private double x;
    private double y;

    Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Vec2d() {
        this(0,0);
    }

    public void setMag(double mag, double angle) {
        x = mag * Math.cos(angle);
        y = mag * Math.sin(angle);
    }

    public void add(Vec2d o) {
        this.x += o.getX();
        this.y += o.getY();
    }

    public void invertX() {
        x *= -1;
    }

    public void invertY() {
        y *= -1;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void mulX(double m) {
        x *= m;
    }

    public void mulY(double m) {
        y *= m;
    }

    public void set(Vec2d o) {
        this.x = o.getX();
        this.y = o.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMag() {
        return Math.sqrt((x * x) + (y * y));
    }

    public static Vec2d fromAngle(double angle, double magnitude) {

        final double x = magnitude * Math.cos(angle);
        final double y = magnitude * Math.sin(angle);

        return new Vec2d(x,y);
    }
}
