package ecs.systems;

import java.util.ArrayList;

import ecs.Component;
import ecs.Entity;
import ecs.System;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.entities.PlayerEntity;

public class PlayerMovementSystem extends System {
    public PlayerMovementSystem() {
        super(new Component[] {
                new PlayerComponent(),
                new PositionComponent(xPos, yPos)
        });
    }

    @Override
    protected void perform(Entity entity) {
        PlayerEntity pe = (PlayerEntity) entity;
        if (entity.hasComponent(PlayerComponent.class)) {
            pe.position.xPos = ((int) (Math.random() * 100) + 50);
            pe.position.yPos = ((int) (Math.random() * 100) + 50);
        }
    }
}
