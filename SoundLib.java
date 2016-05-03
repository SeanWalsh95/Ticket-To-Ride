import javax.sound.sampled.*;
import java.applet.*;
import java.util.*;
import java.io.*;
/**
 * A Class to hold the sounds played in the game
 * 
 * @author Team 3
 * @version 1.0
 */
public class SoundLib
{
    public static Sound background;
    public static Sound button =
        new Sound("resources/sounds/buttons/button1.au");
    public static Sound turnPage =
        new Sound("resources/sounds/buttons/Pageturn.wav");
    public static Sound purchase =
        new Sound("resources/sounds/buttons/purchase.wav");
    public static Sound error =
        new Sound("resources/sounds/buttons/error.au");

    /**
     * static initializer for this calss
     */
    public static void SoundLib() {
        //grab filepath of soundtrack
        String filePath =
            "resources/sounds/backgroundSounds/tryEverything.au";
        // plays random background sound from filePath
        background = new Sound(filePath);
        // plays audio on loop
        background.playLoop();
    }

    //static sub class for holding single audio files
    static class Sound{

        private AudioClip sound; // Sound player
        
        /**
         * Constructor for sound
         * 
         * @param filename The path of the sound file
         */
        Sound(String filename) {
            try {
                sound = Applet.newAudioClip(
                    this.getClass().getResource(filename)); // Load the Sound                
            } catch (Exception e) {
            } // Satisfy the catch
        }

        /**
         * Play sound on a loop
         */
        public void playLoop() {
            sound.loop(); // Play 
        }

        /**
         * stop sound
         */
        public void stop() {
            sound.stop(); // Play 
        }

        /**
         * play sound once
         */
        public void play() {
            sound.play(); // Play only once
        }
    }
}
