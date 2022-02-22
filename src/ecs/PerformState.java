package ecs;

import java.awt.Graphics;

public class PerformState {
    private Entity entity;
    private Graphics graphics;
    private int fps;
    private int delta;

    public PerformState(Entity entity, Graphics graphics, int fps, int delta) {
        this.entity = entity;
        this.graphics = graphics;
        this.fps = fps;
        this.delta = delta;
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
}
