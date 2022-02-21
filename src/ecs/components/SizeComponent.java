package ecs.components;

import ecs.Component;

public class SizeComponent extends Component {
    float width;
    float height;

    public SizeComponent(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }
}
