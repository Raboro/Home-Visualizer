package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import javax.swing.SwingUtilities;

import HomeVisualizer.Graphics.CreateRoomNamesGraphics;

public class CreateRoomNamesLogicGraphics {

    protected static CreateRoomNamesGraphics graphics;
    private static int divideFactor;
    private static final int[] checkValue = { 1000, 800, 600 };
    private static final int[] decreaseValueBy = { 5, 4, 2 };
    private static final int[][] wallPoints = new int[CreateRoomsLogic.wallPoints.size()][4];
    
    public static void init() {
        SwingUtilities.invokeLater(() -> {
            graphics = new CreateRoomNamesGraphics();
            graphics.setVisible(true);
        });
    }

    public static int[] translateSizeParameterOutsideWalls(int[] values) {
        for (int value = 0; value < values.length; value++) {
            values[value] = getOnlyPositiveValue(values[value]);
            checkIfTranslatable(values, value);
        }
        changeZeroValue(values);
        return values;
    }

    private static int getOnlyPositiveValue(int value) {
        return value < 0 ? value * (-1) : value;
    }

    private static void checkIfTranslatable(int[] values, int value) {
        for (int check = 0; check < checkValue.length; check++) {
            if (values[value] >= checkValue[check]) {
                setDivideFactor(check);
                translateValues(values, check);
            }
        }
    }

    private static void setDivideFactor(int check) {
        divideFactor = divideFactor == 0 ? divideFactor += decreaseValueBy[check]
                : Math.max(divideFactor, decreaseValueBy[check]);
    }

    private static void translateValues(int[] values, int check) {
        for (int i = 0; i < values.length; i++) {
            values[i] /= decreaseValueBy[check];
        }
    }

    private static void changeZeroValue(int[] values) {
        for (int value = 0; value < values.length; value++) {
            values[value] = values[value] == 0 ? 100 : values[value];
        }
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

        return (isHorizontalEqual && !isVerticalEqual) || (!isHorizontalEqual && isVerticalEqual);
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

                wallPoints[wall][parameter] = getOnlyPositiveValue(wallPoints[wall][parameter]);
                wallPoints[wall][parameter] /= divideFactor;
                wallPoints[wall][parameter] += 100;
            }
        }
        return wallPoints;
    }
}