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
    int x, y;
    int xOFFSET= 16, yOFFSET = 39;
    boolean hover;

    /**
     * Constructor that takes a string deliminated with the given deliminator to initlize the values of this class
     * in the following format (example uses ";" as a deliminator) name;region;x;y
     */
    public City(String s, String delim){
        StringTokenizer st = new StringTokenizer(s,delim);
        String nameStr = st.nextToken();
        String regionStr = st.nextToken();
        String xStr = st.nextToken();
        String yStr = st.nextToken();

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
        try{
            x = Integer.parseInt(xStr);
        }catch(Exception e){
            System.err.println(classMsg+xStr+": Cannot parse x to int");
        }
        try{
            y = Integer.parseInt(yStr);
        }catch(Exception e){
            System.err.println(classMsg+yStr+": Cannot parse y to int");
        }
        hover = false;
    }

    public String toString(){
        return name+","+region+" ("+x+","+y+")";
    }

    public int getX(){
        return x+xOFFSET;
    }
    
    public int getY(){
        return y+yOFFSET;
    }
    
    /**
     * method to determine if a the curser is hovering over a citys location
     * 
     * @param mouseX the current x positon of the curser
     * @param mouseY the current y positon of the curser
     * 
     * @return true if hovering false if not
     */
    public boolean inRange(int mouseX, int mouseY){
        if(mouseX >= x+xOFFSET && mouseX <= x+20+xOFFSET && mouseY >= y+yOFFSET && mouseY <= y+20+yOFFSET){
            return true;
        }else{
            return false;
        }
    }
}
