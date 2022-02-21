package ecs.systems;

import java.util.ArrayList;
import java.awt.Graphics;

import ecs.Entity;

public interface IDrawingSystem {
    void execute(ArrayList<Entity> entities, Graphics g);
}
