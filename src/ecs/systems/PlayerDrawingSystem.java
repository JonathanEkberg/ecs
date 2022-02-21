package ecs.systems;

import ecs.PerformState;
import ecs.System;
import ecs.Util;
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

        int x = (int) playerEntity.position.xPos;
        int y = (int) playerEntity.position.yPos;

        int width = (int) playerEntity.size.getWidth();
        int height = (int) playerEntity.size.getHeight();

        Util.print(String.format("%d %d %d %d", x, y, width, height));

        state.getGraphics().fillRect(x, y, width, height);
    }
}
