package ecs.systems;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

import ecs.Component;
import ecs.Entity;
import ecs.PerformState;
import ecs.System;
import ecs.components.ColorComponent;
import ecs.components.PlayerComponent;
import ecs.components.PositionComponent;
import ecs.components.SizeComponent;

public final class PlayerDrawingSystem extends System {
    private static final Set<Class<?>> components = new HashSet<>(
            Arrays.asList(PlayerComponent.class, PositionComponent.class, SizeComponent.class, ColorComponent.class));
    private static final WeakHashMap<Integer, Component[]> componentMap = new WeakHashMap<>();

    public PlayerDrawingSystem() {
        super(components);
    }

    @Override
    protected boolean debug() {
        return true;
    }

    @Override
    public void perform(Entity entity, Graphics graphics, int fps, int delta, int drawDelta) {
        PositionComponent position;
        SizeComponent size;
        ColorComponent color;

        if (!componentMap.containsKey(entity.hashCode())) {
            position = entity.getComponent(PositionComponent.class);
            size = entity.getComponent(SizeComponent.class);
            color = entity.getComponent(ColorComponent.class);

            componentMap.put(entity.hashCode(), new Component[] { position, size, color });
        } else {
            Component[] components = componentMap.get(entity.hashCode());

            position = (PositionComponent) components[0];
            size = (SizeComponent) components[1];
            color = (ColorComponent) components[2];
        }

        int x = (int) position.getPosX();
        int y = (int) position.getPosY();

        int width = (int) size.getWidth();
        int height = (int) size.getHeight();

        graphics.setColor(color.getColor());
        graphics.fillRect(x, y, width, height);
    }
}
