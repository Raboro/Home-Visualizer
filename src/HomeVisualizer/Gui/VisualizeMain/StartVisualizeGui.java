package HomeVisualizer.Gui.VisualizeMain;

import javax.swing.JPanel;

import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StartVisualizeElementsGui;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.CreateApartmentGui;
import HomeVisualizer.Logic.StartVisualizeLogic;
import HomeVisualizer.VisualizeRenderer.Display;

public class StartVisualizeGui extends Frame {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1700;

    public static JPanel panel;

    public StartVisualizeGui(String user) {
        super(user, WIDTH, HEIGHT);

        panel = new JPanel();
        panel.setLayout(null);

        this.add(panel);
        createLayout();

        StartVisualizeLogic.initNewProject();
        StartVisualizeLogic.addActionListenerToElements();

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
        panel.invalidate();
    }

    public static void startSteps() {
        StartVisualizeLogic.startSteps();
        panel.invalidate();
    }

    public static void createDisplay() {
        double length = Integer.parseInt(CreateApartmentGui.getApartmentParameter[0].getText());
        double height = Integer.parseInt(CreateApartmentGui.getApartmentParameter[1].getText());
        double width = Integer.parseInt(CreateApartmentGui.getApartmentParameter[2].getText());

        Display display = new Display(length, height, width);
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);

        display.start();
    }
}