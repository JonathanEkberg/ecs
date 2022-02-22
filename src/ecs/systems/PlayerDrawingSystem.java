package ecs.systems;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ecs.PerformState;
import ecs.System;
import ecs.components.ColorComponent;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.components.SizeComponent;

public final class PlayerDrawingSystem extends System {
    private static final Set<Class<?>> components = new HashSet<>(
            Arrays.asList(PlayerComponent.class, PositionComponent.class, SizeComponent.class, ColorComponent.class));

    public PlayerDrawingSystem() {
        super(components);
    }

    @Override
    public void perform(PerformState state) {
        Graphics g = state.getGraphics();

        PositionComponent position = state.getEntity().getComponent(PositionComponent.class);
        SizeComponent size = state.getEntity().getComponent(SizeComponent.class);
        ColorComponent color = state.getEntity().getComponent(ColorComponent.class);

        int x = (int) position.getPosX();
        int y = (int) position.getPosY();

        int width = (int) size.getWidth();
        int height = (int) size.getHeight();

        g.setColor(color.getColor());
        g.fillRect(x, y, width, height);
    }
}
