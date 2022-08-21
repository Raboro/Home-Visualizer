package HomeVisualizer.Gui.VisualizeMain.StepsGui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateRoomsGui {

    public static JLabel StartXPos = new JLabel("Start X Pos");
    public static JLabel StartYPos = new JLabel("Start Y Pos");
    public static JLabel EndXPos = new JLabel("End X Pos");
    public static JLabel EndYPos = new JLabel("End Y Pos");
    public static JLabel[] positions = { StartXPos, StartYPos, EndXPos, EndYPos };

    public static JTextField getStartXPos = new JTextField();
    public static JTextField getStartYPos = new JTextField();
    public static JTextField getEndXPos = new JTextField();
    public static JTextField getEndYPos = new JTextField();
    public static JTextField[] getPositions = { getStartXPos, getStartYPos, getEndXPos, getEndYPos };

    public static JButton addWalls = new JButton("Add wall");
    public static JButton finishedAddingWalls = new JButton("Create");

    public static JButton[] actionButtons = { addWalls, finishedAddingWalls };

    public static void initButtons() {
        addWalls.setBounds(740, 600, 100, 100);
        finishedAddingWalls.setBounds(890, 600, 100, 100);

        for (int button = 0; button < actionButtons.length; button++) {
            actionButtons[button].setBackground(CreateApartmentGui.CHOOSE_BUTTON_COLOR);
            actionButtons[button]
                    .setBorder(BorderFactory.createLineBorder(CreateApartmentGui.CHOOSE_BUTTON_COLOR_BORDER, 6));
            actionButtons[button].setVisible(false);
        }
    }

    public static void initLabels() {
        StartXPos.setBounds(537, 300, 100, 20);
        StartYPos.setBounds(737, 300, 100, 20);
        EndXPos.setBounds(937, 300, 100, 20);
        EndYPos.setBounds(1137, 300, 70, 20);

        for (int parameter = 0; parameter < positions.length; parameter++) {
            positions[parameter].setVisible(false);
            positions[parameter].setFont(new Font("Arial", Font.BOLD, 15));
        }
    }

    public static void initTextFields() {
        getStartXPos.setBounds(537, 320, 100, 20);
        getStartYPos.setBounds(737, 320, 100, 20);
        getEndXPos.setBounds(937, 320, 100, 20);
        getEndYPos.setBounds(1137, 320, 70, 20);

        for (int parameter = 0; parameter < getPositions.length; parameter++) {
            getPositions[parameter].setVisible(false);
            getPositions[parameter].setFont(new Font("Arial", Font.BOLD, 15));
        }
    }
}