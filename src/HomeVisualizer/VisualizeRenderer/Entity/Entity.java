package HomeVisualizer.VisualizeRenderer.Entity;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import HomeVisualizer.VisualizeRenderer.Point.MyVector;
import HomeVisualizer.VisualizeRenderer.Shapes.MyPolygon;
import HomeVisualizer.VisualizeRenderer.Shapes.Tetrahedron;

public class Entity implements IEntity {
    
    private List<Tetrahedron> tetrahedrons;
    private MyPolygon[] polygons;

    public Entity(List<Tetrahedron> tetrahedrons) {
        this.tetrahedrons = tetrahedrons;
        List<MyPolygon> tempList= new ArrayList<MyPolygon>();

        for (Tetrahedron tetrahedron : this.tetrahedrons) {
            tempList.addAll(Arrays.asList(tetrahedron.getPolygons()));
        }
        this.polygons = new MyPolygon[tempList.size()];
        this.polygons = tempList.toArray(this.polygons);
        this.sortPolygons();
    }

    @Override
    public void render(Graphics g) {
        for (MyPolygon poly : this.polygons) {
            poly.render(g);
        }
    }

    @Override
    public void translate(double x, double y, double z) {
        for (Tetrahedron tetra : this.tetrahedrons) {
            tetra.translate(x, y, z);
        }
        this.sortPolygons();
    }

    @Override
    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees, MyVector lightVector) {
        for (Tetrahedron tetra : this.tetrahedrons) {
            tetra.rotate(CW, xDegrees, yDegrees, zDegrees, lightVector);
        }
        this.sortPolygons();
    }

    @Override
    public void setLighting(MyVector lightVector) {
        for (Tetrahedron tetra : this.tetrahedrons) {
            tetra.setLighting(lightVector);
        }
    }
    
    private void sortPolygons() {
        MyPolygon.sortPolygons(this.polygons);
    }

    @Override
    public MyPolygon[] getPolygons() {
        return this.polygons;
    }
}
