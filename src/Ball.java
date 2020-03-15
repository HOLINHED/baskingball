import java.awt.*;

public class Ball extends Entity {

    public static final int size = 50;

    Ball() {
        super(100,100,size,size);
    }

    @Override
    void draw(Graphics g) {
        update();
        g.setColor(Color.RED);
        g.fillRect((int)s.getX(), (int)s.getY(), size, size);
    }


}
