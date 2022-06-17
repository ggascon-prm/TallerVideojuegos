package com.germangascon.tallervideojuegos.game.scenes;

import com.germangascon.tallervideojuegos.engine.entities.Collider;
import com.germangascon.tallervideojuegos.engine.scene.Scene;
import com.germangascon.tallervideojuegos.engine.world.World;
import com.germangascon.tallervideojuegos.game.entities.Player;
import com.germangascon.tallervideojuegos.utils.ImageLoader;
import com.germangascon.tallervideojuegos.utils.Vector2;

import java.awt.image.BufferedImage;

public class MainScene extends Scene {
    public MainScene(World world, int minEntities) {
        super(world, minEntities);
        BufferedImage texture = ImageLoader.loadImage("/textures/playerShip.png");
        long enemies = 0x00000001;
        long bullets = 0x00000002;
        long playerMask = enemies |bullets;
        Collider collider = new Collider(texture.getWidth(), texture.getHeight(), playerMask, 10);
        Player player = new Player(new Vector2(50, 50), texture, collider, 100, 10, new Vector2(5, 0));
        entities.add(player);
    }
}
