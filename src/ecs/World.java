package ecs;

import java.awt.Graphics;
import java.util.ArrayList;

public final class World {
    private final System[] systems;
    private final ArrayList<Entity> entities;
    private boolean hasChanged = false;

    public World(Entity[] entities, System[] systems) {
        this.systems = systems;
        this.entities = new ArrayList<>(entities.length);

        for (Entity entity : entities) {
            this.entities.add(entity);
        }
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
        this.hasChanged = true;
    }

    /**
     * Iterates over the systems and calls their execute method with an ExecuteState
     * with the graphics context.
     * 
     * @param g
     */
    public void execute(Graphics g) {
        ExecuteState state = new ExecuteState(g, entities, hasChanged);
        hasChanged = false;

        for (System system : systems) {
            system.execute(state);
        }
    }
}
