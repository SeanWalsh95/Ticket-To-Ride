import java.util.*;
import java.io.File;
/**
 * Write a description of class routeBuilder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class routeBuilder
{
    public static void main(String args[]){
        routeBuilder rb = new routeBuilder("resources\\Routes.txt");
    }

    /**
     * Constructor for objects of class routeBuilder
     */
    public routeBuilder(String filePath)
    {
        ArrayList<Route> routes = new ArrayList<Route>();
        try(Scanner sc = new Scanner(new File(filePath)))
        {
            while(sc.hasNext()){
                String line = sc.nextLine();
                routes.add(new Route(line,","));
            }
        }catch(Exception e){
            System.err.println("(ERR Tech): Cannot find file: "+filePath);
        }
    }
}
