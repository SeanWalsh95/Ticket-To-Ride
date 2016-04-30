import java.awt.*;
import java.util.*;
import java.io.File;

/**
 * Write a description of class Technologies here.
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class Tech extends Card {
    int numberAvalable, cost;
    Technology name;
    String description, nameString;
    private static final String path =
            "resources\\images\\cards\\Technologies\\";

    /**
     * Constructor that takes a string deliminated with the given
     * deliminator to
     * initlize the values of this class in the following format (example uses
     * ";" as a deliminator) name;cost;numberAvalable;description
     */
    public Tech(String line, String delim) {
        // the following block of code breaks a single string into the
        // parameter values for the class storing them in local strings to be
        // parsed into values for the class
        StringTokenizer st = new StringTokenizer(line, delim);
        String nameStr = st.nextToken();
        String costStr = st.nextToken();
        String numberAvalableStr = st.nextToken();
        String description = st.nextToken();

        // identifying message for this class
        String classMsg = "(ERR CONST Tech)";

        // attempts to parse the values from the given string into the classes
        // values
        // if a parse fails it is caught and an error is printed
        try {
            name = Technology.valueOf(nameStr.replace(" ", ""));
            nameString = nameStr;
        } catch (Exception e) {
            System.err.println(classMsg + nameStr + ": Invalid Tech name");
        }
        try {
            cost = Integer.parseInt(costStr);
        } catch (Exception e) {
            System.err.println(classMsg + cost + ": Cannot parse cost to int");
        }
        try {
            numberAvalable = Integer.parseInt(numberAvalableStr);
        } catch (Exception e) {
            System.err.println(classMsg + numberAvalable
                    + ": Cannot parse numberAvalable to int");
        }
    }

    public Image getImage(Technology name) {
        String filePath = path + name + ".jpg";
        try (Scanner sc = new Scanner(new File(filePath))) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(filePath);
        } catch (Exception e) {
            System.err.println("(ERR Tech.getImage): Cannot find file \""
                    + filePath + "\"");
        }
        return null;
    }
    
    public Image getImage() {
        String filePath = path + name + ".jpg";
        try (Scanner sc = new Scanner(new File(filePath))) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(filePath);
        } catch (Exception e) {
            System.err.println("(ERR Tech.getImage): Cannot find file \""
                    + filePath + "\"");
        }
        return null;
    }

    /**
     * method to compare this Tech card to other Objects
     *
     * @param o A Object to compare to
     * @return false if the Objects are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Tech)
            if (this.name == ((Tech) o).name)
                return true;
        return false;
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
