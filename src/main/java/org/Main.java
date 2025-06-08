package org;

import org.MusicPlayer;

import javax.sound.sampled.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("My music player");

        // resp;ve file path
        String filePath = "audio/Savin-Me-Nickelback.wav";
        File file = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
             Scanner scanner = new Scanner(System.in);) {

            // access the audio clip
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // response loop
            String response ="";
            while(!response.equals("Q")) {

                System.out.print("""
                                P to play
                                S to stop
                                R to reset
                                Q to quit
                                """);
                System.out.print("Enter your selection: ");
                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setFramePosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid input!");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Audio file not found");
        } catch (UnsupportedAudioFileException e){
            System.out.println("Unsupported audio file");
        } catch (IOException e) {
            System.out.println("Error for input");
        } catch (LineUnavailableException e) {
            System.out.println("Line unavailable");
        } finally {
            System.out.println("Thanks for playing");
        }

    }
}
