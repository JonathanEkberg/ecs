import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ecs.Entity;
import ecs.System;
import ecs.Util;
import ecs.World;
import ecs.components.ColorComponent;
import ecs.components.PositionComponent;
import ecs.components.SizeComponent;
import ecs.entities.PlayerEntity;
import ecs.systems.PlayerDrawingSystem;
import ecs.systems.PlayerMovementSystem;

public class Game implements Runnable {
    private static final Dimension WINDOW_SIZE = new Dimension(1280, 720);
    private static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(600, 400);

    private final World world;

    public Game() {
        Entity[] entities = new Entity[100000];

        Util.println(WINDOW_SIZE.getWidth());
        Util.println(WINDOW_SIZE.getHeight());
        for (int i = 0; i < entities.length; i++) {
            float xPos = (float) (Math.random() * WINDOW_SIZE.getWidth());
            float yPos = (float) (Math.random() * WINDOW_SIZE.getHeight());
            PositionComponent position = new PositionComponent(xPos, yPos);

            float dimension = (float) (Math.random() * 100 + 50);
            SizeComponent size = new SizeComponent(dimension, dimension);

            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            ColorComponent color = new ColorComponent(new Color(r, g, b));

            entities[i] = new PlayerEntity(position, size, color);
        }

        System[] systems = new System[] {
                new PlayerDrawingSystem(),
                new PlayerMovementSystem()
        };
        this.world = new World(entities, systems);
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Game");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(MINIMUM_WINDOW_SIZE);
        frame.setSize(WINDOW_SIZE);
        frame.setPreferredSize(WINDOW_SIZE);
        frame.setLocationRelativeTo(null);
        frame.add(new Panel(world));

        frame.pack();
        frame.setVisible(true);
    }

    public World getWorld() {
        return this.world;
    }
}
