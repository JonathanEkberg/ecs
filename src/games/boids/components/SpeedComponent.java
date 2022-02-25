package games.boids.components;

import ecs.Component;

public class SpeedComponent extends Component {
    private float speed;

    public SpeedComponent(float speed) {
        this.speed = speed;
    }

    public float value() {
        return speed;
    }

    public void accelerate(float speed) {
        this.speed += speed;
    }
}
