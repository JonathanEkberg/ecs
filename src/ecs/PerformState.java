package ecs;

import java.awt.Graphics;

public class PerformState {
    private Entity entity;
    private Graphics graphics;
    private int fps;
    private int delta;
    private int drawDelta;

    public PerformState(Entity entity, Graphics graphics, int fps, int delta, int drawDelta) {
        this.entity = entity;
        this.graphics = graphics;
        this.fps = fps;
        this.delta = delta;
        this.drawDelta = drawDelta;
    }

    public Entity getEntity() {
        return entity;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public int getFps() {
        return fps;
    }

    public int getDelta() {
        return delta;
    }

    public int getDrawDelta() {
        return drawDelta;
    }
}
