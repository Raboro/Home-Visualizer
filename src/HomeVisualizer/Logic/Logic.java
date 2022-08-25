package HomeVisualizer.Logic;

import java.awt.Component;

public class Logic {

    public static final int METER_INTO_PIXEL = 2;
    
    public static <T> void setElementsVisibility(T[] element, boolean visibility) {
        for (int i = 0; i < element.length; i++) {
            ((Component) element[i]).setVisible(visibility);
        }
    }
}
