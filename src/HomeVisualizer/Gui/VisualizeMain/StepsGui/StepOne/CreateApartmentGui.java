package HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.Colors;

import java.awt.Font;

public class CreateApartmentGui {

    public static void initChooseWallsButtons() {
        CreateApartmentGuiElements.fourWalls.setBounds(730, 400, 100, 100);
        CreateApartmentGuiElements.undefinedWalls.setBounds(880, 400, 100, 100);
        editButtonProperty(CreateApartmentGuiElements.chooseWalls);
    }

    public static void initFinishedCreation() {
        CreateApartmentGuiElements.finishedCreation.setBounds(790, 500, 150, 60);
        CreateApartmentGuiElements.finishedAddingWalls.setBounds(900, 500, 150, 60);
        CreateApartmentGuiElements.oneMoreWall.setBounds(670, 500, 200, 60);
        editButtonProperty(CreateApartmentGuiElements.actionButtons);
    }

    private static void editButtonProperty(JButton[] elements) {
        for (JButton element : elements) {
            element.setBackground(Colors.CHOOSE_BUTTON_COLOR);
            element.setBorder(BorderFactory.createLineBorder(Colors.CHOOSE_BUTTON_COLOR_BORDER, 6));
            element.setVisible(false);
        }
    }

    public static void initLabels() {
        CreateApartmentGuiElements.length.setBounds(637, 400, 70, 20);
        CreateApartmentGuiElements.height.setBounds(837, 400, 70, 20);
        CreateApartmentGuiElements.width.setBounds(1037, 400, 70, 20);

        CreateApartmentGuiElements.xPos.setBounds(737, 300, 70, 20);
        CreateApartmentGuiElements.yPos.setBounds(937, 300, 70, 20);

        editLabelsAndTexFieldsProperty(CreateApartmentGuiElements.apartmentParameter);
        editLabelsAndTexFieldsProperty(CreateApartmentGuiElements.undefinedApartmentParameter);
    }

    public static void initTextFields() {
        CreateApartmentGuiElements.getLength.setBounds(637, 420, 60, 28);
        CreateApartmentGuiElements.getHeight.setBounds(837, 420, 55, 28);
        CreateApartmentGuiElements.getWidth.setBounds(1037, 420, 50, 28);

        CreateApartmentGuiElements.getXPos.setBounds(737, 320, 60, 28);
        CreateApartmentGuiElements.getYPos.setBounds(937, 320, 55, 28);

        editLabelsAndTexFieldsProperty(CreateApartmentGuiElements.getApartmentParameter);
        editLabelsAndTexFieldsProperty(CreateApartmentGuiElements.getUndefinedApartmentParameter);
    }

    private static <T> void editLabelsAndTexFieldsProperty(T[] elements) {
        for (T element : elements) {
            ((JComponent) element).setVisible(false);
            ((JComponent) element).setFont(new Font("Arial", Font.BOLD, 15));
        }
    }
}