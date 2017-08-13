import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) {
        final Window window = new Window("NeuralNetwork");
        final Field field = new Field();
        final Circle circle = new Circle(50, 50, 50);
        circle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                circle.grabFocus();
                System.out.println(circle.getLeft()
                        + " " + circle.getTop()
                        + " " + circle.getRight()
                        + " " + circle.getBottom());
            }
        });
        circle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println(circle.getRight());
                if (circle.getRight() + 20 <= field.getWidth())
                    circle.setLocation(circle.getX() + 20, circle.getY());
            }
        });
        field.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                System.out.println(e.getX() + " " + e.getY());
            }
        });
        field.add(circle);
        window.add(field);
        window.pack();
    }
}
