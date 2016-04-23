import java.util.*;
/**
 * Static methods to help with cards
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardCounter
{
    public static int countTrainColor(ArrayList<Card> list ,RouteColor color){ 
        int count = 0;
        for(Card c: list)
            if(((Train)c).color == color)
                count++;
        return count;
    }
}
