import javax.swing.*;
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
        
        JDialog menuDialog = new JDialog(new JFrame("Ticket to Ride - Team 3 (2016) [MENU]"),true);
        MenuPanel mp = new MenuPanel();
        menuDialog.setSize( 1276, 939 ); // set frame size
        menuDialog.add(mp);
        menuDialog.setVisible(true);
        
        
        JFrame gameFrame = new JFrame("Ticket to Ride - Team 3 (2016)");
        gameFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        gameFrame.setSize( 1276, 989 ); // set frame size

        //creates new GamePanel, passing player list form the MenuPanel
        GamePanel gp = new GamePanel(mp.players);
        gameFrame.add( gp, BorderLayout.CENTER ); // add panel to frame

        gameFrame.setVisible( true ); // display frame
        
    }
}
