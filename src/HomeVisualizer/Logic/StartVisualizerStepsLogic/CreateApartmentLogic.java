package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import HomeVisualizer.Graphics.Point2d;
import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne.CreateApartmentGuiElements;
import HomeVisualizer.Logic.Logic;

public class CreateApartmentLogic {

    public static boolean isFourWalls;
    public static double constantHeight;
    public static boolean addHeightSuccessful = false;
    public static List<Point2d> wallPoints = new ArrayList<>();

    public static void userChooseFourWalls() {
        Logic.setElementsVisibility(CreateApartmentGuiElements.chooseWalls, false);
        isFourWalls = true;
        initFourWalls();
    }

    private static void initFourWalls() {
        addElemetsToPanelFourWalls();
        CreateApartmentGuiElements.finishedCreation.setVisible(true);
        Logic.setElementsVisibility(CreateApartmentGuiElements.apartmentParameter, true);
        Logic.setElementsVisibility(CreateApartmentGuiElements.getApartmentParameter, true);
    }

    private static void addElemetsToPanelFourWalls() {
        Logic.addElementsToPanel(new JButton[] { CreateApartmentGuiElements.finishedCreation },
                StartVisualizeGui.panel);
        Logic.addElementsToPanel(CreateApartmentGuiElements.apartmentParameter, StartVisualizeGui.panel);
        Logic.addElementsToPanel(CreateApartmentGuiElements.getApartmentParameter, StartVisualizeGui.panel);
    }

    public static void userChooseUndefinedWalls() {
        Logic.setElementsVisibility(CreateApartmentGuiElements.chooseWalls, false);
        isFourWalls = false;
        initUndefinedWalls();
    }

    private static void initUndefinedWalls() {
        addElemetsToPanelUndefinedWalls();
        CreateApartmentGuiElements.height.setVisible(true);
        CreateApartmentGuiElements.getHeight.setVisible(true);
        CreateApartmentGuiElements.finishedAddingWalls.setVisible(true);
        CreateApartmentGuiElements.oneMoreWall.setVisible(true);
        CreateApartmentGuiElements.getHeight.setText("in cm");
    }

    private static void addElemetsToPanelUndefinedWalls() {
        Logic.addElementsToPanel(new JLabel[] { CreateApartmentGuiElements.height }, StartVisualizeGui.panel);
        Logic.addElementsToPanel(new JTextField[] { CreateApartmentGuiElements.getHeight }, StartVisualizeGui.panel);
        Logic.addElementsToPanel(new JButton[] { CreateApartmentGuiElements.finishedAddingWalls },
                StartVisualizeGui.panel);
        Logic.addElementsToPanel(new JButton[] { CreateApartmentGuiElements.oneMoreWall }, StartVisualizeGui.panel);
    }

    public static void addHeight() {
        try {
            constantHeight = Integer.parseInt(CreateApartmentGuiElements.getHeight.getText()) * Logic.METER_INTO_PIXEL;
        } catch (Exception e) {
            return;
        }
        addHeightSuccessful = true;
    }

    public static void initAddWalls() {
        CreateApartmentGuiElements.height.setVisible(false);
        CreateApartmentGuiElements.getHeight.setVisible(false);
        CreateApartmentGuiElements.oneMoreWall.setText("One more wall");

        Logic.addElementsToPanel(CreateApartmentGuiElements.undefinedApartmentParameter, StartVisualizeGui.panel);
        Logic.addElementsToPanel(CreateApartmentGuiElements.getUndefinedApartmentParameter, StartVisualizeGui.panel);

        Logic.setElementsVisibility(CreateApartmentGuiElements.undefinedApartmentParameter, true);
        Logic.setElementsVisibility(CreateApartmentGuiElements.getUndefinedApartmentParameter, true);
    }

    public static void addWall() {
        double x = Integer.parseInt(CreateApartmentGuiElements.getXPos.getText()) * Logic.METER_INTO_PIXEL;
        double y = Integer.parseInt(CreateApartmentGuiElements.getYPos.getText()) * Logic.METER_INTO_PIXEL;
        Point2d point = new Point2d(x, y);
        if (wallIsNotAlreadyInArray(point)) {
            wallPoints.add(point);
        }
    }

    private static boolean wallIsNotAlreadyInArray(Point2d point) {
        for (Point2d loopPoint : wallPoints) {
            if (loopPoint.getX() == point.getX() && loopPoint.getY() == point.getY()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUserInputCorrect() {
        for (int parameter = 0; parameter < CreateApartmentGuiElements.getApartmentParameter.length; parameter++) {
            try {
                if (isFourWalls) {
                    Integer.parseInt(CreateApartmentGuiElements.getApartmentParameter[parameter].getText());
                } else {
                    Integer.parseInt(CreateApartmentGuiElements.getXPos.getText());
                    Integer.parseInt(CreateApartmentGuiElements.getYPos.getText());
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void finishedStepOne() {
        if (isFourWalls) {
            constantHeight = Integer.parseInt(CreateApartmentGuiElements.getApartmentParameter[1].getText())
                    * Logic.METER_INTO_PIXEL;
            elementsInvisibleFourWalls();
        } else {
            elementsInvisibleUndefinedWalls();
        }
        Logic.setElementsVisibility(CreateApartmentGuiElements.actionButtons, false);
    }

    private static void elementsInvisibleFourWalls() {
        Logic.setElementsVisibility(CreateApartmentGuiElements.apartmentParameter, false);
        Logic.setElementsVisibility(CreateApartmentGuiElements.getApartmentParameter, false);
        Logic.setElementsVisibility(CreateApartmentGuiElements.actionButtons, false);
    }

    private static void elementsInvisibleUndefinedWalls() {
        CreateApartmentGuiElements.getXPos.setVisible(false);
        CreateApartmentGuiElements.getYPos.setVisible(false);
        CreateApartmentGuiElements.xPos.setVisible(false);
        CreateApartmentGuiElements.yPos.setVisible(false);
    }
}