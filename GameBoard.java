import java.util.*;
import java.io.*;
/**
 * Write a description of class GameBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard
{
    ArrayList<City> cities = new ArrayList<City>();
    ArrayList<Route> routes = new ArrayList<Route>();

    public static void main(String args[]){
        GameBoard board = new GameBoard();
        board.printLists();

    }

    public GameBoard(){
        importCities();
        importRoutes();
    }

    public void printLists(){
        System.out.println("Cities:");
        for(City c : cities){
            System.out.println(c.toString());
        }
        System.out.println("\n\n\nRoutes:");
        for(Route r : routes){
            System.out.println(r.toString());
        }
    }

    /**
     * Imports routes from the text file "Cities.txt"
     */
    public void importCities(){
        try(Scanner sc = new Scanner(new File("resources\\Cities.txt"))){
            while(sc.hasNext()){
                cities.add(new City(sc.nextLine(),","));
            }
        }catch(Exception FileNotFound){
            System.err.println("Cities.txt not found");
        }
    }

    /**
     * Imports routes from the text files "Routes.txt" and "FerryRoutes.txt"
     */
    public void importRoutes(){
        try(Scanner sc = new Scanner(new File("resources\\Routes.txt"))){
            while(sc.hasNext()){
                routes.add(new Route(sc.nextLine(),","));
            }
        }catch(Exception FileNotFound){
            System.err.println("Routes.txt not found");
        }
        try(Scanner sc = new Scanner(new File("resources\\FerryRoutes.txt"))){
            while(sc.hasNext()){
                routes.add(new FerryRoute(sc.nextLine(),","));
            }
        }catch(Exception FileNotFound){
            System.err.println("FerryRoutes.txt not found");
        }

    }
}