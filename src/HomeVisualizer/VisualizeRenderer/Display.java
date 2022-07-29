package HomeVisualizer.VisualizeRenderer;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import HomeVisualizer.VisualizeRenderer.Entity.EntityManager;
import HomeVisualizer.VisualizeRenderer.Input.UserInput;

public class Display extends Canvas implements Runnable {

    private boolean running;
    private Thread thread;
    private UserInput userInput;
    private EntityManager entityManager;
    
    public JFrame frame;
    public static final String TITLE = "Visualize";
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;

    public Display() {
        this.frame = new JFrame();
        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);
        this.userInput = new UserInput();
        this.entityManager = new EntityManager();

        this.addMouseListener(this.userInput.mouse);
        this.addMouseMotionListener(this.userInput.mouse);
        this.addMouseWheelListener(this.userInput.mouse);
        this.addKeyListener(this.userInput.keyboard);
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        this.entityManager.render(g);

        g.dispose();
        bs.show();
    }

    private void update() {
        this.entityManager.update();
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
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 120;
        double delta = 0;
        int frames = 0;

        this.entityManager.init(this.userInput);

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                update();
                delta--;
                render();
                frames++;
            } 

            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                this.frame.setTitle(TITLE + " | " + frames + " fps");
                frames = 0;
            }
        }
        this.stop();
    }
}
