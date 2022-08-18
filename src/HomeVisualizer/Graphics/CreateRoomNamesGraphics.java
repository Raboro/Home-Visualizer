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

    private void chooseWallMode(Graphics g) {
        if (CreateApartmentLogic.userChooseFourWalls) {
            int[] coordinates = getFourWallsCoordinates();
            paintFourWalls(g, coordinates);
        } else {
            loopOverUndefinedWalls(g);
        }
    }

    private int[] getFourWallsCoordinates() {
        int length = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[0].getText()) * METER_INTO_PIXEL) / 10;
        int width = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[2].getText()) * METER_INTO_PIXEL) / 10;
        return CreateRoomNamesLogic.formatSizeParameterOutsideWalls(new int[]{length, width});
    }

    private void paintFourWalls(Graphics g, int[] coordinates) {
        g.drawLine(100, 100, 100, (100 + coordinates[1]));
        g.drawLine(100, 100, (100 + coordinates[0]), 100);
        g.drawLine(100, (100 + coordinates[1]), (100 + coordinates[0]), (100 + coordinates[1]));
        g.drawLine((100 + coordinates[0]), 100, (100 + coordinates[0]), (100 + coordinates[1]));
    }

    private void loopOverUndefinedWalls(Graphics g) {
        boolean isFirstWall = true;
        for (int wallIndex = 0; wallIndex < CreateApartmentLogic.wallPoints.size(); wallIndex++) {
            int[] wall = getUndefinedWallsCoordinates(wallIndex);

            if (isFirstWall) {
                isFirstWall = false;
                paintUndefinedWall(g, wall);
            } else {
                int[] wallBefore = getUndefinedWallsCoordinates(wallIndex - 1);
                paintUndefinedWall(g, wall, wallBefore);
            }
        }
    }

    private int[] getUndefinedWallsCoordinates(int wallIndex) {
        int x = (int) (CreateApartmentLogic.wallPoints.get(wallIndex)[0] * METER_INTO_PIXEL) / 10;
        int y = (int) (CreateApartmentLogic.wallPoints.get(wallIndex)[1] * METER_INTO_PIXEL) / 10;
        return CreateRoomNamesLogic.formatSizeParameterOutsideWalls(new int[]{ x, y });
    }

    private void paintUndefinedWall(Graphics g, int[] wall) {
        g.drawLine(100, 100, wall[0], wall[1]);
    }

    private void paintUndefinedWall(Graphics g, int[] wall, int[] wallBefore) {
        g.drawLine(wallBefore[0], wallBefore[1], wall[0], wall[1]);
    }

    private void paintInsideWalls(Graphics g) {
        int[][] walls = CreateRoomNamesLogic.formatSizeParameterInsideWalls();
        for (int[] wall: walls) {
            g.drawLine(wall[0], wall[1], wall[2], wall[3]);
        }
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("This is Draw Line Example", 100, 70);
        g.setColor(Color.BLACK);
        chooseWallMode(g);
        paintInsideWalls(g);
    }
}