package ecs;

import java.awt.Graphics;

public class Context {
    private Graphics graphics;

    public Context(Graphics graphics) {
        this.graphics = graphics;
    }

    public Graphics getGraphics() {
        return graphics;
    }
}
