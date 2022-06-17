package com.germangascon.tallervideojuegos.engine.entities;

import com.germangascon.tallervideojuegos.engine.interfaces.IEngine;
import com.germangascon.tallervideojuegos.utils.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements IEngine {
    private final Vector2 position;
    private final BufferedImage texture;
    private final Collider collider;
    private int health;
    private double maxVelocity;
    private final Vector2 velocity;

    public Entity(Vector2 position, BufferedImage texture, Collider collider, int health, double maxVelocity, Vector2 velocity) {
        this.position = position;
        this.texture = texture;
        this.collider = collider;
        this.health = health;
        this.maxVelocity = maxVelocity;
        this.velocity = velocity;
    }

    public void applyDamage(int damage) {
        this.health -= damage;
        if(health < 0)
            health = 0;
    }

    public Vector2 getPosition() {
        return position;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public Collider getCollider() {
        return collider;
    }

    public int getHealth() {
        return health;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public boolean collidesTo(Entity e2) {
        if((collider.getMask() & e2.collider.getMask()) > 0) {
            Rectangle r1 = new Rectangle((int)position.x, (int) position.y, collider.getBoundingBox().width, collider.getBoundingBox().height);
            Rectangle r2 = new Rectangle((int)e2.position.x, (int) e2.position.y, collider.getBoundingBox().width, collider.getBoundingBox().height);
            return r1.intersects(r2);
        }
        return false;
    }
}
