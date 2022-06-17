package com.germangascon.tallervideojuegos.utils;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2 copy() {
        return new Vector2(this);
    }

    public Vector2 add(Vector2 v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public static Vector2 add(Vector2 v1, Vector2 v2) {
        Vector2 result = new Vector2();
        result.x = v1.x + v2.x;
        result.y = v1.y + v2.y;
        return result;
    }

    public Vector2 sub(Vector2 v) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public static Vector2 sub(Vector2 v1, Vector2 v2) {
        Vector2 result = new Vector2();
        result.x = v1.x - v2.x;
        result.y = v1.y - v2.y;
        return result;
    }

    public double dot(Vector2 v) {
        return x * v.x + y * v.y;
    }

    public Vector2 mulAdd(Vector2 v, double scalar) {
        this.x += v.x * scalar;
        this.y += v.y * scalar;
        return this;
    }

    public double magnitude() {
        return Math.sqrt((Math.pow((x), 2) + Math.pow((y), 2)));
    }

    public double distance(Vector2 v) {
        final double x_d = v.x - x;
        final double y_d = v.y - y;
        return Math.sqrt(x_d * x_d + y_d * y_d);
    }

    public static double distance(Vector2 v1, Vector2 v2) {
        final double x_d = v1.x - v2.x;
        final double y_d = v1.y - v2.y;
        return Math.sqrt(x_d * x_d + y_d * y_d);
    }

    public static double magnitude(Vector2 v) {
        return Math.sqrt((Math.pow((v.x), 2) + Math.pow((v.y), 2)));
    }

    public Vector2 normalize() {
        double len = magnitude();
        if(len != 0) {
            x /= len;
            y /= len;
        }
        return this;
    }

    public static Vector2 normalize(Vector2 v) {
        Vector2 result = new Vector2(v);
        double len = magnitude(v);
        if(len != 0) {
            result.x = v.x / len;
            result.y = v.y / len;
        }
        return result;
    }

    public Vector2 scale(double scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    public static Vector2 scale(Vector2 v, double scalar) {
        Vector2 result = new Vector2(v);
        v.x *= scalar;
        v.y *= scalar;
        return result;
    }
}
