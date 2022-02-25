package games.boxes.components;

import ecs.Component;

public class PositionComponent extends Component {
    private float xPos, yPos;

    public PositionComponent(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public float getPosX() {
        return xPos;
    }

    public float getPosY() {
        return yPos;
    }

    public void move(float xOffset, float yOffset) {
        xPos += xOffset;
        yPos += yOffset;
    }
}
