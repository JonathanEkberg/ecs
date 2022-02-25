package games.boids.entities;

import java.util.Arrays;
import java.util.HashSet;

import ecs.Entity;
import games.boids.components.AngleComponent;
import games.boids.components.BoidComponent;
import games.boids.components.ColorComponent;
import games.boids.components.PositionComponent;
import games.boids.components.SpeedComponent;

public class BoidEntity extends Entity {
    private final PositionComponent position;
    private final AngleComponent angle;
    private final SpeedComponent speed;
    private final ColorComponent color;

    public BoidEntity(PositionComponent position, SpeedComponent speed, AngleComponent angle, ColorComponent color) {
        super(new HashSet<>(Arrays.asList(new BoidComponent(),
                position,
                speed,
                angle,
                color)));

        this.position = position;
        this.angle = angle;
        this.speed = speed;
        this.color = color;
    }

    public PositionComponent position() {
        return position;
    }

    public AngleComponent angle() {
        return angle;
    }

    public SpeedComponent speed() {
        return speed;
    }

    public ColorComponent color() {
        return color;
    }
}
