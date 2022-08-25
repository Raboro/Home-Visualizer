package HomeVisualizer.ActionListener;

import java.awt.event.ActionListener;

import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepOne.CreateApartmentGuiElements;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepThree.CreateRoomNamesGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepTwo.CreateRoomsGui;

public class AddActionListenerStartVisualize implements AddActionListener {

    @Override
    public void add(ActionListener l) {
        StartVisualizeElementsGui.newProject.addActionListener(l);
        StartVisualizeElementsGui.threeDVisualizer.addActionListener(l);
        NewProjectElementsGui.startSteps.addActionListener(l);
        NewProjectElementsGui.continueSteps.addActionListener(l);
        CreateApartmentGuiElements.chooseWalls[0].addActionListener(l);
        CreateApartmentGuiElements.chooseWalls[1].addActionListener(l);
        CreateApartmentGuiElements.finishedCreation.addActionListener(l);
        CreateApartmentGuiElements.finishedAddingWalls.addActionListener(l);
        CreateApartmentGuiElements.oneMoreWall.addActionListener(l);
        CreateRoomsGui.addWalls.addActionListener(l);
        CreateRoomsGui.finishedAddingWalls.addActionListener(l);
        CreateRoomNamesGui.finishedStep.addActionListener(l);
        CreateRoomNamesGui.addWall.addActionListener(l);
        CreateRoomNamesGui.finishRoom.addActionListener(l);        
    }   
}