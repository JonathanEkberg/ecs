package ecs;

import java.util.List;
import java.awt.Graphics;

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
