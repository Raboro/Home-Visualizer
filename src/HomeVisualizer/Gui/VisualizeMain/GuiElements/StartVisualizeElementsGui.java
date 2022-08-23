package HomeVisualizer.Gui.VisualizeMain.GuiElements;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StartVisualizeElementsGui {

    public static JMenuBar menuBar;
    public static JMenu menuProjects, submenuOpenProjects, tutorial, help, submenuControl;
    public static JMenuItem newProject, openProject, renameProject, deleteProject, threeDVisualizer;

    public static void initMenu() {
        initMenuElements();
        addMenuElementsToMenu();
    }

    private static void initMenuElements() {
        menuBar = new JMenuBar();
        menuBar.setVisible(false);

        menuProjects = new JMenu("Projects");
        submenuOpenProjects = new JMenu("Open");
        tutorial = new JMenu("Tutorial");
        help = new JMenu("Help");
        submenuControl = new JMenu("Control");

        newProject = new JMenuItem("New");
        openProject = new JMenuItem("Open Project");
        renameProject = new JMenuItem("Rename Project");
        deleteProject = new JMenuItem("Delete Project");
        threeDVisualizer = new JMenuItem("3D Visualizer");
    }

    private static void addMenuElementsToMenu() {
        submenuOpenProjects.add(openProject);
        submenuOpenProjects.add(renameProject);
        submenuOpenProjects.add(deleteProject);

        menuProjects.add(newProject);
        menuProjects.add(submenuOpenProjects);

        submenuControl.add(threeDVisualizer);

        help.add(submenuControl);

        menuBar.add(menuProjects);
        menuBar.add(tutorial);
        menuBar.add(help);
    }
}