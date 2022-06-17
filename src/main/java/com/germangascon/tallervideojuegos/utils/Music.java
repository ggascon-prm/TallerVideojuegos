package com.germangascon.tallervideojuegos.utils;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Music extends PlaybackListener implements Runnable {
    private boolean playing;
    private final URL fileURL;
    private AdvancedPlayer player;
    private Thread thread;
    private boolean loop;

    public Music(String path, boolean loop) throws FileNotFoundException {
        playing = false;
        this.loop = loop;
        thread = null;
        fileURL = Music.class.getResource(path);
        if(fileURL == null)
            throw new FileNotFoundException("Cannot find " + path);
    }

    public Music(String path) throws FileNotFoundException {
        this(path, false);
    }

    public void play(boolean loop) {
        this.loop = loop;
        play();
    }

    public void play() {
        if(!playing) {
            try {
                BufferedInputStream bis = new BufferedInputStream(fileURL.openStream());
                player = new AdvancedPlayer(bis);
                player.setPlayBackListener(this);
                thread = new Thread(this, "MusicThread");
                thread.start();
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
                throw new RuntimeException("Cannot find " + fileURL.getFile());
            } catch (JavaLayerException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        try {
            playing = true;
            player.play();
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        if(playing) {
            player.stop();
        }
    }

    @Override
    public void playbackStarted(PlaybackEvent playbackEvent) {
        System.out.println("Start playing");
    }

    @Override
    public void playbackFinished(PlaybackEvent playbackEvent) {
        playing = false;
        System.out.println("Stop playing");
        if(loop)
            play();
    }
}
