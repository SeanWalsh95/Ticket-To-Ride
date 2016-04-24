import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
/**
 * Write a description of class GameFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameFrame extends JFrame
implements MouseListener,MouseMotionListener{
    GamePanel gp;

    Rectangle mapBounds = new Rectangle(9,39,590,885);
    Rectangle playersCardsBounds = new Rectangle(609,573,636,320); 

    public GameFrame(){
        super( "Ticket to Ride - Team 3 (2016)" );

        gp = new GamePanel();
        getContentPane().add( gp, BorderLayout.CENTER ); // add panel to frame

        addMouseListener( this );
        addMouseMotionListener( this );
    }

    public void mouseEntered( MouseEvent e ){}

    public void mousePressed( MouseEvent e ){
        Point p = e.getPoint();
        if(mapBounds.contains(p))
            gp.getClickedCity(p);
        if(playersCardsBounds.contains(p))
            gp.getClickedCard(p);
    }

    public void mouseReleased( MouseEvent e ){}

    public void mouseClicked( MouseEvent e ){}

    public void mouseExited( MouseEvent e ){}

    public void mouseDragged(MouseEvent e){}

    public void mouseMoved(MouseEvent e){}

}
