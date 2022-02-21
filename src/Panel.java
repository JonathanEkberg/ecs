import javax.swing.Timer;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import ecs.World;

public class Panel extends JPanel implements ActionListener {
    private static final float FPS = 1;

    private final transient World world;
    private final Timer timer;

    public Panel(World world) {
        this.world = world;

        timer = new Timer((int) (1000 / FPS), this);
        timer.start();
    }

    private void update() {
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        world.execute(g);
    }
}
