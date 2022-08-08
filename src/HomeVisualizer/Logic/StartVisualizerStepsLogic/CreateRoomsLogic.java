package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateRoomsGui;
import HomeVisualizer.Logic.StartVisualizeLogic;

public class CreateRoomsLogic {

    public static List<double[]> wallPoints = new ArrayList<>();
    
    private static void setVisibleElements(boolean visibility) {
        for (int i = 0; i < CreateRoomsGui.positions.length; i++) {
            CreateRoomsGui.positions[i].setVisible(visibility);
            CreateRoomsGui.getPositions[i].setVisible(visibility);
        }
        CreateRoomsGui.actionButtons[0].setVisible(visibility);
        CreateRoomsGui.actionButtons[1].setVisible(visibility);
    }

    public static void init() {
        StartVisualizeLogic.addElementsToPanel(CreateRoomsGui.positions);
        StartVisualizeLogic.addElementsToPanel(CreateRoomsGui.getPositions);
        StartVisualizeLogic.addElementsToPanel(CreateRoomsGui.actionButtons);
        
        setVisibleElements(true);
    }

    public static boolean isUserInputCorrectStepTwo() {
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
        double startXPos = Integer.parseInt(CreateRoomsGui.getStartXPos.getText()); 
        double startYPos = Integer.parseInt(CreateRoomsGui.getStartYPos.getText());
        double endXPos = Integer.parseInt(CreateRoomsGui.getEndXPos.getText()); 
        double endYPos = Integer.parseInt(CreateRoomsGui.getEndYPos.getText());
        double[] point = { startXPos, startYPos, endXPos, endYPos };
        wallPoints.add(point);
    }

    public static void finishedStepTwo() {
        setVisibleElements(false);
        StartVisualizeGui.createDisplay();
    }
}