package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import javax.swing.SwingUtilities;

import HomeVisualizer.Graphics.CreateRoomNamesGraphics;

public class CreateRoomNamesLogic {

    private static int divideFactor;
    private static int[] checkValue = { 1000, 800, 600 };
    private static int[] decreaseValueBy = { 5, 4, 2 };
    private static int[][] wallPoints = new int[CreateRoomsLogic.wallPoints.size()][4];

    public static void init() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateRoomNamesGraphics g = new CreateRoomNamesGraphics();
                g.setVisible(true);
            }
        });
    }

    public static int[] translateSizeParameterOutsideWalls(int[] values) {
        for (int value = 0; value < values.length; value++) {
            values[value] = getOnlyPositivValue(values[value]);
            values = checkIfTranslateable(values, value);
        }
        values = changeZeroValue(values);
        return values;
    }

    private static int getOnlyPositivValue(int value) {
        return value < 0 ? value * (-1) : value;
    }

    private static int[] checkIfTranslateable(int[] values, int value) {
        for (int check = 0; check < checkValue.length; check++) {
            if (values[value] >= checkValue[check]) {
                setDivideFactor(check);
                values = translateValues(values, check);
            }
        }
        return values;
    }

    private static void setDivideFactor(int check) {
        divideFactor = divideFactor == 0 ? divideFactor += decreaseValueBy[check]
                : divideFactor <= decreaseValueBy[check] ? decreaseValueBy[check] : divideFactor;
    }

    private static int[] translateValues(int[] values, int check) {
        for (int i = 0; i < values.length; i++) {
            values[i] /= decreaseValueBy[check];
        }
        return values;
    }

    private static int[] changeZeroValue(int[] values) {
        for (int value = 0; value < values.length; value++) {
            values[value] = values[value] == 0 ? 100 : values[value];
        }
        return values;
    }

    public static int[] getPositionToDrawWallName(int[] wallBefore, int[] wall) {
        return calculateDrawPositionWallName(wallBefore, wall);
    }

    private static int[] calculateDrawPositionWallName(int[] wallBefore, int[] wall) {
        if (isOnePositionChange(wallBefore, wall)) {
            if (wallBefore[0] == wall[0]) {
                return getPositionWallNameHorizontal(wallBefore, wall);
            } else {
                return getPositionWallNameVertical(wallBefore, wall);
            }
        } else {
            return getPositionWallNameDiagonal(wallBefore, wall);
        }
    }

    private static boolean isOnePositionChange(int[] wallBefore, int[] wall) {
        boolean isHorizontalEqual = wallBefore[0] == wall[0];
        boolean isVerticalEqual = wallBefore[1] == wall[1];

        if ((isHorizontalEqual && !isVerticalEqual) || (!isHorizontalEqual && isVerticalEqual)) {
            return true;
        } 
        return false;
    }

    private static int[] getPositionWallNameHorizontal(int[] wallBefore, int[] wall) {
        int xPos = wall[0] == 100 ? wall[0] - 20 : wall[0] + 20; 
        int yPos = (wall[1] + wallBefore[1]) / 2;
        return new int[]{ xPos, yPos };
    }

    private static int[] getPositionWallNameVertical(int[] wallBefore, int[] wall) {
        int xPos = (wall[0] + wallBefore[0]) / 2;
        int yPos = wall[1] == 100 ? wall[1] - 20 : wall[1] + 20;
        return new int[]{ xPos, yPos };
    }

    private static int[] getPositionWallNameDiagonal(int[] wallBefore, int[] wall) {
        int xPos = (wall[0] + wallBefore[0]) / 2;
        int yPos = (wall[1] + wallBefore[1]) / 2;
        xPos = wall[0] > wallBefore[0] ? xPos + 20 : xPos - 20; 
        return new int[] { xPos, yPos };
    }

    public static int[][] translateSizeParameterInsideWalls() {
        for (int wall = 0; wall < CreateRoomsLogic.wallPoints.size(); wall++) {
            for (int parameter = 0; parameter < 4; parameter++) {
                wallPoints[wall][parameter] = (int) CreateRoomsLogic.wallPoints.get(wall)[parameter] / 10;

                wallPoints[wall][parameter] = getOnlyPositivValue(wallPoints[wall][parameter]);
                wallPoints[wall][parameter] /= divideFactor;
                wallPoints[wall][parameter] += 100;
            }
        }
        return wallPoints;
    }
}