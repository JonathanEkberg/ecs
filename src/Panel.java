import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import ecs.World;

public class Panel extends JPanel implements ActionListener {
    private static final float FPS = 60;

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
