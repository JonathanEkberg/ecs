package games.boids.components;

import ecs.Component;

public class PositionComponent extends Component {
    private float x, y;

    public PositionComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    /**
     * Moves x and y position by given x and y value.
     * 
     * @param x the amount to change x by
     * @param y the amount to change y by
     */
    public void move(double x, double y) {
        move((float) x, (float) y);
    }

    /**
     * Moves x and y position by given x and y value.
     * 
     * @param x the amount to change x by
     * @param y the amount to change y by
     */
    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Sets the x and y component of the position to the given value.
     * 
     * @param x the amount to change x by
     * @param y the amount to change y by
     */
    public void set(double x, double y) {
        set((float) x, (float) y);
    }

    /**
     * Sets the x and y component of the position to the given value.
     * 
     * @param x the amount to change x by
     * @param y the amount to change y by
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
