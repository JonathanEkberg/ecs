package ecs;

import java.util.ArrayList;
import java.util.List;

public abstract class System {
    private final Class<?>[] dependencies;

    private int previousEntityMapHash;
    private List<Entity> previouslyRendered;

    protected System(Class<?>[] dependencies) {
        this.dependencies = dependencies;
    }

    public void execute(List<Entity> entities) {
        if (previousEntityMapHash != entities.hashCode()) {
            previouslyRendered = new ArrayList<>();

            a: for (Entity entity : entities) {
                for (Component component : dependencies) {
                    if (!entity.hasComponent(component.getClass())) {
                        continue a;
                    }

                    perform(entity);
                    previouslyRendered.add(entity);
                }
            }
        }

        for (Entity entity : previouslyRendered) {
            perform(entity);
        }
    }

    protected abstract void perform(Entity entity);
}
