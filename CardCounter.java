import java.util.*;

/**
 * Static methods to help with cards
 *
 * @author Sean Walsh
 * @version 1.0
 */
public class CardCounter {
    /**
     * counts cards of a specified color
     * 
     * @param list The ArrayList you want to count the color
     * @param color The color you want to check the count of
     * 
     * @return The number of trains of that color in the list
     */
    public static int countTrainColor(ArrayList<Card> list, RouteColor color) {
        int count = 0;
        for (Card c : list)
            if (((Train) c).color == color)
                count++;
        return count;
    }
}
