package ecs.entities;

import ecs.Component;
import ecs.Entity;

import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.components.SizeComponent;

public class PlayerEntity extends Entity {
    public PlayerComponent player;
    public PositionComponent position;
    public SizeComponent size;

    public PlayerEntity(PositionComponent position, SizeComponent size) {
        super(new Component[] { new PlayerComponent(),
                position,
                size,
        });

        this.player = (PlayerComponent) this.components.get(0);
        this.position = position;
        this.size = size;
    }
}
