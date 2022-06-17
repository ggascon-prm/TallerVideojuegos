package com.germangascon.tallervideojuegos.game.entities;

import com.germangascon.tallervideojuegos.engine.entities.Collider;
import com.germangascon.tallervideojuegos.engine.entities.Entity;
import com.germangascon.tallervideojuegos.utils.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    public Player(Vector2 position, BufferedImage texture, Collider collider, int health, double maxVelocity, Vector2 velocity) {
        super(position, texture, collider, health, maxVelocity, velocity);
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getTexture(), (int)getPosition().x, (int)getPosition().y, null);
    }

    @Override
    public void renderUI(Graphics g) {

    }
}
