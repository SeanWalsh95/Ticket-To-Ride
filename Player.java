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
    protected String name = "";
    protected int id = 0;
    protected Color color = Color.BLACK;
    protected int trainPieces = 0;
    protected int score = 0;
    protected int completedDestCards = 0;
    protected ArrayList<Card> heldDestinationCards = new ArrayList<Card>();
    protected ArrayList<Card> heldTrainCards = new ArrayList<Card>();
    protected ArrayList<Card> heldTechCards = new ArrayList<Card>();

    public Player(int playerID, String playerName, Color playerColor){
        this.id = playerID;
        this.name = playerName;
        this.color = playerColor;
        trainPieces = 35;
    }

    public String toString(){
        return name+" ID:"+id;
    }

}
