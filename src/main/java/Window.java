
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final int width = 640;
    private static final int height = 480;

    public Window(String name) {
        super(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }
}
