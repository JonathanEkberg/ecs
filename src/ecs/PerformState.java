package ecs;

public class PerformState {
    private int fps;
    private int delta;
    private int drawDelta;

    public PerformState(int fps, int delta, int drawDelta) {
        this.fps = fps;
        this.delta = delta;
        this.drawDelta = drawDelta;
    }

    public int fps() {
        return fps;
    }

    public int delta() {
        return delta;
    }

    public int drawDelta() {
        return drawDelta;
    }
}
