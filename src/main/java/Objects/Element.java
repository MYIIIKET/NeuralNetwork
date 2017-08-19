package Objects;

import Util.Stock;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.Random;

@Getter
public abstract class Element extends JComponent {
    private final Color color = Color.BLACK;

    private Center center = new Center();

    public int getTop() {
        return getY();
    }

    public int getBottom() {
        return getWidth();
    }

    public int getLeft() {
        return getX();
    }

    public int getRight() {
        return getHeight();
    }

    public static final Color getRandomColor() {
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);
        return new Color(red, green, blue);
    }

    public boolean collidesWith(JComponent otherComponent) {
        Area areaA = new Area(this.getBounds());
        Area areaB = new Area(otherComponent.getBounds());
        return areaA.intersects(areaB.getBounds2D());
    }

    public void destroy() {
        Stock.elements.remove(this);
        this.setVisible(false);
        this.getParent().remove(this);
    }

    @Getter
    public class Center {
        private int x;
        private int y;

        private Center() {
            updateCenterPosition();
        }

        public void updateCenterPosition() {
            x = getRight() - getWidth() / 2;
            y = getBottom() - getHeight() / 2;
        }
    }
}
