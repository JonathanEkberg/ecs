package ecs.systems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ecs.PerformState;
import ecs.System;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.entities.PlayerEntity;

public final class PlayerMovementSystem extends System {
    private static final Set<Class<?>> components = new HashSet<>(
            Arrays.asList(PlayerComponent.class, PositionComponent.class));

    public PlayerMovementSystem() {
        super(components);
    }

    @Override
    protected void perform(PerformState state) {
        PlayerEntity pe = (PlayerEntity) state.getEntity();

        float random = (float) (Math.random() * 2);

        random = Math.random() > 0.5d ? -random : random;

        pe.getPosition().move(random, random);
    }
}
