import java.applet.Applet;
import java.applet.AudioClip;
import java.net.*;

    public class Sound{ // Holds one audio file

        private AudioClip sound; // Sound player
        private URL url; // Sound path

        Sound(String filename) {
            try {
                url = this.getClass().getResource(filename); // Get the Sound URL
                sound = Applet.newAudioClip(url); // Load the Sound                
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