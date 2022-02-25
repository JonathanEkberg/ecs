package ecs;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;
import java.util.WeakHashMap;

public final class World {
    private final EcsSystem[] systems;
    private final ArrayList<Entity> entities;
    private final ArrayList<Entity> newEntities;
    private final ArrayList<Entity> removedEntities;
    private final WeakHashMap<EcsSystem, Entity[]> cachedDependencies;

    private boolean hasChanged;
    private int drawDelta;

    public World(Entity[] entities, EcsSystem[] systems) {
        this.systems = systems;
        this.entities = new ArrayList<>(entities.length);

        newEntities = new ArrayList<>(5);
        removedEntities = new ArrayList<>(5);
        cachedDependencies = new WeakHashMap<>(systems.length);

        hasChanged = true;

        for (Entity entity : entities) {
            this.entities.add(entity);
        }
    }

    public void addEntity(final Entity entity) {
        entities.add(entity);
        newEntities.add(entity);
        hasChanged = true;
    }

    public void removeEntity(final Entity entity) {
        entities.remove(entity);
        removedEntities.add(entity);
        hasChanged = true;
    }

    /**
     * Iterates over the systems and calls their execute method with an ExecuteState
     * with the graphics context.
     * 
     * @param g
     */
    public void execute(Graphics graphics, int fps, int delta, int frame) {
        for (EcsSystem system : systems) {
            system.execute(graphics, fps, delta, drawDelta, frame, getSystemEntities(system));
        }
    }

    private Entity[] getSystemEntities(EcsSystem system) {
        if (!hasChanged) {
            return cachedDependencies.get(system);
        }

        // TODO: Only search the newly added entities if cachedDependencies is not empty

        Set<Class<?>> dependencies = system.getDependencies();
        ArrayList<Entity> correctEntities = new ArrayList<>(dependencies.size());

        a: for (Entity entity : entities) {
            for (Class<?> component : dependencies) {
                if (!entity.hasComponent(component)) {
                    continue a;
                }
            }

            correctEntities.add(entity);
        }

        Entity[] toReturn = correctEntities.toArray(new Entity[correctEntities.size()]);
        cachedDependencies.put(system, toReturn);

        return toReturn;
    }
}
