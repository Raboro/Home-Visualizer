package HomeVisualizer.Gui.VisualizeMain.GuiElements;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StartVisualizeElementsGui {

    public static JMenuBar menuBar;
    public static JMenu menuProjects, submenuOpenProjects;
    public static JMenuItem newProject, openProject, renameProject, deleteProject;

    private static void initMenuElements() {
        menuBar = new JMenuBar();
        menuBar.setVisible(false);

        menuProjects = new JMenu("Projects");
        submenuOpenProjects = new JMenu("Open");

        newProject = new JMenuItem("New");
        openProject = new JMenuItem("Open Project");
        renameProject = new JMenuItem("Rename Project");
        deleteProject = new JMenuItem("Delete Project");
    }

    private static void addMenuElementsToMenu() {
        submenuOpenProjects.add(openProject);
        submenuOpenProjects.add(renameProject);
        submenuOpenProjects.add(deleteProject);

        menuProjects.add(newProject);
        menuProjects.add(submenuOpenProjects);

        menuBar.add(menuProjects);
    }

    public static void initMenu() {
        initMenuElements();
        addMenuElementsToMenu();
    }
}