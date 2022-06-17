package com.germangascon.tallervideojuegos.engine;

import com.germangascon.tallervideojuegos.engine.interfaces.IEngine;
import com.germangascon.tallervideojuegos.engine.scene.Scene;
import com.germangascon.tallervideojuegos.engine.screen.Screen;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable {
    private Screen screen;
    private Thread thread;
    private int width;
    private int height;
    private boolean running;
    private Scene scene;
    private int currentFPS;
    private double nsPerFrame;

    public Engine(String title, int width, int height, Scene scene, int targetFPS) {
        this.width = width;
        this.height = height;
        screen = new Screen(title, width, height);
        this.scene = scene;
        this.nsPerFrame = 1_000_000_000f / targetFPS;
        start();
    }

    private void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double nanoAcum = 0.0;
        double deltaTime = 0.0;
        long currentTime;
        long lastTime = System.nanoTime();
        int FPS = 0;
        long timer = System.nanoTime();

        while (running) {
            currentTime = System.nanoTime();
            nanoAcum += (currentTime - lastTime) / nsPerFrame;
            deltaTime += (currentTime - lastTime) / 1_000_000_000f;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(nanoAcum >= 1.0) {
                update(deltaTime);
                render();
                deltaTime = 0;
                nanoAcum--;
                FPS++;
            }
            if(timer >= 1_000_000_000) {
                timer = 0;
                currentFPS = FPS;
                FPS = 0;
            }


            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void update(double deltaTime) {
        scene.update(deltaTime);
    }

    public void render() {
        BufferStrategy bs = screen.getCanvas().getBufferStrategy();
        if (bs == null) {
            screen.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        clearScreen(g);
        scene.render(g);

        renderUI(g);
        bs.show();
        g.dispose();
    }

    public void clearScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
    }

    public void renderUI(Graphics g) {
        scene.renderUI(g);
        g.setColor(Color.BLACK);
        g.drawString("Fps: " + currentFPS, screen.getWidth() - 100, 40);
    }

    private void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
