package Objects;

import lombok.Getter;

import java.awt.*;

@Getter
public class Circle extends Element implements Movable {

    private int radius;

    private static final int step = 20;

    private int leftBorder = 0;
    private int topBorder = 0;

    private Color color = getRandomColor();

    public Circle(int x, int y, int radius) {
        this.radius = radius;
        setLayout(null);
        setBounds(x, y, radius, radius);
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
