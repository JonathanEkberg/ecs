package ecs.systems;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ecs.Entity;
import ecs.System;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.entities.PlayerEntity;

public final class PlayerMovementSystem extends System {
    private static final Set<Class<?>> components = new HashSet<>(
            Arrays.asList(PlayerComponent.class, PositionComponent.class));
    private static final Random random = new Random();

    public PlayerMovementSystem() {
        super(components);
    }

    @Override
    protected boolean debug() {
        return false;
    }

    @Override
    protected void perform(Entity entity, Graphics graphics, int fps, int delta, int drawDelta) {
        PlayerEntity pe = (PlayerEntity) entity;

        int pos = random.nextInt(2);

        if (pos == 0) {
            pos = -2;
        } else {
            pos = 2;
        }

        pe.getPosition().move(pos, pos);
    }
}
