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
    ImageLibrary image;
    ArrayList<Card> selectedTechCards,selectedDestCards;

    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
        this.setLayout(null);

        cb = new CityBuilder();

        image = new ImageLibrary();
        db = new DeckBuilder();

        viewTechnologyButt = new JButton("");
        viewTechnologyButt.setBounds(612, 508, 196, 51);
        viewTechnologyButt.setIcon(new ImageIcon(image.viewTechButtonUnselected));
        viewTechnologyButt.setBorderPainted(false);
        viewTechnologyButt.setOpaque(false);
        viewTechnologyButt.setContentAreaFilled(false);

        buyTechnologyButt = new JButton("");
        buyTechnologyButt.setBounds(828, 508, 196, 51);
        buyTechnologyButt.setIcon(new ImageIcon(image.buyTechButtonUnselected));
        buyTechnologyButt.setBorderPainted(false);
        buyTechnologyButt.setOpaque(false);
        buyTechnologyButt.setContentAreaFilled(false);

        viewDestinationsButt = new JButton("");
        viewDestinationsButt.setBounds(1044, 508, 196, 51);
        viewDestinationsButt.setIcon(new ImageIcon(image.viewDestButtonUnselected));
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
                    viewTechnologyButt.setIcon(new ImageIcon(image.viewTechButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    viewTechnologyButt.setIcon(new ImageIcon(image.viewTechButtonUnselected));
                }
            });

        buyTechnologyButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    purchaseTechCards();
                }
            });
        buyTechnologyButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buyTechnologyButt.setIcon(new ImageIcon(image.buyTechButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buyTechnologyButt.setIcon(new ImageIcon(image.buyTechButtonUnselected));
                }
            });

        viewDestinationsButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    selectDestCards();
                }
            });
        viewDestinationsButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    viewDestinationsButt.setIcon(new ImageIcon(image.viewDestButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    viewDestinationsButt.setIcon(new ImageIcon(image.viewDestButtonUnselected));
                }
            });

        this.add(viewTechnologyButt);
        this.add(buyTechnologyButt);
        this.add(viewDestinationsButt);
    }

    public void purchaseTechCards(){
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel(image.viewTech ,db.tech);
        JDialog jd = new JDialog(parentFrame,true);
        jd.setTitle("Card Select");

        jd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed( MouseEvent e ){
                    Point p = e.getPoint();
                    panel.select(panel.getCardIndex(p));
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
                    setSelectedTechCards(panel.getSelected());
                    jd.dispose();
                }
            });

        jd.setSize( 1276, 939 ); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        for(Card c : selectedTechCards){
            System.out.println(((Tech)c).name);
        }
    }

    public void setSelectedTechCards(ArrayList<Card> selected){
        selectedTechCards = selected;
    }

    public void selectDestCards(){
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel(image.viewTech ,db.dest);
        JDialog jd = new JDialog(parentFrame,true);
        jd.setTitle("Card Select");

        jd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed( MouseEvent e ){
                    Point p = e.getPoint();
                    panel.select(panel.getCardIndex(p));
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
                    setSelectedDestCards(panel.getSelected());
                    jd.dispose();
                }
            });

        jd.setSize( 1276, 939 ); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        for(Card c : selectedDestCards){
            System.out.println(((Dest)c).toString());
        }
    }

    public void setSelectedDestCards(ArrayList<Card> selected){
        selectedDestCards = selected;
    }

    public void showPlayerCards(ArrayList<Card> cardsToShow){
        JFrame parentFrame = (JFrame)SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel(image.viewTech ,cardsToShow);
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
        g.drawImage(image.background,0,0,this);
        for(City c : cb.cities){
            g.setColor(Color.GREEN);
            g.drawRect(c.x,c.y,20,20);
            if(c.hover)
                g.drawImage(image.getHover(c.name), c.x-87, c.y-60, this);
        }
        drawPlayerHand(g);
    } // end method paintComponent

    public void mouseCheckHoverCity(int x, int y){
        for(City c : cb.cities) 
            if(c.inRange(x,y)){
                c.hover = true;
                repaint();
            }else{
                c.hover = false;
                repaint();
            }
    }

    public CityName getClickedCity(int x, int y){
        for(City c : cb.cities) 
            if(c.inRange(x,y))
                return c.name;
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

    public RouteColor findClickdCard(Point point){
        int rows = 3, cardWidth=146, cardHeight=94, leftBorder=650, topBorder=585;
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
            if (imageBounds.contains(point))
                return order[i];
        }
        return null;
    }
}
