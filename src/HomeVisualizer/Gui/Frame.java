package HomeVisualizer.Gui;

import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame(String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}