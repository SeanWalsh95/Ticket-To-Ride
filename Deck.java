import java.util.*;
import java.io.*;
/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();
    ArrayList<Card> discarded = new ArrayList<Card>();
    public Deck(String type, String path){
        try(Scanner sc = new Scanner(new File(path))){
            while(sc.hasNext()){
                if(type.equals("Train")){
                    StringTokenizer st = new StringTokenizer(sc.nextLine(),",");
                    String routeColorStr = st.nextToken();
                    int cardCount = Integer.parseInt(st.nextToken());
                    for(int i = 0; 0 < cardCount; i++)
                        deck.add(new Train(RouteColor.valueOf(routeColorStr)));
                }
                if(type.equals("Destination")){
                    deck.add(new Dest(sc.nextLine(),","));
                }
            }
        }catch(Exception e){
            System.err.println("Cannot find file from the follwing path"+path);
        }
    }
}
