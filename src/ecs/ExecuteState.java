package ecs;

import java.awt.Graphics;
import java.util.List;

public class ExecuteState {
    private Graphics graphics;
    private List<Entity> entities;

    public ExecuteState(Graphics graphics, List<Entity> entities) {
        this.graphics = graphics;
        this.entities = entities;
    }

    Graphics getGraphics() {
        return graphics;
    }

    List<Entity> getEntities() {
        return entities;
    }
}