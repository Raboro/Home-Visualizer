package HomeVisualizer.Graphics;

import javax.swing.JFrame;

import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomNamesLogic;

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
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("This is Draw Line Example", 100, 70);
        g.setColor(Color.BLACK);
        // g.drawLine(90, 135, 90, 180);
        // g.setColor(Color.green);
        // g.drawLine(60, 4, 120, 120);

        // g.drawLine(10, 10, 100, 10);
        // g.drawLine(10, 10, 10, 100);
        // g.drawLine(10, 100, 100, 100);
        // g.drawLine(100, 10, 100, 100);

        if (CreateApartmentLogic.userChooseFourWalls) {
            int length = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[0].getText()) * 2) / 10;
            int width = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[2].getText()) * 2) / 10;

            int[] size = CreateRoomNamesLogic.formatSizeParameter(length, width);
            length = size[0];
            width = size[1];

            g.drawLine(100, 100, 100, (100 + width));
            g.drawLine(100, 100, (100 + length), 100);
            g.drawLine(100, (100 + width), (100 + length), (100 + width));
            g.drawLine((100 + length), 100, (100 + length), (100 + width));

            int[][] walls = CreateRoomNamesLogic.formatSizeParameterWalls();

            for (int[] wall: walls) {
                g.drawLine(wall[0], wall[1], wall[2], wall[3]);
            }


        } else {

        }
    }
}