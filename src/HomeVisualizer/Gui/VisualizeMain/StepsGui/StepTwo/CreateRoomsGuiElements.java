package HomeVisualizer.Gui.VisualizeMain.StepsGui.StepTwo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateRoomsGuiElements {
    
    protected static JLabel StartXPos = new JLabel("Start X Pos");
    protected static JLabel StartYPos = new JLabel("Start Y Pos");
    protected static JLabel EndXPos = new JLabel("End X Pos");
    protected static JLabel EndYPos = new JLabel("End Y Pos");
    public static JLabel[] positions = { StartXPos, StartYPos, EndXPos, EndYPos };

    public static JTextField getStartXPos = new JTextField();
    public static JTextField getStartYPos = new JTextField();
    public static JTextField getEndXPos = new JTextField();
    public static JTextField getEndYPos = new JTextField();
    public static JTextField[] getPositions = { getStartXPos, getStartYPos, getEndXPos, getEndYPos };

    public static JButton addWalls = new JButton("Add wall");
    public static JButton finishedAddingWalls = new JButton("Create");

    public static JButton[] actionButtons = { addWalls, finishedAddingWalls };
}
