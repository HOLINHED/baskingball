import java.awt.*;

class Baskingball extends Filler {

    Ball ball;
    Player player;

    @Override
    public void create() {
        ball = new Ball();
        Player player = new Player();
    }

    @Override
    public void draw() {
        ball.draw(g);
        player.draw(g);


    }

    @Override
    public void close() { }

    private Baskingball() {
        super(1250,720,"Baskingball");
    }

    public static void main(String... args) {
        Baskingball b = new Baskingball();
        b.start();
    }

}