import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.*;
/**
 * Write a description of class GameFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameFrame extends JFrame
implements MouseListener,MouseMotionListener{

    GamePanel gp;
    CardSelectPanel csp;

    public GameFrame(){
        super( "Ticket to Ride - Team 3 (2016)" );
        
        ImageLibrary image = new ImageLibrary();
        DeckBuilder db = new DeckBuilder();
        
        //gp = new GamePanel();
        //getContentPane().add( gp, BorderLayout.CENTER ); // add panel to frame

        csp = new CardSelectPanel(image.viewTech ,db.tech);
        getContentPane().add( csp, BorderLayout.CENTER ); // add panel to frame

        addMouseListener( this );
        addMouseMotionListener( this );
    }

    public void actionPerformed(ActionEvent e){}

    public void mouseEntered( MouseEvent e ){}

    public void mousePressed( MouseEvent e ){
        int x = e.getX();
        int y = e.getY();
        csp.select(csp.getCardIndex(x,y));
    }

    public void mouseReleased( MouseEvent e ){}

    public void mouseClicked( MouseEvent e ){}

    public void mouseExited( MouseEvent e ){}

    public void mouseDragged(MouseEvent e){}

    public void mouseMoved(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        //gp.mouseCheckHoverCity(x,y);
    }

}
