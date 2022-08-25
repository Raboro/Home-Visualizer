package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateRoomNamesGui;
import HomeVisualizer.Logic.Logic;

public class CreateRoomNamesLogicGui {

    public static List<RoomNames> roomNames = new ArrayList<>();

    private static CreateRoomNamesGui gui;
    private static List<Integer> wallNames = new ArrayList<>();
    
    public static void init() {
        addElementsToPanel(CreateRoomNamesGui.labels);
        addElementsToPanel(CreateRoomNamesGui.fields);
        addElementsToPanel(CreateRoomNamesGui.buttons);
        setElementsVisibility(true);
        NewProjectElementsGui.continueSteps.setEnabled(false);
        gui = new CreateRoomNamesGui();
    }

    public static <T> void addElementsToPanel(T[] elements) {
        for (T element : elements) {
            CreateRoomNamesGui.panel.add((Component) element);
        }
    }

    public static <T> void setElementsVisibility(boolean visibility) {
        Logic.setElementsVisibility(CreateRoomNamesGui.labels, visibility);
        Logic.setElementsVisibility(CreateRoomNamesGui.fields, visibility);
        Logic.setElementsVisibility(CreateRoomNamesGui.buttons, visibility);
    }

    public static void addWallName() {
        if (isUserGiveRightInput()) {
            int name = Integer.parseInt(CreateRoomNamesGui.getWallName.getText()) - 1;
            wallNames.add(name);
        }
    }

    private static boolean isUserGiveRightInput() {
        try {
            int name = Integer.parseInt(CreateRoomNamesGui.getWallName.getText());
            if (CreateRoomNamesLogicGraphics.graphics.getWallNames().contains(name)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void finishedRoom() {
        if (wallNames.size() > 2 && CreateRoomNamesGui.getRoomName.getText().length() > 1) {
            roomNames.add(new RoomNames(CreateRoomNamesGui.getRoomName.getText(), wallNames));
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