import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 * Write a description of class GamePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel{
    CityBuilder cb;//replace with a refrence to GameBoard.citys
    DeckBuilder db;//replace with a refrence to GameBoard.currentPlayer.hand;
    JButton viewTechnologyButt,buyTechnologyButt, viewDestinationsButt;
    ArrayList<Card> selectedTechCards,selectedDestCards;

    Rectangle mapBounds = new Rectangle(9,39,590,885);
    Rectangle playersCardsBounds = new Rectangle(609,573,636,320); 

    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
        this.setLayout(null);

        cb = new CityBuilder();
        db = new DeckBuilder();

        selectedTechCards = new ArrayList<Card>();
        selectedDestCards = new ArrayList<Card>();

        viewTechnologyButt = new JButton("");
        viewTechnologyButt.setBounds(612, 508, 196, 51);
        viewTechnologyButt.setIcon(new ImageIcon(ImgLib.viewTechButtonUnselected));
        viewTechnologyButt.setBorderPainted(false);
        viewTechnologyButt.setOpaque(false);
        viewTechnologyButt.setContentAreaFilled(false);

        buyTechnologyButt = new JButton("");
        buyTechnologyButt.setBounds(828, 508, 196, 51);
        buyTechnologyButt.setIcon(new ImageIcon(ImgLib.buyTechButtonUnselected));
        buyTechnologyButt.setBorderPainted(false);
        buyTechnologyButt.setOpaque(false);
        buyTechnologyButt.setContentAreaFilled(false);

        viewDestinationsButt = new JButton("");
        viewDestinationsButt.setBounds(1044, 508, 196, 51);
        viewDestinationsButt.setIcon(new ImageIcon(ImgLib.viewDestButtonUnselected));
        viewDestinationsButt.setBorderPainted(false);
        viewDestinationsButt.setOpaque(false);
        viewDestinationsButt.setContentAreaFilled(false);

        viewTechnologyButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    //showPlayerCards(GameBoard.getCurrPlayer().getTech());
                }
            });
        viewTechnologyButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    viewTechnologyButt.setIcon(new ImageIcon(ImgLib.viewTechButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    viewTechnologyButt.setIcon(new ImageIcon(ImgLib.viewTechButtonUnselected));
                }
            });

        buyTechnologyButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    for(Card c : purchaseTechCards()){
                        System.out.println(((Tech)c).name);
                    }
                }
            });
        buyTechnologyButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buyTechnologyButt.setIcon(new ImageIcon(ImgLib.buyTechButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buyTechnologyButt.setIcon(new ImageIcon(ImgLib.buyTechButtonUnselected));
                }
            });

        viewDestinationsButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    for(Card c : selectDestCards()){
                        System.out.println(((Dest)c).toString());
                    }
                }
            });
        viewDestinationsButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    viewDestinationsButt.setIcon(new ImageIcon(ImgLib.viewDestButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    viewDestinationsButt.setIcon(new ImageIcon(ImgLib.viewDestButtonUnselected));
                }
            });

        for(City c : cb.cities){
            JLabel cityLabel = new JLabel();
            cityLabel.setBounds(c.x,c.y,20,20);
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

        this.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed( MouseEvent e ){
                    Point p = e.getPoint();
                    //if(mapBounds.contains(p))
                    //getClickedCity(p);
                    if(playersCardsBounds.contains(p))
                        getClickedCard(p);
                }
            });

        this.add(viewTechnologyButt);
        this.add(buyTechnologyButt);
        this.add(viewDestinationsButt);

    }

    public ArrayList<Card> purchaseTechCards(){
        int limit = 1, minimum = 1;
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel("Purchase Technologies",db.tech);
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

        return selectedTechCards;
    }

    public void setSelectedTechCards(ArrayList<Card> selected){
        selectedTechCards = selected;
    }

    public ArrayList<Card> selectDestCards(){
        int limit = 4, minimum = 3;
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel("Select Destination Cards",db.dest);
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
                        selectedDestCards = panel.getSelected();
                        jd.dispose();
                    }else{
                        JOptionPane.showMessageDialog(new JFrame(), "You must select at least "+minimum+" cards");
                    }
                }
            });

        jd.setSize( 1276, 939 ); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        return selectedDestCards;
    }

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

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawImage(ImgLib.background,0,0,this);
        for(City c : cb.cities){
            g.setColor(Color.GREEN);
            g.drawRect(c.x,c.y,20,20);
            if(c.hover)
                g.drawImage(ImgLib.getHover(c.name), c.x-87, c.y-60, this);
        }
        drawPlayerHand(g);
        //drawTrainDeck(g);
    } // end method paintComponent

    public void mouseCheckHoverCity(Point p){
        for(City c : cb.cities){
            Rectangle cityBounds = new Rectangle(c.getX(),c.getY(),20,20);
            if(cityBounds.contains(p)){
                c.hover = true;
                repaint();
                return;
            }else{
                c.hover = false;
                repaint();
            }
        }
    }

    public CityName getClickedCity(Point p){
        for(City c : cb.cities){
            Rectangle cityBounds = new Rectangle(c.x,c.y,20,20);
            if(cityBounds.contains(p)){
                System.out.println(c.name);
                return c.name;
            }
        }
        return null;
    }

    public void drawPlayerHand(Graphics g){
        int rows = 3, cardWidth=146, cardHeight=94, leftBorder=650, topBorder=585;
        ArrayList<Card> trainCards = db.train;//GameBoard.getCurrPlayer().getTech();
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
            }
        }
    }

    public RouteColor getClickedCard(Point point){
        int rows = 3, cardWidth=146, cardHeight=94, leftBorder=650, topBorder=585;//+39;
        ArrayList<Card> trainCards = db.train;//GameBoard.getCurrPlayer().getTech();
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

        for(int i=0; i < 9; i++){
            int x = ((i%rows)*55)+(i%rows)*cardWidth+leftBorder;
            int y = ((i/rows)*7)+(i/rows)*cardHeight+topBorder;
            Rectangle imageBounds = new Rectangle(x,y,cardWidth, cardHeight);
            int count = CardCounter.countTrainColor(trainCards,order[i]);
            if (imageBounds.contains(point) && count > 0){
                System.out.println(order[i]);
                return order[i];
            }
        }
        return null;
    }

    public void drawTrainDeck(Graphics g){
        int cardWidth=146, cardHeight=94, leftBorder=603, topBorder=5;//+39;
        for(int i=0; i < 9; i++){
            int x = leftBorder;//((i%rows)*0)+(i%rows)*cardWidth+leftBorder;
            int y = (i*4)+(i*cardHeight)+topBorder;
            g.drawImage(ImgLib.backOfTrainCard,x,y,cardWidth,cardHeight,this);
        }
    }
}
