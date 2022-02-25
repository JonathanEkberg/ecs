package games.boids.systems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashSet;
import java.util.Set;

import ecs.EcsSystem;
import ecs.Entity;

public class FpsDrawingSystem extends EcsSystem {
    private static final Set<Class<?>> components = new HashSet<>();
    private static final Font f = new Font("Comic Sans MS", Font.PLAIN, 16);

    public FpsDrawingSystem() {
        super(components);
    }

    @Override
    protected void perform(Entity entity, Graphics graphics, int fps, int delta, int frame, int drawDelta) {
        Graphics2D g = (Graphics2D) graphics;
        String fpsStr = String.format("%d FPS", fps);
        String deltaStr = String.format("Frame: %dms", delta);
        String drawDeltaStr = String.format("Draw: %dms", drawDelta);

        g.setColor(Color.white);
        g.fillRect(0, 0, deltaStr.length() * 10, 50);

        g.setColor(Color.black);
        g.setFont(f);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawString(fpsStr, 5, 15);
        g.drawString(deltaStr, 5, 30);
        g.drawString(drawDeltaStr, 5, 45);
    }
}
