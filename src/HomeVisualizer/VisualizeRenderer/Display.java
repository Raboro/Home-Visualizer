package HomeVisualizer.VisualizeRenderer;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Dimension;

import HomeVisualizer.VisualizeRenderer.Input.UserInput;

public class Display extends JFrame implements Runnable {

    private boolean running;
    private Thread thread;
    private UserInput userInput;
    private static final String TITLE = "Visualize";

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;

    public Display() {
        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);
        this.userInput = new UserInput();

        this.addMouseListener(this.userInput.mouse);
        this.addMouseMotionListener(this.userInput.mouse);
        this.addMouseWheelListener(this.userInput.mouse);
        this.addKeyListener(this.userInput.keyboard);
    }

    private void render() {

    }

    private void update() {

    }

    public synchronized void start() {
        this.running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }

    public synchronized void stop() {
        this.running = false;

        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }
}
