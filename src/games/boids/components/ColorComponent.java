package games.boids.components;

import java.awt.Color;

import ecs.Component;

public class ColorComponent extends Component {
    private Color color;

    public ColorComponent(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
