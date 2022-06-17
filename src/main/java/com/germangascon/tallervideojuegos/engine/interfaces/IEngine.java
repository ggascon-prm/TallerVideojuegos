package com.germangascon.tallervideojuegos.engine.interfaces;

import java.awt.*;

public interface IEngine {
    void update(double deltaTime);
    void render(Graphics g);
    void renderUI(Graphics g);
}
