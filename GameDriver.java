import javax.swing.JFrame;
import java.awt.*;
/**
 * Write a description of class GameDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameDriver
{
    public static void main(String args[]){
        ImgLib.ImageLibrary();
        JFrame gameFrame = new JFrame("Ticket to Ride - Team 3 (2016)");

        gameFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        gameFrame.setSize( 1276, 939 ); // set frame size

        GamePanel gp = new GamePanel();
        gameFrame.add( gp, BorderLayout.CENTER ); // add panel to frame

        gameFrame.setVisible( true ); // display frame
    }
}
