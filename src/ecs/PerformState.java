package ecs;

import java.awt.Graphics;

public class PerformState {
    private Entity entity;
    private Graphics graphics;

    public PerformState(Entity entity, Graphics graphics) {
        this.entity = entity;
        this.graphics = graphics;
    }

    public Entity getEntity() {
        return entity;
    }

    public Graphics getGraphics() {
        return graphics;
    }
}
