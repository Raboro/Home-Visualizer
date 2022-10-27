package HomeVisualizer.VisualizeRenderer.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {

    private int mouseX = -1;
    private int mouseY = -1;
    private int mouseB = -1;
    private int scroll = 0;

    public int getX() {
        return this.mouseX;
    }

    public int getY() {
        return this.mouseY;
    }

    public boolean isScrollingUp() {
        return this.scroll == -1;
    }

    public boolean isScrollingDown() {
        return this.scroll == 1;
    }

    public void resetScroll() {
        this.scroll = 0;
    }

    public ClickType getButton() {
        return switch (this.mouseB) {
            case 1 -> ClickType.LEFTCLICK;
            case 2 -> ClickType.SCROLLCLICK;
            case 3 -> ClickType.RIGHTCLICK;
            default -> ClickType.UNKNOWN;
        };
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {
        scroll = event.getWheelRotation();
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        this.mouseX = event.getX();
        this.mouseY = event.getY();
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        this.mouseX = event.getX();
        this.mouseY = event.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent event) {
        this.mouseB = event.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        this.mouseB = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}