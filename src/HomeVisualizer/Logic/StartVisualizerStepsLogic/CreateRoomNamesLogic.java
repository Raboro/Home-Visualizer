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

    private static int[] translateValues(int[] values, int check) {
        for (int i = 0; i < values.length; i++) {
            values[i] /= decreaseValueBy[check]; 
        }
        return values;
    }

    public static int[] formatSizeParameter(int[] values) {
        for (int value = 0; value < values.length; value++) {
            if (values[value] < 0) {
                values[value] *= -1;
            }

            for (int check = 0; check < checkValue.length; check++) {
                if (values[value] >= checkValue[check]) {
                    if (divideFactor == 0) {
                        divideFactor += decreaseValueBy[check];
                    } else {
                        divideFactor = divideFactor <= decreaseValueBy[check] ? decreaseValueBy[check] : divideFactor;
                    }
                    translateValues(values, check);
                }
            }
        }
        for (int value = 0; value < values.length; value++) {
            if (values[value] == 0) {
                values[value] = 100;
            }
        }
        return values;
    }

    public static int[][] formatSizeParameterWalls() {
        for (int wall = 0; wall < CreateRoomsLogic.wallPoints.size(); wall++) {
            for (int parameter = 0; parameter < 4; parameter++) {
                wallPoints[wall][parameter] = (int) CreateRoomsLogic.wallPoints.get(wall)[parameter] / 10;

                if (wallPoints[wall][parameter] < 0) {
                    wallPoints[wall][parameter] *= -1;
                }
                wallPoints[wall][parameter] /= divideFactor;
                wallPoints[wall][parameter] += 100;
            }
        }
        return wallPoints;
    }
}