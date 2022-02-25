package graphics;

import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Graphics2D;

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
            try {
                Thread.sleep(16);
            } catch (Exception e) {
                System.exit(1);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Set anti-alias!

        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

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
