package ecs;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {
    private final System[] systems;
    private final ArrayList<Entity> entities;

    public World(Entity[] entities, System[] systems) {
        this.systems = systems;
        this.entities = new ArrayList<>(entities.length);

        for (Entity entity : entities) {
            this.entities.add(entity);
        }
    }

    public void execute(Graphics g) {
        ExecuteState state = new ExecuteState(g, entities);

        for (System system : systems) {
            system.execute(state);
        }
    }
}
