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
import javax.swing.JTextField;

import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.ColorState;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.NewProjectElementsGui;
import HomeVisualizer.Gui.VisualizeMain.GuiElements.StepStates;
import HomeVisualizer.Gui.VisualizeMain.StatesGui.CreateApartmentGui;
import HomeVisualizer.VisualizeRenderer.Display;

public class StartVisualizeGui extends Frame implements ActionListener, Runnable {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1700;

    private JPanel panel;
    private JMenu menuProjects, submenuProjects;
    private JMenuItem newProject, openProject, renameProject, deleteProject;
    private JMenuBar menuBar;
    private JDialog creatingProjectNotFinished = new JDialog();
    private JButton startSteps, continueButton;
    private JButton finishedApartmentGeneration = CreateApartmentGui.getFinishedCreation();
    private JButton[] buttonsSteps;
    private JButton[] chooseWalls = CreateApartmentGui.getChooseWallsButtons();
    private JLabel stepName;
    private JLabel[] apartmentParameter;
    private JTextField[] getApartmentParameter;
    private boolean isUserStartingEditing, finishedStartSteps = false;
    private boolean running;
    private Thread thread;
    private boolean stepButtonsAdded;
    private int stepsState = 0;
    private boolean userWorking = false;
    private ColorState[] colorsLines = new ColorState[3];
    private StepStates currentState;

    public StartVisualizeGui(String user) {
        super(user, WIDTH, HEIGHT);

        for (int line = 0; line < this.colorsLines.length; line++) {
            colorsLines[line] = ColorState.UNFULFILLED;
        }

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.add(this.panel);
        createLayout();
        this.menuBar.setVisible(true);
        this.setLocation(110, 300);
        this.setVisible(true);
    }

    private void createLayout() {
        this.menuBar = new JMenuBar();
        this.menuBar.setVisible(false);
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
        this.stepName = NewProjectElementsGui.getStateName(NewProjectElementsGui.stepName);
        this.buttonsSteps = NewProjectElementsGui.getStepButtons();
        this.startSteps = NewProjectElementsGui.getStartStep();
        this.startSteps.addActionListener(this);

        for (int i = 0; i < this.buttonsSteps.length; i++) {
            this.panel.add(this.buttonsSteps[i]);
        }
        this.panel.add(this.startSteps);
        this.panel.add(this.stepName);
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

    private void updateButtonsCenter() {
        this.buttonsSteps = NewProjectElementsGui.changeLocationStepsCenter(this.buttonsSteps);
        this.panel.invalidate();
    }

    private void getContinueButton() {
        this.continueButton = NewProjectElementsGui.getContinueStep();
        this.continueButton.addActionListener(this);
        this.panel.add(this.continueButton);
        this.continueButton.setVisible(true);
        this.panel.invalidate();
    }

    private Color getColorToDrawLine(int index) {
        switch (this.colorsLines[index]) {
            case UNFULFILLED:
                return NewProjectElementsGui.UNFULFILLED_STEP_COLOR;
            case FINISHED:
                return NewProjectElementsGui.FINISHED_STEP_COLOR;
            case IN_WORK:
                return NewProjectElementsGui.IN_WORK_STEP_COLOR;
        }
        return null;
    }

    private void selectMethodForCurrentStep() {
        switch (this.currentState) {
            case CREATE_APARTMENT:
                this.create_Apartment();
            case CREATE_DOORS:
                break;
            case CREATE_ROOMS:
                break;
            case CREATE_ROOM_NAMES:
                break;
        }
    }

    private void create_Apartment() {
        this.panel.add(this.chooseWalls[0]);
        this.panel.add(this.chooseWalls[1]);
        this.panel.invalidate();

        this.chooseWalls[0].setVisible(true);
        this.chooseWalls[1].setVisible(true);

        this.chooseWalls[0].addActionListener(this);

        this.panel.invalidate();
    }

    private void fourWalls() {
        this.panel.add(this.finishedApartmentGeneration);
        this.panel.invalidate();
        this.finishedApartmentGeneration.setVisible(true);
        this.panel.invalidate();
        this.finishedApartmentGeneration.addActionListener(this);

        this.apartmentParameter = CreateApartmentGui.getLabels();

        for (int i = 0; i < this.apartmentParameter.length; i++) {
            this.panel.add(this.apartmentParameter[i]);
        }

        this.panel.invalidate();

        for (int i = 0; i < this.apartmentParameter.length; i++) {
            this.apartmentParameter[i].setVisible(true);
        }

        this.getApartmentParameter = CreateApartmentGui.getTextFields();

        for (int i = 0; i < this.getApartmentParameter.length; i++) {
            this.panel.add(this.getApartmentParameter[i]);
        }

        this.panel.invalidate();

        for (int i = 0; i < this.getApartmentParameter.length; i++) {
            this.getApartmentParameter[i].setVisible(true);
        }

        this.panel.invalidate();
        this.continueButton.setEnabled(false);
    }

    private boolean isUserInputIsCorrectStepOne() {
        for (int parameter = 0; parameter < this.getApartmentParameter.length; parameter++) {
            try {
                int testValue = Integer.parseInt(this.getApartmentParameter[parameter].getText());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private void createDisplay() {
        double length = Integer.parseInt(this.getApartmentParameter[0].getText());
        double height = Integer.parseInt(this.getApartmentParameter[1].getText());
        double width = Integer.parseInt(this.getApartmentParameter[2].getText());

        Display display = new Display(length, height, width);
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);

        display.start();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        if (this.stepButtonsAdded || (this.isUserStartingEditing && !this.userWorking)) {
            // line connection between button 1 & 2
            g.setColor(getColorToDrawLine(0));
            g.drawLine(680, 509, 729, 509);
            g.setColor(getColorToDrawLine(0));
            g.drawLine(680, 510, 729, 510);
            g.setColor(getColorToDrawLine(0));
            g.drawLine(680, 511, 729, 511);

            // line connection between button 2 & 3
            g.setColor(getColorToDrawLine(1));
            g.drawLine(830, 509, 879, 509);
            g.setColor(getColorToDrawLine(1));
            g.drawLine(830, 510, 879, 510);
            g.setColor(getColorToDrawLine(1));
            g.drawLine(830, 511, 879, 511);

            // line connection between button 3 & 4
            g.setColor(getColorToDrawLine(2));
            g.drawLine(980, 509, 1029, 509);
            g.setColor(getColorToDrawLine(2));
            g.drawLine(980, 510, 1029, 510);
            g.setColor(getColorToDrawLine(2));
            g.drawLine(980, 511, 1029, 511);
        }

        if (this.userWorking) {
            // line connection between button 1 & 2
            g.setColor(getColorToDrawLine(0));
            g.drawLine(1360, 939, 1400, 939);
            g.setColor(getColorToDrawLine(0));
            g.drawLine(1360, 940, 1400, 940);
            g.setColor(getColorToDrawLine(0));
            g.drawLine(1360, 941, 1400, 941);

            // line connection between button 2 & 3
            g.setColor(getColorToDrawLine(1));
            g.drawLine(1460, 939, 1500, 939);
            g.setColor(getColorToDrawLine(1));
            g.drawLine(1460, 940, 1500, 940);
            g.setColor(getColorToDrawLine(1));
            g.drawLine(1460, 941, 1500, 941);

            // line connection between button 3 & 4
            g.setColor(getColorToDrawLine(2));
            g.drawLine(1560, 939, 1600, 939);
            g.setColor(getColorToDrawLine(2));
            g.drawLine(1560, 940, 1600, 940);
            g.setColor(getColorToDrawLine(2));
            g.drawLine(1560, 941, 1600, 941);
        }

        bs.show();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.newProject) {
            if (!isUserStartingEditing) {
                isUserStartingEditing = true;
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
            this.stepName.setVisible(true);
            this.startSteps.setVisible(false);
            this.currentState = StepStates.CREATE_APARTMENT;
            this.selectMethodForCurrentStep();
        }

        if (event.getSource() == this.continueButton) {
            if (this.userWorking == true) {
                this.userWorking = false;
                this.stepName.setVisible(false);
                this.buttonsSteps[this.stepsState].setBackground(NewProjectElementsGui.FINISHED_STEP_COLOR);
                this.buttonsSteps[this.stepsState]
                        .setBorder(BorderFactory.createLineBorder(NewProjectElementsGui.FINISHED_STEP_COLOR_BORDER, 6));
                updateButtonsCenter();

                this.stepName.setVisible(false);

                if (this.stepsState < 3) {
                    this.stepName = NewProjectElementsGui.getStateName(this.stepName);
                    this.colorsLines[this.stepsState] = ColorState.IN_WORK;
                } else {
                    this.continueButton.setEnabled(false);
                    this.continueButton.setVisible(false);
                    this.finishedStartSteps = true;
                }

            } else {
                this.stepName.setVisible(true);
                this.colorsLines[this.stepsState] = ColorState.FINISHED;
                this.stepsState += 1;
                this.userWorking = true;
                this.buttonsSteps[this.stepsState].setBackground(NewProjectElementsGui.IN_WORK_STEP_COLOR);
                this.buttonsSteps[this.stepsState]
                        .setBorder(BorderFactory.createLineBorder(NewProjectElementsGui.IN_WORK_STEP_COLOR_BORDER, 6));
                updateButtonsRightBottom();
            }

        }

        if (event.getSource() == this.chooseWalls[0]) {
            this.chooseWalls[0].setVisible(false);
            this.chooseWalls[1].setVisible(false);
            this.fourWalls();
        }

        if (event.getSource() == this.finishedApartmentGeneration) {
            if (isUserInputIsCorrectStepOne()) {
                this.continueButton.setEnabled(true);

                for(int i = 0; i < this.apartmentParameter.length; i++) {
                    this.apartmentParameter[i].setVisible(false);
                    this.apartmentParameter[i].setEnabled(false);
                    this.getApartmentParameter[i].setVisible(false);
                    this.getApartmentParameter[i].setEnabled(false);
                }
                
                this.finishedApartmentGeneration.setVisible(false);
                this.finishedApartmentGeneration.setEnabled(false);

                this.createDisplay();
            }
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
