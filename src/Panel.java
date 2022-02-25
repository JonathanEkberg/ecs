import java.awt.Graphics;

import javax.swing.JPanel;

import ecs.World;

public class Panel extends JPanel implements Runnable {
    private boolean run = true;

    private int fpsPrintInterval = 500;
    private int fps;
    private int delta;
    private int frame;
    private long totalTime;

    private final transient World world;

    public Panel(World world) {
        this.world = world;
    }

    public int getFps() {
        return fps;
    }

    @Override
    public void run() {
        while (run) {
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        long start = (System.nanoTime() / 1_000_000);
        world.execute(g, fps, delta, frame);
        delta = (int) ((System.nanoTime() / 1_000_000) - start);
        frame++;
        totalTime += delta;

        if (totalTime > fpsPrintInterval) {
            fps = frame * (1000 / fpsPrintInterval);
            frame = 0;
            totalTime = 0;
        }
    }
}
