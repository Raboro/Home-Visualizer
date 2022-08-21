package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;

import HomeVisualizer.Logic.StartVisualizeLogic;

public class CreateApartmentLogic {
    
    private static boolean undefinedWallsHeightInput = true;
    private static boolean startAddingWalls = false;
    private static final int METER_INTO_PIXEL = 2;

    public static boolean userChooseFourWalls;
    public static double constantHeight;
    public static List<double[]> wallPoints = new ArrayList<>();

    private static void fourWalls() {
        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.finishedCreation);
        StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.apartmentParameter);
        StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.getApartmentParameter);

        CreateApartmentGui.finishedCreation.setVisible(true);

        for (int i = 0; i < CreateApartmentGui.apartmentParameter.length; i++) {
            CreateApartmentGui.apartmentParameter[i].setVisible(true);
            CreateApartmentGui.getApartmentParameter[i].setVisible(true);
        }

        StartVisualizeGui.panel.invalidate();
        NewProjectElementsGui.continueSteps.setEnabled(false);
    }

    private static void undefinedWalls() {
        if (undefinedWallsHeightInput) {
            StartVisualizeLogic.addElementToPanel(CreateApartmentGui.height);
            StartVisualizeLogic.addElementToPanel(CreateApartmentGui.getHeight);

            CreateApartmentGui.height.setVisible(true);
            CreateApartmentGui.getHeight.setVisible(true);
            CreateApartmentGui.getHeight.setText("in cm");

            undefinedWallsHeightInput = false;
        } else {
            if (startAddingWalls) {
                double xPos = Integer.parseInt(CreateApartmentGui.getXPos.getText()) * METER_INTO_PIXEL; 
                double yPos = Integer.parseInt(CreateApartmentGui.getYPos.getText()) * METER_INTO_PIXEL;
                double[] point = { xPos, yPos };
                checkIfWallIsAlreadyInArray(point);
            }
 
            constantHeight = Integer.parseInt(CreateApartmentGui.getHeight.getText()) * METER_INTO_PIXEL;
            CreateApartmentGui.height.setVisible(false);
            CreateApartmentGui.getHeight.setVisible(false);
            CreateApartmentGui.oneMoreWall.setText("One more Wall");
            
            StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.undefinedApartmentParameter);
            StartVisualizeLogic.addElementsToPanel(CreateApartmentGui.getUndefinedApartmentParameter);
            
            for (int i = 0; i < CreateApartmentGui.undefinedApartmentParameter.length; i++) {
                CreateApartmentGui.undefinedApartmentParameter[i].setVisible(true);
                CreateApartmentGui.getUndefinedApartmentParameter[i].setVisible(true);
            }

            if (!startAddingWalls) {
                startAddingWalls = true;
            }
        }

        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.finishedAddingWalls);
        StartVisualizeLogic.addElementToPanel(CreateApartmentGui.oneMoreWall);

        CreateApartmentGui.finishedAddingWalls.setVisible(true);
        CreateApartmentGui.oneMoreWall.setVisible(true);

        StartVisualizeGui.panel.invalidate();
        NewProjectElementsGui.continueSteps.setEnabled(false);
    }

    private static void checkIfWallIsAlreadyInArray(double[] point) {
        for (int i = 0; i < wallPoints.size(); i++) {
            if (wallPoints.get(i)[0] == point[0] && wallPoints.get(i)[1] == point[1]) {
                return;
            }
        }
        wallPoints.add(point);
    }

    public static void userChooseFourWalls() {
        CreateApartmentGui.chooseWalls[0].setVisible(false);
        CreateApartmentGui.chooseWalls[1].setVisible(false);
        userChooseFourWalls = true;
        fourWalls();
    }

    public static void userChooseMoreThenFourWalls() {
        CreateApartmentGui.chooseWalls[0].setVisible(false);
        CreateApartmentGui.chooseWalls[1].setVisible(false);
        userChooseFourWalls = false;
        undefinedWalls();
    }

    public static boolean isUserInputCorrectStepOne() {
        for (int parameter = 0; parameter < CreateApartmentGui.getApartmentParameter.length; parameter++) {
            try {
                if (userChooseFourWalls) {
                    Integer.parseInt(CreateApartmentGui.getApartmentParameter[parameter].getText());
                } else {
                    if (!startAddingWalls) {
                        Integer.parseInt(CreateApartmentGui.getHeight.getText());
                        continue;
                    }
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
        if (userChooseFourWalls) {
            constantHeight = Integer.parseInt(CreateApartmentGui.getApartmentParameter[1].getText()) * METER_INTO_PIXEL;
            for (int i = 0; i < CreateApartmentGui.apartmentParameter.length; i++) {
                CreateApartmentGui.apartmentParameter[i].setVisible(false);
                CreateApartmentGui.apartmentParameter[i].setEnabled(false);
                CreateApartmentGui.getApartmentParameter[i].setVisible(false);
                CreateApartmentGui.getApartmentParameter[i].setEnabled(false);
                CreateApartmentGui.actionButtons[i].setVisible(false);
                CreateApartmentGui.actionButtons[i].setEnabled(false);
            }
    
        } else {
            CreateApartmentGui.actionButtons[1].setVisible(false);
            CreateApartmentGui.actionButtons[2].setVisible(false);
            CreateApartmentGui.getXPos.setVisible(false);
            CreateApartmentGui.getYPos.setVisible(false);
            CreateApartmentGui.xPos.setVisible(false);
            CreateApartmentGui.yPos.setVisible(false);
        }
    }
}