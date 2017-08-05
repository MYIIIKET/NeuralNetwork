import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
public class Window {
    private static String name = "NeuralNetwork";
    private static int width = 640;
    private static int height = 480;
    private static final JFrame window = new JFrame(name);
    private static final Window WINDOW = new Window();

    private Window() {
    }

    public static void setName(String newName) {
        name = newName;
    }

    public static void setWidth(int newWidth) {
        width = newWidth;
    }

    public static void setHeight(int newHeight) {
        height = newHeight;
    }

}
