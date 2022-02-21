package ecs.systems;

import java.awt.Graphics;

import ecs.PerformState;
import ecs.System;
import ecs.components.PlayerComponent;
import ecs.entities.PlayerEntity;

public class PlayerDrawingSystem extends System {
    public PlayerDrawingSystem() {
        super(new Class<?>[] {
                PlayerComponent.class
        });
    }

    @Override
    public void perform(PerformState state) {
        PlayerEntity playerEntity = (PlayerEntity) state.getEntity();
        Graphics g = state.getGraphics();

        int x = (int) playerEntity.getPosition().getPosX();
        int y = (int) playerEntity.getPosition().getPosY();

        int width = (int) playerEntity.getSize().getWidth();
        int height = (int) playerEntity.getSize().getHeight();

        g.setColor(playerEntity.getColor().getColor());
        g.fillRect(x, y, width, height);
    }
}
