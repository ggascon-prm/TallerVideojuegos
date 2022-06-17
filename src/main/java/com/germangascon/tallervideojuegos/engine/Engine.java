package com.germangascon.tallervideojuegos.engine;

import com.germangascon.tallervideojuegos.engine.interfaces.IEngine;
import com.germangascon.tallervideojuegos.engine.screen.Screen;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine implements IEngine, Runnable {
    private Screen screen;
    private Thread thread;
    private int width;
    private int height;
    private boolean running;

    public Engine(String title, int width, int height) {
        this.width = width;
        this.height = height;
        screen = new Screen(title, width, height);
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
        while(running) {
            update();
            render();
            renderUI();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        BufferStrategy bs = screen.getCanvas().getBufferStrategy();
        if (bs == null) {
            screen.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(50, 50, 50, 50);
        g.drawString("Hola", 10, 15);
        bs.show();
        g.dispose();
    }

    @Override
    public void renderUI() {

    }
}
