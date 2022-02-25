package ecs.systems;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ecs.EcsSystem;
import ecs.Entity;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.entities.PlayerEntity;

public final class PlayerMovementSystem extends EcsSystem {
    private static final Set<Class<?>> components = new HashSet<>(
            Arrays.asList(PlayerComponent.class, PositionComponent.class));

    public PlayerMovementSystem() {
        super(components);
    }

    @Override
    protected boolean debug() {
        return false;
    }

    @Override
    protected void perform(Entity entity, Graphics graphics, int fps, int delta, int frame, int drawDelta) {
        PlayerEntity pe = (PlayerEntity) entity;

        float xPos = (float) (Math.cos(frame / 100d) * (delta / 10d));
        float yPos = (float) (Math.sin(frame / 100d) * (delta / 10d));

        pe.getPosition().move(xPos, yPos);
    }
}
