import java.util.*;
/**
 * Write a description of class Route here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route
{
    String cityA, cityB;
    String routeColor;
    int trainRequirement;
    int ownerID;
    
    
    /**
     * Basic constructor to initlise values to their null or default values
     */
    public Route(){}
    
    /**
     * Constructor that takes a string deliminated with the given deliminator to initlize the values of this class
     * in the following format (example uses ";" as a deliminator) cityA;cityB;size;color
     */
    public Route(String s , String delim)
    {
        StringTokenizer st = new StringTokenizer(s,delim);
        cityA = st.nextToken();
        cityB = st.nextToken();
        trainRequirement = Integer.parseInt(st.nextToken());
        routeColor = st.nextToken();
    }
    
    /**
     * Constructor that takes a in and sets the values for this class
     */
    public Route(String cityA, String cityB, String routeColor, int trainRequirement)
    {
        this.cityA =cityA;
        this.cityB = cityB;
        this.routeColor = routeColor;
        this.trainRequirement = trainRequirement;
    }
    
    public String toString()
    {
        return "Route: "+cityA+"\t"+cityB+"\t"+routeColor+"\t"+trainRequirement+"\t";//+owner.toString();
    }
}