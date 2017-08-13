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
                System.out.println(circle.getRight() + " " + circle.getCenter().getX());
            }
        });
        circle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (circle.getRight() + 20 <= field.getWidth()) {
                    circle.setLocation(circle.getX() + 20, circle.getY());
                    circle.getCenter().updateCenterPosition();
                }
            }
        });
        field.add(circle);
        window.add(field);
        window.pack();
    }
}
