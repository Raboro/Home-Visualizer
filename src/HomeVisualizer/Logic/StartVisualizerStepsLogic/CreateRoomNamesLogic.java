package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import javax.swing.SwingUtilities;

import HomeVisualizer.Graphics.CreateRoomNamesGraphics;

public class CreateRoomNamesLogic {

    private static int divideFactor;
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

    public static int[] formatSizeParameter(int length, int width) {
        if (divideFactor > 0) {
            if ((length >= 1000 || width >= 1000)) {
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
        }
        if ((length >= 1000 || width >= 1000)) {
            length /= 5;
            width /= 5;
            divideFactor += 5;
        }

        if (length >= 800 || width >= 800) {
            length /= 4;
            width /= 4;
            divideFactor += 4;
        }

        if (length >= 600 || width >= 600) {
            length /= 2;
            width /= 2;
            divideFactor += 2;
        }
        return new int[] { length, width };
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
