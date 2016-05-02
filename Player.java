import java.util.*;
import java.awt.*;

/**
 * Write a description of class Player here.
 *
 * @author group 3
 * @version 0.1
 */
public class Player {
    protected String name = "";
    protected int id = 0;
    protected int drawCount = 2;
    protected Color color = Color.BLACK;
    protected int trainPieces = 0;
    protected int score = 0;
    protected int completedDestCards = 0;
    protected int longestRoute = 0;
    protected ArrayList<Card> heldDestinationCards = new ArrayList<Card>();
    protected ArrayList<Card> heldTrainCards = new ArrayList<Card>();
    protected ArrayList<Card> heldTechCards = new ArrayList<Card>();
    protected boolean startedWithDeck = false;

    public Player(int playerID, String playerName, Color playerColor) {
        this.id = playerID;
        this.name = playerName;
        this.color = playerColor;
        trainPieces = 35;
    }

    public String toString() {
        return name + " ID:" + id;
    }

    /**
     * Removes a train card from the player's hand that is
     * the same as the given card
     * 
     * @param tr The train you want to remove
     * 
     * @return The train you removed
     */
    public Card removeTrainCard(Card tr){
        for(int i = 0; i < heldTrainCards.size(); i++){
            if(tr.equals(heldTrainCards.get(i))){
                return heldTrainCards.remove(i);
            }
        }
        return null;
    }
}
