package com.germangascon.tallervideojuegos.engine.scene;

import com.germangascon.tallervideojuegos.engine.entities.Entity;
import com.germangascon.tallervideojuegos.engine.interfaces.IEngine;
import com.germangascon.tallervideojuegos.engine.world.World;

import java.awt.*;
import java.util.ArrayList;


public abstract class Scene implements IEngine {
    protected final World world;
    protected final ArrayList<Entity> entities;

    public Scene(World world, int minEntities) {
        this.world = world;
        entities = new ArrayList<>(minEntities);
    }

    @Override
    public void update(double deltaTime) {
        world.update(deltaTime);
        for(Entity e: entities)
            e.update(deltaTime);
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        for(Entity e: entities)
            e.render(g);
    }

    @Override
    public void renderUI(Graphics g) {
        world.renderUI(g);
        for(Entity e: entities)
            e.renderUI(g);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
