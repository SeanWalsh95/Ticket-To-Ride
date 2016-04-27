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
    int cardWidth, cardHeight ,rows, border = 50, topBorder = 100, leftBorder = 50;
    //JButton backButt,purchaseButt;
    GButton backButt,purchaseButt;
    String title;

    boolean[] selectedCards;

    public CardSelectPanel(String titleIn, ArrayList<Card> avalableCards){
        this.setLayout(null);
        title = titleIn;

        this.background = ImgLib.woodBackground;

        selectedCards = new boolean[avalableCards.size()+1];
        cards = new ArrayList<Card>(avalableCards);
        if(avalableCards.get(0) instanceof Dest){
            cardWidth = 160;
            cardHeight = 247;
            rows = 6;
        }else{
            cardWidth = 247;
            cardHeight = 160;
            rows = 4;
        }

        
        backButt = new GButton(new int[]{5,828,98,48},ImgLib.backButtonUnselected,ImgLib.backButtonHighlighted);
        this.add(backButt);
        
        purchaseButt = new GButton(new int[]{5,828,98,48},ImgLib.backButtonUnselected,ImgLib.backButtonHighlighted);
        this.add(purchaseButt);
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawImage(background,0,0,this);
        g.setColor(Color.WHITE);

        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 3F);
        g.setFont(newFont);
        int titleBuffer = (this.getWidth()-(g.getFontMetrics().stringWidth(title)))/2;
        g.drawString(title,titleBuffer,50);

        //int x=58, y=110;
        for(int i=0; i < cards.size();i++){
            int x = ((i%rows)*25)+(i%rows)*cardWidth+leftBorder;
            int y = ((i/rows)*25)+(i/rows)*cardHeight+topBorder;
            g.drawImage(cards.get(i).getImage(),x,y,cardWidth,cardHeight,this);
            if(selectedCards[i]){
                g.setColor(new Color(225,225,0,50));
                g.fillRect(x,y,cardWidth,cardHeight);
            }
        }
    } // end method paintComponent

    public int getCardIndex(Point point){
        for(int i=0; i < cards.size();i++){
            int x = ((i%rows)*25)+(i%rows)*cardWidth+leftBorder;
            int y = ((i/rows)*25)+(i/rows)*cardHeight+topBorder;
            Rectangle imageBounds = new Rectangle(x,y,cardWidth, cardHeight);
            if (imageBounds.contains(point))
                return i;
        }
        return -1;
    }

    public void select(int idx){
        if(idx < cards.size() && !selectedCards[idx]){
            selectedCards[idx] = true;
        }else{
            selectedCards[idx] = false;
        }
        repaint();
    }

    public int getNumberSelected(){
        int count=0;
        for(boolean selected : selectedCards)
            if(selected)
                count++;
        return count;
    }

    public ArrayList<Card> getSelected(){
        ArrayList<Card> selected = new ArrayList<Card>();
        for(int i=0; i < cards.size();i++)
            if(selectedCards[i])
                selected.add(cards.get(i));
        return selected;
    }
}
