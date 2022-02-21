package ecs.systems;

import ecs.PerformState;
import ecs.System;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.entities.PlayerEntity;

public class PlayerMovementSystem extends System {
    public PlayerMovementSystem() {
        super(new Class<?>[] {
                PlayerComponent.class,
                PositionComponent.class
        });
    }

    @Override
    protected void perform(PerformState state) {
        PlayerEntity pe = (PlayerEntity) state.getEntity();

        pe.getPosition().xPos = ((int) (Math.random() * 100) + 50);
        pe.getPosition().yPos = ((int) (Math.random() * 100) + 50);
    }
}
