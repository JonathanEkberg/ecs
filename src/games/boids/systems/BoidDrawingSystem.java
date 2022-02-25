package games.boids.systems;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ecs.EcsSystem;
import ecs.Entity;
import games.boids.components.AngleComponent;
import games.boids.components.BoidComponent;
import games.boids.components.ColorComponent;
import games.boids.components.PositionComponent;
import graphics.Window;

public final class BoidDrawingSystem extends EcsSystem {
    private static final Set<Class<?>> components = new HashSet<>(
            Arrays.asList(BoidComponent.class, PositionComponent.class, ColorComponent.class));

    public BoidDrawingSystem() {
        super(components);
    }

    @Override
    public void perform(Entity entity, Graphics graphics, int fps, int delta, int frame, int drawDelta) {
        PositionComponent position = entity.getComponent(PositionComponent.class);
        AngleComponent angle = entity.getComponent(AngleComponent.class);
        ColorComponent color = entity.getComponent(ColorComponent.class);

        int width = 40;
        int[][] positions = getTrianglePositions(position, angle, width);

        // // OVERFLOW DETECTION SHOULD NOT BE HERE CHANGE THIS IN THE NEAR FUTURE
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                if (positions[i][j] < 0) {
                    position.set((Window.WINDOW_SIZE.getWidth() - width * 1.25),
                            (float) (Window.WINDOW_SIZE.getHeight() - width * 1.25));
                    angle.set(3 * (Math.PI / 4));
                    positions = getTrianglePositions(position, angle, width);
                }
            }
        }

        graphics.setColor(color.getColor());
        graphics.fillPolygon(positions[0], positions[1], 3);
    }

    private int[][] getTrianglePositions(PositionComponent pos, AngleComponent angle, float width) {
        int x = (int) pos.x();
        int[] xPoints = new int[] {
                (int) (x + (width * Math.cos(angle.rad()))),
                (int) (x + ((width / 3d) * Math.cos(angle.rad() + (Math.PI / 2)))),
                (int) (x + ((width / 3d) * Math.cos(angle.rad() + ((3 * Math.PI) / 2))))
        };

        int y = (int) pos.y();
        int[] yPoints = new int[] {
                (int) (y + (width * Math.sin(angle.rad()))),
                (int) (y + ((width / 3d) * Math.sin(angle.rad() + (Math.PI / 2)))),
                (int) (y + ((width / 3d) * Math.sin(angle.rad() + ((3 * Math.PI) / 2))))
        };

        return new int[][] { xPoints, yPoints };
    }
}
