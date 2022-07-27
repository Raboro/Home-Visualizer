package HomeVisualizer.Gui.VisualizeMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;

public class StartVisualizeGui extends Frame implements ActionListener, Runnable {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1700;
    private String USER;

    private JPanel panel;
    private JMenu menuProjects, submenuProjects;
    private JMenuItem newProject, openProject, renameProject, deleteProject;
    private JMenuBar menuBar;
    private JDialog creatingProjectNotFinished = new JDialog();
    private JButton startSteps, continueButton;
    private JButton[] buttonsSteps;
    private boolean isUserEditing = false;
    private boolean running;
    private Thread thread;
    private boolean stepButtonsAdded;
    private int stepsState = 0;
    private boolean userWorking = false;

    public StartVisualizeGui(String user) {
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

    private void loadNewProjectGui() {
        this.buttonsSteps = NewProjectElementsGui.getStepButtons();
        this.startSteps = NewProjectElementsGui.getStartStep();
        this.startSteps.addActionListener(this);

        for (int i = 0; i < this.buttonsSteps.length; i++) {
            this.panel.add(this.buttonsSteps[i]);
        }
        this.panel.add(this.startSteps);
        this.panel.invalidate();

        for (int i = 0; i < this.buttonsSteps.length; i++) {
            this.buttonsSteps[i].setVisible(true);
        }

        this.startSteps.setVisible(true);
        this.panel.invalidate();
        this.stepButtonsAdded = true;
    }

    private void updateButtonsRightBottom() {
        this.buttonsSteps = NewProjectElementsGui.changeLocationStepsRightBottom(this.buttonsSteps);
        this.panel.invalidate();
    }

    private void getContinueButton() {
        this.continueButton = NewProjectElementsGui.getContinueStep();
        this.panel.add(this.continueButton);
        this.continueButton.setVisible(true);
        this.panel.invalidate();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        if (this.stepButtonsAdded || (this.isUserEditing && !this.userWorking)) {
            // line connection between button 1 & 2
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(680, 509, 730, 509);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR);
            g.drawLine(680, 510, 730, 510);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(680, 511, 730, 511);

            // line connection between button 2 & 3
            g.drawLine(830, 509, 880, 509);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR);
            g.drawLine(830, 510, 880, 510);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(830, 511, 880, 511);

            // line connection between button 3 & 4
            g.drawLine(980, 509, 1030, 509);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR);
            g.drawLine(980, 510, 1030, 510);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(980, 511, 1030, 511);
        }

        if (this.userWorking) {
            // line connection between button 1 & 2
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(1360, 939, 1400, 939);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR);
            g.drawLine(1360, 940, 1400, 940);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(1360, 941, 1400, 941);

            // line connection between button 2 & 3
            g.drawLine(1460, 939, 1500, 939);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR);
            g.drawLine(1460, 940, 1500, 940);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(1460, 941, 1500, 941);

            // line connection between button 3 & 4
            g.drawLine(1560, 939, 1600, 939);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR);
            g.drawLine(1560, 940, 1600, 940);
            g.setColor(NewProjectElementsGui.UNFULFILLED_STEP_COLOR_BORDER);
            g.drawLine(1560, 941, 1600, 941);
        }

        bs.show();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.newProject) {
            if (!isUserEditing) {
                isUserEditing = true;
                loadNewProjectGui();
            } else {
                // TODO add more checks for when the creating Phase is over -> he can save
                // project and then open another
                showPopUpCreatingProjectNotFinished();
            }

        }

        if (event.getSource() == this.startSteps) {
            this.buttonsSteps[0].setBackground(NewProjectElementsGui.IN_WORK_STEP_COLOR);
            this.buttonsSteps[0]
                    .setBorder(BorderFactory.createLineBorder(NewProjectElementsGui.IN_WORK_STEP_COLOR_BORDER, 6));
            updateButtonsRightBottom();
            this.userWorking = true;
            this.stepButtonsAdded = false;
            getContinueButton();
            this.startSteps.setVisible(false);
        }

    }

    public synchronized void start() {
        running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 120;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                delta--;
                render();
            }

            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
            }
        }
        this.stop();

    }

}
