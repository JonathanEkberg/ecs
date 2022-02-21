package ecs;

import java.util.ArrayList;

public class Entity {
    protected final ArrayList<Component> components;

    public Entity(Component[] components) {
        this.components = new ArrayList<>(components.length);

        for (Component component : components) {
            this.components.add(component);
        }
    }

    public Component[] getComponents() {
        return components.toArray(new Component[0]);
    }

    public boolean hasComponent(Class<?> searcing) {
        for (Component component : components) {
            if (component.getClass().isAssignableFrom(searcing.getClass())) {
                return true;
            }
        }

        return false;
    }
}
