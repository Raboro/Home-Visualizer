package HomeVisualizer.Gui.VisualizeMain.StepsGui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;


import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.Colors;
import HomeVisualizer.Logic.Logic;

public class CreateRoomNamesGui extends Frame{

    public static JPanel panel = new JPanel();
    public static JLabel roomName = new JLabel("Room name");
    public static JLabel wallName = new JLabel("Wall name");

    public static JLabel[] labels = { roomName, wallName };
    public static JButton addWall = new JButton("Add wall");  
    public static JButton finishRoom = new JButton("Add Room");  
    public static JButton finishedStep = new JButton("Finished");  
    public static JButton[] buttons = { addWall, finishRoom, finishedStep };
    public static JTextField getRoomName = new JTextField();
    public static JTextField getWallName = new JTextField();
    public static JTextField[] fields = { getRoomName, getWallName };

    public CreateRoomNamesGui() {
        super("Room Names", Logic.STEP_THREE_WINDOW_SIZE, Logic.STEP_THREE_WINDOW_SIZE);
        this.add(panel);
        panel.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(1030, 550);
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
        finishRoom.setBounds(200, 200, 100, 50);
        addWall.setBounds(400, 200, 85, 50);
        finishedStep.setBounds(300, 400, 100, 50);
        editButtonsProperty();
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

    private static void editButtonsProperty() {
        for (int button = 0; button < buttons.length; button++) {
            buttons[button].setBackground(Colors.CHOOSE_BUTTON_COLOR);
            buttons[button]
                    .setBorder(BorderFactory.createLineBorder(Colors.CHOOSE_BUTTON_COLOR_BORDER, 6));
            buttons[button].setVisible(false);
        }
    } 
}
