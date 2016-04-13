import java.util.*;
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
     * This method take shuffles the cards in the deck
     */
    public void shuffle()
    {
        Collections.shuffle(this.deck);//Randomly shuffles the deck
    }
    
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
    
}
