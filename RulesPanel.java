import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 * A extension of the JPanel class to diplay the rules of
 * ticket to ride to a player
 * 
 * @author Sean Walsh
 * @version 1.0
 */
public class RulesPanel extends JPanel
{
    // backround image to paint behind everything
    Image background;

    /**
     * Constructor for objects of class RulesPanel
     */
    public RulesPanel()
    {
        this.setLayout(null);
        JPanel self = this;
        //makes the mouse cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor a = toolkit.createCustomCursor(ImgLib.mouseCursor,
                new Point(this.getX(),this.getY()), "img");
        setCursor(a);
        background = ImgLib.rulesScreen1;
        GButton next = new GButton(new int[]{962, 13, 80, 30},
                ImgLib.nextButtonUnselected, ImgLib.nextButtonHighlighted);
        next.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SoundLib.turnPage.play();
                    background = ImgLib.rulesScreen2;
                    repaint();
                }
            });
        this.add(next);

        GButton previous = new GButton(new int[]{219, 13, 80, 30},
                ImgLib.previousButtonUnselected,
                ImgLib.previousButtonHighlighted);
        previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SoundLib.turnPage.play();
                    background = ImgLib.rulesScreen1;
                    repaint();
                }
            });
        this.add(previous);

        GButton back = new GButton(new int[]{5, 846, 98, 48},
                ImgLib.backButtonUnselected, ImgLib.backButtonHighlighted);
        back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SoundLib.button.play();
                    ((JDialog) SwingUtilities.windowForComponent(self)).dispose();
                }
            });
        this.add(back);
    }

    /**
     * Paint component method for this JPanel component
     *
     * @param g the Graphics object for this Class
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }
}
