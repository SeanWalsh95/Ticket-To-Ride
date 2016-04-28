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
    protected GButton backButt,purchaseButt;
    String title;

    boolean[] selectedCards;
    /**
     * Contsructor for CardSelectPanel
     * 
     * @param titleIn the text to be displayed at the top of the panel
     * @param avalableCards the list of cards to print to the screen
     */
    public CardSelectPanel(String titleIn, ArrayList<Card> avalableCards){
        JPanel self = this;
        this.setLayout(null);
        title = titleIn;

        this.background = ImgLib.woodBackground;

        selectedCards = new boolean[avalableCards.size()+1];
        cards = new ArrayList<Card>(avalableCards);
        if(avalableCards.size() > 0){
            if(avalableCards.get(0) instanceof Dest){
                cardWidth = 160;
                cardHeight = 247;
                rows = 6;
            }else{
                cardWidth = 247;
                cardHeight = 160;
                rows = 4;
            }
        }

        backButt = new GButton(new int[]{5,828,98,48},ImgLib.backButtonUnselected,ImgLib.backButtonHighlighted);
        backButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    ((JDialog)SwingUtilities.windowForComponent(self)).dispose();
                }
            });
        this.add(backButt);

        purchaseButt = new GButton(new int[]{543,828,174,51},ImgLib.purchaseButtonUnselected,ImgLib.purchaseButtonHighlighted);
        this.add(purchaseButt);
    }

    /**
     * paint component for this JPanel component
     */
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
    }

    /**
     * method to return the index of a selected card
     * 
     * @param point the point where the user clicked
     * @return return the index of the clicked card or -1 if a card was not clicked
     */
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

    /**
     * method to toggle the selection of a card
     * @param idx the index of the card to be selected
     */
    public void select(int idx){
        if(idx < cards.size() && !selectedCards[idx]){
            selectedCards[idx] = true;
        }else{
            selectedCards[idx] = false;
        }
        repaint();
    }

    /**
     * method to get the number of cards currently selected
     * 
     * @return the number of cards currently selected
     */
    public int getNumberSelected(){
        int count=0;
        for(boolean selected : selectedCards)
            if(selected)
                count++;
        return count;
    }

    /**
     * method to get the number of cards currently selected
     * 
     * @return an array of cards currently selected
     */
    public ArrayList<Card> getSelected(){
        ArrayList<Card> selected = new ArrayList<Card>();
        for(int i=0; i < cards.size();i++)
            if(selectedCards[i])
                selected.add(cards.get(i));
        return selected;
    }

    /**
     * method to get the number of cards currently unselected
     * 
     * @return an array of cards currently unselected
     */
    public ArrayList<Card> getRemainder(){
        ArrayList<Card> remainder = new ArrayList<Card>();
        for(int i=0; i < cards.size();i++)
            if(selectedCards[i])
                remainder.add(cards.get(i));
        return remainder;
    }
}
