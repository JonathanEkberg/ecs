package ecs;

import java.awt.Graphics;
import java.util.ArrayList;

import ecs.systems.IDrawingSystem;
import ecs.systems.ISystem;

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

    public void execute() {
        for (System system : systems) {
            if (system instanceof ISystem) {
                Util.println(system);
                ((ISystem) system).execute(entities);
            }
        }
    }

    public void draw(Graphics g) {
        for (System system : systems) {
            if (IDrawingSystem.class.isAssignableFrom(system.getClass())) {
                ((IDrawingSystem) system).execute(entities, g);
                continue;
            }

            Util.println("Not an instance of IDrawingSystem!");
        }
    }
}
