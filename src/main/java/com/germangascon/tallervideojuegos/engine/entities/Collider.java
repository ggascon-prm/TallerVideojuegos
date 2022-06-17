package com.germangascon.tallervideojuegos.engine.entities;

import java.awt.*;

public class Collider {
    private final Rectangle boundingBox;
    private long mask;
    private int damage;

    public Collider(int width, int height, long mask, int damage) {
        boundingBox = new Rectangle(0, 0, width, height);
        this.mask = mask;
        this.damage = damage;
    }

    public long getMask() {
        return mask;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}
