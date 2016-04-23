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
    JButton backButt,purchaseButt;

    boolean[] selectedCards;

    public CardSelectPanel(Image background, ArrayList<Card> avalableCards){
        this.setLayout(null);
        
        this.background = background;
        ImageLibrary image = new ImageLibrary();

        selectedCards = new boolean[avalableCards.size()];
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

        backButt = new JButton("");
        backButt.setBounds(5, 828, 98, 48);
        backButt.setIcon(new ImageIcon(image.backButtonUnselected));
        backButt.setBorderPainted(false);
        backButt.setOpaque(false);
        backButt.setContentAreaFilled(false);

        purchaseButt = new JButton("");
        purchaseButt.setBounds(543, 828, 174, 51);
        purchaseButt.setIcon(new ImageIcon(image.purchaseButtonUnselected));
        purchaseButt.setBorderPainted(false);
        purchaseButt.setOpaque(false);
        purchaseButt.setContentAreaFilled(false);

        backButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    backButt.setIcon(new ImageIcon(image.backButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    backButt.setIcon(new ImageIcon(image.backButtonUnselected));
                }
            });

        purchaseButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    purchaseButt.setIcon(new ImageIcon(image.purchaseButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    purchaseButt.setIcon(new ImageIcon(image.purchaseButtonUnselected));
                }
            });

        this.add(backButt);
        this.add(purchaseButt);
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawImage(background,0,0,this);
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

    public int getCardIndex(int x, int y){
        int row = ((x-leftBorder)-(rows*25))/cardWidth;
        int col = ((y-topBorder)-((cards.size()/rows)*25))/cardHeight;
        int index = row+col*rows;
        if(index < cards.size()){
            return index;
        }else
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

    public ArrayList<Card> getSelected(){
        ArrayList<Card> selected = new ArrayList<Card>();
        for(int i=0; i < cards.size();i++)
            if(selectedCards[i])
                selected.add(cards.get(i));
        return selected;
    }
}
