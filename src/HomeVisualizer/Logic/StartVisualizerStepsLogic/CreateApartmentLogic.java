package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Graphics.Point2d;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne.CreateApartmentGui;
import HomeVisualizer.Logic.Logic;
import HomeVisualizer.Logic.StartVisualizeLogic;

public class CreateApartmentLogic {

    public static boolean isFourWalls;
    public static double constantHeight;
    public static boolean addHeightSuccesful = false;
    public static List<Point2d> wallPoints = new ArrayList<>();

    public static void userChooseFourWalls() {
        Logic.setElementsVisibility(CreateApartmentGui.chooseWalls, false);
        isFourWalls = true;
        initFourWalls();
    }

    private static void initFourWalls() {
        addElemetsToPanelFourWalls();
        CreateApartmentGui.finishedCreation.setVisible(true);
        Logic.setElementsVisibility(CreateApartmentGui.apartmentParameter, true);
        Logic.setElementsVisibility(CreateApartmentGui.getApartmentParameter, true);
    }

    private static void addElemetsToPanelFourWalls() {
        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.finishedCreation);
        StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.apartmentParameter);
        StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.getApartmentParameter);
    }

    public static void userChooseUndefinedWalls() {
        Logic.setElementsVisibility(CreateApartmentGui.chooseWalls, false);
        isFourWalls = false;
        initUndefinedWalls();
    }

    private static void initUndefinedWalls() {
        addElemetsToPanelUndefinedWalls();
        CreateApartmentGui.height.setVisible(true);
        CreateApartmentGui.getHeight.setVisible(true);
        CreateApartmentGui.finishedAddingWalls.setVisible(true);
        CreateApartmentGui.oneMoreWall.setVisible(true);
        CreateApartmentGui.getHeight.setText("in cm");
    }

    private static void addElemetsToPanelUndefinedWalls() {
        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.height);
        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.getHeight);
        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.finishedAddingWalls);
        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.oneMoreWall);
    }

    public static void addHeight() {
        try {
            constantHeight = Integer.parseInt(CreateApartmentGui.getHeight.getText()) * Logic.METER_INTO_PIXEL;
        } catch (Exception e) {
            return;
        }
        addHeightSuccesful = true;
    }

    public static void initAddWalls() {
        CreateApartmentGui.height.setVisible(false);
        CreateApartmentGui.getHeight.setVisible(false);
        CreateApartmentGui.oneMoreWall.setText("One more wall");

        StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.undefinedApartmentParameter);
        StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.getUndefinedApartmentParameter);

        Logic.setElementsVisibility(CreateApartmentGui.undefinedApartmentParameter, true);
        Logic.setElementsVisibility(CreateApartmentGui.getUndefinedApartmentParameter, true);
    }

    public static void addWall() {
        double x = Integer.parseInt(CreateApartmentGui.getXPos.getText()) * Logic.METER_INTO_PIXEL;
        double y = Integer.parseInt(CreateApartmentGui.getYPos.getText()) * Logic.METER_INTO_PIXEL;
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
        for (int parameter = 0; parameter < CreateApartmentGui.getApartmentParameter.length; parameter++) {
            try {
                if (isFourWalls) {
                    Integer.parseInt(CreateApartmentGui.getApartmentParameter[parameter].getText());
                } else {
                    Integer.parseInt(CreateApartmentGui.getXPos.getText());
                    Integer.parseInt(CreateApartmentGui.getYPos.getText());
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void finishedStepOne() {
        if (isFourWalls) {
            constantHeight = Integer.parseInt(CreateApartmentGui.getApartmentParameter[1].getText()) * Logic.METER_INTO_PIXEL;
            elementsInvisibleFourWalls();
        } else {
            elementsInvisibleUndefinedWalls();
        }
        Logic.setElementsVisibility(CreateApartmentGui.actionButtons, false);
    }

    private static void elementsInvisibleFourWalls() {
        Logic.setElementsVisibility(CreateApartmentGui.apartmentParameter, false);
        Logic.setElementsVisibility(CreateApartmentGui.getApartmentParameter, false);
        Logic.setElementsVisibility(CreateApartmentGui.actionButtons, false);
    }

    private static void elementsInvisibleUndefinedWalls() {
        CreateApartmentGui.getXPos.setVisible(false);
        CreateApartmentGui.getYPos.setVisible(false);
        CreateApartmentGui.xPos.setVisible(false);
        CreateApartmentGui.yPos.setVisible(false);
    }
}