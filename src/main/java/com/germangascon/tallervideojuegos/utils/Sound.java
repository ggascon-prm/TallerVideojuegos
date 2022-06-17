package com.germangascon.tallervideojuegos.utils;

import javax.sound.sampled.*;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * No es necesario que esta clase sea un Thread
 * ya que Clip lo implementa internamente
 */
public class Sound implements LineListener {
    public boolean done;
    private final Clip clip;

    public Sound(String path) throws FileNotFoundException {
        try {
            done = false;
            InputStream is = Sound.class.getResourceAsStream(path);
            if(is == null)
                throw new FileNotFoundException("Cannot find " + path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
            clip = AudioSystem.getClip();
            clip.addLineListener(this);
            clip.open(audioInputStream);
        } catch (Exception e) {
            throw new FileNotFoundException("Cannot find " + path);
        }
    }

    public void play() {
        play(0);
    }

    public void stop() {
        clip.stop();
    }

    public void play(boolean loop) {
        if(loop)
            play(-1);
        else
            play(0);
    }

    public void play(int loopCount) {
        clip.setFramePosition(0);
        if(loopCount == -1)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        if(loopCount > 0)
            clip.loop(loopCount);
        else {
            clip.start();
        }
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type eventType = event.getType();
        if (eventType == LineEvent.Type.STOP) {
            System.out.println("Finalizado");
            clip.close();
        }
    }
}
