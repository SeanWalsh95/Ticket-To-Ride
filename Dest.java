import java.awt.*;
import java.util.*;
import java.io.File;

/**
 * Write a description of class Destination here.
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class Dest extends Card {
    CityName cityA, cityB;
    private static final String path =
        "resources\\images\\cards\\destination cards\\";
    int pointValue;

    /**
     * The constructor for dest cards
     * 
     * @param line A string from file IO
     * @param A delim for the line string
     */
    public Dest(String line, String delim) {
        StringTokenizer st = new StringTokenizer(line, delim);
        String cityAStr = st.nextToken();
        String cityBStr = st.nextToken();
        String pointValueStr = st.nextToken();

        // identifying message for this class
        String classMsg = "(ERR CONST Destination)";

        try {
            cityA = CityName.valueOf(cityAStr.replace(" ", ""));
        } catch (Exception e) {
            System.err.println(classMsg + cityAStr + ": Invalid City name");
        }
        try {
            cityB = CityName.valueOf(cityBStr.replace(" ", ""));
        } catch (Exception e) {
            System.err.println(classMsg + cityBStr + ": Invalid City name");
        }
        try {
            pointValue = Integer.parseInt(pointValueStr);
        } catch (Exception e) {
            System.err.println(classMsg + pointValueStr
                + ": Cannot parse pointValue to int");
        }
    }

    /**
     * Method gets the filepath for the image
     * 
     * @return The objects image
     */
    public Image getImage() {
        String filePath = path + cityA + "_" + cityB + ".jpg";
        try (Scanner sc = new Scanner(new File(filePath))) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(filePath);
        } catch (Exception e) {
            System.err.println("(ERR Dest.getImage): Cannot find file \""
                + filePath + "\"");
        }
        return null;
    }

    /**
     * method to compare this Dest card to other Objects
     *
     * @param o A Object to compare to
     * @return false if the Objects are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Dest)
            if (this.cityA == ((Dest) o).cityA && this.cityB == ((Dest) o)
            .cityB)
                return true;
        return false;
    }

    /**
     * This method creates the hashCode for a dest
     * card
     * 
     * @return The hashcode int
     */
    @Override
    public int hashCode() {
        return ((cityA+"")+"_"+(cityB+"")).hashCode();
    }
}
