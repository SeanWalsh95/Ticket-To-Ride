import java.awt.*;
import java.util.*;
import java.io.File;

/**
 * Write a description of class Train here.
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class Train extends Card {
    RouteColor color;
    private static final String path =
            "resources\\images\\cards\\train cards\\";

    /**
     * import from csv in the format RouteColor
     */
    public Train(RouteColor color) {
        this.color = color;
    }

    public Image getImage() {
        String filePath = path + color + ".jpg";
        try (Scanner sc = new Scanner(new File(filePath))) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(filePath);
        } catch (Exception e) {
            System.err.println("(ERR Train.getImage): Cannot find file \""
                    + filePath + "\"");
        }
        return null;
    }

    public static Image getImage(RouteColor color) {
        String filePath = path + color + ".jpg";
        try (Scanner sc = new Scanner(new File(filePath))) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(filePath);
        } catch (Exception e) {
            System.err.println("(ERR Train.getImage): Cannot find file \""
                    + filePath + "\"");
        }
        return null;
    }

    /**
     * method to compare this Train card to other Objects
     *
     * @param o A Object to compare to
     * @return false if the Objects are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Train)
            if (this.color == ((Train) o).color)
                return true;
        return false;
    }
    
    @Override
    public int hashCode() {
        return color.hashCode();
    }
}
