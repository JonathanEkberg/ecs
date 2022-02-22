package ecs;

import java.util.Set;

public class Entity {
    protected final Set<Component> components;
    private final Component[] componentArr;

    public Entity(final Set<Component> components) {
        this.components = components;
        this.componentArr = components.toArray(new Component[components.size()]);
    }

    public Component[] getComponents() {
        return componentArr;
    }

    /**
     * Returns true if the entity has the given component.
     * 
     * @param searching
     * @return
     */
    public boolean hasComponent(final Class<?> searching) {
        return this.getComponent(searching) != null;
    }

    /**
     * Finds and returns the component of class searching.
     * 
     * @param searching the class of the component requested.
     * @return the component of the class searching
     * @throws IllegalArgumentException if the entity does not have a component of
     *                                  the given class
     */
    public <T extends Component> T getComponent(final Class<?> searching) {
        for (Component component : components) {
            if (searching.isAssignableFrom(component.getClass())) {
                return (T) component;
            }
        }

        throw new IllegalArgumentException("The specified component of class does not exist.");
    }
}
