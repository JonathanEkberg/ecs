package ecs;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

public abstract class DrawingSystem {
    private final Component[] dependencies;

    private int previousEntityMapHash;
    private List<Entity> previouslyRendered;

    protected DrawingSystem(Component[] dependencies) {
        this.dependencies = dependencies;
    }

    public void execute(List<Entity> entities, Graphics g) {
        if (previousEntityMapHash != entities.hashCode()) {
            previouslyRendered = new ArrayList<>();

            a: for (Entity entity : entities) {
                for (Component component : dependencies) {
                    if (!entity.hasComponent(component.getClass())) {
                        continue a;
                    }

                    perform(entity, g);
                    previouslyRendered.add(entity);
                }
            }
        }

        for (Entity entity : previouslyRendered) {
            perform(entity, g);
        }
    }

    protected abstract void perform(Entity entity, Graphics g);
}
