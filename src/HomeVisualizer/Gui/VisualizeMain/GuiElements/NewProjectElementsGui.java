package HomeVisualizer.Gui.VisualizeMain.GuiElements;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class NewProjectElementsGui {
    private static JButton firstStep = new JButton("STEP 1");
    private static JButton secondStep = new JButton("STEP 2");
    private static JButton thirdStep = new JButton("STEP 3");
    private static JButton fourthStep = new JButton("STEP 4");
    private static JButton[] steps = { firstStep, secondStep, thirdStep, fourthStep };

    private static JButton startSteps = new JButton("Start");
    private static JButton continueSteps = new JButton("Continue");

    private static final Color START_STEPS_COLOR = new Color(46, 134, 193);
    private static final Color START_STEPS_COLOR_BORDER = new Color(46, 134, 255);

    public static final Color UNFULFILLED_STEP_COLOR = new Color(238, 75, 43);
    public static final Color UNFULFILLED_STEP_COLOR_BORDER = new Color(255, 105, 43);
    public static final Color IN_WORK_STEP_COLOR = new Color(241, 196, 15);
    public static final Color IN_WORK_STEP_COLOR_BORDER = new Color(247, 220, 111);
    public static final Color FINISHED_STEP_COLOR = new Color(82, 190, 128);
    public static final Color FINISHED_STEP_COLOR_BORDER = new Color(125, 206, 160);

    public static JButton[] getStepButtons() {

        firstStep.setBounds(580, 400, 100, 100);
        secondStep.setBounds(730, 400, 100, 100);
        thirdStep.setBounds(880, 400, 100, 100);
        fourthStep.setBounds(1030, 400, 100, 100);

        for (int step = 0; step < steps.length; step++) {
            steps[step].setBackground(UNFULFILLED_STEP_COLOR);
            steps[step].setBorder(BorderFactory.createLineBorder(UNFULFILLED_STEP_COLOR_BORDER, 6));
            steps[step].setVisible(false);
            steps[step].setEnabled(false);
        }
        return steps;
    }

    public static JButton[] changeLocationStepsRightBottom(JButton[] inputSteps) {
        inputSteps[0].setBounds(1300, 850, 60, 60);
        inputSteps[1].setBounds(1400, 850, 60, 60);
        inputSteps[2].setBounds(1500, 850, 60, 60);
        inputSteps[3].setBounds(1600, 850, 60, 60);

        return inputSteps;
    }

    public static JButton getStartStep() {
        startSteps.setBackground(START_STEPS_COLOR);
        startSteps.setBounds(755, 600, 200, 60);
        startSteps.setBorder(BorderFactory.createLineBorder(START_STEPS_COLOR_BORDER, 6));
        startSteps.setVisible(false);
        return startSteps;
    }

    public static JButton getContinueStep() {
        continueSteps.setBackground(START_STEPS_COLOR);
        continueSteps.setBounds(755, 850, 200, 60);
        continueSteps.setBorder(BorderFactory.createLineBorder(START_STEPS_COLOR_BORDER, 6));
        continueSteps.setVisible(false);
        return continueSteps;
    }

}
