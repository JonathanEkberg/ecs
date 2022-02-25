package ecs;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;

public abstract class EcsSystem {
    /**
     * The components required by the system.
     */
    protected final Set<Class<?>> dependencies;
    /**
     * The previously used entities. Used to prevent searching for entities if there
     * are no new entities.
     */
    protected ArrayList<Entity> entities = new ArrayList<>();

    protected EcsSystem(Set<Class<?>> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Finds the entities with the required depenencies and calls this systems
     * perform method.
     * 
     * @param state - The state of the execution.
     */
    public void execute(Graphics graphics, int fps, int delta, int frameTime, int frame, Entity[] entities) {
        for (Entity entity : entities) {
            perform(entity, graphics, fps, delta, frame, frameTime);
        }
    }

    public Set<Class<?>> getDependencies() {
        return dependencies;
    }

    protected abstract boolean debug();

    /**
     * Mutates or reads the entities components and draws to graphics as is required
     * by the system.
     * 
     * @param state - The state of the perform.
     */
    protected abstract void perform(Entity entity, Graphics graphics, int fps, int delta, int frame, int drawDelta);
}