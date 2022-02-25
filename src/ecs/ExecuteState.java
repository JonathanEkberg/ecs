package ecs;

public class ExecuteState extends PerformState {
    private Entity[] entities;

    public ExecuteState(int fps, int delta, int drawDelta, Entity[] entities) {
        super(fps, delta, drawDelta);
        this.entities = entities;
    }

    public Entity[] getEntities() {
        return entities;
    }
}
