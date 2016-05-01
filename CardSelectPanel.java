import javax.swing.*;
import java.util.*;
import java.awt.*;

/**
 * Extnsion of JPanel to be used to have a player select from a group of given
 * cards
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class CardSelectPanel extends JPanel {
    // backround image to be drawn behind everything
    Image background;
    // lists for cards passed in for selection
    ArrayList<Card> cards;
    // int's representing various static vlaues
    int cardWidth, cardHeight, rows, border = 50, topBorder = 100,
            leftBorder = 50;
    // GButton's to be pressed by the user
    protected GButton backButt;
    // String to be printed at the top of the Panel
    String title;
    // array of size cards that holds if a card is or is not selected
    boolean[] selectedCards;

    /**
     * Contsructor for CardSelectPanel
     *
     * @param titleIn       the text to be displayed at the top of the panel
     * @param avalableCards the list of cards to print to the screen
     */
    public CardSelectPanel(String titleIn, ArrayList<Card> avalableCards) {
        this.setLayout(null);
        this.background = ImgLib.woodBackground;

        // sets the title of the Panel
        title = titleIn;

        // init the boolean array to size of the passed list of cards
        selectedCards = new boolean[avalableCards.size() + 1];
        // sets the local list to refrence the passed list
        cards = new ArrayList<Card>(avalableCards);
        // sets the width and height based on the card type
        if (avalableCards.size() > 0) {
            if (avalableCards.get(0) instanceof Dest) {
                cardWidth = 160;
                cardHeight = 247;
                rows = 6;
            } else {
                cardWidth = 247;
                cardHeight = 160;
                rows = 4;
            }
        }

        // self refrence to this JPanel for button ActionListener's
        JPanel self = this;

        // adds a back GButton that closes the JDialog Class containing this
        // JPanel
        backButt = new GButton(new int[]{5, 828, 98, 48},
                ImgLib.backButtonUnselected, ImgLib.backButtonHighlighted);
        backButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ((JDialog) SwingUtilities.windowForComponent(self)).dispose();
            }
        });
        this.add(backButt);
    }

    /**
     * PaintComponent for this JPanel component
     *
     * @param g the Graphics object for this Class
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        g.setColor(Color.WHITE);

        // sets the curent font to a larger size
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 3F);
        g.setFont(newFont);

        // centers the title text
        int titleBuffer = (this.getWidth()
                - (g.getFontMetrics().stringWidth(title))) / 2;

        // paints the title text
        g.drawString(title, titleBuffer, 50);

        // paints the list of cards to the screen
        for (int i = 0; i < cards.size(); i++) {
            int x = ((i % rows) * 25) + (i % rows) * cardWidth + leftBorder;
            int y = ((i / rows) * 25) + (i / rows) * cardHeight + topBorder;
            g.drawImage(cards.get(i).getImage(), x, y, cardWidth, cardHeight,
                    this);
            if (selectedCards[i]) {
                g.setColor(new Color(225, 225, 0, 50));
                g.fillRect(x, y, cardWidth, cardHeight);
            }
        }
    }

    /**
     * method to return the index of a selected card
     *
     * @param point the point where the user clicked
     * @return return the index of the clicked card or -1 if a card was not
     * clicked
     */
    public int getCardIndex(Point point) {
        for (int i = 0; i < cards.size(); i++) {
            int x = ((i % rows) * 25) + (i % rows) * cardWidth + leftBorder;
            int y = ((i / rows) * 25) + (i / rows) * cardHeight + topBorder;
            Rectangle imageBounds = new Rectangle(x, y, cardWidth, cardHeight);
            if (imageBounds.contains(point))
                return i;
        }
        return -1;
    }

    /**
     * method to toggle the selection of a card
     *
     * @param idx the index of the card to be selected
     */
    public void select(int idx) {
        if (idx < cards.size() && !selectedCards[idx]) {
            selectedCards[idx] = true;
        } else {
            selectedCards[idx] = false;
        }
        repaint();
    }

    /**
     * method to get the number of cards currently selected
     *
     * @return the number of cards currently selected
     */
    public int getNumberSelected() {
        int count = 0;
        for (boolean selected : selectedCards)
            if (selected)
                count++;
        return count;
    }

    /**
     * method to get the number of cards currently selected
     *
     * @return an array of cards currently selected
     */
    public ArrayList<Card> getSelected() {
        ArrayList<Card> selected = new ArrayList<Card>();
        for (int i = 0; i < cards.size(); i++)
            if (selectedCards[i])
                selected.add(cards.get(i));
        return selected;
    }

    /**
     * method to get the number of cards currently unselected
     *
     * @return an array of cards currently unselected
     */
    public ArrayList<Card> getRemainder() {
        ArrayList<Card> remainder = new ArrayList<Card>();
        for (int i = 0; i < cards.size(); i++)
            if (selectedCards[i])
                remainder.add(cards.get(i));
        return remainder;
    }
}
