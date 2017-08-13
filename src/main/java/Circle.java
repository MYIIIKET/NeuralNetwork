import lombok.Data;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
public class Circle extends JComponent {
    Random randomGenerator = new Random();
    int red = randomGenerator.nextInt(256);
    int green = randomGenerator.nextInt(256);
    int blue = randomGenerator.nextInt(256);
    private int radius;
    private final Color color = new Color(red, green, blue);
    private Center center;

    public Circle(int x, int y, int radius) {
        this.setLayout(null);
        this.radius = radius;
        this.setBounds(x, y, radius, radius);
        center = new Center();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, radius, radius);
    }

    public int getTop() {
        return this.getY();
    }

    public int getBottom() {
        return getTop() + radius;
    }

    public int getLeft() {
        return this.getX();
    }

    public int getRight() {
        return getLeft() + radius;
    }

    public Center getCenter() {
        return center;
    }

    @Getter
    class Center {
        private int x;
        private int y;

        private Center() {
            updateCenterPosition();
        }

        public void updateCenterPosition() {
            x = getRight() - getRadius()/2;
            y = getBottom() - getRadius()/2;
        }

    }
}
