package HomeVisualizer.Logic;

import java.awt.Component;

public class Logic {

    public static final int METER_INTO_PIXEL = 2;
    public static final int[] MAIN_WINDOW_SIZE = { 1700, 1000 };
    public static final int STEP_THREE_WINDOW_SIZE = 700;

    public static <T> void setElementsVisibility(T[] element, boolean visibility) {
        for (int i = 0; i < element.length; i++) {
            ((Component) element[i]).setVisible(visibility);
        }
    }
}
