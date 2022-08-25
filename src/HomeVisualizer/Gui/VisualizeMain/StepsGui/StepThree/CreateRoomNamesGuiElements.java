package HomeVisualizer.Gui.VisualizeMain.StepsGui.StepThree;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateRoomNamesGuiElements {
    
    public static JPanel panel = new JPanel();
    protected static JLabel roomName = new JLabel("Room name");
    protected static JLabel wallName = new JLabel("Wall name");

    public static JLabel[] labels = { roomName, wallName };
    public static JButton addWall = new JButton("Add wall");  
    public static JButton finishRoom = new JButton("Add Room");  
    public static JButton finishedStep = new JButton("Finished");  
    public static JButton[] buttons = { addWall, finishRoom, finishedStep };
    public static JTextField getRoomName = new JTextField();
    public static JTextField getWallName = new JTextField();
    public static JTextField[] fields = { getRoomName, getWallName };
}