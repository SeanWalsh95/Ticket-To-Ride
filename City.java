import java.util.*;
/**
 * Write a description of class City here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City
{
    String name,region;
    
    /**
     * Constructor that takes a string deliminated with the given deliminator to initlize the values of this class
     * in the following format (example uses ";" as a deliminator) name;region
     */
    public City(String s, String delim){
        StringTokenizer st = new StringTokenizer(s,delim);
        name = st.nextToken();
        region = st.nextToken();
    }
    
    public String toString(){
        return name+","+region;
    }
}

