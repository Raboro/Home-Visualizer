package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import javax.swing.SwingUtilities;

import HomeVisualizer.Graphics.CreateRoomNamesGraphics;

public class CreateRoomNamesLogic {
    
    public static void init() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateRoomNamesGraphics g = new CreateRoomNamesGraphics();
                g.setVisible(true);
            }
        });
    }
}
