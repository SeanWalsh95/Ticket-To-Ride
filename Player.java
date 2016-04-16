import java.util.*;
import java.awt.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    protected String playerName = "";
    protected int playerID = 0;
    protected Color playerColor = Color.BLACK;
    protected int trainPieces = 0;
    protected int score = 0;
    protected ArrayList<Card> heldDestinationCards = new ArrayList<Card>();
    protected ArrayList<Card> heldTrainCards = new ArrayList<Card>();
    protected ArrayList<Tech> tech = new ArrayList<Tech>();
    
    public String toString(){
        return playerName+" ID:"+playerID;
    }

}
