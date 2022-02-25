import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {
    public static final Dimension WINDOW_SIZE = new Dimension(1280, 720);
    public static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(600, 400);

    public Window(Panel panel) {
        JFrame frame = new JFrame("Game");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(MINIMUM_WINDOW_SIZE);
        frame.setSize(WINDOW_SIZE);
        frame.setPreferredSize(WINDOW_SIZE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
