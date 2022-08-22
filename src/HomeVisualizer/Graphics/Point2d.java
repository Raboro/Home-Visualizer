package HomeVisualizer.Graphics;

public class Point2d {

    private double x, y;
    private double x1, x2, y1, y2;

    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2d(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int[] getPointAsIntTwoCoodinates() {
        return new int[] { (int) this.x, (int) this.y };
    }

    public int[] getPointAsIntFourCoodinates() {
        return new int[] { (int) this.x1, (int) this.x2, (int) this.y1, (int) this.y2 };
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getX1() {
        return this.x1;
    }

    public double getY1() {
        return this.y1;
        
    }

    public double getX2() {
        return this.x2;

    }

    public double getY2() {
        return this.y2;
        
    }
}
