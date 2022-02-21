package ecs.entities;

import ecs.Component;
import ecs.Entity;
import ecs.components.ColorComponent;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.components.SizeComponent;

public class PlayerEntity extends Entity {
    private final PositionComponent position;
    private final SizeComponent size;
    private final ColorComponent color;

    public PlayerEntity(PositionComponent position, SizeComponent size, ColorComponent color) {
        super(new Component[] { new PlayerComponent(),
                position,
                size,
        });

        this.position = position;
        this.size = size;
        this.color = color;
    }

    public PositionComponent getPosition() {
        return position;
    }

    public SizeComponent getSize() {
        return size;
    }

    public ColorComponent getColor() {
        return color;
    }

    public void setSize(float width, float height) {
        size.setWidth(width);
        size.setHeight(height);
    }
}
