import javax.sound.sampled.*;
import java.applet.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class SoundLib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
