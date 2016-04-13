import java.util.*;
/**
 * Write a description of class FerryRoute here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FerryRoute extends Route
{
    int locomotiveRequiremnet;
    /**
     * Constructor that takes a string deliminated with the given deliminator to initlize the values of this class
     * in the following format (example uses ";" as a deliminator) cityA;cityB;size;color
     */
    public FerryRoute(String s , String delim){
        StringTokenizer st = new StringTokenizer(s,delim);
        cityA = st.nextToken();
        cityB = st.nextToken();
        locomotiveRequiremnet = Integer.parseInt(st.nextToken());
        trainRequirement = Integer.parseInt(st.nextToken());
    }
}