import javax.sound.sampled.*;
import java.applet.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class SoundLib here.
 * 
 * @author Sean Walsh
 * @version 1.0
 */
public class SoundLib
{
    public static Sound background;
    public static Sound button = new Sound("resources/sounds/buttons/button1.au");
    public static Sound turnPage = new Sound("resources/sounds/buttons/Pageturn.wav");
    public static Sound purchase = new Sound("resources/sounds/buttons/purchase.wav");
    public static Sound error = new Sound("resources/sounds/buttons/error.au");
    public static Sound gong = new Sound("resources/sounds/buttons/soundgong.au");

    public static void SoundLib() {
        playBackgroundSound();
    }

    /**
     * Generate a random number for the background sounds and sets the sound to
     * play
     */
    public static void playBackgroundSound() {
        String filePath = "";
        // instance of Random Class
        Random r = new Random();
        // set randomInt to random # between 1 and 6
        int randomInt = r.nextInt(6) + 1;
        // set the random number to play random button sound
        if (randomInt == 1) {
            filePath = "resources/sounds/backgroundSounds/america.au";
        }
        if (randomInt == 2) {
            filePath = "resources/sounds/backgroundSounds/europe.au";
        }
        if (randomInt == 3) {
            filePath = "resources/sounds/backgroundSounds/legendaryAsia.au";
        }
        if (randomInt == 4) {
            filePath = "resources/sounds/backgroundSounds/suspense.au";
        }
        if (randomInt == 5) {
            filePath = "resources/sounds/backgroundSounds/switzerland.au";
        }
        if (randomInt == 6) {
            filePath = "resources/sounds/backgroundSounds/titleTheme.au";
        }

        // plays random background sound from filePath
        background = new Sound(filePath);
        // plays audio on loop
        background.playLoop();
    }
    
    //static sub class for holding single audio files
    static class Sound{
        
        private AudioClip sound; // Sound player

        Sound(String filename) {
            try {
                sound = Applet.newAudioClip(this.getClass().getResource(filename)); // Load the Sound                
            } catch (Exception e) {
            } // Satisfy the catch
        }

        public void playLoop() {
            sound.loop(); // Play 
        }

        public void stop() {
            sound.stop(); // Play 
        }

        public void play() {
            sound.play(); // Play only once
        }
    }
}
