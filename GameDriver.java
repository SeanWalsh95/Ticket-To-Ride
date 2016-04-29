import javax.sound.sampled.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;

/**
 * Write a description of class GameDriver here.
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class GameDriver {
    static Clip clip;

    public static void main(String args[]) {
        ImgLib.ImageLibrary();

        playBackgroundSound();

        JDialog menuDialog = new JDialog(
                new JFrame("Ticket to Ride - Team 3 (2016) [MENU]"), true);
        MenuPanel mp = new MenuPanel();
        menuDialog.setSize(1276, 939); // set frame size
        menuDialog.add(mp);
        menuDialog.setVisible(true);

        JFrame gameFrame = new JFrame("Ticket to Ride - Team 3 (2016)");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(1276, 989); // set frame size

        // creates new GamePanel, passing player list form the MenuPanel
        GamePanel gp = new GamePanel(mp.players);
        gameFrame.add(gp, BorderLayout.CENTER); // add panel to frame

        gameFrame.setVisible(true); // display frame

        clip.close();
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
        try (AudioInputStream inputStream = AudioSystem
                .getAudioInputStream(new File(filePath))) {
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            // plays audio on loop
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println("Cannot find sound file: \"" + filePath + "\"");
        }
    }
}
