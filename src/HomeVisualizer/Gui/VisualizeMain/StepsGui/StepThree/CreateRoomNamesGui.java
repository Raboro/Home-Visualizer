package HomeVisualizer.Gui.VisualizeMain.StepsGui.StepThree;

import javax.swing.BorderFactory;

import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.Colors;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepGui;
import HomeVisualizer.Logic.Logic;

public class CreateRoomNamesGui extends Frame implements StepGui{

    public CreateRoomNamesGui() {
        super("Room Names", Logic.STEP_THREE_WINDOW_SIZE, Logic.STEP_THREE_WINDOW_SIZE);
        this.add(CreateRoomNamesGuiElements.panel);
        CreateRoomNamesGuiElements.panel.setLayout(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocation(1030, 550);
        this.setVisible(true);
    }

    public static void initializeGuiElements() {
        initializeLabels();
        initializeButtons();
        initializeTextFields();
    }

    private static void initializeLabels() {
        CreateRoomNamesGuiElements.roomName.setBounds(200, 120, 100, 20);
        CreateRoomNamesGuiElements.wallName.setBounds(400, 120, 100, 20);
        Logic.editLabelsAndTextFieldsProperty(CreateRoomNamesGuiElements.labels);
    }
    
    private static void initializeButtons() {
        CreateRoomNamesGuiElements.finishRoom.setBounds(200, 200, 100, 50);
        CreateRoomNamesGuiElements.addWall.setBounds(400, 200, 85, 50);
        CreateRoomNamesGuiElements.finishedStep.setBounds(300, 400, 100, 50);
        editButtonsProperty();
    }

    private static void initializeTextFields() {
        CreateRoomNamesGuiElements.getRoomName.setBounds(200, 140, 95, 20);
        CreateRoomNamesGuiElements.getWallName.setBounds(400, 140, 85, 20);
        Logic.editLabelsAndTextFieldsProperty(CreateRoomNamesGuiElements.fields);
    } 

    private static void editButtonsProperty() {
        for (int button = 0; button < CreateRoomNamesGuiElements.buttons.length; button++) {
            CreateRoomNamesGuiElements.buttons[button].setBackground(Colors.CHOOSE_BUTTON_COLOR);
            CreateRoomNamesGuiElements.buttons[button]
                    .setBorder(BorderFactory.createLineBorder(Colors.CHOOSE_BUTTON_COLOR_BORDER, 6));
            CreateRoomNamesGuiElements.buttons[button].setVisible(false);
        }
    } 
}