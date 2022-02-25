package games.boids;

import java.awt.Color;
import java.util.Random;

import ecs.EcsSystem;
import ecs.Entity;
import ecs.World;
import games.boids.components.AngleComponent;
import games.boids.components.ColorComponent;
import games.boids.components.PositionComponent;
import games.boids.components.SpeedComponent;
import games.boids.entities.BoidEntity;
import games.boids.systems.BoidDrawingSystem;
import games.boids.systems.BoidMovementSystem;
import games.boids.systems.FpsDrawingSystem;
import graphics.Panel;
import graphics.Window;

public final class Game implements Runnable {
    private static final Random rand = new Random();
    private static final Entity[] entities = createRandomEntities(10);
    private static final EcsSystem[] systems = new EcsSystem[] {
            new BoidDrawingSystem(),
            new BoidMovementSystem(),
            new FpsDrawingSystem()
    };

    private final World world;
    private final Panel panel;

    public Game() {
        world = new World(entities, systems);
        panel = new Panel(world);
        new Window(panel);
    }

    @Override
    public void run() {
        panel.run();
    }

    private static Entity[] createRandomEntities(final int entityCount) {
        Entity[] entities = new Entity[entityCount];

        for (int i = 0; i < entities.length; i++) {
            float xPos = (rand.nextInt((int) Window.WINDOW_SIZE.getWidth()));
            float yPos = (rand.nextInt((int) Window.WINDOW_SIZE.getHeight()));
            PositionComponent position = new PositionComponent(xPos, yPos);

            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            ColorComponent color = new ColorComponent(new Color(r, g, b));

            double rad = (rand.nextDouble() * 2 * Math.PI) - Double.MIN_NORMAL;
            AngleComponent angle = new AngleComponent(rad);
            SpeedComponent speed = new SpeedComponent(1);

            entities[i] = new BoidEntity(position, speed, angle, color);
        }

        return entities;
    }
}
