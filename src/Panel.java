import java.awt.Graphics;

import javax.swing.JPanel;

import ecs.World;

public class Panel extends JPanel implements Runnable {
    private boolean run = true;

    private int fpsPrintInterval = 500;
    private int fps;
    private int delta;
    private int frames;
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
        start();
    }

    private void start() {
        while (run) {
            update();
        }
    }

    private void update() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        long start = (System.nanoTime() / 1_000_000);
        world.execute(g, fps, delta);
        delta = (int) ((System.nanoTime() / 1_000_000) - start);
        frames++;
        totalTime += delta;

        if (totalTime > fpsPrintInterval) {
            fps = (short) (frames * (1000 / fpsPrintInterval));
            frames = 0;
            totalTime = 0;
            System.out.println("FPS: " + fps);
        }
    }
}
