package HomeVisualizer.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Logic.StartVisualizeLogic;

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
            StartVisualizeLogic.userChooseFourWalls();
        }

        if (event.getSource() == CreateApartmentGui.chooseWalls[1]) {
            StartVisualizeLogic.userChooseMoreThenFourWalls();
        }

        if (event.getSource() == CreateApartmentGui.finishedCreation) {
            if (StartVisualizeLogic.isUserInputCorrectStepOne()) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                StartVisualizeLogic.finishedStepOne();
            }
        }

        if (event.getSource() == CreateApartmentGui.oneMoreWall) {
            StartVisualizeLogic.userChooseMoreThenFourWalls();
        }

        if (event.getSource() == CreateApartmentGui.finishedAddingWalls) {
            if (StartVisualizeLogic.isUserInputCorrectStepOne() && StartVisualizeLogic.wallPoints.size() > 2) {
                NewProjectElementsGui.continueSteps.setEnabled(true);
                StartVisualizeLogic.finishedStepOne();
            }
        }
    }
}