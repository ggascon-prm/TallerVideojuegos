package com.germangascon.tallervideojuegos;

import com.germangascon.tallervideojuegos.engine.Engine;
import com.germangascon.tallervideojuegos.game.scenes.MainScene;
import com.germangascon.tallervideojuegos.game.worlds.MyWorld;

public class Main {
    public static void main(String[] args) {
        MainScene scene = new MainScene( new MyWorld(), 200);
        Engine engine = new Engine("Mi juego", 800, 600, scene, 9000);
    }

}
