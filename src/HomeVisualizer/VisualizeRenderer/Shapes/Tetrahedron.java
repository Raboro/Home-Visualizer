package HomeVisualizer.VisualizeRenderer.Shapes;

import java.awt.Color;
import java.awt.Graphics;

import HomeVisualizer.VisualizeRenderer.Point.MyVector;



public class Tetrahedron {
    
    private MyPolygon[] polygons;
    private Color color;

    public Tetrahedron(Color color, boolean decayColor, MyPolygon... polygons) {
        this.color = color;
        this.polygons = polygons;

        if (decayColor) {
            this.setDecayingPolygonColor();
        } else {
            this.setPolygonColor();
        }
        this.sortPolygons();
    }

    public Tetrahedron(MyPolygon... polygons) {
        this.color = Color.WHITE;
        this.polygons = polygons;
        this.sortPolygons();
    }

    private void sortPolygons() {
        MyPolygon.sortPolygons(this.polygons);
    }

    private void setPolygonColor() {
        for (MyPolygon poly: this.polygons) {
            poly.setColor(this.color);
        }
    }

    private void setDecayingPolygonColor() {
        double decayfactor = 0.95;
        for (MyPolygon poly: this.polygons) {
            poly.setColor(this.color);
            int r = (int) (this.color.getRed() * decayfactor);
            int g = (int) (this.color.getGreen() * decayfactor);
            int b = (int) (this.color.getBlue() * decayfactor);
            this.color = new Color(r, g, b);
        }
    }

    public void render(Graphics g) {
        for (MyPolygon poly: this.polygons) {
            poly.render(g);
        }
    }

    public void translate(double x, double y, double z) {
        for (MyPolygon poly : this.polygons) {
            poly.translate(x, y, z);
        }
        this.sortPolygons();
    }

    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees, MyVector lightVector) {
        for (MyPolygon p : this.polygons) {
            p.rotate(CW, xDegrees, yDegrees, zDegrees, lightVector);
        }
        this.sortPolygons();
    }

    public void setLighting(MyVector lightVector) {
        for (MyPolygon p : this.polygons) {
            p.setLighting(lightVector);
        }
    }

    public MyPolygon[] getPolygons() {
        return this.polygons;
    }
}
