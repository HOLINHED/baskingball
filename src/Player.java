import java.awt.*;

public class Player extends Entity {

    public static final int width = 80;
    public static final int height = 175;
    public static final int jumpHeight = 4;
    public static final double yFallOff = 0.1;
    public static final int movespeed = 4;

    private int jumps = 0;

    Player() {
        super(200,100,width,height, yFallOff);
    }

    @Override
    void draw(Graphics g) {
        update();
        g.setColor(Color.gray);
        g.fillRect((int)s.getX(), (int)s.getY(), width, height);
    }

    void move(int dir) {
        v.setX(dir * movespeed);
    }

    void jump() {
        if (jumps < 2) {
            jumps += 1;
            v.setY(-jumpHeight);
        }
    }

    @Override
    public void hitFloor() {
        if (jumps != 0) jumps -= 1;
    }

}
