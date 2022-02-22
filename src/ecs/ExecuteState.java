package ecs;

import java.awt.Graphics;
import java.util.List;

public class ExecuteState {
    private Graphics graphics;
    private List<Entity> entities;
    private boolean hasChanged;

    public ExecuteState(Graphics graphics, List<Entity> entities, boolean hasChanged) {
        this.graphics = graphics;
        this.entities = entities;
        this.hasChanged = hasChanged;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public boolean getHasChanged() {
        return hasChanged;
    }
}
