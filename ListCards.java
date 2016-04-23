import java.util.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class ListCards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListCards extends JFrame
implements MouseListener{
    
    // instance variables - replace the example below with your own
    private int x;
    boolean selectedCards[] = new boolean[5];

    /**
     * Constructor for objects of class ListCards
     */
    public ListCards(ArrayList<Card> cards)
    {
        super( "Pick your starting cards" );
    }

    public void mouseEntered( MouseEvent e ){}

    public void mousePressed( MouseEvent e ){}

    public void mouseReleased( MouseEvent e ){}

    public void mouseClicked( MouseEvent e ){}

    public void mouseExited( MouseEvent e ){}

}
