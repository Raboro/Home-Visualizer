package HomeVisualizer.Gui.VisualizeMain.StatesGui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

public class CreateApartmentGui {

    private static JButton fourWalls = new JButton("4 Walls");
    private static JButton moreThenFourWalls = new JButton(">4 Walls");
    private static JButton[] chooseWalls = { fourWalls, moreThenFourWalls };

    private static JLabel length = new JLabel("Length");
    private static JLabel height = new JLabel("Height");
    private static JLabel width = new JLabel("Width");
    private static JLabel[] apartmentParameter = { length, height, width };

    private static JTextField getLength = new JTextField("all");
    private static JTextField getHeight = new JTextField("in");
    private static JTextField getWidth = new JTextField("meter");
    private static JTextField[] getApartmentParameter = { getLength, getHeight, getWidth };

    private static JButton finishedCreation = new JButton("Create");

    private static final Color CHOOSE_BUTTON_COLOR = new Color(46, 134, 193);
    private static final Color CHOOSE_BUTTON_COLOR_BORDER = new Color(46, 134, 255);

    public static JButton[] getChooseWallsButtons() {
        fourWalls.setBounds(730, 400, 100, 100);
        moreThenFourWalls.setBounds(880, 400, 100, 100);

        for (int button = 0; button < chooseWalls.length; button++) {
            chooseWalls[button].setBackground(CHOOSE_BUTTON_COLOR);
            chooseWalls[button].setBorder(BorderFactory.createLineBorder(CHOOSE_BUTTON_COLOR_BORDER, 6));
            chooseWalls[button].setVisible(false);
        }
        return chooseWalls;
    }

    public static JButton getFinishedCreation() {
        finishedCreation.setBounds(790, 500, 150, 60);
        finishedCreation.setBackground(CHOOSE_BUTTON_COLOR);
        finishedCreation.setBorder(BorderFactory.createLineBorder(CHOOSE_BUTTON_COLOR_BORDER, 6));
        finishedCreation.setVisible(false);
        return finishedCreation;
    }

    public static JLabel[] getLabels() {
        length.setBounds(637, 400, 70, 20);
        height.setBounds(837, 400, 70, 20);
        width.setBounds(1037, 400, 70, 20);

        for (int parameter = 0; parameter < apartmentParameter.length; parameter++) {
            apartmentParameter[parameter].setVisible(false);
            apartmentParameter[parameter].setFont(new Font("Arial", Font.BOLD, 15));
        }

        return apartmentParameter;
    }

    public static JTextField[] getTextFields() {
        getLength.setBounds(637, 420, 60, 28);
        getHeight.setBounds(837, 420, 55, 28);
        getWidth.setBounds(1037, 420, 50, 28);

        for (int parameter = 0; parameter < apartmentParameter.length; parameter++) {
            getApartmentParameter[parameter].setVisible(false);
        }

        return getApartmentParameter;
    }

}
