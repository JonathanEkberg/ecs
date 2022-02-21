package ecs;

public class Entity {
    protected final Component[] components;

    public Entity(Component[] components) {
        this.components = components;
    }

    public Component[] getComponents() {
        return components;
    }

    public boolean hasComponent(Class<?> searching) {
        for (Component component : components) {
            if (searching.isAssignableFrom(component.getClass())) {
                return true;
            }
        }

        return false;
    }
}
