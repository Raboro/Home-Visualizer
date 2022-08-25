package HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateApartmentGuiElements {
    protected static JButton fourWalls = new JButton("4 Walls");
    protected static JButton undefinedWalls = new JButton(">4/<4 Walls");
    public static JButton[] chooseWalls = { fourWalls, undefinedWalls };

    protected static JLabel length = new JLabel("Length");
    public static JLabel height = new JLabel("Height");
    protected static JLabel width = new JLabel("Width");
    public static JLabel[] apartmentParameter = { length, height, width };

    protected static JTextField getLength = new JTextField("all");
    public static JTextField getHeight = new JTextField("in");
    protected static JTextField getWidth = new JTextField("cm");
    public static JTextField[] getApartmentParameter = { getLength, getHeight, getWidth };

    public static JButton finishedCreation = new JButton("Create");

    public static JLabel xPos = new JLabel("X Pos");
    public static JLabel yPos = new JLabel("Y Pos");
    public static JLabel[] undefinedApartmentParameter = { xPos, yPos };

    public static JTextField getXPos = new JTextField();
    public static JTextField getYPos = new JTextField();
    public static JTextField[] getUndefinedApartmentParameter = { getXPos, getYPos };

    public static JButton oneMoreWall = new JButton("Add first wall");
    public static JButton finishedAddingWalls = new JButton("Create");

    public static JButton[] actionButtons = { finishedCreation, oneMoreWall, finishedAddingWalls };
}