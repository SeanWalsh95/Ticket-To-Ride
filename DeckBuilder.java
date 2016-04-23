import java.util.*;
import java.io.*;
/**
 * Write a description of class DeckBuilder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeckBuilder
{
    //protected Deck trainDeck;
    protected Deck destDeck;
    protected ArrayList<Card> dest;
    protected ArrayList<Card> tech;
    public DeckBuilder()
    {
        //trainDeck = new Deck("Train","resources\\TainCards.txt");
        destDeck = new  Deck("Dest","resources\\DestinationCards.txt");
        
        dest = new ArrayList<Card>();
        dest.addAll(destDeck.drawCards(5));
        
        tech = new ArrayList<Card>();
        try(Scanner sc = new Scanner(new File("resources\\Technologies.txt")))
        {
            while(sc.hasNext())
                tech.add(new Tech(sc.nextLine(),","));
        }catch(Exception e){
            System.err.println("(ERR Tech): Cannot find file: resources\\Technologies.txt");
        }
    }
}
