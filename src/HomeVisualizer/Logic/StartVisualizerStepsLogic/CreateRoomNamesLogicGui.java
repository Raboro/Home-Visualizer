package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepThree.CreateRoomNamesGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepThree.CreateRoomNamesGuiElements;
import HomeVisualizer.Logic.Logic;

public class CreateRoomNamesLogicGui {

    public static List<RoomNames> roomNames = new ArrayList<>();

    private static CreateRoomNamesGui gui;
    private static final List<Integer> wallNames = new ArrayList<>();
    
    public static void init() {
        Logic.addElementsToPanel(CreateRoomNamesGuiElements.labels, CreateRoomNamesGuiElements.panel);
        Logic.addElementsToPanel(CreateRoomNamesGuiElements.fields, CreateRoomNamesGuiElements.panel);
        Logic.addElementsToPanel(CreateRoomNamesGuiElements.buttons, CreateRoomNamesGuiElements.panel);
        setElementsVisibility(true);
        NewProjectElementsGui.continueSteps.setEnabled(false);
        gui = new CreateRoomNamesGui();
    }

    public static <T> void setElementsVisibility(boolean visibility) {
        Logic.setElementsVisibility(CreateRoomNamesGuiElements.labels, visibility);
        Logic.setElementsVisibility(CreateRoomNamesGuiElements.fields, visibility);
        Logic.setElementsVisibility(CreateRoomNamesGuiElements.buttons, visibility);
    }

    public static void addWallName() {
        if (isUserGiveRightInput()) {
            int name = Integer.parseInt(CreateRoomNamesGuiElements.getWallName.getText()) - 1;
            wallNames.add(name);
        }
    }

    private static boolean isUserGiveRightInput() {
        try {
            int name = Integer.parseInt(CreateRoomNamesGuiElements.getWallName.getText());
            if (CreateRoomNamesLogicGraphics.graphics.getWallNames().contains(name)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void finishedRoom() {
        if (wallNames.size() > 2 && CreateRoomNamesGuiElements.getRoomName.getText().length() > 1) {
            roomNames.add(new RoomNames(CreateRoomNamesGuiElements.getRoomName.getText(), wallNames));
            wallNames.clear();
        }
    }

    public static void finishedStep() {
        if (roomNames.size() >= 1) {
            setElementsVisibility(false);
            NewProjectElementsGui.continueSteps.setEnabled(true);
            gui.dispose();
            CreateRoomNamesLogicGraphics.graphics.setVisible(false);
        }
    }
}