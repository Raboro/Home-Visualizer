package HomeVisualizer.VisualizeRenderer.Point;

import java.awt.Point;

import HomeVisualizer.VisualizeRenderer.Display;

public class PointConverter {

    private static double scale = 4;
    private static final double ZOOMFACTOR = 1.2;

    private static double[] scale(double x3d, double y3d, double depth) {
        double distance = Math.sqrt(x3d * x3d + y3d * y3d);
        double theta = Math.atan2(y3d, x3d);
        double depthCemeraRelative = 15 - depth;
        double localScale = Math.abs(1400 / (depthCemeraRelative + 1400));

        distance *= localScale;

        double[] newVal = new double[2];
        newVal[0] = distance * Math.cos(theta); // x
        newVal[1] = distance * Math.sin(theta); // y

        return newVal;
    }

    public static Point convertPoint(MyPoint point3D) {
        double x3d = point3D.getAdjustedY() * scale;
        double y3d = point3D.getAdjustedZ() * scale;
        double depth = point3D.getAdjustedX() * scale;

        double[] newVal = scale(x3d, y3d, depth);

        int x2d = (int) (Display.WIDTH / 2 + newVal[0]);
        int y2d = (int) (Display.HEIGHT / 2 - newVal[1]);

        return new Point(x2d, y2d);
    }

    public static void rotateAxisX(MyPoint p, boolean CW, double degrees) {
        double radius = Math.sqrt(p.y * p.y + p.z * p.z);
        double theta = Math.atan2(p.z, p.y);

        theta += 2 * Math.PI / 360 * degrees * (CW ? -1 : 1);

        p.y = radius * Math.cos(theta);
        p.z = radius * Math.sin(theta);
    }

    public static void rotateAxisY(MyPoint p, boolean CW, double degrees) {
        double radius = Math.sqrt(p.x * p.x + p.z * p.z);
        double theta = Math.atan2(p.x, p.z);

        theta += 2 * Math.PI / 360 * degrees * (CW ? -1 : 1);

        p.x = radius * Math.sin(theta);
        p.z = radius * Math.cos(theta);
    }

    public static void rotateAxisZ(MyPoint p, boolean CW, double degrees) {
        double radius = Math.sqrt(p.y * p.y + p.x * p.x);
        double theta = Math.atan2(p.y, p.x);

        theta += 2 * Math.PI / 360 * degrees * (CW ? -1 : 1);

        p.y = radius * Math.sin(theta);
        p.x = radius * Math.cos(theta);
    }

    public static void zoomIn() {
        scale *= ZOOMFACTOR;
    }

    public static void zoomOut() {
        scale /= ZOOMFACTOR;
    }
}
