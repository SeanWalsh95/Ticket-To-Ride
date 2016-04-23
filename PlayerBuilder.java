import java.awt.*;
import java.util.*;
/**
 * Write a description of class PlayerBuilder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBuilder
{
    protected ArrayList<Player> players;

    public PlayerBuilder()
    {
        players = new ArrayList<Player>();
        players.add(new Player(0,"bob",Color.BLUE));
        players.add(new Player(1,"joe",Color.GREEN));
        players.add(new Player(2,"sam",Color.RED));
    }

}
