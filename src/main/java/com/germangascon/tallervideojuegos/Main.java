package com.germangascon.tallervideojuegos;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi juego");
        int width = 800;
        int height = 600;
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showOnDisplay(1, frame);
        frame.setVisible(true);

        Canvas canvas = new Canvas();
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


}
