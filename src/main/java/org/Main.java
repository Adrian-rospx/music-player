package org;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("My music player");

        try (Scanner scanner = new Scanner(System.in)) {
            // set song file path
            String filePath = "audio/Savin-Me-Nickelback.wav";
            // create a music player for the song
            MusicPlayer player = new MusicPlayer(filePath);
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

                // manage responses
                switch (response) {
                    case "P" -> player.play();
                    case "S" -> player.stop();
                    case "R" -> player.reset();
                    case "Q" -> player.close();
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
