package HomeVisualizer.VisualizeRenderer.Entity.Builder;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.VisualizeRenderer.Entity.Entity;
import HomeVisualizer.VisualizeRenderer.Entity.IEntity;
import HomeVisualizer.VisualizeRenderer.Point.MyPoint;
import HomeVisualizer.VisualizeRenderer.Shapes.MyPolygon;
import HomeVisualizer.VisualizeRenderer.Shapes.Tetrahedron;



public class ComplexEntitiyBuilder {
    
    public static IEntity createRubicsCube(double size, double centerX, double centerY, double centerZ) {
        List<Tetrahedron> tetras = new ArrayList<>();
        double cubeSpacing = 5;

        for (int x = -1; x < 2; x++) {
            double cubeCenterX = x * (size + cubeSpacing) + centerX;
            for (int y = -1; y < 2; y++) {
                double cubeCenterY = y * (size + cubeSpacing) + centerY;
                for (int z = -1; z < 2; z++) {
                    if (x == 0 && y == 0 && z == 0)
                        continue;
                    double cubeCenterZ = z * (size + cubeSpacing) + centerZ;

                    MyPoint p1 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p2 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p3 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p4 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);
                    MyPoint p5 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p6 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p7 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p8 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);

                    MyPolygon polyRed = new MyPolygon(Color.RED, p5, p6, p8, p7);
                    MyPolygon polyWhite = new MyPolygon(Color.WHITE, p2, p4, p8, p6);
                    MyPolygon polyBlue = new MyPolygon(Color.BLUE, p3, p7, p8, p4);
                    MyPolygon polyGreen = new MyPolygon(Color.GREEN, p1, p2, p6, p5);
                    MyPolygon polyOrange = new MyPolygon(Color.ORANGE, p1, p3, p4, p2);
                    MyPolygon polyYellow = new MyPolygon(Color.YELLOW, p1, p5, p7, p3);

                    Tetrahedron tetra = new Tetrahedron(polyRed, polyWhite, polyBlue, polyGreen, polyOrange, polyYellow);
                    tetras.add(tetra);
                }
            }
        }

        return new Entity(tetras);
    }
}