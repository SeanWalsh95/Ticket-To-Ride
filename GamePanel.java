import java.awt.event.*;
import javax.swing.*;
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

    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
        this.setLayout(null);

        cb = new CityBuilder();

        image = new ImageLibrary();

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

        viewTechnologyButt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    viewTechnologyButt.setIcon(new ImageIcon(image.viewTechButtonHighlighted));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    viewTechnologyButt.setIcon(new ImageIcon(image.viewTechButtonUnselected));
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


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawImage(image.background,0,0,this);
        for(City c : cb.cities){
            g.setColor(Color.GREEN);
            g.drawRect(c.x,c.y,20,20);
            if(c.hover){
                g.drawImage(image.getHover(c.name), c.x-87, c.y-60, this);
            }else{
                g.drawImage(image.emptyHover, 8, 8, this);
            }
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

    public void drawPlayerHand(Graphics g){

    }
}
