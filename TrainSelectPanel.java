import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 * Write a description of class TrainSelectPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainSelectPanel extends JPanel {

    // backround image to be drawn behind everything
    Image background;

    // int's representing various static vlaues
    int cardWidth = 147, cardHeight = 94, rows = 2;
    // String to be printed at the top of the Panel
    String title;

    ArrayList<Card> selected, hand;

    //order of printed cards
    RouteColor[] order = new RouteColor[]{RouteColor.BLACK,
            RouteColor.GREEN, RouteColor.BLUE, RouteColor.YELLOW,
            RouteColor.NEUTRAL, RouteColor.ORANGE, RouteColor.RED,
            RouteColor.WHITE, RouteColor.PINK};

    /**
     * Constructor for objects of class TrainSelectPanel
     */
    public TrainSelectPanel(String title, ArrayList<Card> playersHand)
    {
        JPanel self = this;
        this.setLayout(null);
        //makes the mouse cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor a = toolkit.createCustomCursor(ImgLib.mouseCursor,
                new Point(this.getX(),this.getY()), "img");
        setCursor(a);
        this.background = ImgLib.trainPickerBackground;
        this.title = title;
        this.hand = new ArrayList<Card>(playersHand);
        this.selected = new ArrayList<Card>();

        GButton purchaseButt = new GButton(
                new int[]{543,828,174,51},
                ImgLib.confirmPurchaseButtonUnselected,
                ImgLib.confirmPurchaseButtonHighlighted);
        //JButton purchaseButt = new JButton("Confirm");
        //purchaseButt.setBounds(543,828,174,51);
        purchaseButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    SoundLib.purchase.play();
                    ((JDialog) SwingUtilities.windowForComponent(self)).dispose();
                }
            });
        this.add(purchaseButt);
    }

    /**
     * PaintComponent for this JPanel component
     *
     * @param g the Graphics object for this Class
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);

        // sets the curent font to a larger size
        g.setFont(new Font("Wide Latin", Font.PLAIN, 30));
        g.setColor(Color.WHITE);

        // centers the title text
        int titleBuffer = 
            (this.getWidth()-(g.getFontMetrics().stringWidth(title))) / 2;

        // paints the title text
        g.drawString(title, titleBuffer, 50);

        g.drawString("Your Hand", 170, 150);
        g.drawString("Selected Cards", 790, 150);

        g.setFont(new Font("Wide Latin", Font.PLAIN, 12));
        drawCards(g,155,184,hand);
        drawCards(g,801,184,selected);

    }

    public void drawCards(Graphics g,int leftBorder, int topBorder, ArrayList<Card> list){
        JPanel self = this;

        for (int i = 0; i < 9; i++) {
            int x = ((i % rows) * 60) + (i % rows) * cardWidth + leftBorder;
            int y = ((i / rows) * 10) + (i / rows) * cardHeight + topBorder;
            int count = CardCounter.countTrainColor(list, order[i]);
            if (count >= 0) {
                g.drawImage(Train.getImage(order[i]), x, y, cardWidth,
                    cardHeight, this);
                if(list == hand)
                    g.setColor(Color.WHITE);
                else
                    g.setColor(Color.RED);
                g.drawString(count + "", x - 15, y + 25);
                RouteColor rc = order[i];
                JLabel lbl = new JLabel();
                lbl.setBounds(x, y, cardWidth, cardHeight);
                int index = i;
                lbl.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            if(list == hand){
                                for(int i=0; i < hand.size(); i++){
                                    Train t = (Train)hand.get(i);
                                    if(t.color == order[index]){
                                        selected.add(hand.remove(i));
                                        self.repaint();
                                        break;
                                    }
                                }
                            }else if(list == selected){
                                for(int i=0; i < selected.size(); i++){
                                    Train t = (Train)selected.get(i);
                                    if(t.color == order[index]){
                                        hand.add(selected.remove(i));
                                        self.repaint();
                                        break;
                                    }
                                }
                            }
                        }
                    });
                this.add(lbl);

            }
        }
    }
}
