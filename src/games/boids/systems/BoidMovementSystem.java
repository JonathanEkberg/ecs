package games.boids.systems;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ecs.EcsSystem;
import ecs.Entity;
import games.boids.components.AngleComponent;
import games.boids.components.BoidComponent;
import games.boids.components.PositionComponent;
import games.boids.components.SpeedComponent;
import games.boids.entities.BoidEntity;

public final class BoidMovementSystem extends EcsSystem {
    private static final Set<Class<?>> components = new HashSet<>(
            Arrays.asList(BoidComponent.class, PositionComponent.class, SpeedComponent.class, AngleComponent.class));

    public BoidMovementSystem() {
        super(components);
    }

    @Override
    protected void perform(Entity entity, Graphics graphics, int fps, int delta, int frame, int drawDelta) {
        BoidEntity pe = (BoidEntity) entity;

        float angle = pe.angle().rad();
        float speed = pe.speed().value();

        float xOffset = (float) (Math.cos(angle) * speed);
        float yOffset = (float) (Math.sin(angle) * speed);

        // System.out.println(Math.toDegrees(Math.atan2(xOffset, yOffset)));
        // System.out.println(xOffset);
        // System.out.println(yOffset);
        // System.out.println();

        pe.position().move(xOffset, yOffset);
    }
}
