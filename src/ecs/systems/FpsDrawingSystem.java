package ecs.systems;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashSet;
import java.util.Set;
import java.awt.Color;
import java.awt.Font;

import ecs.PerformState;
import ecs.System;

public class FpsDrawingSystem extends System {
    private static final Set<Class<?>> components = new HashSet<>();
    private static final Font f = new Font("Comic Sans MS", Font.PLAIN, 32);

    public FpsDrawingSystem() {
        super(components);
    }

    @Override
    protected void perform(PerformState state) {
        Graphics2D g = (Graphics2D) state.getGraphics();
        String fps = Integer.toString(state.getFps());

        g.setColor(Color.white);
        g.fillRect(0, 0, fps.length() * 25, 50);

        g.setColor(Color.black);
        g.setFont(f);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawString(fps, 5, 40);
    }
}
