import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 * A java JPanel to be used to display the gaem board to the players of the game
 * 
 * @author Sean Walsh
 * @version 1.0
 */
public class GamePanel extends JPanel{
    GameBoard gameBoard;
    GButton viewTechButt, buyTechButt, viewDestButt;
    ArrayList<Card> selectedTechCards,selectedDestCards;

    Rectangle mapBounds = new Rectangle(9,39+50,590,885);
    Rectangle playersCardsBounds = new Rectangle(609,573+50,636,320); 
    int xOFFSET= 0, yOFFSET = 50;

    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel(ArrayList<Player> players)
    {
        this.setLayout(null);

        gameBoard = new GameBoard(players);
        for(Player p : gameBoard.players){
            p.heldDestinationCards.addAll(selectDestCards("Player "+(p.id+1)+": Select Your Starting Destination Cards",3,5,5));
            p.heldTrainCards.addAll(gameBoard.trainDeck.drawCards(5));
        }

        selectedTechCards = new ArrayList<Card>();
        selectedDestCards = new ArrayList<Card>();

        viewTechButt = new GButton(new int[]{612,508+yOFFSET,196,51},ImgLib.viewTechButtonUnselected,ImgLib.viewTechButtonHighlighted);
        viewTechButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    Player p = gameBoard.getCurrentPlayer();
                    showPlayerCards("Player "+(p.id+1)+"'s Tech Cards", p.heldTechCards);
                }
            });
        this.add(viewTechButt);

        buyTechButt = new GButton(new int[]{828,508+yOFFSET,196,51},ImgLib.buyTechButtonUnselected,ImgLib.buyTechButtonHighlighted);
        buyTechButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    for(Card c : purchaseTechCards()){
                        System.out.println(((Tech)c).name);
                    }
                }
            });
        this.add(buyTechButt);

        viewDestButt = new GButton(new int[]{1044,508+yOFFSET,196,51},ImgLib.viewDestButtonUnselected,ImgLib.viewDestButtonHighlighted);
        viewDestButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    Player p = gameBoard.getCurrentPlayer();
                    showPlayerCards("Player "+(p.id+1)+"'s Destination Cards", p.heldDestinationCards);
                }
            });
        this.add(viewDestButt);

        for(City c : gameBoard.cities){
            JLabel cityLabel = new JLabel();
            cityLabel.setBounds(c.getX(),c.getY(),20,20);
            cityLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed( MouseEvent e ){
                        System.out.println(c.name);
                        //add call to cityClicked() method here
                    }

                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        c.hover = true;
                        repaint();
                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        c.hover = false;
                        repaint();
                    }
                });
            this.add(cityLabel);
        }
    }

    /**
     * method to present the user with a menu to pick a tech card to purchase
     * 
     * @return a list of cards to be purchased
     */
    public ArrayList<Card> purchaseTechCards(){
        int limit = 1, minimum = 1;
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel("Purchase Technologies",gameBoard.techAvail);
        JDialog jd = new JDialog(parentFrame,true);
        jd.setTitle("Card Select");

        jd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed( MouseEvent e ){
                    int index = -1;
                    index = panel.getCardIndex(e.getPoint());
                    if(index > -1 &&(panel.getNumberSelected() < limit || panel.selectedCards[index]))
                        panel.select(index);
                }
            });
        panel.backButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    jd.dispose();
                }
            });
        panel.purchaseButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    if(panel.getNumberSelected() >= minimum){
                        selectedTechCards = panel.getSelected();
                        jd.dispose();
                    }else{
                        JOptionPane.showMessageDialog(new JFrame(), "You must select at least "+minimum+" cards");
                    }
                }
            });

        jd.setSize( 1276, 939 ); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        JOptionPane.showMessageDialog(new JFrame(), "Select 4 train cards or one locomotive");

        return selectedTechCards;
    }

    /**
     * method to present the user with a menu to pick a dest cards to select from
     * 
     * @return a list of selected cards
     */
    public ArrayList<Card> selectDestCards(String title,int minimum, int limit ,int numberOfCards){
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel(title,gameBoard.destDeck.drawCards(numberOfCards));
        JDialog jd = new JDialog(parentFrame,true);
        jd.setTitle("Card Select");

        panel.removeAll();

        jd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed( MouseEvent e ){
                    int index = -1;
                    index = panel.getCardIndex(e.getPoint());
                    if(index > -1 &&(panel.getNumberSelected() < limit || panel.selectedCards[index]))
                        panel.select(index);
                }
            });

        GButton purchaseButt = new GButton(new int[]{543,828,174,51},ImgLib.selectButtonUnselected,ImgLib.selectButtonHighlighted);
        purchaseButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    if(panel.getNumberSelected() >= minimum){
                        selectedDestCards = panel.getSelected();
                        jd.dispose();
                    }else{
                        JOptionPane.showMessageDialog(new JFrame(), "You must select at least "+minimum+" cards");
                    }
                }
            });
        panel.add(purchaseButt);

        GButton backButt = new GButton(new int[]{5,828,98,48},ImgLib.backButtonUnselected,ImgLib.backButtonHighlighted);
        backButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    jd.dispose();
                }
            });
        panel.add(backButt);

        jd.setSize( 1276, 939 ); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        gameBoard.destDeck.discard(panel.getRemainder());
        return selectedDestCards;
    }

    /**
     * presents the user with a list of given cards
     * 
     * @param title text to display at the top of the window
     * @param cardsToShow a list of cards to display
     */
    public void showPlayerCards(String title,ArrayList<Card> cardsToShow){
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel(title,cardsToShow);
        JDialog jd = new JDialog(parentFrame,true);
        jd.setTitle("Card Select");

        panel.remove(panel.purchaseButt);

        panel.backButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    jd.dispose();
                }
            });

        jd.setSize( 1276, 939 ); // set frame size
        jd.add(panel);
        jd.setVisible(true);
    }

    /**
     * paint component for this JPanel component
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawImage(ImgLib.background,0,0,this);
        for(City c : gameBoard.cities){
            g.setColor(Color.GREEN);
            g.drawRect(c.getX(),c.getY(),20,20);
            if(c.hover)
                g.drawImage(ImgLib.getHover(c.name), c.getX()-87, c.getY()-60, this);
        }
        drawPlayerHand(g);
        drawPlayerInfo(g);
        //drawTrainDeck(g);
    } // end method paintComponent

    /**
     * draws the current players hand of train cards
     */
    public void drawPlayerHand(Graphics g){
        int rows = 3, cardWidth=146, cardHeight=94, leftBorder=650, topBorder=585+yOFFSET;
        ArrayList<Card> trainCards = gameBoard.getCurrentPlayer().heldTrainCards;//GameBoard.getCurrPlayer().getTech();
        RouteColor[] order = new RouteColor[]{
                RouteColor.BLACK,
                RouteColor.GREEN,
                RouteColor.BLUE,
                RouteColor.YELLOW,
                RouteColor.NEUTRAL,
                RouteColor.ORANGE,
                RouteColor.RED,
                RouteColor.WHITE,
                RouteColor.PINK
            };

        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5F);
        g.setFont(newFont);

        for(int i=0; i < 9; i++){
            int x = ((i%rows)*55)+(i%rows)*cardWidth+leftBorder;
            int y = ((i/rows)*7)+(i/rows)*cardHeight+topBorder;
            int count = CardCounter.countTrainColor(trainCards,order[i]);
            if(count > 0){
                g.drawImage(Train.getImage(order[i]),x,y,cardWidth,cardHeight,this);
                g.setColor(Color.WHITE);
                g.drawString(count+"",x-15,y+25);
                RouteColor rc = order[i];
                JLabel trainCardLabel = new JLabel();
                trainCardLabel.setBounds(x,y,cardWidth, cardHeight);
                trainCardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed( MouseEvent e ){
                            System.out.println(rc);
                            //add call to cardClicked() method here
                        }
                    });
                this.add(trainCardLabel);
            }
        }
    }

    /**
     * draws the train deck cards
     */
    public void drawTrainDeck(Graphics g){
        int cardWidth=241, cardHeight=94, leftBorder=1011, topBorder=8+yOFFSET;
        for(int i=0; i < 9; i++){
            int x = leftBorder;//((i%rows)*0)+(i%rows)*cardWidth+leftBorder;
            int y = (i*4)+(i*cardHeight)+topBorder;
            g.drawImage(ImgLib.backOfTrainCard,x,y,cardWidth,cardHeight,this);
        }
    }

    /**
     * draws information about the current players of the game to the board
     */
    public void drawPlayerInfo(Graphics g){
        int width=241, height=91, leftBorder=1011, topBorder=8+yOFFSET;
        
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1F);
        g.setFont(newFont);
        for(int i=0; i < gameBoard.players.size(); i++){
            Player p = gameBoard.players.get(i);
            int x = leftBorder;
            int y = topBorder + (height*i) + (11*i);
            g.drawImage(ImgLib.playerCard,x,y,width,height,this);
            g.setColor(Color.WHITE);
            g.drawString(p.name+"",x+5,y+5+(g.getFontMetrics().getHeight()/2));
            g.setColor(p.color);
            g.fillRect(g.getFontMetrics().stringWidth(p.name)+x+10,y+3,15,15);

        }
    }
}
