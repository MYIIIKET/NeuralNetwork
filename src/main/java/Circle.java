import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
public class Circle extends Element implements Movable {

    private Random randomGenerator = new Random();
    private int red = randomGenerator.nextInt(256);
    private int green = randomGenerator.nextInt(256);
    private int blue = randomGenerator.nextInt(256);
    private final Color color = new Color(red, green, blue);

    private int radius;

    private int leftBorder = 0;
    private int topBorder = 0;

    private int step = 5;

    public Circle(int x, int y, int radius) {
        this.setLayout(null);
        this.radius = radius;
        this.setBounds(x, y, radius, radius);
        getCenter().updateCenterPosition();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, radius, radius);
    }

    @Override
    public void moveUp() {
        int newPosition = getTop() - step;
        if (newPosition >= topBorder) {
            setLocation(getX(), newPosition);
            getCenter().updateCenterPosition();
        }
    }

    @Override
    public void moveDown() {
        int newPosition = getTop() + step;
        int bottomBorder = getParent().getHeight() - getRadius();
        if (newPosition <= bottomBorder) {
            setLocation(getX(), newPosition);
            getCenter().updateCenterPosition();
        }
    }

    @Override
    public void moveLeft() {
        int newPosition = getLeft() - step;
        if (newPosition >= leftBorder) {
            setLocation(newPosition, getY());
            getCenter().updateCenterPosition();
        }
    }

    @Override
    public void moveRight() {
        int newPosition = getLeft() + step;
        int rightBorder = getParent().getWidth() - getRadius();
        if (newPosition <= rightBorder) {
            setLocation(newPosition, getY());
            getCenter().updateCenterPosition();
        }
    }

}
