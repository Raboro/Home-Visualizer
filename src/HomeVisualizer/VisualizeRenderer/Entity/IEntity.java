package HomeVisualizer.VisualizeRenderer.Entity;

import java.awt.Graphics;

import HomeVisualizer.VisualizeRenderer.Point.MyVector;
import HomeVisualizer.VisualizeRenderer.Shapes.MyPolygon;

public interface IEntity {
    
    void render(Graphics g);

    void translate(double x, double y, double z);

    void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees, MyVector lightVector);

    void setLighting(MyVector lightVector);

    MyPolygon[] getPolygons();
}
