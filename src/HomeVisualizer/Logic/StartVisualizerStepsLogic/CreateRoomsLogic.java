package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateRoomsGui;
import HomeVisualizer.Logic.Logic;
import HomeVisualizer.Logic.StartVisualizeLogic;

public class CreateRoomsLogic {

    private static final int METER_INTO_PIXEL = 2; 

    public static List<double[]> wallPoints = new ArrayList<>();
    
    public static void init() {
        StartVisualizeLogic.addElementsToPanel(CreateRoomsGui.positions);
        StartVisualizeLogic.addElementsToPanel(CreateRoomsGui.getPositions);
        StartVisualizeLogic.addElementsToPanel(CreateRoomsGui.actionButtons);
        
        setElementsVisibility(true);
        NewProjectElementsGui.continueSteps.setEnabled(false);
    }

    private static void setElementsVisibility(boolean visibility) {
        Logic.setElementsVisibility(CreateRoomsGui.positions, visibility);
        Logic.setElementsVisibility(CreateRoomsGui.getPositions, visibility);
        Logic.setElementsVisibility(CreateRoomsGui.actionButtons, visibility);
    }

    public static boolean isUserInputCorrect() {
        for (int parameter = 0; parameter < CreateRoomsGui.getPositions.length; parameter++) {
            try {
                    Integer.parseInt(CreateRoomsGui.getStartXPos.getText());
                    Integer.parseInt(CreateRoomsGui.getStartYPos.getText());
                    Integer.parseInt(CreateRoomsGui.getEndXPos.getText());
                    Integer.parseInt(CreateRoomsGui.getEndYPos.getText());
                }
            catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void addWallsToArray() {
        double startXPos = Integer.parseInt(CreateRoomsGui.getStartXPos.getText()) * METER_INTO_PIXEL; 
        double startYPos = Integer.parseInt(CreateRoomsGui.getStartYPos.getText()) * METER_INTO_PIXEL;
        double endXPos = Integer.parseInt(CreateRoomsGui.getEndXPos.getText()) * METER_INTO_PIXEL; 
        double endYPos = Integer.parseInt(CreateRoomsGui.getEndYPos.getText()) * METER_INTO_PIXEL;
        double[] point = { startXPos, startYPos, endXPos, endYPos };
        checkIfWallIsAlreadyInArray(point);
    }

    private static void checkIfWallIsAlreadyInArray(double[] point) {
        for (int i = 0; i < wallPoints.size(); i++) {
            if (wallPoints.get(i)[0] == point[0] && wallPoints.get(i)[1] == point[1] && wallPoints.get(i)[2] == point[2] && wallPoints.get(i)[3] == point[3]) {
                return;
            }
        }
        wallPoints.add(point);
    }

    public static void finishedStepTwo() {
        setElementsVisibility(false);
        NewProjectElementsGui.continueSteps.setEnabled(true);
        StartVisualizeGui.createDisplay();
    }
}