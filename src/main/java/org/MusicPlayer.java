package org;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MusicPlayer {
    private final Clip clip;

    public MusicPlayer(String filePath)
            throws FileNotFoundException, UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        File file = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    public void play() {
        if(!clip.isRunning())
            clip.start();
    }
    public void stop() {
        if(clip.isRunning())
            clip.stop();
    }
    public void reset() {
        clip.setFramePosition(0);
    }
    public void close() {
        clip.close();
    }

}
