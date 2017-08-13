import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
abstract class Element extends JComponent {
    private Random randomGenerator = new Random();
    private int red = randomGenerator.nextInt(256);
    private int green = randomGenerator.nextInt(256);
    private int blue = randomGenerator.nextInt(256);
    private final Color color = new Color(red, green, blue);

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
