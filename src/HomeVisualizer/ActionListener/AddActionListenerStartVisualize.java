package HomeVisualizer.ActionListener;

import java.awt.event.ActionListener;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateRoomNamesGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateRoomsGui;

public class AddActionListenerStartVisualize implements AddActionListener {

    @Override
    public void add(ActionListener l) {
        StartVisualizeElementsGui.newProject.addActionListener(l);
        StartVisualizeElementsGui.threeDVisualizer.addActionListener(l);
        NewProjectElementsGui.startSteps.addActionListener(l);
        NewProjectElementsGui.continueSteps.addActionListener(l);
        CreateApartmentGui.chooseWalls[0].addActionListener(l);
        CreateApartmentGui.chooseWalls[1].addActionListener(l);
        CreateApartmentGui.finishedCreation.addActionListener(l);
        CreateApartmentGui.finishedAddingWalls.addActionListener(l);
        CreateApartmentGui.oneMoreWall.addActionListener(l);
        CreateRoomsGui.addWalls.addActionListener(l);
        CreateRoomsGui.finishedAddingWalls.addActionListener(l);
        CreateRoomNamesGui.finishedStep.addActionListener(l);
        CreateRoomNamesGui.addWall.addActionListener(l);
        CreateRoomNamesGui.finishRoom.addActionListener(l);        
    }   
}