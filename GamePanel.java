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
public class GamePanel extends JPanel {
    GameBoard gameBoard;
    GButton viewTechButt, buyTechButt, viewDestButt;
    ArrayList<Card> selectedTechCards, selectedDestCards;

    // offset for compatibility
    int xOFFSET = 0, yOFFSET = 50;

    // booleans for route selection
    boolean firstCityClick = true, routeSelected = false;
    // citys selected for route
    CityName routePointA, routePointB;

    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel(ArrayList<Player> players) {
        this.setLayout(null);

        gameBoard = new GameBoard(players);
        // init for players
        for (Player p : gameBoard.players) {
            p.heldDestinationCards.addAll(selectDestCards(
                    "Player " + (p.id + 1)
                    + ": Select Your Starting Destination Cards",
                    3, 5, 5));
            p.heldTrainCards.addAll(gameBoard.trainDeck.drawCards(5));
        }

        // init selection arrays
        selectedTechCards = new ArrayList<Card>();
        selectedDestCards = new ArrayList<Card>();

        // GButton to allow a player to view their Tech Cards
        viewTechButt = new GButton(new int[] { 612, 508 + yOFFSET, 196, 51 },
            ImgLib.viewTechButtonUnselected,
            ImgLib.viewTechButtonHighlighted);
        viewTechButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Player p = gameBoard.getCurrentPlayer();
                    showPlayerCards("Player " + (p.id + 1) + "'s Tech Cards",
                        p.heldTechCards);
                }
            });
        this.add(viewTechButt);

        // GButton to allow a player to purchase a Tech Card
        buyTechButt = new GButton(new int[] { 828, 508 + yOFFSET, 196, 51 },
            ImgLib.buyTechButtonUnselected,
            ImgLib.buyTechButtonHighlighted);
        buyTechButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Card> boughtTech = purchaseTechCards();
                    if (boughtTech.size() > 0)
                        gameBoard.buyTech((Tech) boughtTech.get(0));
                }
            });
        this.add(buyTechButt);

        // Gbutton to allow a player to view their Dest Cards
        viewDestButt = new GButton(new int[] { 1044, 508 + yOFFSET, 196, 51 },
            ImgLib.viewDestButtonUnselected,
            ImgLib.viewDestButtonHighlighted);
        viewDestButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Player p = gameBoard.getCurrentPlayer();
                    showPlayerCards("Player " + (p.id + 1) + "'s Destination Cards",
                        p.heldDestinationCards);
                }
            });
        this.add(viewDestButt);

        // adds JLabel component with MouseListener's for every city in
        // GameBoard
        for (City c : gameBoard.cities) {
            JLabel cityLabel = new JLabel();
            cityLabel.setBounds(c.x, c.y + yOFFSET, 20, 20);
            cityLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    // calls cityClicked if a city is clicked
                    public void mousePressed(MouseEvent e) {
                        cityClicked(c.name);
                        //System.out.println(c.name);
                    }

                    // displays the city name if hoverd
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        c.hover = true;
                        repaint();
                    }

                    // removes the city name if not hoverd
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        c.hover = false;
                        repaint();
                    }
                });
            this.add(cityLabel);
        }
    }

    /**
     * Method to help determine a route a player is trying to choose
     * 
     * @Param c the name of a clicked city
     */
    private void cityClicked(CityName c) {
        if (!routeSelected)
            if (firstCityClick) {
                routePointA = c;
                firstCityClick = false;
                routeSelected = false;
            } else {
                routePointB = c;
                if (gameBoard.getRoute(routePointA, routePointB,null) != null)
                    routeSelected = true;
                else
                    firstCityClick = true;
            }
        repaint();
    }

    /**
     * method to present the user with a menu to pick a tech card to purchase
     * 
     * @return An ArrayList of cards to be purchased
     */
    public ArrayList<Card> purchaseTechCards() {
        int limit = 1, minimum = 1;
        JFrame parentFrame = (JFrame) SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel("Purchase Technologies",
                gameBoard.techAvail);
        JDialog jd = new JDialog(parentFrame, true);
        jd.setTitle("Card Select");

        jd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    int index = -1;
                    index = panel.getCardIndex(e.getPoint());
                    if (index > -1 && (panel.getNumberSelected() < limit
                        || panel.selectedCards[index]))
                        panel.select(index);
                }
            });

        GButton purchaseButt = new GButton(new int[] { 543, 828, 174, 51 },
                ImgLib.purchaseButtonUnselected,
                ImgLib.purchaseButtonHighlighted);
        purchaseButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (panel.getNumberSelected() >= minimum) {
                        selectedTechCards = panel.getSelected();
                        jd.dispose();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(),
                            "You must select at least " + minimum + " cards");
                    }
                }
            });
        panel.add(purchaseButt);

        jd.setSize(1276, 939); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        return selectedTechCards;
    }

    /**
     * method to present the player with a list of Dest Cards to choose from,
     * unselected cards are added to gameBoard.destDeck.discard
     * 
     * @param title
     *            text to display at the top of the window
     * @param minimum
     *            minimum number of cards that can be selected
     * @param limit
     *            maximum number of cards that can be selected
     * @param numberOfCards
     *            number of cards to draw from the GameBoard Dest Deck
     * @return a list of selected cards
     */
    public ArrayList<Card> selectDestCards(String title, int minimum, int limit,
    int numberOfCards) {
        JFrame parentFrame = (JFrame) SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel(title,
                gameBoard.destDeck.drawCards(numberOfCards));
        JDialog jd = new JDialog(parentFrame, true);
        jd.setTitle("Card Select");

        jd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    int index = -1;
                    index = panel.getCardIndex(e.getPoint());
                    if (index > -1 && (panel.getNumberSelected() < limit
                        || panel.selectedCards[index]))
                        panel.select(index);
                }
            });

        GButton selectButt = new GButton(new int[] { 543, 828, 174, 51 },
                ImgLib.selectButtonUnselected, ImgLib.selectButtonHighlighted);
        selectButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (panel.getNumberSelected() >= minimum) {
                        selectedDestCards = panel.getSelected();
                        jd.dispose();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(),
                            "You must select at least " + minimum + " cards");
                    }
                }
            });
        panel.add(selectButt);

        jd.setSize(1276, 939); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        gameBoard.destDeck.discard(panel.getRemainder());

        return selectedDestCards;
    }

    /**
     * presents the user with a list of given cards
     * 
     * @param title
     *            text to display at the top of the window
     * @param cardsToShow
     *            a list of cards to display
     */
    public void showPlayerCards(String title, ArrayList<Card> cardsToShow) {
        JFrame parentFrame = (JFrame) SwingUtilities.windowForComponent(this);
        CardSelectPanel panel = new CardSelectPanel(title, cardsToShow);
        JDialog jd = new JDialog(parentFrame, true);
        jd.setTitle("Card Select");

        jd.setSize(1276, 939); // set frame size
        jd.add(panel);
        jd.setVisible(true);
    }

    /**
     * paint component for this JPanel component
     * 
     * @param g
     *            the Graphics object for this Class
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgLib.background, 0, 0, this);
        for (City c : gameBoard.cities) {
            g.setColor(Color.GREEN);
            g.drawRect(c.x, c.y + yOFFSET, 20, 20);
            if (c.hover)
                g.drawImage(ImgLib.getHover(c.name), c.x - 87,
                    (c.y + yOFFSET) - 60, this);
        }
        drawPlayerHand(g);
        drawPlayerInfo(g);
        drawSelectedRouteInfo(g);
        // drawTrainDeck(g);
    } // end method paintComponent

    /**
     * draws the current players hand of train cards
     * 
     * @param g
     *            the Graphics object for this Class
     */
    public void drawPlayerHand(Graphics g) {
        int rows = 3, cardWidth = 146, cardHeight = 94, leftBorder = 650,
        topBorder = 585 + yOFFSET;
        ArrayList<Card> trainCards = gameBoard
            .getCurrentPlayer().heldTrainCards;
        RouteColor[] order = new RouteColor[] { RouteColor.BLACK,
                RouteColor.GREEN, RouteColor.BLUE, RouteColor.YELLOW,
                RouteColor.NEUTRAL, RouteColor.ORANGE, RouteColor.RED,
                RouteColor.WHITE, RouteColor.PINK };

        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.5F);
        g.setFont(newFont);

        for (int i = 0; i < 9; i++) {
            int x = ((i % rows) * 55) + (i % rows) * cardWidth + leftBorder;
            int y = ((i / rows) * 7) + (i / rows) * cardHeight + topBorder;
            int count = CardCounter.countTrainColor(trainCards, order[i]);
            if (count > 0) {
                g.drawImage(Train.getImage(order[i]), x, y, cardWidth,
                    cardHeight, this);
                g.setColor(Color.WHITE);
                g.drawString(count + "", x - 15, y + 25);
                RouteColor rc = order[i];
                JLabel trainCardLabel = new JLabel();
                trainCardLabel.setBounds(x, y, cardWidth, cardHeight);
                trainCardLabel
                .addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            System.out.println(rc);
                            // add call to cardClicked() method here
                        }
                    });
                this.add(trainCardLabel);
            }
        }
    }

    /**
     * draws the train deck cards
     * 
     * @param g
     *            the Graphics object for this Class
     */
    public void drawTrainDeck(Graphics g) {
        int cardWidth = 241, cardHeight = 94, leftBorder = 1011,
        topBorder = 8 + yOFFSET;
        for (int i = 0; i < 9; i++) {
            int x = leftBorder;// ((i%rows)*0)+(i%rows)*cardWidth+leftBorder;
            int y = (i * 4) + (i * cardHeight) + topBorder;
            g.drawImage(ImgLib.backOfTrainCard, x, y, cardWidth, cardHeight,
                this);
        }
    }

    /**
     * draws information about the current players of the game to the board
     * 
     * @param g
     *            the Graphics object for this Class
     */
    public void drawPlayerInfo(Graphics g) {
        int width = 241, height = 91, leftBorder = 1011,
        topBorder = 8 + yOFFSET;

        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1F);
        g.setFont(newFont);
        for (int i = 0; i < gameBoard.players.size(); i++) {
            Player p = gameBoard.players.get(i);
            int x = leftBorder;
            int y = topBorder + (height * i) + (11 * i);
            int fHeight = g.getFontMetrics().getHeight();
            g.drawImage(ImgLib.playerCard, x, y, width, height, this);
            g.setColor(Color.WHITE);
            g.drawString(p.name + "", x + 5,
                y + 5 + (fHeight / 2));
            g.setColor(p.color);
            g.fillRect(g.getFontMetrics().stringWidth(p.name) + x + 10, y + 3,
                15, 15);
                
            g.setColor(Color.WHITE);
            g.drawImage(
                ImgLib.trainIcon,
                x+5,y+fHeight,
                20,20,this);
            g.drawString(
                p.trainPieces+"",
                x+30,y+15+fHeight);

        }
    }

    /**
     * draws information the sleceted route to the top of the Panel
     * 
     * @param g
     *            the Graphics object for this Class
     */
    public void drawSelectedRouteInfo(Graphics g) {
        int x = 8, y = 25;
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1F);
        g.setFont(newFont);
        g.setColor(Color.WHITE);
        JPanel self = this;
        JButton clearButt = new JButton("Clear");
        clearButt.setBounds(708, y, 75, 25);
        clearButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    firstCityClick = true;
                    routeSelected = false;
                    routePointA = null;
                    routePointB = null;
                    self.repaint();
                }
            });

        JButton purchaseButt = new JButton("Purchase");
        purchaseButt.setBounds(608, y, 100, 25);
        purchaseButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Route r = gameBoard.getRoute(routePointA, routePointB,null);
                    System.out.println("Purchase action " + routeSelected + " "
                        + r.toString());
                    if (routeSelected && r != null) {
                        City a, b;
                        a = b = null;
                        for (City c : gameBoard.cities) {
                            if (r.cityA == c.name)
                                a = c;
                            if (r.cityB == c.name)
                                b = c;
                        }

                        System.out.println(a.name + "  " + b.name);
                        if (a != null && b != null) {
                            System.out.println("Calling GB for " + r.toString());
                            gameBoard.buyRoute(a, b);
                        }
                    }
                }
            });
        this.add(clearButt);
        this.add(purchaseButt);
        if (routeSelected) {
            Route r = gameBoard.getRoute(routePointA, routePointB,null);
            if (r != null) {
                g.drawString(r.toString() + " selected", x + 5,
                    y + 5 + (g.getFontMetrics().getHeight() / 2));
            } else {
                firstCityClick = true;
                routeSelected = false;
            }
        }
    }

    // WIP
    public ArrayList<Card> selectTrainCards() {
        return null;
    }
}
