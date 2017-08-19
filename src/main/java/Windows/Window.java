package Windows;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final int width = 640;
    private static final int height = 480;
    private static final Color backGround = Color.WHITE;

    public Window(String name) {
        super(name);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }
}
