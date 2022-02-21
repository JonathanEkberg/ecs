package ecs;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class System {
    protected final Class<?>[] dependencies;

    protected int previousEntityMapHash;
    protected List<Entity> previouslyUsed;

    protected System(Class<?>[] dependencies) {
        this.dependencies = dependencies;
    }

    public void execute(ExecuteState state) {
        Graphics graphics = state.getGraphics();

        if (previousEntityMapHash != state.getEntities().hashCode()) {
            previouslyUsed = new ArrayList<>();

            for (Entity entity : state.getEntities()) {
                for (Class<?> component : dependencies) {
                    if (!entity.hasComponent(component)) {
                        break;
                    }

                    perform(new PerformState(entity, graphics));
                    previouslyUsed.add(entity);
                }
            }
            previousEntityMapHash = state.getEntities().hashCode();
            return;
        }

        for (Entity entity : previouslyUsed) {
            perform(new PerformState(entity, graphics));
        }
    }

    protected abstract void perform(PerformState state);
}
