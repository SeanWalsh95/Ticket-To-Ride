import java.util.*;
import java.awt.*;

/**
 * A Object Orented Class to hold all information pertaining to a route for the
 * game Ticket to Ride
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class Route {
    // the two endpoint citys of the route
    CityName cityA, cityB;

    // the color of the route
    RouteColor color;

    // number to indicate secondary route x of x
    int routeIndex;

    // number of trains required to take the route
    int trainRequirement;

    // the playerID of the current owner of the route
    int ownerID;

    // stores a list of polygons which represent the tiles in a given route
    ArrayList<Polygon> polygons;

    /**
     * Basic constructor to initlise values to their null/default values
     */
    public Route() {
    }

    /**
     * Constructor that takes a string deliminated with the given
     * deliminator to
     * initlize the values of this class in the following format (example uses
     * ";" as a deliminator) cityA;cityB;size;color
     */
    public Route(String s, String delim) {
        // the following block of code breaks a single string into the
        // parameter values for the class storing them in local strings to be
        // parsed into values for the class
        StringTokenizer st = new StringTokenizer(s, delim);
        String cityAStr = st.nextToken();
        String cityBStr = st.nextToken();
        String trainRequirementStr = st.nextToken();
        String colorStr = st.nextToken();
        String pointsList = st.nextToken();

        // identifying message for this class
        String classMsg = "(ERR CONST Route)";

        // attempts to parse the values from the given string into the classes
        // values
        // if a parse fails it is caught and an error is printed
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
            color = RouteColor.valueOf(colorStr.toUpperCase());
        } catch (Exception e) {
            System.err.println(classMsg + colorStr + ": Invalid RouteColor");
        }
        try {
            trainRequirement = Integer.parseInt(trainRequirementStr);
        } catch (Exception e) {
            System.err.println(classMsg + trainRequirementStr
                    + ": Cannot parse trainRequirement to int");
        }
        try {
            polygons = new ArrayList<Polygon>();
            StringTokenizer points = new StringTokenizer(pointsList, " ");
            while (points.hasMoreTokens()) {
                String xStr = points.nextToken(), yStr = points.nextToken();
                StringTokenizer xValues = new StringTokenizer(xStr, "-");
                StringTokenizer yValues = new StringTokenizer(yStr, "-");
                int numberOfPoints = 0;
                if (xValues.countTokens() == xValues.countTokens()) {
                    numberOfPoints = xValues.countTokens();
                } else {
                    System.err.println(classMsg
                            + ":X and Y values do not match in length for " +
                            "polygon");
                }
                int[] xList = new int[numberOfPoints];
                int[] yList = new int[numberOfPoints];
                for (int i = 0; i < numberOfPoints; i++) {
                    xList[i] = Integer.parseInt(xValues.nextToken());
                    yList[i] = Integer.parseInt(yValues.nextToken());
                }
                // System.out.println("X:("+Arrays.toString(xList)+")
                // Y:("+Arrays.toString(yList)+") Count:"+numberOfPoints);
                polygons.add(new Polygon(xList, yList, numberOfPoints));
            }
        } catch (Exception e) {
            System.err.println(classMsg + ": Cannot parse points to polygon");
        }
        // sets the ownerID to its default value of -1 awaiting a player to
        // capture it
        ownerID = -1;
    }

    public String toString() {
        return "Route " + cityA + " to " + cityB;
    }
}
