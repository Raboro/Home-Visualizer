package HomeVisualizer.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne.CreateApartmentGuiElements;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepThree.CreateRoomNamesGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepTwo.CreateRoomsGui;
import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;

import HomeVisualizer.Logic.StartVisualizeLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomNamesLogicGui;
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

        if (event.getSource() == CreateApartmentGuiElements.chooseWalls[0]) {
            CreateApartmentLogic.userChooseFourWalls();
        }

        if (event.getSource() == CreateApartmentGuiElements.chooseWalls[1]) {
            CreateApartmentLogic.userChooseUndefinedWalls();
        }

        if (event.getSource() == CreateApartmentGuiElements.finishedCreation) {
            if (CreateApartmentLogic.isUserInputCorrect()) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                CreateApartmentLogic.finishedStepOne();
            }
        }

        if (event.getSource() == CreateApartmentGuiElements.oneMoreWall) {
            if (CreateApartmentGuiElements.oneMoreWall.getText() == "Add first wall") {
                CreateApartmentLogic.addHeight();
                if (CreateApartmentLogic.addHeightSuccesful) {
                    CreateApartmentLogic.initAddWalls();
                }
            } else {
                CreateApartmentLogic.addWall();
            }
        }

        if (event.getSource() == CreateApartmentGuiElements.finishedAddingWalls) {
            if (CreateApartmentLogic.isUserInputCorrect() && CreateApartmentLogic.wallPoints.size() > 2) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                CreateApartmentLogic.finishedStepOne();
            }
        }

        if (event.getSource() == CreateRoomsGui.addWalls) {
            if (CreateRoomsLogic.isUserInputCorrect()) {
                CreateRoomsLogic.addWallsToArray();
            }
        }

        if (event.getSource() == CreateRoomsGui.finishedAddingWalls) {
            if (CreateRoomsLogic.isUserInputCorrect() && CreateRoomsLogic.wallPoints.size() > 2) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                CreateRoomsLogic.finishedStepTwo();
            }
        }

        if (event.getSource() == CreateRoomNamesGui.addWall) {
            CreateRoomNamesLogicGui.addWallName();
        }

        if (event.getSource() == CreateRoomNamesGui.finishRoom) {
            CreateRoomNamesLogicGui.finishedRoom();
        }

        if (event.getSource() == CreateRoomNamesGui.finishedStep) {
            CreateRoomNamesLogicGui.finishedStep();
        }
    }
}