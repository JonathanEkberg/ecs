package games.boids.components;

import ecs.Component;

public class AngleComponent extends Component {
    private static final float TWO_PI = (float) Math.PI * 2;
    private static final float ONE_EIGHTY_OVER_PI = (float) (180 / Math.PI);

    /**
     * This components angle represented in radians.
     */
    private float angleRad;
    /**
     * This components angle represented in radians.
     */
    private float angleDeg;

    /**
     * Constructs an AngleComponent class.
     * 
     * @param angle in radians
     */
    public AngleComponent(double angle) {
        angleRad = truncate(angle);
        angleDeg = radToDeg(angleRad);
    }

    /**
     * Constructs an AngleComponent class.
     * 
     * @param angle in radians
     */
    public AngleComponent(float angle) {
        angleRad = truncate(angle);
        angleDeg = radToDeg(angleRad);
    }

    /**
     * Gets the angle in radians.
     * 
     * @return this components angle in radians.
     */
    public float rad() {
        return angleRad;
    }

    /**
     * Gets the angle in degrees.
     * 
     * @return this components angle in degrees.
     */
    public float deg() {
        return angleDeg;
    }

    /**
     * Changes the angle by 'angle' amount.
     * 
     * @param angle amount to rotate by in radians
     */
    public void rotate(float angle) {
        this.set(angleRad + angle);
    }

    /**
     * Sets the angle in radians.
     * 
     * @param angle the new angle in radians
     */
    public void set(double angle) {
        set((float) angle);
    }

    /**
     * Restricts angle argument to be within 0 and 2π.
     * 
     * @param angle angle in radians
     * @return the angle within the range 0 and 2π
     */
    private static float truncate(double angle) {
        return truncate((float) angle);
    }

    /**
     * Sets the angle in radians.
     * 
     * @param angle the new angle in radians
     */
    public void set(float angle) {
        angleRad = truncate(angle);
        angleDeg = radToDeg(angleRad);
    }

    /**
     * Restricts angle argument to be within 0 and 2π.
     * 
     * @param angle angle in radians
     * @return the angle within the range 0 and 2π
     */
    private static float truncate(float angle) {
        if (angle > TWO_PI) {
            System.out.println(String.format("TRUNCATING FROM: %d, TO: %d", angle, angle - TWO_PI));
            return angle - TWO_PI;
        } else if (angle < 0) {
            System.out.println(String.format("TRUNCATING FROM: %d, TO: %d", angle, TWO_PI - angle));
            return TWO_PI - angle;
        }

        return angle;
    }

    /**
     * Converts angle from radians to degrees.
     * 
     * @param angle the angle in radians
     * @return the angle in degrees
     */
    private static float radToDeg(float angle) {
        return angle * ONE_EIGHTY_OVER_PI;
    }

    /**
     * Converts angle from radians to degrees.
     * 
     * @param angle the angle in degrees
     * @return the angle in radians
     */
    private static float degToRad(float angle) {
        return angle / ONE_EIGHTY_OVER_PI;
    }
}
