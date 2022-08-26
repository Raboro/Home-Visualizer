package HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.Colors;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepGui;
import HomeVisualizer.Logic.Logic;

public class CreateApartmentGui implements StepGui {

    public static void initializeGuiElements() {
        initializeLabels();
        initializeButtons();
        initializeTextFields();
    }

    public static void initializeLabels() {
        CreateApartmentGuiElements.length.setBounds(637, 400, 70, 20);
        CreateApartmentGuiElements.height.setBounds(837, 400, 70, 20);
        CreateApartmentGuiElements.width.setBounds(1037, 400, 70, 20);

        CreateApartmentGuiElements.xPos.setBounds(737, 300, 70, 20);
        CreateApartmentGuiElements.yPos.setBounds(937, 300, 70, 20);

        Logic.editLabelsAndTextFieldsProperty(CreateApartmentGuiElements.apartmentParameter);
        Logic.editLabelsAndTextFieldsProperty(CreateApartmentGuiElements.undefinedApartmentParameter);
    }

    public static void initializeButtons() {
        CreateApartmentGuiElements.fourWalls.setBounds(730, 400, 100, 100);
        CreateApartmentGuiElements.undefinedWalls.setBounds(880, 400, 100, 100);
        CreateApartmentGuiElements.finishedCreation.setBounds(790, 500, 150, 60);
        CreateApartmentGuiElements.finishedAddingWalls.setBounds(900, 500, 150, 60);
        CreateApartmentGuiElements.oneMoreWall.setBounds(670, 500, 200, 60);
        
        editButtonProperty(CreateApartmentGuiElements.actionButtons);
        editButtonProperty(CreateApartmentGuiElements.chooseWalls);
    }

    public static void initializeTextFields() {
        CreateApartmentGuiElements.getLength.setBounds(637, 420, 60, 28);
        CreateApartmentGuiElements.getHeight.setBounds(837, 420, 55, 28);
        CreateApartmentGuiElements.getWidth.setBounds(1037, 420, 50, 28);

        CreateApartmentGuiElements.getXPos.setBounds(737, 320, 60, 28);
        CreateApartmentGuiElements.getYPos.setBounds(937, 320, 55, 28);

        Logic.editLabelsAndTextFieldsProperty(CreateApartmentGuiElements.getApartmentParameter);
        Logic.editLabelsAndTextFieldsProperty(CreateApartmentGuiElements.getUndefinedApartmentParameter);
    }

    private static void editButtonProperty(JButton[] elements) {
        for (JButton element : elements) {
            element.setBackground(Colors.CHOOSE_BUTTON_COLOR);
            element.setBorder(BorderFactory.createLineBorder(Colors.CHOOSE_BUTTON_COLOR_BORDER, 6));
            element.setVisible(false);
        }
    }   
}