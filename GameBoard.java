import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Write a description of class GameBoard here.
 *
 * @author Nolan Tunny
 * @version 1.0
 */
public class GameBoard {
    protected ArrayList<Player> players;
    protected ArrayList<Route> routes;
    protected ArrayList<City> cities;
    protected ArrayList<Card> techAvail;
    protected Deck trainDeck;
    protected Deck destDeck;
    protected int currentPlayer;
    private int countPlayer;
    private boolean lastTurn;
    protected boolean rightOfWay;

    /**
     * Constructor for the GameBoard class that sets the board up to be
     * played and handle logic
     *
     * @param playersIn An array list representing the players of the game
     */
    public GameBoard(ArrayList<Player> playersIn){
        rightOfWay = false;
        routes = new ArrayList<Route>();
        try(Scanner sc = new Scanner(new File("resources\\Routes.txt")))
        {
            while(sc.hasNext())
                routes.add(new Route(sc.nextLine(),","));
        }catch(Exception e){
            System.err.println("(ERR Routes): Cannot find file: " +
                "resources\\Routes.txt");
        }
        try(Scanner sc = new Scanner(new File("resources\\FerryRoutes.txt")))
        {
            while(sc.hasNext())
                routes.add(new FerryRoute(sc.nextLine(),","));
        }catch(Exception e){
            System.err.println("(ERR routes): Cannot find file: " +
                "resources\\FerryRoutes.txt");
        }

        cities = new ArrayList<City>();
        try(Scanner sc = new Scanner(new File("resources\\Cities.txt")))
        {
            while(sc.hasNext())
                cities.add(new City(sc.nextLine(),","));
        }
        catch(Exception e)
        {
            System.err.println("(ERR cities): Cannot find file: " +
                "resources\\Cities.txt");
        }

        techAvail = new ArrayList<Card>();
        try(Scanner sc = new Scanner(new File("resources\\Technologies.txt")))
        {
            while(sc.hasNext())
                techAvail.add(new Tech(sc.nextLine(),","));
        }catch(Exception e){
            System.err.println("(ERR Tech): Cannot find file: " +
                "resources\\Technologies.txt");
        }

        trainDeck = new Deck("Train","resources\\TrainCards.txt");
        trainDeck.shuffle();

        destDeck = new  Deck("Dest","resources\\DestinationCards.txt");
        destDeck.shuffle();

        lastTurn = false;

        currentPlayer = 0;

        countPlayer = -1;

        players = playersIn;
        /*
        players = new ArrayList<Player>();
        players.add(new Player(0,"bob",Color.BLUE));
        players.add(new Player(1,"joe",Color.GREEN));
        players.add(new Player(2,"sam",Color.RED));
         */
    }

    /**
     * Purchases the route between two cities for the current player
     *
     * @param cityA One of the cities that connects the desired route
     * @param cityB One of the cities that connects the desired route
     * @return The method returns true if the purchase was successful
     */
    public boolean buyRoute(City cityA, City cityB) {
        Player curPlayer = players.get(currentPlayer);
        Route desRoute = getRoute(cityA.name, cityB.name,null);
        boolean success = false;
        if(JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog
        (null,
            "Do you want to purchase the " + desRoute
            .color +
            " route from " +
            desRoute.cityA + " to " + desRoute.cityB
            + "?","choose one", JOptionPane
            .YES_NO_OPTION)){
            desRoute = getRoute(cityA.name,cityB.name,desRoute);
            if(JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog
            (null,
                "Do you want to purchase the " + desRoute
                .color +
                " route from " +
                desRoute.cityA + " to " + desRoute.cityB
                + "?","choose one", JOptionPane
                .YES_NO_OPTION))
                return success;
        }
        if (desRoute == null) return success;
        if (curPlayer.trainPieces < desRoute.trainRequirement){
            JOptionPane.showMessageDialog(null,
                "Insufficient train pieces!","Alert!",
                JOptionPane
                .INFORMATION_MESSAGE);
            return success;
        }
        if(desRoute.ownerID.contains(curPlayer.id)){
            JOptionPane.showMessageDialog(null,
                "You already own that route!","Alert!",
                JOptionPane
                .INFORMATION_MESSAGE);
            return success;
        }
        if (desRoute.ownerID.size() == 0 || rightOfWay) {
            if (techChecker(curPlayer, desRoute, cityA, cityB)) {
                ArrayList<Card> trainsToSpend = promptTrainSelect();
                if (desRoute instanceof FerryRoute) {
                    if (purchase(desRoute, curPlayer, ((FerryRoute)
                            desRoute).locomotiveRequirement,trainsToSpend)) {
                        success = true;
                        desRoute.ownerID.add(curPlayer.id);
                        if(players.size() == 2)
                            routes.remove(
                                getRoute(cityA.name,cityB.name,desRoute));
                        if (hasTech(curPlayer, Technology.BoilerLagging))
                            curPlayer.score += 1;
                        if (hasTech(curPlayer, Technology.SteamTurbine))
                            curPlayer.score += 2;
                        if (desRoute.trainRequirement == 1) {
                            curPlayer.score += 1;
                            curPlayer.trainPieces -= 1;
                        } else if (desRoute.trainRequirement == 2) {
                            curPlayer.score += 2;
                            curPlayer.trainPieces -= 2;
                        } else if (desRoute.trainRequirement == 3) {
                            curPlayer.score += 4;
                            curPlayer.trainPieces -= 3;
                        } else if (desRoute.trainRequirement == 4) {
                            curPlayer.score += 7;
                            curPlayer.trainPieces -= 4;
                        } else if (desRoute.trainRequirement == 5) {
                            curPlayer.score += 10;
                            curPlayer.trainPieces -= 5;
                        } else if (desRoute.trainRequirement == 6) {
                            curPlayer.score += 15;
                            curPlayer.trainPieces -= 6;
                        } else {
                            curPlayer.score += 40;
                            curPlayer.trainPieces -= 10;
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                            "Purchase failed try again","Alert!",
                            JOptionPane
                            .INFORMATION_MESSAGE);
                    }
                } else {
                    if (purchase(desRoute, curPlayer, 0, trainsToSpend)) {
                        success = true;
                        desRoute.ownerID.add(curPlayer.id);
                        if(players.size() == 2)
                            routes.remove(
                                getRoute(cityA.name,cityB.name,desRoute));
                        if (hasTech(curPlayer, Technology.BoilerLagging))
                            curPlayer.score += 1;
                        if (desRoute.trainRequirement == 1) {
                            curPlayer.score += 1;
                            curPlayer.trainPieces -= 1;
                        } else if (desRoute.trainRequirement == 2) {
                            curPlayer.score += 2;
                            curPlayer.trainPieces -= 2;
                        } else if (desRoute.trainRequirement == 3) {
                            curPlayer.score += 4;
                            curPlayer.trainPieces -= 3;
                        } else if (desRoute.trainRequirement == 4) {
                            curPlayer.score += 7;
                            curPlayer.trainPieces -= 4;
                        } else if (desRoute.trainRequirement == 5) {
                            curPlayer.score += 10;
                            curPlayer.trainPieces -= 5;
                        } else if (desRoute.trainRequirement == 6) {
                            curPlayer.score += 15;
                            curPlayer.trainPieces -= 6;
                        } else {
                            curPlayer.score += 40;
                            curPlayer.trainPieces -= 10;
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                            "Purchase failed try again","Alert!",
                            JOptionPane
                            .INFORMATION_MESSAGE);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,
                    "You don't have the right tech!","Alert!",
                    JOptionPane
                    .INFORMATION_MESSAGE);
            }
        }
        if (success == true) {
            if (!hasTech(curPlayer, Technology.Thermocompressor)) endTurn();
            else discardTech(curPlayer, Technology.Thermocompressor);
        }
        return success;
    }

    /**
     * Handles removal of cards from the player's hand in order to purchase
     * route
     *
     * @param route    The route you want to buy
     * @param player   The player doing the buying
     * @param locoCost The number of locomotives needed to buy the route
     * @return Returns true if purchase was successful, false if not
     */
    private boolean purchase(Route route, Player player, int locoCost,
    ArrayList<Card> trains) {
        int locos = 0;
        int unmatchedTrains = 0;
        int properColor = 0;
        int trainReq = route.trainRequirement;
        if (hasTech(player, Technology.DieselPower)) trainReq--;
        RouteColor colorOfClaim = route.color;
        if (trainReq > trains.size()) return false;
        else if (trains.size() >= trainReq) {
            if (route.color == RouteColor.NEUTRAL) {
                RouteColor mostPopColor = getMostColor(trains);
                System.out.println(mostPopColor);
                for (Card train : trains) {
                    if (((Train)train).color != mostPopColor) unmatchedTrains++;
                    else properColor++;
                }
                if (hasTech(player, Technology.Booster)) {
                    locos += unmatchedTrains / 3;
                } else {
                    locos += unmatchedTrains / 4;
                }
            } else {
                for (Card train : trains) {
                    if (((Train)train).color != colorOfClaim) unmatchedTrains++;
                    else properColor++;
                }
                if (hasTech(player, Technology.Booster)) {
                    locos += unmatchedTrains / 3;
                } else {
                    locos += unmatchedTrains / 4;
                }
            }
        }
        for (int i = 0; i < trains.size(); i++) {
            if (((Train) trains.get(i)).color == RouteColor.NEUTRAL) locos++;
        }
        if (locos < locoCost) return false;
        locos -= locoCost;
        if (trainReq > (locos + properColor)) return false;
        for (Card train : trains) {
            trainDeck.discarded.add(player.removeTrainCard(train));
        }
        return true;
    }

    /**
     * Gets the train color most prevalent in the given ArrayList
     *
     * @param trains The ArrayList you want to search
     * @return The color most prevalent in the array
     */
    private RouteColor getMostColor(ArrayList<Card> trains) {
        int yellow = 0;
        int pink = 0;
        int red = 0;
        int black = 0;
        int blue = 0;
        int green = 0;
        int white = 0;
        int orange = 0;
        for (Card train : trains) {
            if (((Train) train).color == RouteColor.YELLOW) yellow++;
            else if (((Train) train).color == RouteColor.PINK) pink++;
            else if (((Train) train).color == RouteColor.RED) red++;
            else if (((Train) train).color == RouteColor.BLACK) black++;
            else if (((Train) train).color == RouteColor.BLUE) blue++;
            else if (((Train) train).color == RouteColor.GREEN) green++;
            else if (((Train) train).color == RouteColor.WHITE) white++;
            else if (((Train) train).color == RouteColor.ORANGE) orange++;
        }
        if (yellow >= pink && yellow >= red && yellow >= black &&
        yellow >= blue && yellow >= green && yellow >= white &&
        yellow >= orange) {
            return RouteColor.YELLOW;
        } else if (pink >= yellow && pink >= red && pink >= black &&
        pink >= blue && pink >= green && pink >= white && pink >=
        orange) {
            return RouteColor.PINK;
        } else if (red >= pink && red >= yellow && red >= black &&
        red >= blue && red >= green && red >= white && red >= orange) {
            return RouteColor.RED;
        } else if (black >= pink && black >= red && black >= yellow &&
        black >= blue && black >= green && black >= white && black
        >= orange) {
            return RouteColor.BLACK;
        } else if (blue >= pink && blue >= red && blue >= yellow &&
        blue >= black && blue >= green && blue >= white && blue >=
        orange) {
            return RouteColor.BLUE;
        } else if (green >= pink && green >= red && green >= yellow &&
        green >= blue && green >= black && green >= white && green
        >= orange) {
            return RouteColor.GREEN;
        } else if (white >= pink && white >= red && white >= yellow &&
        white >= blue && white >= green && white >= black && white
        >= orange) {
            return RouteColor.WHITE;
        } else {
            return RouteColor.BLACK;
        }
    }

    /**
     * Helper method compares necessary tech to the tech the player currently
     * owns
     *
     * @param player The player whose tech you want to check
     * @param route  The route whose requirements you want to check
     * @param cityA  One of the cities connected to the route
     * @param cityB  One of the cities connected to the route
     * @return Method returns true if the player can buy the route, false if
     * not
     */
    private boolean techChecker(Player player, Route route, City cityA, City
    cityB) {
        //You need no tech for the southampton to New York route this base
        // case handles that;
        if (route.cityA == CityName.NewYork || route.cityB == CityName.NewYork) return true;

        //Next 2 if blocks handles all checks for region techs
        if (cityA.region != Region.England) {
            if (cityA.region == Region.Scotland) {
                if (!hasTech(player, Technology.ScotlandConcession))
                    return false;
            } else if (cityA.region == Region.Wales) {
                if (!hasTech(player, Technology.WalesConcession)) return false;
            } else {
                if (!hasTech(player, Technology.IrelandFranceConcession))
                    return false;
            }
        }
        if (cityB.region != Region.England &&
        cityB.region != cityA.region) {
            if (cityB.region == Region.Scotland) {
                if (!hasTech(player, Technology.ScotlandConcession))
                    return false;
            } else if (cityB.region == Region.Wales) {
                if (!hasTech(player, Technology.WalesConcession)) return false;
            } else {
                if (!hasTech(player, Technology.IrelandFranceConcession))
                    return false;
            }
        }

        //Handles route length checks
        if (route.trainRequirement == 3) {
            if (!hasTech(player, Technology.MechanicalStoker)) return false;
        }
        if (route.trainRequirement == 4 || route.trainRequirement == 5
        || route.trainRequirement == 6) {
            if (!hasTech(player, Technology.SuperheatedSteamBoiler))
                return false;
        }

        //checks if it is a ferry route
        if (route instanceof FerryRoute) {
            if (!hasTech(player, Technology.Propellers)) return false;
        }

        return true;
    }

    /**
     * Checks if the player has a tech named techName
     *
     * @param player   The player you want to check if they own the tech
     * @param techName The name of the tech you want to find
     * @return The method returns true if the player owns a tech of the
     * specified name
     */
    public boolean hasTech(Player player, Technology techName) {
        for (Card c : player.heldTechCards) {
            if (((Tech)c).name == techName) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the tech named techName from the player
     *
     * @param player   The player you want to remove the tech from
     * @param techName The name of the tech you want to discard
     */
    private void discardTech(Player player, Technology techName) {
        for (Card c : player.heldTechCards) {
            if (((Tech)c).name == techName) {
                techAvail.add(((Tech)c));
                player.heldTechCards.remove(((Tech)c));
            }
        }

    }

    /**
     * Method finds a route that connects two cities
     *
     * @param cityA The name of one of the cities you want to connect
     * @param cityB The name of one of the cities you want to connect
     * @return The Route object that connects the two cities
     */
    public Route getRoute(CityName cityA, CityName cityB, Route exclude) {
        for (int i = 0; i < routes.size(); i++) {
            if ((routes.get(i).cityA.equals(cityA) && routes.get(i).cityB
                .equals(cityB)) ||
            (routes.get(i).cityB.equals(cityA) && routes.get(i)
                .cityA.equals(cityB)))
                if(!routes.get(i).equals(exclude))
                    return routes.get(i);
        }
        return null;
    }

    /**
     * This method handles tech purchasing
     *
     * @param tech The tech that the player selects to buy
     * @return Method returns true if the tech is purchased successfully
     */
    public boolean buyTech(Tech tech) {
        ArrayList<Card> trainsToSpend = promptTrainSelect();
        ArrayList<Card> trainsSpent = new ArrayList<Card>();
        Player curPlayer = getCurrentPlayer();
        int locoCost = tech.cost;
        System.out.println(trainsToSpend);
        if (trainsToSpend.size() < locoCost){
            JOptionPane.showMessageDialog(null,
                "Purchase failed try again","Alert!",
                JOptionPane
                .INFORMATION_MESSAGE);
            return false;
        }
        else {
            for (int i = 0; i<trainsToSpend.size(); i++) {
                if (((Train)trainsToSpend.get(i)).color == RouteColor.NEUTRAL) {
                    trainsSpent.add(trainsToSpend.remove(i));
                    i--;
                }
            }
            System.out.println(trainsSpent);
            if (trainsSpent.size() == locoCost) {
                for (int i = 0; i<trainsSpent.size(); i++) {
                    trainDeck.discarded.add(curPlayer.removeTrainCard(trainsSpent.get(i)));
                }
                if(tech.name == Technology.RightOfWay){
                    JOptionPane.showMessageDialog(null,
                        "You Have purchased Right of Way!","Alert!",
                        JOptionPane
                        .INFORMATION_MESSAGE);
                    rightOfWay = true;
                }
                else{
                    techAvail.remove(tech);
                    curPlayer.heldTechCards.add(tech);
                }
                return true;
            } else {
                if (hasTech(curPlayer, Technology.Booster)) {
                    if (locoCost == trainsSpent.size() + (trainsToSpend.size
                        () / 3)) {
                        trainsSpent.addAll(trainsToSpend);
                        for (int i = 0; i<trainsSpent.size(); i++) {
                            trainDeck.discarded.add(curPlayer.removeTrainCard(trainsSpent.get(i)));
                        }
                        if(tech.name == Technology.RightOfWay){
                            JOptionPane.showMessageDialog(null,
                                "You Have purchased Right of Way!","Alert!",
                                JOptionPane
                                .INFORMATION_MESSAGE);
                            rightOfWay = true;
                        }
                        else{
                            techAvail.remove(tech);
                            curPlayer.heldTechCards.add(tech);
                        }
                        return true;
                    }
                } else {
                    if (locoCost == trainsSpent.size() + (trainsToSpend.size
                        () / 4)) {
                        trainsSpent.addAll(trainsToSpend);
                        for (int i = 0; i<trainsSpent.size(); i++) {
                            trainDeck.discarded.add(curPlayer.removeTrainCard(trainsSpent.get(i)));
                        }
                        if(tech.name == Technology.RightOfWay){
                            JOptionPane.showMessageDialog(null,
                                "You Have purchased Right of Way!","Alert!",
                                JOptionPane
                                .INFORMATION_MESSAGE);
                            rightOfWay = true;
                        }
                        else{
                            techAvail.remove(tech);
                            curPlayer.heldTechCards.add(tech);
                        }
                        return true;
                    }
                }
            }
            JOptionPane.showMessageDialog(null,
                "Purchase failed try again","Alert!",
                JOptionPane
                .INFORMATION_MESSAGE);
            return false;
        }

    }

    /**
     * This method moves the currentPlayer to the next player and ends their
     * turn
     */
    public void endTurn() {
        rightOfWay = false;
        if(trainDeck.deck.size() == 0) trainDeck.rebuildDeck();
        if(players.get(currentPlayer).trainPieces <= 3)
            lastTurn = true;
        if(lastTurn == true)
            countPlayer++;
        currentPlayer++;
        if (currentPlayer >= players.size())
            currentPlayer = currentPlayer - players.size();
        if(countPlayer == players.size()-1)
            endStep();
    }

    /**
     * This method will execute the checks at the end of the game to see if
     * players have or have not satisfied their destination cards
     */
    private void checkAllPlayersDest() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).score += checkPlayerDest(players.get(i));
        }
    }

    /**
     * This method returns the total number of points the player will either
     * receive or lose from their destination cards
     *
     * @param player The player whose destination cards you want to check
     * @return int The points the player will lose or gain as a result of
     * destination cards
     */
    private int checkPlayerDest(Player player) {
        int score = 0;
        for (int i = 0; i < player.heldDestinationCards.size(); i++) {
            ArrayList<CityName> visited = new ArrayList<CityName>();
            if (checkDestCard(player.id,
                ((Dest) player.heldDestinationCards.get(i)).cityA,
                ((Dest) player.heldDestinationCards.get(i)).cityB,
                visited)) {
                score += ((Dest)player.heldDestinationCards.get(i)).pointValue;
                player.completedDestCards++;
            } else
                score -= ((Dest) player.heldDestinationCards.get(i)).pointValue;
        }
        return score;
    }

    /**
     * Helper method that executes Depth First Search to see if a path from the
     * start point of destination card to the endpoint exists
     *
     * @param playerID The int value associated with the player and routes to
     *                 indicate ownership
     * @param start    The starting city that you want to build a path from
     * @param dest     The destination city that you want to reach with your
     *                 path
     * @param visited  An ArrayList of all the cities the algorithm has visited
     *                 while trying to get from start to dest
     * @return The method will return true if a path exists or false otherwise
     */
    private boolean checkDestCard(int playerID, CityName start, CityName dest,
    ArrayList<CityName> visited) {
        if (start.equals(dest)) return true;
        else {
            visited.add(start);
            for (int i = 0; i < routes.size(); i++) {
                if (routes.get(i).ownerID.contains(playerID)) {
                    if (routes.get(i).cityA.equals(start) &&
                    !visited.contains(routes.get(i).cityB))
                        return checkDestCard(playerID, routes.get(i).cityB,
                            dest, visited);
                    else if (routes.get(i).cityB.equals(start)
                    && !visited.contains(routes.get(i).cityA))
                        return checkDestCard(playerID, routes.get(i).cityA,
                            dest, visited);
                }
            }
        }
        return false;
    }

    /**
     * This method figures out if the player given has the longest route
     * 
     * @param player The player who wants to see if they have the 
     * longest route
     * @return Returns true if the given player has the longest route
     */
    private boolean doesPlayerHaveLongestRoute(Player player){
        for(int i = 0; i < players.size(); i++){
            players.get(i).longestRoute = longestRoutePlayerOwns(players.get(i));
        }
        for(int i = 0; i < players.size(); i++){
            if(player.longestRoute < players.get(i).longestRoute){
                return false;
            }
        }
        return true;
    }

    /**
     * This method will figure out the length of a player's longest route
     *
     * @param player The player whose route you want to check.
     * @return The length of the longest route the player owns
     */
    private int longestRoutePlayerOwns(Player player) {
        int pID = player.id;
        int max = 0;
        int temp = 0;
        for (Route route : routes) {
            if (route.ownerID.contains(pID)) {
                temp = playerRouteLength(pID, route, new ArrayList<Route>());
            }
            if (temp > max) max = temp;
        }
        return max;
    }

    /**
     * Helper method to check the length of a route containing the given route
     *
     * @param pID     The player's identification number
     * @param route   The route you want to add to the long route
     * @param visited The list of routes already included in the current route
     * @return The length of the route containing the given route
     */
    private int playerRouteLength(int pID, Route route,
    ArrayList<Route> visited) {
        int max = 0;
        int temp = 0;
        visited.add(route);
        for (Route rt : routes) {
            if (!visited.contains(rt) && rt.ownerID.contains(pID) &&
            (rt.cityA == route.cityA || rt.cityB == route.cityB ||
                rt.cityA == route.cityB || rt.cityB == rt.cityA)) {
                ArrayList<Route> tempVis = new ArrayList<Route>();
                tempVis.addAll(visited);
                temp = playerRouteLength(pID, rt, tempVis);
            }
            if (temp > max) max = temp;
        }
        return max + route.trainRequirement;
    }

    /**
     * The selectTrains method is used to allow the user to select trains
     * they want to spend
     *
     * @return The ArrayList containing the train cards that the player wants
     * to spend
     */
    private ArrayList<Card> selectTrains(){
        ArrayList<Card> selected = new ArrayList<Card>();
        Player p = getCurrentPlayer();
        for(int i = 0; i<p.heldTrainCards.size(); i++){
            if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                "Do you want " +
                "to" +
                " " +
                "add a " + ((Train)p.heldTrainCards.get(i)).color + " " +
                "train to your pool?","choose one",JOptionPane.YES_NO_OPTION)){
                selected.add(p.heldTrainCards.get(i));
            }
        }
        int confirm = JOptionPane.showConfirmDialog(null,"You sure?",
                "choose one",JOptionPane.YES_NO_CANCEL_OPTION);
        if(JOptionPane.YES_OPTION == confirm)return selected;
        else if(JOptionPane.NO_OPTION == confirm)return selectTrains();
        return null;
    }

    /**
     * Prompts the player to select trains to spend
     * 
     * @return The ArrayList of cards the player wants to spend
     */
    private ArrayList<Card> promptTrainSelect(){
        JFrame parentFrame = new JFrame();
        Player p = getCurrentPlayer();
        int cost = 0;//use as a paramater for this method
        String title = 
            "SELECT TRAINS (Cost:"+cost+")";
        TrainSelectPanel panel =
            new TrainSelectPanel(
            title,p.heldTrainCards);
        JDialog jd = new JDialog(parentFrame, true);
        jd.setTitle("Card Select");

        jd.setSize(1276, 939); // set frame size
        jd.add(panel);
        jd.setVisible(true);

        return new ArrayList<Card>(panel.selected);
    }

    /**
     * To be run when the end phase starts, essentially hijacks the game and
     * locks some rules down to account for the final steps
     */
    public void endStep(){
        checkAllPlayersDest();
        for(int i = 0; i < players.size(); i++){
            if(hasTech(players.get(i),Technology.EqualisingBeam)){
                if(doesPlayerHaveLongestRoute(players.get(i))){
                    players.get(i).score += 15;
                }
                else{
                    players.get(i).score -= 15;
                }
            }
            if(hasTech(players.get(i),Technology.RiskyContracts)){
                if(riskyContracts(players.get(i))){
                    players.get(i).score += 20;
                }
                else{
                    players.get(i).score -= 20;
                }
            }
        }
        JOptionPane.showMessageDialog(null,highestScore() +
            " wins!","Congratulations!",
            JOptionPane
            .INFORMATION_MESSAGE);
    }

    /**
     * Gets the Player with the highest score;
     * 
     * @return The player with the highes score
     */
    private Player highestScore(){
        Player high = players.get(0);
        for(int i = 1; i < players.size(); i++){
            if(high.score < players.get(i).score)
                high = players.get(i);
        }
        return high;
    }

    /**
     * This method handles the risky contracts card
     * 
     * @param player The player who owns the card
     * @return True if they have the most completed dest cards
     */
    private boolean riskyContracts(Player player){
        for(int i = 0; i < players.size(); i++){
            if(player.completedDestCards < players.get(i).completedDestCards){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is for retrieving the information for the current player
     * to be used to track player turns in GUI
     * 
     * @return The current Player object
     */
    public Player getCurrentPlayer(){
        return players.get(currentPlayer);
    }

    /**
     * Method used to retrieve the city object associated with the given
     * CityName
     * 
     * @param cn The name of the city you want to find
     * 
     * @return The city with the given name
     */
    public City getCity(CityName cn){
        for (City city : cities) {
            if (city.name == cn) {
                return city;
            }
        }
        return null;
    }

    /**
     * Method used to retrieve the Tech object associated with the
     * given Technology
     * 
     * @param t The name of the Tech you want to find
     * 
     * @return The Tech with the given name
     */
    public Tech getTech(Technology t){
        for (Card c : techAvail) {
            if (((Tech)c).name == t) {
                return (Tech)c;
            }
        }
        return null;
    }
}
