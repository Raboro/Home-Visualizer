package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepTwo.CreateRoomsGuiElements;
import HomeVisualizer.Logic.Logic;

public class CreateRoomsLogic {

    public static List<double[]> wallPoints = new ArrayList<>();
    
    public static void init() {
        Logic.addElementsToPanel(CreateRoomsGuiElements.positions, StartVisualizeGui.panel);
        Logic.addElementsToPanel(CreateRoomsGuiElements.getPositions, StartVisualizeGui.panel);
        Logic.addElementsToPanel(CreateRoomsGuiElements.actionButtons, StartVisualizeGui.panel);
        
        setElementsVisibility(true);
        NewProjectElementsGui.continueSteps.setEnabled(false);
    }

    private static void setElementsVisibility(boolean visibility) {
        Logic.setElementsVisibility(CreateRoomsGuiElements.positions, visibility);
        Logic.setElementsVisibility(CreateRoomsGuiElements.getPositions, visibility);
        Logic.setElementsVisibility(CreateRoomsGuiElements.actionButtons, visibility);
    }

    public static boolean isUserInputCorrect() {
        for (int parameter = 0; parameter < CreateRoomsGuiElements.getPositions.length; parameter++) {
            try {
                    Integer.parseInt(CreateRoomsGuiElements.getStartXPos.getText());
                    Integer.parseInt(CreateRoomsGuiElements.getStartYPos.getText());
                    Integer.parseInt(CreateRoomsGuiElements.getEndXPos.getText());
                    Integer.parseInt(CreateRoomsGuiElements.getEndYPos.getText());
                }
            catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void addWallsToArray() {
        double startXPos = Integer.parseInt(CreateRoomsGuiElements.getStartXPos.getText()) * Logic.METER_INTO_PIXEL; 
        double startYPos = Integer.parseInt(CreateRoomsGuiElements.getStartYPos.getText()) * Logic.METER_INTO_PIXEL;
        double endXPos = Integer.parseInt(CreateRoomsGuiElements.getEndXPos.getText()) * Logic.METER_INTO_PIXEL; 
        double endYPos = Integer.parseInt(CreateRoomsGuiElements.getEndYPos.getText()) * Logic.METER_INTO_PIXEL;
        double[] point = { startXPos, startYPos, endXPos, endYPos };
        if (wallIsNotAlreadyInArray(point)) {
            wallPoints.add(point);
        }
    }

    private static boolean wallIsNotAlreadyInArray(double[] point) {
        for (double[] wallPoint : wallPoints) {
            boolean x1PosIsEqual = wallPoint[0] == point[0];
            boolean y1PosIsEqual = wallPoint[1] == point[1];
            boolean x2PosIsEqual = wallPoint[2] == point[2];
            boolean y2PosIsEqual = wallPoint[3] == point[3];

            if (x1PosIsEqual && y1PosIsEqual && x2PosIsEqual && y2PosIsEqual) {
                return false;
            }
        }
        return true;
    }

    public static void finishedStepTwo() {
        setElementsVisibility(false);
        NewProjectElementsGui.continueSteps.setEnabled(true);
        StartVisualizeGui.createDisplay();
    }
}