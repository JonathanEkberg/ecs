package ecs;

import java.awt.Graphics;
import java.util.List;

public class ExecuteState extends PerformState {
    private List<Entity> entities;
    private boolean hasChanged;

    public ExecuteState(Graphics graphics, int fps, int delta,
            List<Entity> entities,
            boolean hasChanged) {
        super(null, graphics, fps, delta);
        this.entities = entities;
        this.hasChanged = hasChanged;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public boolean getHasChanged() {
        return hasChanged;
    }

}
