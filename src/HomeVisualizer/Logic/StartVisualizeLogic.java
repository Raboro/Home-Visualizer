package HomeVisualizer.Logic;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import HomeVisualizer.ActionListener.StartVisualizerActionListener;
import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StepStates;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;

public class StartVisualizeLogic {

    private static int stepState = 0;

    public static StepStates currentState;
    public static boolean userStartNewProject = false;
    public static boolean userIsWorking = false;
    public static boolean finishedStartSteps = false;

    private static void selectCurrentStep() {
        switch (currentState) {
            case CREATE_APARTMENT:
                create_Apartment();
            case CREATE_DOORS:
                break;
            case CREATE_ROOMS:
                break;
            case CREATE_ROOM_NAMES:
                break;
        }
    }

    public static <T> void addElementsToPanel(T[] addElement) {
        for (int i = 0; i < addElement.length; i++) {
            StartVisualizeGui.panel.add((Component) addElement[i]);
        }
    }

    public static <T> void addElementToPanel(T addElement) {
        StartVisualizeGui.panel.add((Component) addElement);
    }

    public static void initNewProject() {
        NewProjectElementsGui.initStateName();
        NewProjectElementsGui.initStepButtons();
        NewProjectElementsGui.initStartStep();
        NewProjectElementsGui.initContinueStep();

        CreateApartmentGui.initChooseWallsButtons();
        CreateApartmentGui.initFinishedCreation();
        CreateApartmentGui.initLabels();
        CreateApartmentGui.initTextFields();
    }

    public static void addActionListenerToElements() {
        ActionListener actionListener = new StartVisualizerActionListener();

        StartVisualizeElementsGui.newProject.addActionListener(actionListener);
        StartVisualizeElementsGui.threeDVisualizer.addActionListener(actionListener);
        NewProjectElementsGui.startSteps.addActionListener(actionListener);
        NewProjectElementsGui.continueSteps.addActionListener(actionListener);
        CreateApartmentGui.chooseWalls[0].addActionListener(actionListener);
        CreateApartmentGui.chooseWalls[1].addActionListener(actionListener);
        CreateApartmentGui.finishedCreation.addActionListener(actionListener);
        CreateApartmentGui.finishedAddingWalls.addActionListener(actionListener);
        CreateApartmentGui.oneMoreWall.addActionListener(actionListener);
    }

    public static void loadNewProjectGui() {
        initNewProject();

        addElementsToPanel(NewProjectElementsGui.buttonsSteps);
        addElementToPanel(NewProjectElementsGui.startSteps);
        addElementToPanel(NewProjectElementsGui.stepName);

        for (int i = 0; i < NewProjectElementsGui.buttonsSteps.length; i++) {
            NewProjectElementsGui.buttonsSteps[i].setVisible(true);
        }

        NewProjectElementsGui.startSteps.setVisible(true);
    }

    public static void startSteps() {
        NewProjectElementsGui.buttonsSteps[0].setBackground(NewProjectElementsGui.IN_WORK_STEP_COLOR);
        NewProjectElementsGui.buttonsSteps[0]
                .setBorder(BorderFactory.createLineBorder(NewProjectElementsGui.IN_WORK_STEP_COLOR_BORDER, 6));
        NewProjectElementsGui.stepButtonsRightBottom();
        userIsWorking = true;

        addElementToPanel(NewProjectElementsGui.continueSteps);

        NewProjectElementsGui.continueSteps.setVisible(true);
        NewProjectElementsGui.stepName.setVisible(true);
        NewProjectElementsGui.startSteps.setVisible(false);
        currentState = StepStates.CREATE_APARTMENT;
        selectCurrentStep();
    }

    public static void continueAfterUserIsWorking() {
        userIsWorking = false;
        NewProjectElementsGui.stepName.setVisible(false);
        NewProjectElementsGui.buttonsSteps[stepState].setBackground(NewProjectElementsGui.FINISHED_STEP_COLOR);
        NewProjectElementsGui.buttonsSteps[stepState]
                .setBorder(BorderFactory.createLineBorder(NewProjectElementsGui.FINISHED_STEP_COLOR_BORDER, 6));
        NewProjectElementsGui.stepButtonsCenter();

        if (stepState < 3) {
            NewProjectElementsGui.changeStateName();
        } else {
            NewProjectElementsGui.continueSteps.setEnabled(false);
            NewProjectElementsGui.continueSteps.setVisible(false);
            finishedStartSteps = true;
        }
    }

    public static void continueAfterUserIsNotWorking() {
        NewProjectElementsGui.stepName.setVisible(true);
        stepState += 1;
        userIsWorking = true;
        NewProjectElementsGui.buttonsSteps[stepState].setBackground(NewProjectElementsGui.IN_WORK_STEP_COLOR);
        NewProjectElementsGui.buttonsSteps[stepState]
                .setBorder(BorderFactory.createLineBorder(NewProjectElementsGui.IN_WORK_STEP_COLOR_BORDER, 6));
        NewProjectElementsGui.stepButtonsRightBottom();
    }

    public static void create_Apartment() {
        addElementsToPanel(CreateApartmentGui.chooseWalls);
        StartVisualizeGui.panel.invalidate();

        CreateApartmentGui.chooseWalls[0].setVisible(true);
        CreateApartmentGui.chooseWalls[1].setVisible(true);
        StartVisualizeGui.panel.invalidate();
    }
}