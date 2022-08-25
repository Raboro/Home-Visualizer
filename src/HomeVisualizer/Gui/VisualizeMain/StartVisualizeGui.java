package HomeVisualizer.Gui.VisualizeMain;

import javax.swing.JPanel;

import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Logic.Logic;
import HomeVisualizer.Logic.StartVisualizeLogic;
import HomeVisualizer.Logic.StartVisualizerStepsLogic.CreateApartmentLogic;

import HomeVisualizer.VisualizeRenderer.Display;

public class StartVisualizeGui extends Frame {
    
    public static JPanel panel;

    public StartVisualizeGui(String user) {
        super(user, Logic.MAIN_WINDOW_SIZE[0], Logic.MAIN_WINDOW_SIZE[1]);

        panel = new JPanel();
        panel.setLayout(null);

        this.add(panel);
        createLayout();

        StartVisualizeElementsGui.menuBar.setVisible(true);
        this.setLocation(110, 300);
        this.setVisible(true);
    }

    private void createLayout() {
        StartVisualizeElementsGui.initMenu();
        this.setJMenuBar(StartVisualizeElementsGui.menuBar);
    }

    public static void loadNewProjectGui() {
        StartVisualizeLogic.loadNewProjectGui();
    }

    public static void startSteps() {
        StartVisualizeLogic.startSteps();
    }

    public static void createDisplay() {
        Display display;
        
        if (CreateApartmentLogic.isFourWalls) {
        double length = Integer.parseInt(CreateApartmentGui.getApartmentParameter[0].getText()) * 2;
        double height = Integer.parseInt(CreateApartmentGui.getApartmentParameter[1].getText()) * 2;
        double width = Integer.parseInt(CreateApartmentGui.getApartmentParameter[2].getText()) * 2;


        display = new Display(length, height, width);
        } else {
            display = new Display(0, 0, 0);
        }
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);

        display.start();
    }
}