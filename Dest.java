import java.util.*;
/**
 * Write a description of class Destination here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dest extends Card
{
    CityName cityA, cityB;
    private static final String path = "resources\\images\\cards\\destination cards\\";
    public Dest(String line, String delim){
        StringTokenizer st = new StringTokenizer(line,delim);
        String cityAStr = st.nextToken();
        String cityBStr = st.nextToken();
        
        //identifying message for this class
        String classMsg = "(ERR CONST Destination)";
        
        try{
            cityA = CityName.valueOf(cityAStr.replace(" ",""));
        }catch(Exception e){
            System.err.println(classMsg+cityAStr+": Invalid City name");
        }
        try{
            cityB = CityName.valueOf(cityBStr.replace(" ",""));
        }catch(Exception e){
            System.err.println(classMsg+cityBStr+": Invalid City name");
        }
    }
    
    public String getImage(){
        return path+cityA+"_"+cityB+".jpg";
    }
}
