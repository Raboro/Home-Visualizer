package HomeVisualizer.Graphics;

import javax.swing.JFrame;

import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomNamesLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomsLogic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class CreateRoomNamesGraphics extends JFrame {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1700;
    private static final int METER_INTO_PIXEL = 2; 

    private List<Integer> wallNames = new ArrayList<>();
    private int currentWallName = 0;

    public CreateRoomNamesGraphics() {
        super("Show Apartment");

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.setColor(Color.BLACK);
        chooseWallMode(g);
        paintInsideWallNames(g);
        paintInsideWalls(g);
    }

    private void chooseWallMode(Graphics g) {
        if (CreateApartmentLogic.userChooseFourWalls) {
            initWallNames(4 + CreateRoomsLogic.wallPoints.size() + 1);

            paintFourWalls(g, getFourWallsCoordinates());
            paintFourWallName(g, getFourWallsCoordinates());
        } else {
            initWallNames((CreateApartmentLogic.wallPoints.size()) + (CreateRoomsLogic.wallPoints.size()) + 1);
            loopOverUndefinedWalls(g);
        }
    }

    private void initWallNames(int wallNumber) {
        for (int name = 1; name < wallNumber; name++) {
            wallNames.add(name);
        }
    }

    private int[] getFourWallsCoordinates() {
        int length = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[0].getText()) * METER_INTO_PIXEL) / 10;
        int width = (int) (Integer.parseInt(CreateApartmentGui.getApartmentParameter[2].getText()) * METER_INTO_PIXEL) / 10;
        return CreateRoomNamesLogic.translateSizeParameterOutsideWalls(new int[]{length, width});
    }

    private void paintFourWalls(Graphics g, int[] coordinates) {
        g.drawLine(100, 100, 100, (100 + coordinates[1]));
        g.drawLine(100, 100, (100 + coordinates[0]), 100);
        g.drawLine(100, (100 + coordinates[1]), (100 + coordinates[0]), (100 + coordinates[1]));
        g.drawLine((100 + coordinates[0]), 100, (100 + coordinates[0]), (100 + coordinates[1]));
    }

    private void paintFourWallName(Graphics g, int[] coordinates) {
        g.drawString(Integer.toString(wallNames.get(0)), 100 + (coordinates[0]/2), 80);
        g.drawString(Integer.toString(wallNames.get(1)), (120 + coordinates[0]), (100 + coordinates[1] / 2));
        g.drawString(Integer.toString(wallNames.get(2)), (100 + coordinates[0]/2), (120 + coordinates[1]));
        g.drawString(Integer.toString(wallNames.get(3)), 80, 100 + (coordinates[1]/2));
    } 

    private void loopOverUndefinedWalls(Graphics g) {
        boolean isFirstWall = true;
        for (int wallIndex = 0; wallIndex < CreateApartmentLogic.wallPoints.size(); wallIndex++) {
            int[] wall = getUndefinedWallsCoordinates(wallIndex);

            if (isFirstWall) {
                isFirstWall = false;
                paintUndefinedWallName(g, wall, new int[]{ 100, 100 });
                paintUndefinedWall(g, wall, new int[]{ 100, 100 });
            } else {
                int[] wallBefore = getUndefinedWallsCoordinates(wallIndex - 1);
                paintUndefinedWallName(g, wall, wallBefore);
                paintUndefinedWall(g, wall, wallBefore);
            }
            currentWallName += 1;
        }
    }

    private int[] getUndefinedWallsCoordinates(int wallIndex) {
        int x = (int) (CreateApartmentLogic.wallPoints.get(wallIndex)[0] * METER_INTO_PIXEL) / 10;
        int y = (int) (CreateApartmentLogic.wallPoints.get(wallIndex)[1] * METER_INTO_PIXEL) / 10;
        return CreateRoomNamesLogic.translateSizeParameterOutsideWalls(new int[]{ x, y });
    }

    private void paintUndefinedWallName(Graphics g, int[] wall, int[] wallBefore) {
        int[] point = CreateRoomNamesLogic.getPositionToDrawWallName(wallBefore, wall);
        g.drawString(Integer.toString(wallNames.get(currentWallName)), point[0], point[1]);
    } 

    private void paintUndefinedWall(Graphics g, int[] wall, int[] wallBefore) {
        g.drawLine(wallBefore[0], wallBefore[1], wall[0], wall[1]);
    }

    private void paintInsideWallNames(Graphics g) {
        int[][] walls = CreateRoomNamesLogic.translateSizeParameterInsideWalls();
        for (int[] wall : walls) {
            int[] point = CreateRoomNamesLogic.getPositionToDrawWallName(new int[]{ wall[0], wall[1] }, new int[]{ wall[2], wall[3]});
            g.drawString(Integer.toString(wallNames.get(currentWallName)), point[0], point[1]);
            currentWallName += 1;
        }
    }

    private void paintInsideWalls(Graphics g) {
        int[][] walls = CreateRoomNamesLogic.translateSizeParameterInsideWalls();
        for (int[] wall: walls) {
            g.drawLine(wall[0], wall[1], wall[2], wall[3]);
        }
    }
}