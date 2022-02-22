package ecs;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;

public abstract class System {
    /**
     * The components required by the system.
     */
    protected final Set<Class<?>> dependencies;
    /**
     * The previously used entities. Used to prevent searching for entities if there
     * are no new entities.
     */
    protected ArrayList<Entity> entities = new ArrayList<>();

    protected System(Set<Class<?>> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Finds the entities with the required depenencies and calls this systems
     * perform method.
     * 
     * @param state - The state of the execution.
     */
    public void execute(ExecuteState state) {
        Graphics graphics = state.getGraphics();

        if (this.dependencies.isEmpty()) {
            perform(new PerformState(null, graphics, state.getFps(), state.getDelta()));
        }

        // Only search for new entities if entities have been added or removed.
        if (!state.getHasChanged()) {
            entities = new ArrayList<>();

            for (Entity entity : state.getEntities()) {
                for (Class<?> component : dependencies) {
                    if (!entity.hasComponent(component)) {
                        break;
                    }

                    perform(new PerformState(entity, graphics, state.getFps(), state.getDelta()));
                    entities.add(entity);
                }
            }
            return;
        }

        // Perform on the entities with correct components.
        for (Entity entity : entities) {
            perform(new PerformState(entity, graphics, state.getFps(), state.getDelta()));
        }
    }

    /**
     * Mutates or reads the entities components and draws to graphics as is required
     * by the system.
     * 
     * @param state - The state of the perform.
     */
    protected abstract void perform(PerformState state);
}
