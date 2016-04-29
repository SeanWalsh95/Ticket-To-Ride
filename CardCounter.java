import java.util.*;

/**
 * Static methods to help with cards
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class CardCounter {
    public static int countTrainColor(ArrayList<Card> list, RouteColor color) {
        int count = 0;
        for (Card c : list)
            if (((Train) c).color == color)
                count++;
        return count;
    }
}
