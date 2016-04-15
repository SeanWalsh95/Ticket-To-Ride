import java.util.*;
/**
 * Write a description of class City here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City
{
    CityName name;
    Region region;

    /**
     * Constructor that takes a string deliminated with the given deliminator to initlize the values of this class
     * in the following format (example uses ";" as a deliminator) name;region
     */
    public City(String s, String delim){
        StringTokenizer st = new StringTokenizer(s,delim);
        String nameStr = st.nextToken();
        String regionStr = st.nextToken();
        
        String classMsg = "(ERR CONST City)";
        
        try{
            name = CityName.valueOf(nameStr.replace(" ",""));
        }catch(Exception e){
            System.err.println(classMsg+nameStr+": Invalid Region name");
        }
        try{
            region = Region.valueOf(regionStr.replace(" ",""));
        }catch(Exception e){
            System.err.println(classMsg+regionStr+": Invalid Region name");
        }
    }

    public String toString(){
        return name+","+region;
    }
}
