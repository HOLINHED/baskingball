class Baskingball extends Filler {

    Ball ball;
    Player player;

    @Override
    public void create() {
        ball = new Ball();
        player = new Player();
    }

    @Override
    public void draw() {
        ball.draw(g);
        player.draw(g);

        movements();

    }

    public void movements() {
        if (isKeyPressed(Key.ARROWLEFT)) {
            player.move(-1);
        } else if (isKeyPressed(Key.ARROWRIGHT)) {
            player.move(1);
        } else {
            player.move(0);
        }
    }

    @Override
    public void keyPressed() {
        if (key == 32) {
            player.jump();
        }
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