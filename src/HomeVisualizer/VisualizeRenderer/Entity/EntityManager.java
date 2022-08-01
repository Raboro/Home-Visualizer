package HomeVisualizer.VisualizeRenderer.Entity;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.VisualizeRenderer.Entity.Builder.BasicEntityBuilder;
import HomeVisualizer.VisualizeRenderer.Entity.Builder.ComplexEntitiyBuilder;
import HomeVisualizer.VisualizeRenderer.Input.ClickType;
import HomeVisualizer.VisualizeRenderer.Input.UserInput;
import HomeVisualizer.VisualizeRenderer.Point.MyVector;
import HomeVisualizer.VisualizeRenderer.Point.PointConverter;
import HomeVisualizer.VisualizeRenderer.World.Camera;

public class EntityManager {
    
    private List<IEntity> entities;
    private int initialX, initialY;
    private MyVector lightVector = MyVector.normalize(new MyVector(1, 1, 1));
    private UserInput userInput;
    private Camera camera;
    private double moveSpeed = 100;
    private double lengthApartment, hightApartment, widthApartment;
    private int meterIntoPixel = 2000;

    public EntityManager(double lengthApartment, double hightApartment, double widthApartment) {
        this.entities = new ArrayList<IEntity>();
        this.camera = new Camera(-1500, 0, 0);
        this.lengthApartment = lengthApartment * meterIntoPixel;
        this.hightApartment = hightApartment * meterIntoPixel;
        this.widthApartment = widthApartment * meterIntoPixel;
    }

    public void init(UserInput userInput) {
        this.userInput = userInput;
        // create apartment:
        this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, this.lengthApartment, 10, this.hightApartment, -this.lengthApartment, this.lengthApartment / 5, 0)); // left
        this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, this.lengthApartment, 10, this.hightApartment, -this.lengthApartment, this.lengthApartment - this.lengthApartment / 5, 0)); // right
        this.entities.add(BasicEntityBuilder.createRectangle(Color.GRAY, this.lengthApartment, this.widthApartment + 10, 10, -this.lengthApartment, this.lengthApartment / 2, -this.hightApartment / 2 - 5)); // bottom
        this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, 10, this.widthApartment, this.hightApartment, -this.lengthApartment / 2, this.lengthApartment / 2, 0)); // front
        this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, 10, this.widthApartment, this.hightApartment, -this.lengthApartment * 2, this.lengthApartment / 2, 0)); // back
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, 1000, 10, 300, -1000, 0, 0)); // left
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, 1000, 10, 300, -1000, 1000, 0)); // right
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.GRAY, 1000, 1010, 10, -1000, 500, -155)); // bottom
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, 10, 1000, 300, -500, 500, 0)); // front
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.GREEN, 10, 1000, 300, -2000, 500, 0)); // back

        // add into apartment
        //this.entities.add(BasicEntityBuilder.createCube(100, -800, 500, 100));

        // add walls inside to create rooms
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.BLUE, 10, 400, 300, -800, 800, 0));
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.BLUE, 10, 400, 300, -1500, 800, 0));
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.BLUE, 400, 10, 300, -700, 340, 0));
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.BLUE, 480, 10, 300, -1030, 600, 0));
        // this.entities.add(BasicEntityBuilder.createRectangle(Color.BLUE, 10, 350, 300, -1100, 170, 0));

        // this.entities.add(BasicEntityBuilder.createWallWithDoor(Color.BLUE, 250, 300, -1100, 100, 0, this.entities.get(9)));
        // this.entities.remove(9);
        
        // other forms

        // this.entities.add(BasicEntityBuilder.createCube(100, 0, 0, 0));
        // this.entities.add(ComplexEntitiyBuilder.createRubicsCube(100, -500, 0, 0));
        // this.entities.add(BasicEntityBuilder.createDiamond(new Color(200, 40, 150), 200, 500, 500, 500));
        // this.entities.add(BasicEntityBuilder.createSphere(Color.RED, 100, 50, 0, 0, 0));
        this.setLighting();
        
    }

    public void update() {
        int x = this.userInput.mouse.getX();
        int y = this.userInput.mouse.getY();

        if (this.userInput.mouse.getButton() == ClickType.LEFTCLICK) {
            int xDif = x - initialX;
            int yDif = y - initialY;

            this.rotate(true, 0, -yDif / 2.5, -xDif / 2.5);

        } else if (this.userInput.mouse.getButton() == ClickType.RIGHTCLICK) {
            int xDif = x - initialX;

            this.rotate(true, -xDif / 2.5, 0, 0);
        }

        if (this.userInput.mouse.isScrollingUp()) {
            PointConverter.zoomIn();
        } else if (this.userInput.mouse.isScrollingDown()) {
            PointConverter.zoomOut();
        }

        if (this.userInput.keyboard.getLeft()) {
            this.camera.translate(0, -moveSpeed, 0);
            for (IEntity entity : this.entities) {
                entity.translate(0, moveSpeed, 0);
            }
        } else if (this.userInput.keyboard.getRight()) {
            this.camera.translate(0, moveSpeed, 0);
            for (IEntity entity : this.entities) {
                entity.translate(0, -moveSpeed, 0);
            }
        } else if (this.userInput.keyboard.getUp()) {
            this.camera.translate(0, 0, moveSpeed);
            for (IEntity entity : this.entities) {
                entity.translate(0, 0, -moveSpeed);
            }
        } else if (this.userInput.keyboard.getDown()) {
            this.camera.translate(0, 0, -moveSpeed);
            for (IEntity entity : this.entities) {
                entity.translate(0, 0, moveSpeed);
            }
        } else if (this.userInput.keyboard.getForward()) {
            this.camera.translate(-moveSpeed, 0, 0);
            for (IEntity entity : this.entities) {
                entity.translate(moveSpeed, 0, 0);
            }
        } else if (this.userInput.keyboard.getBackward()) {
            this.camera.translate(moveSpeed, 0, 0);
            for (IEntity entity : this.entities) {
                entity.translate(-moveSpeed, 0, 0);
            }
        }

        this.userInput.mouse.resetScroll();
        this.userInput.keyboard.update();

        initialX = x;
        initialY = y;
    }

    public void render(Graphics g) {
        for (IEntity entity : this.entities) {
            entity.render(g);
        }
    }

    private void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
        for (IEntity entity : this.entities) {
            entity.rotate(CW, xDegrees, yDegrees, zDegrees, this.lightVector);
        }
    }

    private void setLighting() {
        for (IEntity entity : this.entities) {
            entity.setLighting(this.lightVector);
        }
    }
}
