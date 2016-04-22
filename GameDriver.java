import javax.swing.JFrame;
/**
 * Write a description of class GameDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameDriver
{
    public static void main(String args[]){
        GameFrame gameFrame = new GameFrame();
        gameFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        gameFrame.setSize( 1276, 939 ); // set frame size
        gameFrame.setVisible( true ); // display frame
    }
}
