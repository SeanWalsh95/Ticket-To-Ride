import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class gButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GButton extends JButton
{
    Image hover, base;
    /**
     * Constructor for objects of class gButton
     * 
     * 
     * @param bounds array of size [4] that contins the x,y,with,height of the button
     * 
     * 
     */
    public GButton(int[] bounds, Image base, Image hover)
    {
        this.hover = hover;
        this.base = base;
        this.setText("");
        this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        this.setIcon(new ImageIcon(base));
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        GButton self = this; 
        this.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    self.setIcon(((Icon)new ImageIcon(hover)));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    self.setIcon(((Icon)new ImageIcon(base)));
                }
            });

    }
}
