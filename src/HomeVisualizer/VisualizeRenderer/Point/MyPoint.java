package HomeVisualizer.VisualizeRenderer.Point;

public class MyPoint {

    public double x, y, z;
    public double xOffset, yOffset, zOffset = 0;

    public static final MyPoint ORIGIN = new MyPoint(0, 0, 0);

    public MyPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getAdjustedX() {
        return this.x + this.xOffset;
    }

    public double getAdjustedY() {
        return this.y + this.yOffset;
    }

    public double getAdjustedZ() {
        return this.z + this.zOffset;
    }

    public static double dist(MyPoint p1, MyPoint p2) {
        double newX = Math.pow(p1.x - p2.x, 2);
        double newY = Math.pow(p1.y - p2.y, 2);
        double newZ = Math.pow(p1.z - p2.z, 2);

        return Math.sqrt(newX + newY + newZ);
    }
}