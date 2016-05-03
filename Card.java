import java.awt.Image;

/**
 * Abstract class Card - write a description of the class here
 *
 * @author Sean Walsh
 * @version 1.1
 */
public abstract class Card {
    /**
     * Forces all subclasses to have
     * getImage method
     * 
     * @return The image with the card
     */
    public abstract Image getImage();
}
