package ecs.systems;

import java.awt.Graphics;

import ecs.Component;
import ecs.DrawingSystem;
import ecs.Entity;
import ecs.Util;
import ecs.components.PlayerComponent;
import ecs.entities.PlayerEntity;

public class PlayerDrawingSystem extends DrawingSystem {
    public PlayerDrawingSystem() {
        super(new Component[] {
                new PlayerComponent(),
        });
    }

    @Override
    protected void perform(Entity entity, Graphics g) {
        PlayerEntity playerEntity = (PlayerEntity) entity;

        int x = (int) playerEntity.position.xPos;
        int y = (int) playerEntity.position.yPos;

        int width = (int) playerEntity.size.getWidth();
        int height = (int) playerEntity.size.getHeight();

        Util.print(String.format("%d %d %d %d", x, y, width, height));

        g.fillRect(x, y, width, height);
    }
}
