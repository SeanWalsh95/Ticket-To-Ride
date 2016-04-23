import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 * Write a description of class CardSelectPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardSelectPanel extends JPanel
{
    Image background;
    ArrayList<Card> cards, selected;
    int cardWidth, cardHeight;

    public CardSelectPanel(Image background, ArrayList<Card> avalableCards){
        this.background = background;
        if(avalableCards.get(0) instanceof Dest){
            cardWidth = 160;
            cardHeight = 247;
        }else{
            cardWidth = 247;
            cardHeight = 160;
        }
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawImage(background,0,0,this);
        int rows = (this.getWidth()-100)/cardWidth;
        int x=50, y=50;
        for(Card c: cards){
            g.drawImage(c.getImage(),x,y,cardWidth,cardHeight,this);
            x += cardWidth+25;
            if((x-50)/25 > rows){
                x = 50;
                y += cardHeight+25;
            }
        }
    } // end method paintComponent

}
