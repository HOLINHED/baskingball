import java.awt.*;

class Baskingball extends Filler {

    int x;
    int y;

    @Override
    public void create() {
        x = WIDTH/2;
        y = HEIGHT/2;
    }

    @Override
    public void draw() {
        fill(Color.red);
        g.fillRect(x,y,100,100);

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