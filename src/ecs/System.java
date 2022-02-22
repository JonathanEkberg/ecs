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
        int fps = state.getFps();
        int delta = state.getDelta();
        int drawDelta = state.getDrawDelta();

        if (this.dependencies.isEmpty()) {
            perform(null, graphics, fps, delta, drawDelta);
        }

        // Only search for new entities if entities have been added or removed.
        if (!state.getHasChanged()) {
            entities = new ArrayList<>();

            for (Entity entity : state.getEntities()) {
                for (Class<?> component : dependencies) {
                    if (!entity.hasComponent(component)) {
                        break;
                    }

                    perform(entity, graphics, fps, delta, drawDelta);
                    entities.add(entity);
                }
            }
            return;
        }

        // Perform on the entities with correct components.
        for (Entity entity : entities) {
            perform(entity, graphics, fps, delta, drawDelta);
        }
    }

    protected abstract boolean debug();

    /**
     * Mutates or reads the entities components and draws to graphics as is required
     * by the system.
     * 
     * @param state - The state of the perform.
     */
    protected abstract void perform(Entity entity, Graphics graphics, int fps, int delta, int drawDelta);
}