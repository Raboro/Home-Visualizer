package HomeVisualizer.VisualizeRenderer.Entity.Builder;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;
import HomeVisualizer.VisualizeRenderer.Entity.Entity;
import HomeVisualizer.VisualizeRenderer.Entity.IEntity;
import HomeVisualizer.VisualizeRenderer.Point.MyPoint;
import HomeVisualizer.VisualizeRenderer.Shapes.MyPolygon;
import HomeVisualizer.VisualizeRenderer.Shapes.Tetrahedron;

public class BasicEntityBuilder {

    public static IEntity apartmentUndefinedWalls() {
        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
        double moveBackForView = 2000 * 3;
        MyPoint[] wallBottomPoints = new MyPoint[CreateApartmentLogic.wallPoints.size() + 1];

        MyPoint startBottom = new MyPoint(0- moveBackForView, 0, 0);
        MyPoint startTop = new MyPoint(0- moveBackForView, 0, CreateApartmentLogic.constantHeight);

        wallBottomPoints[0] = startBottom;
        
        // add walls
        for (int wall = 0; wall < CreateApartmentLogic.wallPoints.size(); wall++) {
                if (wall == 0) {
                        MyPoint wallBottom = new MyPoint(CreateApartmentLogic.wallPoints.get(wall)[0] - moveBackForView, CreateApartmentLogic.wallPoints.get(wall)[1], 0);
                        MyPoint wallTop = new MyPoint(CreateApartmentLogic.wallPoints.get(wall)[0] - moveBackForView, CreateApartmentLogic.wallPoints.get(wall)[1], CreateApartmentLogic.constantHeight);

                        Tetrahedron tetra = new Tetrahedron(
                                new MyPolygon(startBottom, startTop, wallTop, wallBottom)
                        );
                        tetras.add(tetra);
                        wallBottomPoints[wall + 1] = wallBottom;
                } else {
                        MyPoint wallBottomBefore = new MyPoint(CreateApartmentLogic.wallPoints.get(wall-1)[0] - moveBackForView, CreateApartmentLogic.wallPoints.get(wall-1)[1], 0);
                        MyPoint wallTopBefore = new MyPoint(CreateApartmentLogic.wallPoints.get(wall-1)[0] - moveBackForView, CreateApartmentLogic.wallPoints.get(wall-1)[1], CreateApartmentLogic.constantHeight); 
                        MyPoint wallBottom = new MyPoint(CreateApartmentLogic.wallPoints.get(wall)[0] - moveBackForView, CreateApartmentLogic.wallPoints.get(wall)[1], 0);
                        MyPoint wallTop = new MyPoint(CreateApartmentLogic.wallPoints.get(wall)[0] - moveBackForView, CreateApartmentLogic.wallPoints.get(wall)[1], CreateApartmentLogic.constantHeight);
               
                        Tetrahedron tetra = new Tetrahedron(
                                new MyPolygon(wallBottomBefore, wallTopBefore, wallTop, wallBottom)
                        );
                        tetras.add(tetra);
                        wallBottomPoints[wall + 1] = wallBottom;
                }
        }

        // add bottom
        Tetrahedron tetra = new Tetrahedron(
                new MyPolygon(wallBottomPoints)
        );

        tetras.add(tetra);
        return new Entity(tetras);
    }

    public static IEntity apartmentFourWalls(double length, double height, double width) {

        double moveBackForView = length * 3;

        MyPoint pLeftBottomUpBack = new MyPoint(0 - moveBackForView, -width / 2, 0);
        MyPoint pRightBottomUpBack = new MyPoint(0 - moveBackForView, width / 2, 0);

        MyPoint pLeftBottomUpFront = new MyPoint(length - moveBackForView, -width / 2, 0);
        MyPoint pRightBottomUpFront = new MyPoint(length - moveBackForView, width / 2, 0);

        MyPoint pLeftTopBack = new MyPoint(0 - moveBackForView, -width / 2, height);
        MyPoint pLeftTopFront = new MyPoint(length - moveBackForView, -width / 2, height);

        MyPoint pRightTopBack = new MyPoint(0 - moveBackForView, width / 2, height);
        MyPoint pRightTopFront = new MyPoint(length - moveBackForView, width / 2, height);

        Tetrahedron tetraBottom = new Tetrahedron(
                new MyPolygon(pLeftBottomUpFront, pRightBottomUpFront, pRightBottomUpBack, pLeftBottomUpBack));

        Tetrahedron tetraLeftWall = new Tetrahedron(
                new MyPolygon(pLeftBottomUpFront, pLeftTopFront, pLeftTopBack, pLeftBottomUpBack));

        Tetrahedron tetraRightWall = new Tetrahedron(
                new MyPolygon(pRightBottomUpFront, pRightTopFront, pRightTopBack, pRightBottomUpBack));

        Tetrahedron tetraBackWall = new Tetrahedron(
                new MyPolygon(pLeftBottomUpBack, pLeftTopBack, pRightTopBack, pRightBottomUpBack));

        Tetrahedron tetraFrontWall = new Tetrahedron(
                new MyPolygon(pLeftBottomUpFront, pLeftTopFront, pRightTopFront, pRightBottomUpFront));

        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
        tetras.add(tetraBottom);
        tetras.add(tetraLeftWall);
        tetras.add(tetraRightWall);
        tetras.add(tetraBackWall);
        tetras.add(tetraFrontWall);

        return new Entity(tetras);
    }

    public static IEntity createWallWithDoor(Color color, double length, double height, double centerX,
            double centerY, double centerZ, IEntity wall) {

        MyPolygon[] wallPolygons = wall.getPolygons();
        // MyPolygon wallBack = wallPolygons[0];
        // MyPolygon wallDown = wallPolygons[1];
        // MyPolygon wallLeft = wallPolygons[2];
        // MyPolygon wallRight = wallPolygons[3];
        // MyPolygon wallUp = wallPolygons[4];
        // MyPolygon wallFront = wallPolygons[5];

        // wallBack.getPoints();

        MyPoint[] wallBackPoints = wallPolygons[0].getPoints();
        MyPoint[] wallDownPoints = wallPolygons[1].getPoints();
        MyPoint[] wallLeftPoints = wallPolygons[2].getPoints();
        MyPoint[] wallRightPoints = wallPolygons[3].getPoints();
        MyPoint[] wallUpPoints = wallPolygons[4].getPoints();
        MyPoint[] wallFrontPoints = wallPolygons[5].getPoints();

        // back
        // down
        // left
        // right
        // Up
        // front

        MyPoint p1 = wallLeftPoints[0];
        MyPoint p2 = wallFrontPoints[1];
        MyPoint p3 = wallFrontPoints[2];
        MyPoint p4 = wallFrontPoints[3];
        MyPoint p5 = new MyPoint(wallBackPoints[0].x, wallBackPoints[0].y - (centerY + length / 2),
                wallBackPoints[0].z);
        MyPoint p6 = new MyPoint(wallBackPoints[1].x, wallBackPoints[1].y - (centerY + length / 2),
                wallBackPoints[1].z);
        MyPoint p7 = new MyPoint(wallBackPoints[2].x, wallBackPoints[2].y - (centerY + length / 2),
                wallBackPoints[2].z);
        MyPoint p8 = new MyPoint(wallBackPoints[3].x, wallBackPoints[3].y - (centerY + length / 2),
                wallBackPoints[3].z);

        MyPoint p9 = new MyPoint(wallFrontPoints[0].x, wallFrontPoints[0].y + (centerY + length / 2),
                wallFrontPoints[0].z);
        MyPoint p10 = new MyPoint(wallFrontPoints[1].x, wallFrontPoints[1].y + (centerY + length / 2),
                wallFrontPoints[1].z);
        MyPoint p11 = new MyPoint(wallFrontPoints[2].x, wallFrontPoints[2].y + (centerY + length / 2),
                wallFrontPoints[2].z);
        MyPoint p12 = new MyPoint(wallFrontPoints[3].x, wallFrontPoints[3].y + (centerY + length / 2),
                wallFrontPoints[3].z);
        MyPoint p13 = wallBackPoints[0]; // left down back
        MyPoint p14 = wallBackPoints[1];
        MyPoint p15 = wallBackPoints[2];
        MyPoint p16 = wallBackPoints[3]; // left up back

        MyPoint p17 = new MyPoint(wallFrontPoints[0].x, centerY + -length / 4, centerZ + height / 2); // left down front
        MyPoint p18 = new MyPoint(wallFrontPoints[0].x, centerY + length / 2, centerZ + height / 2); // right down front
        MyPoint p19 = new MyPoint(wallFrontPoints[0].x, centerY + length / 2, centerZ + height / 4); // right up front
        MyPoint p20 = new MyPoint(wallFrontPoints[0].x, centerY + -length / 4, centerZ + height / 4); // left up front
        MyPoint p21 = new MyPoint(wallBackPoints[0].x - 10, centerY + -length / 4, centerZ + height / 2); // left down
                                                                                                          // back
        MyPoint p22 = new MyPoint(wallBackPoints[0].x - 10, centerY + length / 2, centerZ + height / 2); // right down
                                                                                                         // back
        MyPoint p23 = new MyPoint(wallBackPoints[0].x - 10, centerY + length / 2, centerZ + height / 4); // right up
                                                                                                         // back
        MyPoint p24 = new MyPoint(wallBackPoints[0].x - 10, centerY + -length / 4, centerZ + height / 4); // left up
                                                                                                          // back

        Tetrahedron tetraLeft = new Tetrahedron(
                color,
                false,
                new MyPolygon(p5, p6, p7, p8), // back
                new MyPolygon(p1, p5, p6, p2), // down
                new MyPolygon(wallLeftPoints[0], wallLeftPoints[1], wallLeftPoints[2], wallLeftPoints[3]), // left
                new MyPolygon(p2, p6, p7, p3), // right
                new MyPolygon(p4, p3, p7, p8), // Up
                new MyPolygon(p1, p2, p3, p4)); // front

        Tetrahedron tetraRight = new Tetrahedron(
                color,
                false,
                new MyPolygon(p13, p14, p15, p16), // back
                new MyPolygon(p9, p13, p14, p10), // down
                new MyPolygon(p9, p13, p16, p12), // left
                new MyPolygon(wallBackPoints[0], wallBackPoints[1], wallBackPoints[2], wallBackPoints[3]), // right
                new MyPolygon(p12, p11, p15, p16), // Up
                new MyPolygon(p9, p10, p11, p12)); // front

        Tetrahedron tetraUp = new Tetrahedron(
                color,
                false,
                new MyPolygon(p21, p22, p23, p24), // back
                new MyPolygon(p17, p21, p22, p18), // down
                new MyPolygon(p17, p21, p24, p20), // left
                new MyPolygon(p18, p22, p23, p19), // right
                new MyPolygon(p20, p19, p23, p24), // Up
                new MyPolygon(p17, p18, p19, p20)); // front

        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
        tetras.add(tetraLeft);
        tetras.add(tetraRight);
        tetras.add(tetraUp);

        return new Entity(tetras);
    }

    public static IEntity createRectangle(Color color, double length, double width, double height, double centerX,
            double centerY, double centerZ) {
        MyPoint p1 = new MyPoint(centerX + length / 2, centerY + -width / 2, centerZ + -height / 2);
        MyPoint p2 = new MyPoint(centerX + length / 2, centerY + width / 2, centerZ + -height / 2);
        MyPoint p3 = new MyPoint(centerX + length / 2, centerY + width / 2, centerZ + height / 2);
        MyPoint p4 = new MyPoint(centerX + length / 2, centerY + -width / 2, centerZ + height / 2);
        MyPoint p5 = new MyPoint(centerX + -length, centerY + -width / 2, centerZ + -height / 2); // left down back
        MyPoint p6 = new MyPoint(centerX + -length, centerY + width / 2, centerZ + -height / 2); // right down back
        MyPoint p7 = new MyPoint(centerX + -length, centerY + width / 2, centerZ + height / 2); // right up back
        MyPoint p8 = new MyPoint(centerX + -length, centerY + -width / 2, centerZ + height / 2); // left up back

        Tetrahedron tetra = new Tetrahedron(
                new MyPolygon(color, p5, p6, p7, p8),
                new MyPolygon(color, p1, p5, p6, p2),
                new MyPolygon(color, p1, p5, p8, p4),
                new MyPolygon(color, p2, p6, p7, p3),
                new MyPolygon(color, p4, p3, p7, p8),
                new MyPolygon(color, p1, p2, p3, p4));

        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
        tetras.add(tetra);

        return new Entity(tetras);
    }

    public static IEntity createRectangle(double length, double width, double height, double centerX, double centerY,
            double centerZ) {
        MyPoint p1 = new MyPoint(centerX + length / 2, centerY + -width / 2, centerZ + -height / 2);
        MyPoint p2 = new MyPoint(centerX + length / 2, centerY + width / 2, centerZ + -height / 2);
        MyPoint p3 = new MyPoint(centerX + length / 2, centerY + width / 2, centerZ + height / 2);
        MyPoint p4 = new MyPoint(centerX + length / 2, centerY + -width / 2, centerZ + height / 2);
        MyPoint p5 = new MyPoint(centerX + -length, centerY + -width / 2, centerZ + -height / 2);
        MyPoint p6 = new MyPoint(centerX + -length, centerY + width / 2, centerZ + -height / 2);
        MyPoint p7 = new MyPoint(centerX + -length, centerY + width / 2, centerZ + height / 2);
        MyPoint p8 = new MyPoint(centerX + -length, centerY + -width / 2, centerZ + height / 2);

        Tetrahedron tetra = new Tetrahedron(
                new MyPolygon(p5, p6, p7, p8), // back
                new MyPolygon(p1, p5, p6, p2), // down
                new MyPolygon(p1, p5, p8, p4), // left
                new MyPolygon(p2, p6, p7, p3), // right
                new MyPolygon(p4, p3, p7, p8), // Up
                new MyPolygon(p1, p2, p3, p4)); // front

        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
        tetras.add(tetra);

        return new Entity(tetras);
    }

    public static IEntity createCube(double size, double centerX, double centerY, double centerZ) {
        MyPoint p1 = new MyPoint(centerX + size / 2, centerY + -size / 2, centerZ + -size / 2);
        MyPoint p2 = new MyPoint(centerX + size / 2, centerY + size / 2, centerZ + -size / 2);
        MyPoint p3 = new MyPoint(centerX + size / 2, centerY + size / 2, centerZ + size / 2);
        MyPoint p4 = new MyPoint(centerX + size / 2, centerY + -size / 2, centerZ + size / 2);
        MyPoint p5 = new MyPoint(centerX + -size / 2, centerY + -size / 2, centerZ + -size / 2);
        MyPoint p6 = new MyPoint(centerX + -size / 2, centerY + size / 2, centerZ + -size / 2);
        MyPoint p7 = new MyPoint(centerX + -size / 2, centerY + size / 2, centerZ + size / 2);
        MyPoint p8 = new MyPoint(centerX + -size / 2, centerY + -size / 2, centerZ + size / 2);

        Tetrahedron tetra = new Tetrahedron(
                // Color.BLUE,
                new MyPolygon(Color.BLUE, p5, p6, p7, p8),
                new MyPolygon(Color.WHITE, p1, p5, p6, p2),
                new MyPolygon(Color.YELLOW, p1, p5, p8, p4),
                new MyPolygon(Color.GREEN, p2, p6, p7, p3),
                new MyPolygon(Color.ORANGE, p4, p3, p7, p8),
                new MyPolygon(Color.RED, p1, p2, p3, p4));

        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
        tetras.add(tetra);

        return new Entity(tetras);
    }

    public static IEntity createDiamond(Color color, double size, double centerX, double centerY, double centerZ) {
        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();

        int edges = 10;
        double inFactor = 0.8;

        MyPoint bottom = new MyPoint(centerX, centerY, centerZ - size / 2);
        MyPoint[] outPoints = new MyPoint[edges];
        MyPoint[] inPoints = new MyPoint[edges];

        for (int i = 0; i < edges; i++) {
            double theta = 2 * Math.PI / edges * i;
            double xPos = -Math.sin(theta) * size / 2;
            double yPos = Math.cos(theta) * size / 2;
            double zPos = size / 2;

            outPoints[i] = new MyPoint(centerX + xPos, centerY + yPos, centerZ + zPos);
            inPoints[i] = new MyPoint(centerX + xPos * inFactor, centerY + yPos * inFactor, centerZ + zPos / inFactor);
        }

        MyPolygon[] polygons = new MyPolygon[2 * edges + 1];

        for (int i = 0; i < edges; i++) {
            polygons[i] = new MyPolygon(outPoints[i], bottom, outPoints[(i + 1) % edges]);
        }

        for (int i = 0; i < edges; i++) {
            polygons[i + edges] = new MyPolygon(outPoints[i], outPoints[(i + 1) % edges], inPoints[(i + 1) % edges],
                    inPoints[i]);
        }
        polygons[edges * 2] = new MyPolygon(inPoints);

        Tetrahedron tetrahedron = new Tetrahedron(color, true, polygons);
        tetras.add(tetrahedron);

        return new Entity(tetras);
    }

    public static IEntity createSphere(Color color, double size, int resolution, double centerX, double centerY,
            double centerZ) {
        List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
        List<MyPolygon> polygons = new ArrayList<MyPolygon>();

        MyPoint bottom = new MyPoint(centerX, centerY, centerZ - size / 2);
        MyPoint top = new MyPoint(centerX, centerY, centerZ + size / 2);

        MyPoint[][] points = new MyPoint[resolution - 1][resolution];

        for (int i = 1; i < resolution; i++) {
            double theta = Math.PI / resolution * i;
            double zPos = -Math.cos(theta) * size / 2;
            double currentRadius = Math.abs(Math.sin(theta) * size / 2);

            for (int j = 0; j < resolution; j++) {
                double alpha = 2 * Math.PI / resolution * j;
                double xPos = -Math.sin(alpha) * currentRadius;
                double yPos = Math.cos(alpha) * currentRadius;

                points[i - 1][j] = new MyPoint(centerX + xPos, centerY + yPos, centerZ + zPos);
            }
        }

        for (int i = 1; i <= resolution; i++) {
            for (int j = 0; j < resolution; j++) {
                if (i == 1) {
                    polygons.add(
                            new MyPolygon(
                                    points[i - 1][j],
                                    points[i - 1][(j + 1) % resolution],
                                    bottom));
                } else if (i == resolution) {
                    polygons.add(
                            new MyPolygon(
                                    points[i - 2][(j + 1) % resolution],
                                    points[i - 2][j],
                                    top));
                } else {
                    polygons.add(
                            new MyPolygon(
                                    points[i - 1][j],
                                    points[i - 1][(j + 1) % resolution],
                                    points[i - 2][(j + 1) % resolution],
                                    points[i - 2][j]));
                }
            }
        }

        MyPolygon[] pologonArray = new MyPolygon[polygons.size()];
        pologonArray = polygons.toArray(pologonArray);

        Tetrahedron tetrahedron = new Tetrahedron(color, false, pologonArray);
        tetras.add(tetrahedron);

        return new Entity(tetras);
    }
}
