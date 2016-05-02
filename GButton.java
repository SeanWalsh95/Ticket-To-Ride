import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * A custom extnesion of JButton to allow for the use of custom images for
 * buttons but retain the functionality of a JButton
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class GButton extends JButton {
    /**
     * Constructor for GButton
     *
     * @param bounds array of size [4] that contins the x,y,with,height of the
     *               button
     * @param hover  A Image to be shown when the mouse is over the button
     * @prarm base A Image to be shown by default
     */
    public GButton(int[] bounds, Image base, Image hover) {
        // sets text to null
        this.setText("");
        // sets the bounds to the param provided
        this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        // sets the image icon of the button to the given base image
        this.setIcon(new ImageIcon(base));
        // needed to make the icon the only visible part of the button
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        // self refrence for use in actions
        GButton self = this;
        this.addMouseListener(new java.awt.event.MouseAdapter() {
                // action for when the mouse enters the buttons bounds
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    // sets the image icon of the 
					//button to the given hover image
                    self.setIcon(((Icon) new ImageIcon(hover)));
                }

                // action for when the mouse exits the buttons bounds
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    // sets the image icon of the
					//button to the given base image
                    self.setIcon(((Icon) new ImageIcon(base)));
                }
            });

    }

    /**
     * Constructor for GButton
     *
     * @param bounds array of size [4] that contins the x,y,with,height of the
     *               button
     * @param hover  A Image to be shown when the mouse is over the button
     * @prarm base A Image to be shown by default
     * @param pressed A Image to be shown when the mouse is pressed on
     *                  a button
     */
    public GButton(int[] bounds, Image base, Image hover, Image pressed) {
        // sets text to null
        this.setText("");
        // sets the bounds to the param provided
        this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        // sets the image icon of the button to the given base image
        this.setIcon(new ImageIcon(base));
        // needed to make the icon the only visible part of the button
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        // self refrence for use in actions
        GButton self = this;
        this.addMouseListener(new java.awt.event.MouseAdapter() {
                // action for when the mouse enters the buttons bounds
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    // sets the image icon of the
					// button to the given hover image
                    self.setIcon(((Icon) new ImageIcon(hover)));
                }

                // action for when the mouse exits the buttons bounds
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    // sets the image icon of the 
					// button to the given base image
                    self.setIcon(((Icon) new ImageIcon(base)));
                }

                //action for when the mouse is pressed
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    // sets the image icon of the 
					// button to the given hover image
                    self.setIcon(((Icon) new ImageIcon(pressed)));
                }

                //action for when the mouse is released
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    // sets the image icon of the 
					// button to the given base image
                    self.setIcon(((Icon) new ImageIcon(base)));
                }
            });

    }
}
