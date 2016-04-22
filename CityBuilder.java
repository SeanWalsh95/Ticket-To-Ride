import java.util.*;
import java.io.*;
/**
 * Temporary class to act as gameBoard and construst the citys Array for testing
 * 
 */
public class CityBuilder
{
    protected ArrayList<City> cities;
    public CityBuilder()
    {
        cities = new ArrayList<City>();
        try(Scanner sc = new Scanner(new File("resources\\Cities.txt")))
        {
            while(sc.hasNext()){
                String line = sc.nextLine();
                City c = new City(line,",");
                System.out.println(c.toString());
                cities.add(c);
            }
        }
        catch(Exception e)
        {
            System.err.println("Cannot find citys file");
            System.err.println(e.getMessage());
        }
    }
}
