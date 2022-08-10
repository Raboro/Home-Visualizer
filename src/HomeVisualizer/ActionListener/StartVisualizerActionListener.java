package HomeVisualizer.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateRoomsGui;
import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;

import HomeVisualizer.Logic.StartVisualizeLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomsLogic;

public class StartVisualizerActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == StartVisualizeElementsGui.newProject) {
            if (!StartVisualizeLogic.userStartNewProject) {
                StartVisualizeLogic.userStartNewProject = true;
                StartVisualizeGui.loadNewProjectGui();
            } else {
                NewProjectElementsGui.showPopUpCreatingProjectNotFinished();
            }
        }

        if (event.getSource() == StartVisualizeElementsGui.threeDVisualizer) {}

        if (event.getSource() == NewProjectElementsGui.startSteps) {
            StartVisualizeGui.startSteps();
        }

        if (event.getSource() == NewProjectElementsGui.continueSteps) {
            if (StartVisualizeLogic.userIsWorking) {
                StartVisualizeLogic.continueAfterUserIsWorking();
            } else {
                StartVisualizeLogic.continueAfterUserIsNotWorking();
            }
        }

        if (event.getSource() == CreateApartmentGui.chooseWalls[0]) {
            CreateApartmentLogic.userChooseFourWalls();
        }

        if (event.getSource() == CreateApartmentGui.chooseWalls[1]) {
            CreateApartmentLogic.userChooseMoreThenFourWalls();
        }

        if (event.getSource() == CreateApartmentGui.finishedCreation) {
            if (CreateApartmentLogic.isUserInputCorrectStepOne()) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                CreateApartmentLogic.finishedStepOne();
            }
        }

        if (event.getSource() == CreateApartmentGui.oneMoreWall) {
            CreateApartmentLogic.userChooseMoreThenFourWalls();
        }

        if (event.getSource() == CreateApartmentGui.finishedAddingWalls) {
            if (CreateApartmentLogic.isUserInputCorrectStepOne() && CreateApartmentLogic.wallPoints.size() > 2) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                CreateApartmentLogic.finishedStepOne();
            }
        }

        if (event.getSource() == CreateRoomsGui.addWalls) {
            if (CreateRoomsLogic.isUserInputCorrectStepTwo()) {
                CreateRoomsLogic.addWallsToArray();
            }
        }

        if (event.getSource() == CreateRoomsGui.finishedAddingWalls) {
            if (CreateRoomsLogic.isUserInputCorrectStepTwo() && CreateRoomsLogic.wallPoints.size() > 2) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                CreateRoomsLogic.finishedStepTwo();
            }
        }
    }
}