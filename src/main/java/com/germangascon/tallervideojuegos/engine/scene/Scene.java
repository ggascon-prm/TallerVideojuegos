package com.germangascon.tallervideojuegos.engine.scene;

import com.germangascon.tallervideojuegos.engine.entities.Entity;
import com.germangascon.tallervideojuegos.engine.interfaces.IEngine;
import com.germangascon.tallervideojuegos.engine.world.World;

import java.util.ArrayList;


public abstract class Scene implements IEngine {
    private final World world;
    private final ArrayList<Entity> entities;

    public Scene(World world, int minEntities) {
        this.world = world;
        entities = new ArrayList<>(minEntities);
    }

    @Override
    public void update() {
        world.update();
        for(Entity e: entities)
            e.update();
    }

    @Override
    public void render() {
        world.render();
        for(Entity e: entities)
            e.render();
    }

    @Override
    public void renderUI() {
        world.renderUI();
        for(Entity e: entities)
            e.renderUI();
    }
}
