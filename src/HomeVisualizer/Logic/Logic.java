package HomeVisualizer.Logic;

import java.awt.Component;
import java.awt.Font;

public class Logic {

    public static final int METER_INTO_PIXEL = 2;
    public static final int[] MAIN_WINDOW_SIZE = { 1700, 1000 };
    public static final int STEP_THREE_WINDOW_SIZE = 700;

    public static <T> void setElementsVisibility(T[] elements, boolean visibility) {
        for (T element : elements) {
            ((Component) element).setVisible(visibility);
        }
    }

    public static <T> void editLabelsAndTextFieldsProperty(T[] elements) {
        setElementsVisibility(elements, false);
        for (T element : elements) {
            ((Component) element).setFont(new Font("Arial", Font.BOLD, 15));
        }
    }
}