package HomeVisualizer.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VisualizeGui extends Frame implements ActionListener {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1700;
    private String USER;

    private JPanel panel;
    private JMenu menuProjects, submenuProjects;
    private JMenuItem newProject, openProject, renameProject, deleteProject;
    private JMenuBar menuBar;
    private JDialog creatingProjectNotFinished = new JDialog();
    private boolean isUserEditing = false;

    public VisualizeGui(String user) {
        super(user, WIDTH, HEIGHT);
        this.USER = user;

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.add(this.panel);
        createLayout();
        this.setLocation(110, 300);
        this.setVisible(true);
    }

    private void createLayout() {
        this.menuBar = new JMenuBar();
        this.menuProjects = new JMenu("Projects");
        this.submenuProjects = new JMenu("Open");

        this.newProject = new JMenuItem("New");
        this.newProject.addActionListener(this);

        this.openProject = new JMenuItem("Open Project");
        this.renameProject = new JMenuItem("Rename Project");
        this.deleteProject = new JMenuItem("Delete Project");

        this.submenuProjects.add(openProject);
        this.submenuProjects.add(renameProject);
        this.submenuProjects.add(deleteProject);

        this.menuProjects.add(this.newProject);
        this.menuProjects.add(this.submenuProjects);

        this.menuBar.add(this.menuProjects);
        this.setJMenuBar(this.menuBar);
    }

    private void showPopUpCreatingProjectNotFinished() {
        this.creatingProjectNotFinished.setSize(420, 100);
        this.creatingProjectNotFinished.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.creatingProjectNotFinished
                .add(new JLabel("Can`t open other or new project until you finished the creating phase"));

        this.creatingProjectNotFinished.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.newProject) {
            if (!isUserEditing) {
                isUserEditing = true;
            } else {
                // TODO add more checks for when the creating Phase is over -> he can save
                // project and then open another
                showPopUpCreatingProjectNotFinished();
            }

        }

    }

}
