package ecs;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {
    private final ArrayList<Entity> entities;
    private final ArrayList<System> systems;

    public World(Entity[] entities, System[] systems) {
        this.entities = new ArrayList<>(entities.length);
        this.systems = new ArrayList<>(systems.length);

        for (Entity entity : entities) {
            this.entities.add(entity);
        }

        for (System system : systems) {
            this.systems.add(system);
        }
    }

    public void execute(Graphics g) {
        ExecuteState state = new ExecuteState(g, entities);

        for (System system : systems) {
            system.execute(state);
        }
    }
}
