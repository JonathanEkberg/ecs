package ecs;

public class Entity {
    private static int lastId = 0;

    private final int id;

    protected final Component[] components;

    public Entity(Component[] components) {
        this.id = ++lastId;
        this.components = components;
    }

    public int getId() {
        return id;
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
