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
    protected ArrayList<Card> deck = new ArrayList<Card>();
    protected ArrayList<Card> discarded = new ArrayList<Card>();

    /**
     * This method shuffles the cards in the deck
     */
    public void shuffle()
    {
        Collections.shuffle(this.deck);//Randomly shuffles the deck
    }

    /**
     * This method takes a parameter x and draws that many cards from a deck
     * @param x The amount of cards to draw from the deck
     * @return An ArrayList of drawn cards
     */
    public ArrayList<Card> drawCards(int x)
    {
        ArrayList<Card> drawnCards = new ArrayList<Card>();
        for(int i = 0; i < x; i++)
        {
            drawnCards.add(deck.get(i));
            deck.remove(i);
        }
        return drawnCards;
    }

    /**
     * This is the constructor for Deck class
     * @param type The type of deck being created either Train or Dest
     * @param path The path of the file that is being read in to create the Deck
     */
    public Deck(String type, String path)
    {
        try(Scanner sc = new Scanner(new File(path)))
        {
            while(sc.hasNext()){
                if(type.equals("Train")){
                    String[] line = sc.nextLine().split(",");
                    int cardCount = Integer.parseInt(line[1]);
                    for(int i = 0; i < cardCount; i++)
                        deck.add(new Train(RouteColor.valueOf(line[0])));
                }
                if(type.equals("Destination")){
                    deck.add(new Dest(sc.nextLine(),","));
                }
            }
        }
        catch(Exception e)
        {
            System.err.println("Cannot find file from the follwing path"+path);
        }
        shuffle();
    }

    /**
     * This method rebuilds the deck by taking the discarded cards adding 
     * them to the deck and then clearing the discarded pile
     * 
     */
    public void rebuildDeck()
    {
        this.deck.addAll(discarded);
        shuffle();
        this.discarded.clear();
    }
    
    /**
     * This method returns the deck size
     */
    public int size()
    {
        return this.deck.size();
    }
    
    /**
     * This method adds discarded cards to the discarded ArrayList
     * @param x An ArrayList of cards that are going to be discarded
     */
    public void discard(ArrayList<Card> x)
    {
        this.discarded.addAll(x);
    }
}
