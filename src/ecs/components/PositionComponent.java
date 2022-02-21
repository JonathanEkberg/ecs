package ecs.components;

import ecs.Component;

public class PositionComponent extends Component {
    public float xPos, yPos;

    public PositionComponent(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
