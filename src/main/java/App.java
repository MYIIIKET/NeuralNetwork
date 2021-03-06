import Objects.Circle;
import Objects.Field;
import Objects.Sensor;
import Objects.Wall;
import Util.CollisionChecker;
import Util.Stock;
import Windows.Window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {

    public static void main(String[] args) {
        final Window window = new Window("NeuralNetwork");
        final Field field = new Field();
        final Circle circle = new Circle(50, 200, 50);
        final Wall wall = new Wall(300, 100, 50, 300);
        circle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                circle.grabFocus();
                System.out.println("click");
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
                    case KeyEvent.VK_SPACE:
//                        circle.rotateClockwise();
                        break;
                }
            }
        });
        field.add(circle);
        circle.getSensors().forEach(field::add);
        window.add(field);
        window.pack();
    }

}
