package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import javax.swing.SwingUtilities;

import HomeVisualizer.Graphics.CreateRoomNamesGraphics;

public class CreateRoomNamesLogic {

    private static int divideFactor;
    private static int[] checkValue = { 1000, 800, 600 };
    private static int[] decreaseValueBy = { 5, 4, 2 };
    private static int[][] wallPoints = new int[CreateRoomsLogic.wallPoints.size()][4];

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

    public static void init() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateRoomNamesGraphics g = new CreateRoomNamesGraphics();
                g.setVisible(true);
            }
        });
    }

    public static int[] formatSizeParameterOutsideWalls(int[] values) {
        for (int value = 0; value < values.length; value++) {
            values[value] = getOnlyPositivValue(values[value]);
            values = checkIfTranslateable(values, value);
        }
        values = changeZeroValue(values);
        return values;
    }

    public static int[][] formatSizeParameterInsideWalls() {
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

    private static void setDivideFactor(int check) {
        divideFactor = divideFactor == 0 ? divideFactor += decreaseValueBy[check]
                : divideFactor <= decreaseValueBy[check] ? decreaseValueBy[check] : divideFactor;
    }
}