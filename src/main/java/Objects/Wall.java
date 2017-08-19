package Objects;

import java.awt.*;

public class Wall extends Element {

    private int width;
    private int height;

    public Wall(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        setLayout(null);
        setBounds(x, y, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }
}
