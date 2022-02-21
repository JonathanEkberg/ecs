package ecs;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class System {
    protected final Class<?>[] dependencies;

    protected ArrayList<Entity> previouslyUsed = new ArrayList<>();

    protected System(Class<?>[] dependencies) {
        this.dependencies = dependencies;
    }

    public void execute(ExecuteState state) {
        Graphics graphics = state.getGraphics();

        if (!previouslyUsed.equals(state.getEntities())) {
            previouslyUsed = new ArrayList<>();

            for (Entity entity : state.getEntities()) {
                for (Class<?> component : dependencies) {
                    if (!entity.hasComponent(component)) {
                        break;
                    }

                    Util.println("PERFORM 1");
                    perform(new PerformState(entity, graphics));
                    previouslyUsed.add(entity);
                }
            }
            return;
        }

        for (Entity entity : previouslyUsed) {
            Util.println("PERFORM 1");
            perform(new PerformState(entity, graphics));
        }
    }

    protected abstract void perform(PerformState state);
}
