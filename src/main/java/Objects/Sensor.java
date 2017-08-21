package Objects;

import java.awt.*;

public class Sensor extends Element {

    private Color color;
    private static final int radius = 10;

    public Sensor(int x, int y, Color color) {
        this.color = color;
        setLayout(null);
        setBounds(x, y - radius / 2, radius, radius);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, radius, radius);
    }
}