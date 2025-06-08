package org;

import org.MusicPlayer;

import javax.sound.sampled.*;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("My music player");

        String filePath = "audio/Savin-Me-Nickelback.wav";
        File file = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("No problems");

        } catch (FileNotFoundException e) {
            System.out.println("Audio file not found");
        } catch (UnsupportedAudioFileException e){
            System.out.println("Unsupported audio file");
        } catch (IOException e) {
            System.out.println("Error for input");
        } catch (LineUnavailableException e) {
            System.out.println("Line unavailable");
        }

    }
}
