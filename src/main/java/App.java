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
            }
        });
        circle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        circle.moveUp();
                        break;
                    case KeyEvent.VK_S:
                        circle.moveDown();
                        break;
                    case KeyEvent.VK_A:
                        circle.moveLeft();
                        break;
                    case KeyEvent.VK_D:
                        circle.moveRight();
                        break;
                }
            }
        });
        field.add(circle);
        window.add(field);
        window.pack();
    }
}
