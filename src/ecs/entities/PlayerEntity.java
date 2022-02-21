package ecs.entities;

import ecs.Component;
import ecs.Entity;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.components.SizeComponent;

public class PlayerEntity extends Entity {
    private final PositionComponent position;
    private final SizeComponent size;

    public PlayerEntity(PositionComponent position, SizeComponent size) {
        super(new Component[] { new PlayerComponent(),
                position,
                size,
        });

        this.position = position;
        this.size = size;
    }

    public PositionComponent getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position.xPos = x;
        this.position.yPos = y;
    }

    public SizeComponent getSize() {
        return size;
    }

    public void setSize(float width, float height) {
        size.setWidth(width);
        size.setHeight(height);
    }
}
