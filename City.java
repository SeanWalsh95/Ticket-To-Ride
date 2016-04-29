import java.util.*;

/**
 * Write a description of class City here.
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class City {
    CityName name;
    Region region;
    protected int x, y;
    protected boolean hover;

    /**
     * Constructor that takes a string deliminated with the given
     * deliminator to
     * initlize the values of this class in the following format (example uses
     * ";" as a deliminator) name;region;x;y
     */
    public City(String s, String delim) {
        StringTokenizer st = new StringTokenizer(s, delim);
        String nameStr = st.nextToken();
        String regionStr = st.nextToken();
        String xStr = st.nextToken();
        String yStr = st.nextToken();

        String classMsg = "(ERR CONST City)";

        try {
            name = CityName.valueOf(nameStr.replace(" ", ""));
        } catch (Exception e) {
            System.err.println(classMsg + nameStr + ": Invalid City name");
        }
        try {
            region = Region.valueOf(regionStr.replace(" ", ""));
        } catch (Exception e) {
            System.err.println(classMsg + regionStr + ": Invalid Region name");
        }
        try {
            x = Integer.parseInt(xStr);
        } catch (Exception e) {
            System.err.println(classMsg + xStr + ": Cannot parse x to int");
        }
        try {
            y = Integer.parseInt(yStr);
        } catch (Exception e) {
            System.err.println(classMsg + yStr + ": Cannot parse y to int");
        }
        hover = false;
    }

    public String toString() {
        return name + "," + region + " (" + x + "," + y + ")";
    }
}
