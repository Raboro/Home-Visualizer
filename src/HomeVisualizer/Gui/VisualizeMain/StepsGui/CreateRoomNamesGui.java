package HomeVisualizer.Gui.VisualizeMain.StepsGui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;


import HomeVisualizer.Gui.Frame;

public class CreateRoomNamesGui extends Frame{

    public static final int HEIGHT = 500;
    public static final int WIDTH = 700;
    public static final String TITLE = "Room Names";

    public static JPanel panel = new JPanel();
    public static JLabel roomName = new JLabel("Room name");
    public static JLabel wallName = new JLabel("Wall name");

    public static JLabel[] labels = { roomName, wallName };
    public static JButton newRoom = new JButton("New Room");    
    public static JButton addWall = new JButton("Add wall");  
    public static JButton finishRoom = new JButton("Add Room");  
    public static JButton finishedStep = new JButton("Finished");  
    public static JButton[] buttons = { newRoom, addWall, finishRoom, finishedStep };
    public static JTextField getRoomName = new JTextField();
    public static JTextField getWallName = new JTextField();
    public static JTextField[] fields = { getRoomName, getWallName };

    public CreateRoomNamesGui() {
        super(TITLE, WIDTH, HEIGHT);
        this.add(panel);
        panel.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(930, 650);
        this.setVisible(true);
    }

    public static void initializeGuiElements() {
        initializeLabels();
        initializeButtons();
        initializeTextFields();
    }

    private static void initializeLabels() {
        roomName.setBounds(200, 120, 100, 20);
        wallName.setBounds(400, 120, 100, 20);
        editGuiLabelsAndFieldsProperty(labels);
    }
    
    private static void initializeButtons() {
    }

    private static void initializeTextFields() {
        getRoomName.setBounds(200, 140, 95, 20);
        getWallName.setBounds(400, 140, 85, 20);
        editGuiLabelsAndFieldsProperty(fields);
    }

    private static <T> void editGuiLabelsAndFieldsProperty(T[] elements) {
        for (T element : elements) {
            ((JComponent) element).setVisible(false);
            ((JComponent) element).setFont(new Font("Arial", Font.BOLD, 15));
        }
    }   
}
