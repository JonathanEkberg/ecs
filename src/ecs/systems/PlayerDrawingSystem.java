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
        Util.println("HEY");
        PlayerEntity playerEntity = (PlayerEntity) state.getEntity();

        int x = (int) playerEntity.getPosition().xPos;
        int y = (int) playerEntity.getPosition().yPos;

        int width = (int) playerEntity.getSize().getWidth();
        int height = (int) playerEntity.getSize().getHeight();

        Util.print(String.format("%d %d %d %d", x, y, width, height));

        state.getGraphics().fillRect(x, y, width, height);
    }
}
