import java.awt.*;

public class Player extends Entity {

    public static final int width = 100;
    public static final int height = 30;
    public static final int jumpHeight = 10;

    Player() {
        super(100,100,width,height);
    }

    void draw(Graphics g) {
        update();
        g.fillRect((int)s.getX(), (int)s.getY(), width, height);
    }

    void jump() {
        v.setY(-jumpHeight);
    }



}
