package HomeVisualizer.Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne.CreateApartmentGuiElements;
import HomeVisualizer.Logic.Logic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomNamesLogicGraphics;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomsLogic;

public class CreateRoomNamesGraphics extends Frame {

    private final List<Integer> wallNames = new ArrayList<>();
    private int currentWallName = 0;

    public CreateRoomNamesGraphics() {
        super("Show Apartment", Logic.STEP_THREE_WINDOW_SIZE, Logic.STEP_THREE_WINDOW_SIZE);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocation(230, 550);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.setColor(Color.BLACK);
        chooseWallMode(g);
        paintInsideWallNames(g);
        paintInsideWalls(g);
    }

    private void chooseWallMode(Graphics g) {
        if (CreateApartmentLogic.isFourWalls) {
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
        int length = (Integer.parseInt(CreateApartmentGuiElements.getApartmentParameter[0].getText())
                * Logic.METER_INTO_PIXEL) / 10;
        int width = (Integer.parseInt(CreateApartmentGuiElements.getApartmentParameter[2].getText())
                * Logic.METER_INTO_PIXEL) / 10;
        return CreateRoomNamesLogicGraphics.translateSizeParameterOutsideWalls(new int[] { length, width });
    }

    private void paintFourWalls(Graphics g, int[] coordinates) {
        g.drawLine(100, 100, 100, (100 + coordinates[1]));
        g.drawLine(100, 100, (100 + coordinates[0]), 100);
        g.drawLine(100, (100 + coordinates[1]), (100 + coordinates[0]), (100 + coordinates[1]));
        g.drawLine((100 + coordinates[0]), 100, (100 + coordinates[0]), (100 + coordinates[1]));
    }

    private void paintFourWallName(Graphics g, int[] coordinates) {
        g.drawString(Integer.toString(wallNames.get(0)), 100 + (coordinates[0] / 2), 80);
        g.drawString(Integer.toString(wallNames.get(1)), (120 + coordinates[0]), (100 + coordinates[1] / 2));
        g.drawString(Integer.toString(wallNames.get(2)), (100 + coordinates[0] / 2), (120 + coordinates[1]));
        g.drawString(Integer.toString(wallNames.get(3)), 80, 100 + (coordinates[1] / 2));
        currentWallName = 4;
    }

    private void loopOverUndefinedWalls(Graphics g) {
        boolean isFirstWall = true;
        for (int wallIndex = 0; wallIndex < CreateApartmentLogic.wallPoints.size(); wallIndex++) {
            int[] wall = getUndefinedWallsCoordinates(wallIndex);

            if (isFirstWall) {
                isFirstWall = false;
                paintUndefinedWallName(g, wall, new int[] { 100, 100 });
                paintUndefinedWall(g, wall, new int[] { 100, 100 });
            } else {
                int[] wallBefore = getUndefinedWallsCoordinates(wallIndex - 1);
                paintUndefinedWallName(g, wall, wallBefore);
                paintUndefinedWall(g, wall, wallBefore);
            }
            currentWallName += 1;
        }
    }

    private int[] getUndefinedWallsCoordinates(int wallIndex) {
        int x = (int) (CreateApartmentLogic.wallPoints.get(wallIndex).getX() * Logic.METER_INTO_PIXEL) / 10;
        int y = (int) (CreateApartmentLogic.wallPoints.get(wallIndex).getY() * Logic.METER_INTO_PIXEL) / 10;
        return CreateRoomNamesLogicGraphics.translateSizeParameterOutsideWalls(new int[] { x, y });
    }

    private void paintUndefinedWallName(Graphics g, int[] wall, int[] wallBefore) {
        int[] point = CreateRoomNamesLogicGraphics.getPositionToDrawWallName(wallBefore, wall);
        g.drawString(Integer.toString(wallNames.get(currentWallName)), point[0], point[1]);
    }

    private void paintUndefinedWall(Graphics g, int[] wall, int[] wallBefore) {
        g.drawLine(wallBefore[0], wallBefore[1], wall[0], wall[1]);
    }

    private void paintInsideWallNames(Graphics g) {
        int[][] walls = CreateRoomNamesLogicGraphics.translateSizeParameterInsideWalls();
        for (int[] wall : walls) {
            int[] point = CreateRoomNamesLogicGraphics.getPositionToDrawWallName(new int[] { wall[0], wall[1] },
                    new int[] { wall[2], wall[3] });
            g.drawString(Integer.toString(wallNames.get(currentWallName)), point[0], point[1]);
            currentWallName += 1;
        }
    }

    private void paintInsideWalls(Graphics g) {
        int[][] walls = CreateRoomNamesLogicGraphics.translateSizeParameterInsideWalls();
        for (int[] wall : walls) {
            g.drawLine(wall[0], wall[1], wall[2], wall[3]);
        }
    }

    public List<Integer> getWallNames() {
        return this.wallNames;
    }
}