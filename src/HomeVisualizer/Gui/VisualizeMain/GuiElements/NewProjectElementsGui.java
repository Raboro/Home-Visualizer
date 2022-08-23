package HomeVisualizer.Gui.VisualizeMain.GuiElements;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewProjectElementsGui {
    
    public static JButton firstStep = new JButton("STEP 1");
    public static JButton secondStep = new JButton("STEP 2");
    public static JButton thirdStep = new JButton("STEP 3");
    public static JButton fourthStep = new JButton("STEP 4");
    public static JButton[] buttonsSteps = { firstStep, secondStep, thirdStep, fourthStep };

    public static JButton startSteps = new JButton("Start");
    public static JButton continueSteps = new JButton("Continue");
    public static JLabel stepName = new JLabel("");
    public static JDialog creatingProjectNotFinished = new JDialog();

    public static void initStepButtons() {
        stepButtonsCenter();

        for (int step = 0; step < buttonsSteps.length; step++) {
            buttonsSteps[step].setBackground(Colors.UNFULFILLED_STEP_COLOR);
            buttonsSteps[step].setBorder(BorderFactory.createLineBorder(Colors.UNFULFILLED_STEP_COLOR_BORDER, 6));
            buttonsSteps[step].setVisible(false);
            buttonsSteps[step].setEnabled(false);
        }
    }

    public static void stepButtonsRightBottom() {
        firstStep.setBounds(1300, 850, 60, 60);
        secondStep.setBounds(1400, 850, 60, 60);
        thirdStep.setBounds(1500, 850, 60, 60);
        fourthStep.setBounds(1600, 850, 60, 60);
    }

    public static void stepButtonsCenter() {
        firstStep.setBounds(580, 400, 100, 100);
        secondStep.setBounds(730, 400, 100, 100);
        thirdStep.setBounds(880, 400, 100, 100);
        fourthStep.setBounds(1030, 400, 100, 100);
    }

    public static void initStartStep() {
        startSteps.setBackground(Colors.START_STEPS_COLOR);
        startSteps.setBounds(755, 600, 200, 60);
        startSteps.setBorder(BorderFactory.createLineBorder(Colors.START_STEPS_COLOR_BORDER, 6));
        startSteps.setVisible(false);
    }

    public static void initContinueStep() {
        continueSteps.setBackground(Colors.START_STEPS_COLOR);
        continueSteps.setBounds(765, 850, 200, 60);
        continueSteps.setBorder(BorderFactory.createLineBorder(Colors.START_STEPS_COLOR_BORDER, 6));
        continueSteps.setVisible(false);
    }

    public static void initStateName() {
        stepName.setText("Create Apartment");
        stepName.setBounds(720, 30, 300, 50);
        stepName.setVisible(false);
        stepName.setFont(new Font("Arial", Font.BOLD, 30));
    }

    public static void changeStateName() {
        switch (stepName.getText()) {
            case "Create Apartment":
                stepName.setText("Create Rooms");
                stepName.setBounds(745, 30, 300, 50);
                break;

            case "Create Rooms":
                stepName.setText("Create Room Names");
                stepName.setBounds(700, 30, 400, 50);
                break;

            case "Create Room Names":
                stepName.setText("Create Doors");
                stepName.setBounds(755, 30, 300, 50);
                break;
        }
    }

    public static void showPopUpCreatingProjectNotFinished() {
        creatingProjectNotFinished.setSize(420, 100);
        creatingProjectNotFinished.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        creatingProjectNotFinished
                .add(new JLabel("Can`t open other or new project until you finished the creating phase"));

        creatingProjectNotFinished.setVisible(true);
    }
}