import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public abstract class Filler implements KeyListener, MouseListener {

    protected int WIDTH;
    protected int HEIGHT;
    private String TITLE;
    private int FRAMERATE = 1000 / 121;

    private JFrame frame;
    private JPanel window;

    protected Graphics g;
    protected Point    mouse = new Point(0,0);

    private List<Integer> keys;
    protected int key;

    protected static enum Key {
        SPACE(32),
        ESC(27),
        ESCAPE(27),
        DEL(8),
        DELETE(8),
        ENTER(13),
        SHIFT(16),
        CAPS(20),
        CTRL(17),
        CONTROL(17),
        ALT(18),
        META(91),
        ARLEFT(37),
        ARROWLEFT(37),
        ARUP(38),
        ARROWUP(38),
        ARRIGHT(39),
        ARROWRIGHT(39),
        ARDOWN(40),
        ARROWDOWN(40),
        ;

        final int code;

        Key(int code) {
            this.code = code;
        }

    }

    public Filler(int width, int height, String title) {
        WIDTH  = width;
        HEIGHT = height;
        TITLE  = title;
    }

    public Filler(int width, int height) {
        this(width,height,"Filler");
    }

    public void frameRate(int rate) {
        FRAMERATE = 1000 / rate;
    }

    // ------- SETBACKGROUND -------

    public void background(int r, int g, int b) {
        background(new Color(r,g,b));
    }

    public void background(int val) {
        background(new Color(val,val,val));
    }

    public void background(Color color) {
        window.setBackground(color);
    }

    // ------- FILL -------

    public void fill(int r, int g, int b) {
        fill(new Color(r,g,b));
    }

    public void fill(int val) {
        fill(val,val,val);
    }

    public void fill(Color color) {
        g.setColor(color);
    }

    public void start() {

        keys = new ArrayList<>();

        window = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            public void paintComponent(Graphics c) {
                super.paintComponent(c);
                g = c;
                try {
                    draw();
                } catch (Exception e) { }
            }
        };

        window.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        window.setFocusable(true);

        frame  = new JFrame(TITLE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
                super.windowClosing(e);
            }
        });

        frame.add(window);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        window.addMouseListener(this);
        window.addKeyListener(this);

        create();

        while(true) {
            try {
                Thread.sleep(FRAMERATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                mouse = (Point) window.getMousePosition().clone();
            } catch (NullPointerException ignored) { }

            window.repaint();
        }

    }

    // ------- key manager -------
    // unimplemented methods are user definable.
    @Override
    public void keyPressed(KeyEvent e) {
        if (!keys.contains(e.getKeyCode())) {
            key = e.getKeyCode();
            keys.add(e.getKeyCode());
        }
        keyPressed();
    }

    public void keyPressed() { }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.remove((Integer)e.getKeyCode());
        key = e.getKeyCode();
        keyReleased();
    }

    public void keyReleased() { }

    @Override
    public void keyTyped(KeyEvent e) { }

    public boolean isKeyPressed(int keyCode) {
        return keys.contains(keyCode);
    }

    public boolean isKeyPressed(char key) {
        return isKeyPressed((int)Character.toUpperCase(key));
    }

    public boolean isKeyPressed(Key key) {
        return isKeyPressed(key.code);
    }

    // ------- mouse manager -------
    // all methods to be implemented by user

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    // called once before graphics start drawing
    public abstract void create();

    // called every frame
    public abstract void draw();

    // called once when program closes
    public abstract void close();

}