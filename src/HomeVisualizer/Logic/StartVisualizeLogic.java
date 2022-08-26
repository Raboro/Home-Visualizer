package HomeVisualizer.Logic;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.Colors;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StepStates;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne.CreateApartmentGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne.CreateApartmentGuiElements;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepThree.CreateRoomNamesGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepTwo.CreateRoomsGui;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomNamesLogicGraphics;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomNamesLogicGui;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateRoomsLogic;

public class StartVisualizeLogic {

    public static StepStates currentState;
    public static boolean userStartNewProject = false;
    public static boolean userIsWorking = false;
    public static boolean finishedStartSteps = false;

    private static int stepState = 0;
    private static StepStates[] stepArray = { StepStates.CREATE_APARTMENT, StepStates.CREATE_ROOMS,
            StepStates.CREATE_ROOM_NAMES, StepStates.CREATE_DOORS };

    public static void loadNewProjectGui() {
        initNewProject();

        Logic.addElementsToPanel(NewProjectElementsGui.buttonsSteps, StartVisualizeGui.panel);
        Logic.addElementsToPanel(new JButton[]{NewProjectElementsGui.startSteps}, StartVisualizeGui.panel);
        Logic.addElementsToPanel(new JLabel[]{NewProjectElementsGui.stepName}, StartVisualizeGui.panel);

        Logic.setElementsVisibility(NewProjectElementsGui.buttonsSteps, true);
        NewProjectElementsGui.startSteps.setVisible(true);
    }

    public static void initNewProject() {
        NewProjectElementsGui.initStateName();
        NewProjectElementsGui.initStepButtons();
        NewProjectElementsGui.initStartStep();
        NewProjectElementsGui.initContinueStep();

        CreateApartmentGui.initializeGuiElements();
        CreateRoomsGui.initializeGuiElements();
        CreateRoomNamesGui.initializeGuiElements();
    }

    public static void startSteps() {
        NewProjectElementsGui.buttonsSteps[0].setBackground(Colors.IN_WORK_STEP_COLOR);
        NewProjectElementsGui.buttonsSteps[0]
                .setBorder(BorderFactory.createLineBorder(Colors.IN_WORK_STEP_COLOR_BORDER, 6));
        NewProjectElementsGui.stepButtonsRightBottom();
        userIsWorking = true;

        Logic.addElementsToPanel(new JButton[]{NewProjectElementsGui.continueSteps}, StartVisualizeGui.panel);

        NewProjectElementsGui.continueSteps.setVisible(true);
        NewProjectElementsGui.stepName.setVisible(true);
        NewProjectElementsGui.startSteps.setVisible(false);
        currentState = StepStates.CREATE_APARTMENT;
        selectCurrentStep();
    }

    private static void selectCurrentStep() {
        switch (currentState) {
            case CREATE_APARTMENT:
                create_Apartment();
                break;
            case CREATE_ROOMS:
                CreateRoomsLogic.init();
                break;
            case CREATE_ROOM_NAMES:
                CreateRoomNamesLogicGraphics.init();
                CreateRoomNamesLogicGui.init();
                break;
            case CREATE_DOORS:
        }
    }

    public static void continueAfterUserIsWorking() {
        userIsWorking = false;
        NewProjectElementsGui.stepName.setVisible(false);
        NewProjectElementsGui.buttonsSteps[stepState].setBackground(Colors.FINISHED_STEP_COLOR);
        NewProjectElementsGui.buttonsSteps[stepState]
                .setBorder(BorderFactory.createLineBorder(Colors.FINISHED_STEP_COLOR_BORDER, 6));
        NewProjectElementsGui.stepButtonsCenter();

        if (stepState < 3) {
            NewProjectElementsGui.changeStateName();
        } else {
            NewProjectElementsGui.continueSteps.setVisible(false);
            finishedStartSteps = true;
        }
    }

    public static void continueAfterUserIsNotWorking() {
        NewProjectElementsGui.stepName.setVisible(true);
        stepState += 1;
        currentState = stepArray[stepState];
        userIsWorking = true;
        NewProjectElementsGui.buttonsSteps[stepState].setBackground(Colors.IN_WORK_STEP_COLOR);
        NewProjectElementsGui.buttonsSteps[stepState]
                .setBorder(BorderFactory.createLineBorder(Colors.IN_WORK_STEP_COLOR_BORDER, 6));
        NewProjectElementsGui.stepButtonsRightBottom();
        selectCurrentStep();
    }

    public static void create_Apartment() {
        Logic.addElementsToPanel(CreateApartmentGuiElements.chooseWalls, StartVisualizeGui.panel);
        StartVisualizeGui.panel.invalidate();

        Logic.setElementsVisibility(CreateApartmentGuiElements.chooseWalls, true);
        StartVisualizeGui.panel.invalidate();
        NewProjectElementsGui.continueSteps.setEnabled(false);
    }
}