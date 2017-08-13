import javax.swing.*;
import java.awt.*;

public class Circle extends JComponent {
    private int x;
    private int y;
    private int radius;
    private static final Color color = Color.BLACK;

    public Circle(int x, int y, int radius) {
        this.setLayout(null);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.setBounds(x, y, radius, radius);
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
}
