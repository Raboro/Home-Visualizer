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
    private static final int METER_INTO_PIXEL = 2; 

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

        if (CreateApartmentLogic.userChooseFourWalls) {
            int length = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[0].getText()) * METER_INTO_PIXEL) / 10;
            int width = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[2].getText()) * METER_INTO_PIXEL) / 10;

            int[] size = CreateRoomNamesLogic.formatSizeParameterOutsideWalls(new int[]{length, width});
            length = size[0];
            width = size[1];

            g.drawLine(100, 100, 100, (100 + width));
            g.drawLine(100, 100, (100 + length), 100);
            g.drawLine(100, (100 + width), (100 + length), (100 + width));
            g.drawLine((100 + length), 100, (100 + length), (100 + width));

            

        } else {
            boolean firstWall = true;
            for (int wallIndex = 0; wallIndex < CreateApartmentLogic.wallPoints.size(); wallIndex++) {
                int[] wall = new int[2];

                wall[0] = (int) (CreateApartmentLogic.wallPoints.get(wallIndex)[0] * METER_INTO_PIXEL) / 10;
                wall[1] = (int) (CreateApartmentLogic.wallPoints.get(wallIndex)[1] * METER_INTO_PIXEL) / 10;

                wall = CreateRoomNamesLogic.formatSizeParameterOutsideWalls(wall);

                if (firstWall) {
                    firstWall = false;
                    g.drawLine(100, 100, wall[0], wall[1]);

                } else {
                    int[] wallBefore = new int[2];
                    wallBefore[0] = (int) (CreateApartmentLogic.wallPoints.get(wallIndex -1)[0] * METER_INTO_PIXEL) / 10;
                    wallBefore[1] = (int) (CreateApartmentLogic.wallPoints.get(wallIndex -1)[1] * METER_INTO_PIXEL) / 10;    
                    wallBefore = CreateRoomNamesLogic.formatSizeParameterOutsideWalls(wallBefore);
                    g.drawLine(wallBefore[0], wallBefore[1], wall[0], wall[1]);
                }
            }
        }

        int[][] walls = CreateRoomNamesLogic.formatSizeParameterInsideWalls();
        for (int[] wall: walls) {
            g.drawLine(wall[0], wall[1], wall[2], wall[3]);
        }
    }
}