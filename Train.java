import java.util.*;
/**
 * Write a description of class Train here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Train extends Card
{
    protected RouteColor color;
    protected String imagePath;
    /**
     * Constructor for objects of class Train
     */
    public Train(String s, String delim)
    {
        // the following block of code breaks a single string into the 
        // parameter values for the class storing them in local strings to be
        // parsed into values for the class
        StringTokenizer st = new StringTokenizer(s,delim);
        String trainColor = st.nextToken();
        String trainImagePath = st.nextToken();
        
        //identifying message for this class
        String classMsg = "(ERR CONST Train)";
        
        try
        {
            color = RouteColor.valueOf(trainColor.toUpperCase().replace(" ", ""));
        }
        catch(Exception e)
        {
            System.err.println(classMsg+trainColor+" : Invalid Train Color");
        }
        try
        {
            imagePath = trainImagePath.replace(" ","");
        }
        catch(Exception e)
        {
            System.err.println(classMsg+trainImagePath+" : Invalid train image path");
        }
    }
}