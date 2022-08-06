package HomeVisualizer.Gui.VisualizeMain.StepsGui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

public class CreateApartmentGui {

    public static JButton fourWalls = new JButton("4 Walls");
    public static JButton undefinedWalls = new JButton(">4/<4 Walls");
    public static JButton[] chooseWalls = { fourWalls, undefinedWalls };

    public static JLabel length = new JLabel("Length");
    public static JLabel height = new JLabel("Height");
    public static JLabel width = new JLabel("Width");
    public static JLabel[] apartmentParameter = { length, height, width };

    public static JTextField getLength = new JTextField("all");
    public static JTextField getHeight = new JTextField("in");
    public static JTextField getWidth = new JTextField("cm");
    public static JTextField[] getApartmentParameter = { getLength, getHeight, getWidth };

    public static JButton finishedCreation = new JButton("Create");

    public static final Color CHOOSE_BUTTON_COLOR = new Color(46, 134, 193);
    public static final Color CHOOSE_BUTTON_COLOR_BORDER = new Color(46, 134, 255);

    public static JLabel xPos = new JLabel("X Pos");
    public static JLabel yPos = new JLabel("Y Pos");
    public static JLabel[] undefinedApartmentParameter = { xPos, yPos };

    public static JTextField getXPos = new JTextField();
    public static JTextField getYPos = new JTextField();
    public static JTextField[] getUndefinedApartmentParameter = { getXPos, getYPos };

    public static JButton oneMoreWall = new JButton("Add first wall");
    public static JButton finishedAddingWalls = new JButton("Create");

    public static JButton[] actionButtons = { finishedCreation, oneMoreWall, finishedAddingWalls };

    public static void initChooseWallsButtons() {
        fourWalls.setBounds(730, 400, 100, 100);
        undefinedWalls.setBounds(880, 400, 100, 100);

        for (int button = 0; button < chooseWalls.length; button++) {
            chooseWalls[button].setBackground(CHOOSE_BUTTON_COLOR);
            chooseWalls[button].setBorder(BorderFactory.createLineBorder(CHOOSE_BUTTON_COLOR_BORDER, 6));
            chooseWalls[button].setVisible(false);
        }
    }

    public static void initFinishedCreation() {
        finishedCreation.setBounds(790, 500, 150, 60);
        finishedAddingWalls.setBounds(900, 500, 150, 60);
        oneMoreWall.setBounds(670, 500, 200, 60);

        for (int i = 0; i < actionButtons.length; i++) {
            actionButtons[i].setBackground(CHOOSE_BUTTON_COLOR);
            actionButtons[i].setBorder(BorderFactory.createLineBorder(CHOOSE_BUTTON_COLOR_BORDER, 6));
            actionButtons[i].setVisible(false);
        }
    }

    public static void initLabels() {
        length.setBounds(637, 400, 70, 20);
        height.setBounds(837, 400, 70, 20);
        width.setBounds(1037, 400, 70, 20);

        xPos.setBounds(737, 300, 70, 20);
        yPos.setBounds(937, 300, 70, 20);

        for (int parameter = 0; parameter < apartmentParameter.length; parameter++) {
            apartmentParameter[parameter].setVisible(false);
            apartmentParameter[parameter].setFont(new Font("Arial", Font.BOLD, 15));

            if (parameter > 1) {continue;}

            undefinedApartmentParameter[parameter].setVisible(false);
            undefinedApartmentParameter[parameter].setFont(new Font("Arial", Font.BOLD, 15));
        }
    }

    public static void initTextFields() {
        getLength.setBounds(637, 420, 60, 28);
        getHeight.setBounds(837, 420, 55, 28);
        getWidth.setBounds(1037, 420, 50, 28);

        getXPos.setBounds(737, 320, 60, 28);
        getYPos.setBounds(937, 320, 55, 28);

        for (int parameter = 0; parameter < apartmentParameter.length; parameter++) {
            getApartmentParameter[parameter].setVisible(false);

            if (parameter > 1) {continue;}

            getUndefinedApartmentParameter[parameter].setVisible(false);
        }
    }
}