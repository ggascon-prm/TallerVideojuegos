package com.germangascon.tallervideojuegos.engine.screen;

import javax.swing.*;
import java.awt.*;

public class Screen {
    private final JFrame frame;
    private final Canvas canvas;
    private int width;
    private int height;

    public Screen(String title, int width, int height) {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showOnDisplay(1, frame);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public static void showOnDisplay(int display, JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        if( display > -1 && display < gd.length ) {
            GraphicsConfiguration graphicsConfiguration = gd[display].getDefaultConfiguration();
            int screenWidth = graphicsConfiguration.getBounds().width;
            int screenHeight = graphicsConfiguration.getBounds().height;
            frame.setLocation(graphicsConfiguration.getBounds().x + (screenWidth / 2) - (frame.getBounds().width / 2),
                    graphicsConfiguration.getBounds().y + (screenHeight / 2) - (frame.getBounds().height / 2));
        } else if( gd.length > 0 ) {
            frame.setLocation(gd[0].getDefaultConfiguration().getBounds().x, frame.getY());
        } else {
            throw new RuntimeException( "No Screens Found" );
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
