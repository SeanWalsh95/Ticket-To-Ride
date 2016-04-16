import java.util.*;
import javax.swing.*;
/**
 * Write a description of class GameBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard
{
    protected ArrayList<Player> players;
    protected ArrayList<Route> routes;
    protected ArrayList<City> cities;
    protected Deck trainDeck;
    protected Deck destDeck;
    private boolean lastTurn;
    private int currentPlayer;

    /**
     * Purchases the route between two cities for the current player
     * 
     * @param cityA One of the cities that connects the desired route
     * @param cityB One of the cities that connects the desired route
     * 
     * @return The method returns true if the purchase was successful
     */
    public boolean buyRoute(City cityA, City cityB){
        Player curPlayer = players.get(currentPlayer);
        Route desRoute = getRoute(cityA.name,cityB.name);
        boolean success = false;
        if(desRoute == null) return success;
        if(desRoute.ownerID == -1){
            if(techChecker(curPlayer,desRoute,cityA,cityB)){
                ArrayList<Card> trainsToSpend = selectTrains();
                if(desRoute instanceof FerryRoute){
                    if(purchase(desRoute,curPlayer,((FerryRoute)desRoute).locomotiveRequirement)){
                        success = true;
                        desRoute.ownerID = curPlayer.playerID;
                    }
                }
                else{
                    if(purchase(desRoute,curPlayer,0)){
                        success = true;
                        desRoute.ownerID = curPlayer.playerID;
                    }
                }
            }
        }
        return success;
    }

    /**
     * Handles removal of cards from the player's hand in order to purchase route
     * 
     * @param route The route you want to buy
     * @param player The player doing the buying
     * @param locoCost The number of locomotives needed to buy the route
     * 
     * @return Returns true if purchase was successful, false if not
     */
    private boolean purchase(Route route,Player player,int locoCost,ArrayList<Card> trains){
        int locos = 0;
        int unmatchedTrains = 0;
        int properColor = 0;
        int trainReq = route.trainRequirement;
        if(hasTech(player,"diesel power"))trainReq--;
        RouteColor colorOfClaim = route.color;
        if(trainReq > trains.size())return false;
        else if(trains.size() >= trainReq){
            if(route.color != RouteColor.NEUTRAL){
                RouteColor mostPopColor = getMostColor(trains);
                for(Card train: trains){
                    if((Train)train.color != mostPopColor)unmatchedTrains++;
                    else properColor++;
                }
                if(hasTech(player,"booster")){
                    locos += unmatchedTrains/3;
                }
                else{
                    locos += unmatchedTrains/4;
                }
            }
            else{
                for(Card train: trains){
                    if((Train)train.color != colorOfClaim)unmatchedTrains++;
                    else properColor++;
                }
                if(hasTech(player,"booster")){
                    locos += unmatchedTrains/3;
                }
                else{
                    locos += unmatchedTrains/4;
                }
            }
        }
        for(i = 0; i < trains.size(); i++){
            if(((Train)trains.get(i)).color == RouteColor.NEUTRAL)locos++;
        }
        if(locos < locoCost)return false;
        locos -= locoCost;
        if(trainReq > (locos + properColor))return false;
        for(Card train: trains){
            player.heldTrainCards.remove(train);
            trainDeck.discarded.add(train);
        }
        return true;
    }

    /**
     * Gets the train color most prevalent in the given ArrayList
     * 
     * @param trains The ArrayList you want to search
     * 
     * @return The color most prevalent in the array
     */
    private RouteColor getMostColor(ArrayList<Card> trains){
        int yellow = 0;
        int pink = 0;
        int red = 0;
        int black = 0;
        int blue = 0;
        int green = 0;
        int white = 0;
        int orange = 0;
        for(Card train: trains){
            if((Train)train.color == RouteColor.YELLOW)yellow++;
            else if((Train)train.color == RouteColor.PINK)pink++;
            else if((Train)train.color == RouteColor.RED)red++;
            else if((Train)train.color == RouteColor.BLACK)black++;
            else if((Train)train.color == RouteColor.BLUE)blue++;
            else if((Train)train.color == RouteColor.GREEN)green++;
            else if((Train)train.color == RouteColor.WHITE)white++;
            else if((Train)train.color == RouteColor.ORANGE)orange++;
        }
        if(yellow >= pink && yellow >= red && yellow >= black &&
        yellow >= blue && yellow >= green && yellow >= white && yellow >= orange){
            return RouteColor.YELLOW;
        }
        else if(pink >= yellow && pink >= red && pink >= black &&
        pink >= blue && pink >= green && pink >= white && pink >= orange){
            return RouteColor.PINK;
        }
        else if(red >= pink && red >= yellow && red >= black &&
        red >= blue && red >= green && red >= white && red >= orange){
            return RouteColor.RED;
        }
        else if(black >= pink && black >= red && black >= yellow &&
        black >= blue && black >= green && black >= white && black >= orange){
            return RouteColor.BLACK;
        }
        else if(blue >= pink && blue >= red && blue >= yellow &&
        blue >= black && blue >= green && blue >= white && blue >= orange){
            return RouteColor.BLUE;
        }
        else if(green >= pink && green >= red && green >= yellow &&
        green >= blue && green >= black && green >= white && green >= orange){
            return RouteColor.GREEN;
        }
        else if(white >= pink && white >= red && white >= yellow &&
        white >= blue && white >= green && white >= black && white >= orange){
            return RouteColor.WHITE;
        }
        else{
            return RouteColor.BLACK;
        }
    }

    /**
     * Helper method compares necessary tech to the tech the player currently owns
     * 
     * @param player The player whose tech you want to check
     * @param route The route whose requirements you want to check
     * @param cityA One of the cities connected to the route
     * @param cityB One of the cities connected to the route
     * 
     * @return Method returns true if the player can buy the route, false if not
     */
    private boolean techChecker(Player player, Route route, City cityA, City cityB){
        //Next 2 if blocks handles all checks for region techs 
        if(cityA.region != Region.England){
            if(cityA.region == Region.Scotland){
                if(!hasTech(player,"scotland concession")) return false;
            }
            else if(cityA.region == Region.Wales){
                if(!hasTech(player,"wales concession")) return false;
            }
            else{
                if(!hasTech(player,"ireland/france concession")) return false;
            }
        }
        if(cityB.region != Region.England &&
        cityB.region != cityA.region){
            if(cityB.region == Region.Scotland){
                if(!hasTech(player,"scotland concession")) return false;
            }
            else if(cityB.region == Region.Wales){
                if(!hasTech(player,"wales concession")) return false;
            }
            else{
                if(!hasTech(player,"ireland/france concession")) return false;
            }
        }

        //Handles route length checks
        if(route.trainRequirement == 3){
            if(!hasTech(player,"mechanical stoker")) return false;
        }
        else if(route.trainRequirement == 4 && route.trainRequirement == 5 && route.trainRequirement == 6){
            if(!hasTech(player,"superheated steam boiler")) return false;
        }

        //checks if it is a ferry route DOES NOT HANDLE THE SPECIAL ROUTE CASE YET BE ADVISED
        if(route instanceof FerryRoute){
            if(!hasTech(player,"propellers")) return false;
        }

        return true;
    }

    /**
     * Checks if the player has a tech named techName
     * 
     * @param player The player you want to check if they own the tech 
     * @param techName The name of the tech you want to find
     * 
     * @return The method returns true if the player owns a tech of the specified name
     */
    private boolean hasTech(Player player, String techName){
        for(Tech tech: player.tech){
            if(tech.name.toLowerCase().equals(techName)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method finds a route that connects two cities
     * 
     * @param cityA The name of one of the cities you want to connect
     * @param cityB The name of one of the cities you want to connect
     * 
     * @return The Route object that connects the two cities
     */
    public Route getRoute(CityName cityA, CityName cityB){
        for(int i=0; i<routes.size(); i++){
            if((routes.get(i).cityA.equals(cityA) && routes.get(i).cityB.equals(cityB)) ||
            (routes.get(i).cityB.equals(cityA) && routes.get(i).cityA.equals(cityB)))
                return routes.get(i);
        }
        return null;
    }

    /**
     * This method moves the currentPlayer to the next player and ends their turn
     */
    public void endTurn(){
        currentPlayer++;
        if(currentPlayer >= players.size())
            currentPlayer = currentPlayer - players.size();
    }

    /**
     * This method will execute the checks at the end of the game to see if players have or have not satisfied their destination cards
     */
    public void checkAllPlayersDest(){
        for(int i=0; i<players.size(); i++){
            players.get(i).score += checkPlayerDest(players.get(i));
        }
    }

    /**
     * This method returns the total number of points the player will either receive or lose from their destination
     * cards
     * 
     * @param player The player whose destination cards you want to check'
     * 
     * @return int The points the player will lose or gain as a result of destination cards
     */
    private int checkPlayerDest(Player player){
        int score = 0;
        ArrayList<CityName> visited = new ArrayList<CityName>();
        for(int i=0; i<player.heldDestinationCards.size(); i++){
            if(checkDestCard(player.playerID,((Dest)player.heldDestinationCards.get(i)).cityA,((Dest)player.heldDestinationCards.get(i)).cityB,visited))
                score += ((Dest)player.heldDestinationCards.get(i)).pointValue;
            else
                score -= ((Dest)player.heldDestinationCards.get(i)).pointValue;
        }
        return score;
    }

    /**
     * Helper method that executes Depth First Search to see if a path from the start point of a 
     * destination card to the endpoint exists
     * 
     * @param playerID The int value associated with the player and routes to indicate ownership
     * @param start The starting city that you want to build a path from
     * @param dest The destination city that you want to reach with your path
     * @param visited An ArrayList of all the cities the algorithm has visited while trying to get from start to dest
     * 
     * @return The method will return true if a path exists or false otherwise
     */
    private boolean checkDestCard(int playerID, CityName start, CityName dest, ArrayList<CityName> visited){
        if(start.equals(dest))return true;
        else{
            visited.add(start);
            for(int i=0; i<routes.size(); i++){
                if(routes.get(i).ownerID == playerID){
                    if(routes.get(i).cityA.equals(start) && !visited.contains(routes.get(i).cityB))
                        return checkDestCard(playerID,routes.get(i).cityB,dest,visited);
                    else if(routes.get(i).cityB.equals(start) && !visited.contains(routes.get(i).cityA))
                        return checkDestCard(playerID,routes.get(i).cityA,dest,visited);
                }
            }
        }
        return false;
    }
}
