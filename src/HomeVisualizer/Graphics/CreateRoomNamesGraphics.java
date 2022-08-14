package HomeVisualizer.Graphics;

import javax.swing.JFrame;

import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class CreateRoomNamesGraphics extends JFrame {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1700;

    public CreateRoomNamesGraphics() {
        super("Show Apartment");

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial",Font.BOLD,12)); 
        g.drawString("This is Draw Line Example", 100, 70);   
        g.setColor(Color.blue);
        // g.drawLine(90, 135, 90, 180); 
        // g.setColor(Color.green); 
        // g.drawLine(60, 4, 120, 120); 

        // g.drawLine(10, 10, 100, 10);
        // g.drawLine(10, 10, 10, 100);
        // g.drawLine(10, 100, 100, 100);
        // g.drawLine(100, 10, 100, 100);

        if (CreateApartmentLogic.userChooseFourWalls) {
            double length = (Integer.parseInt(CreateApartmentGui.getApartmentParameter[0].getText()) * 2) / 10;
            double width = (Integer.parseInt(CreateApartmentGui.getApartmentParameter[2].getText()) * 2) / 10;

            if ((length >= 1000 || width >= 1000) ) {
                length /= 5;
                width /= 5;
            }

            if (length >= 800 || width >= 800) {
                length /= 4;
                width /= 4;
            }

            if (length >= 600 || width >= 600) {
                length /= 2;
                width /= 2;
            }

            g.drawLine(100, 100, 100, (int) (100 + width));
            g.drawLine(100, 100, (int) (100 + length), 100);
            g.drawLine(100, (int) (100 + width), (int) (100 + length), (int) (100 + width));
            g.drawLine((int) (100 + length), 100, (int) (100 + length), (int) (100 + width));


        } else {

        }
    }
}