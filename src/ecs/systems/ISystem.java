package ecs.systems;

import java.util.ArrayList;

import ecs.Entity;

public interface ISystem {
    void execute(ArrayList<Entity> entities);
}
