package games.boxes;

import java.awt.Color;
import java.util.Random;

import ecs.EcsSystem;
import ecs.Entity;
import ecs.World;
import games.boxes.components.ColorComponent;
import games.boxes.components.PositionComponent;
import games.boxes.components.SizeComponent;
import games.boxes.entities.PlayerEntity;
import games.boxes.systems.FpsDrawingSystem;
import games.boxes.systems.PlayerDrawingSystem;
import games.boxes.systems.PlayerMovementSystem;
import graphics.Panel;
import graphics.Window;

public final class Game implements Runnable {
    private static final Random rand = new Random();
    private static final Entity[] entities = createRandomEntities(1_000);
    private static final EcsSystem[] systems = new EcsSystem[] {
            new PlayerDrawingSystem(),
            new PlayerMovementSystem(),
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

            float dimension = (rand.nextInt(200) + 20);
            SizeComponent size = new SizeComponent(dimension, dimension);

            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            ColorComponent color = new ColorComponent(new Color(r, g, b));

            entities[i] = new PlayerEntity(position, size, color);
        }

        return entities;
    }
}
