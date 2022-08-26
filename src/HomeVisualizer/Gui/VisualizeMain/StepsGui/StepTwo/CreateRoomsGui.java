package HomeVisualizer.Gui.VisualizeMain.StepsGui.StepTwo;

import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepGui;
import HomeVisualizer.Logic.Logic;

public class CreateRoomsGui implements StepGui {

    public static void initializeGuiElements() {
        initializeLabels();
        initializeButtons();
        initializeTextFields();
    }
    
    private static void initializeLabels() {
        CreateRoomsGuiElements.StartXPos.setBounds(537, 300, 100, 20);
        CreateRoomsGuiElements.StartYPos.setBounds(737, 300, 100, 20);
        CreateRoomsGuiElements.EndXPos.setBounds(937, 300, 100, 20);
        CreateRoomsGuiElements.EndYPos.setBounds(1137, 300, 70, 20);
        Logic.editLabelsAndTextFieldsProperty(CreateRoomsGuiElements.positions);
    }

    private static void initializeButtons() {
        CreateRoomsGuiElements.addWalls.setBounds(740, 600, 100, 100);
        CreateRoomsGuiElements.finishedAddingWalls.setBounds(890, 600, 100, 100);
        Logic.editButtonsProperty(CreateRoomsGuiElements.actionButtons);
    }

    private static void initializeTextFields() {
        CreateRoomsGuiElements.getStartXPos.setBounds(537, 320, 100, 20);
        CreateRoomsGuiElements.getStartYPos.setBounds(737, 320, 100, 20);
        CreateRoomsGuiElements.getEndXPos.setBounds(937, 320, 100, 20);
        CreateRoomsGuiElements.getEndYPos.setBounds(1137, 320, 70, 20);
        Logic.editLabelsAndTextFieldsProperty(CreateRoomsGuiElements.getPositions);
    }
}