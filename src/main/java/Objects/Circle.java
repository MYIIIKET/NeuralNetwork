package Objects;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Circle extends Element implements Movable {

    private int radius;

    private static final int step = 20;

    private int leftBorder = 0;
    private int topBorder = 0;

    private Color color = getRandomColor();
    private List<Sensor> sensors = new ArrayList<>();

    public Circle(int x, int y, int radius) {
        this.radius = radius;
        setLayout(null);
        setBounds(x, y, radius, radius);
        getCenter().updateCenterPosition();

        System.out.println(getCenter().getX() + " " + getCenter().getY() + " " + (getRight() + getRadius()) + " " + (getTop()));
        Sensor sensor = new Sensor(getRight() + 2 * getRadius(), getCenter().getY(), color);
        sensors.add(sensor);
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

    @Override
    public void moveForward() {

    }

    @Override
    public void rotateClockwise() {
        int rotateAbleX = sensors.get(0).getCenter().getX();
        int rotateAbleY = sensors.get(0).getCenter().getY();
        int centerX = getCenter().getX();
        int centerY = getCenter().getY();
        double alpha = 0.7;
        int newX = (int) (centerX + (rotateAbleX - centerX) * Math.cos(alpha) - (rotateAbleY - centerY) * Math.sin(alpha));
        int newY = (int) (centerY + (rotateAbleX - centerX) * Math.sin(alpha) + (rotateAbleY - centerY) * Math.cos(alpha));
        if (newX >= 0 && newX <= getParent().getWidth() && newY >= 0 && newY <= getParent().getHeight()) {
            sensors.get(0).setLocation(newX, newY);
            getCenter().updateCenterPosition();
        }
    }

    @Override
    public void rotateCounterClockwise() {

    }

}
