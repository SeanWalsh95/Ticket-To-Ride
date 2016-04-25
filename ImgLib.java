import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * ImageLibrary holds all the images that are
 * Used in the GUI construction
 * 
 * @author (Jordan Cartwright) 
 * @version (a version number or a date)
 */
public class ImgLib
{
    //mouse cursor
    public static Image mouseCursor;

    public static Image woodBackground;

    public static Image backOfTrainCard;
    public static Image backOfDestCard;

    //general Images needed more than once
    public static Image backButtonUnselected;
    public static Image backButtonHighlighted;
    public static Image backButtonPressed;

    //get the images from the backgrounds folder
    public static Image mainMenuBackground;
    public static Image gameBoarbackground2Players;
    public static Image gameBoarbackground3Players;
    public static Image gameBoarbackground4Players;

    //images for the Main Menu
    public static Image mainMenu;
    public static Image playButtonUnselected;
    public static Image rulesButtonUnselected;
    public static Image quitButtonUnselected;
    public static Image playButtonHighlighted;
    public static Image rulesButtonHighlighted;
    public static Image quitButtonHighlighted;
    public static Image playButtonPressed;
    public static Image rulesButtonPressed;
    public static Image quitButtonPressed;

    //images for the selectNumPlayersScreen
    public static Image selectPlayers;
    public static Image twoPlayersUnselected;
    public static Image threePlayersUnselected;
    public static Image fourPlayersUnselected;
    public static Image twoPlayersHighlighted;
    public static Image threePlayersHighlighted;
    public static Image fourPlayersHighlighted;
    public static Image twoPlayersPressed;
    public static Image threePlayersPressed;
    public static Image fourPlayersPressed;

    //images for the rulesScreen
    public static Image rulesScreen1;
    public static Image rulesScreen2;
    public static Image nextButtonUnselected;
    public static Image previousButtonUnselected;
    public static Image nextButtonHighlighted;
    public static Image previousButtonHighlighted;
    public static Image nextButtonPressed;
    public static Image previousButtonPressed;

    //images for the gameBoard screen
    public static Image buyTechButtonUnselected;
    public static Image buyTechButtonHighlighted;
    public static Image buyTechButtonPressed;
    public static Image viewTechButtonUnselected;
    public static Image viewTechButtonHighlighted;
    public static Image viewTechButtonPressed;
    public static Image viewDestButtonUnselected;
    public static Image viewDestButtonHighlighted;
    public static Image viewDestButtonPressed;

    //CityHover Images
    public static Image emptyHover;
    public static Image stornowayHover;
    public static Image ullapoolHover;
    public static Image wickHover;
    public static Image fortwilliamHover;
    public static Image invernessHover;
    public static Image aberdeenHover;
    public static Image londonderryHover;
    public static Image glasgowHover;
    public static Image edinburghHover;
    public static Image dundeeHover;
    public static Image sligoHover;
    public static Image belfastHover;
    public static Image stranraerHover;
    public static Image galwayHover;
    public static Image dundalkHover;
    public static Image carlisleHover;
    public static Image newcastleHover;
    public static Image limerickHover;
    public static Image tullamoreHover;
    public static Image dublinHover;
    public static Image barrowsHover;
    public static Image corkHover;
    public static Image rosslareHover;
    public static Image hollyheadHover;
    public static Image liverpoolHover;
    public static Image leedsHover;
    public static Image aberystrythHover;
    public static Image manchesterHover;
    public static Image hullHover;
    public static Image carmarthenHover;
    public static Image llandrindodwellsHover;
    public static Image birminghamHover;
    public static Image nottinghamHover;
    public static Image cardiffHover;
    public static Image northamptonHover;
    public static Image cambridgeHover;
    public static Image norwichHover;
    public static Image penzanceHover;
    public static Image plymouthHover;
    public static Image bristolHover;
    public static Image readingHover;
    public static Image londonHover;
    public static Image ipswichHover;
    public static Image southamptonHover;
    public static Image brightonHover;
    public static Image doverHover;
    public static Image franceHover;

    public static Image background;

    //images for the viewTechScreen
    public static Image viewTech;

    //Images for the buyTechScreen
    public static Image buyTech;
    public static Image purchaseButtonUnselected;
    public static Image purchaseButtonHighlighted;
    public static Image purchaseButtonPressed;

    //Images for the viewDestScreen
    public static Image viewDest;

    /**
     * Constructor for objects of class ImageLibrary
     */
    public static void ImageLibrary()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Images for the viewTechScreen
        viewTech = toolkit.getImage(
            "resources/images/backgrounds/viewTechScreen.png");

        woodBackground = toolkit.getImage(
            "resources/images/backgrounds/Woodbackground.png");

        background = toolkit.getImage(
            "resources/images/backgrounds/GameBackground.png");

        backOfTrainCard = toolkit.getImage(
            "resources/images/cards/BackOfCard.png");
        backOfDestCard = toolkit.getImage(
            "resources/images/cards/BackOfTicket.png");

        //Images for the buyTechScreen
        buyTech = toolkit.getImage(
            "resources/images/backgrounds/buyTechScreen.png");
        purchaseButtonUnselected = toolkit.getImage(
            "resources/images/buttons/buyTech/purchaseButtonUnselected.png");
        purchaseButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/buyTech/purchaseButtonHighlighted.png");
        purchaseButtonPressed = toolkit.getImage(
            "resources/images/buttons/buyTech/purchaseButtonPressed.png");

        //Images for the viewDestScreen
        viewDest = toolkit.getImage(
            "resources/images/backgrounds/viewDestScreen.png");
        //City Hover images
        emptyHover = toolkit.getImage(
            "resources/images/cityHover/emptyHover.png");
        stornowayHover = toolkit.getImage(
            "resources/images/cityHover/stornowayHover.png");
        ullapoolHover = toolkit.getImage(
            "resources/images/cityHover/ullapoolHover.png");
        wickHover = toolkit.getImage(
            "resources/images/cityHover/wickHover.png");
        fortwilliamHover = toolkit.getImage(
            "resources/images/cityHover/fortwilliamHover.png");
        invernessHover = toolkit.getImage(
            "resources/images/cityHover/invernessHover.png");
        aberdeenHover = toolkit.getImage(
            "resources/images/cityHover/aberdeenHover.png");
        londonderryHover = toolkit.getImage(
            "resources/images/cityHover/londonderryHover.png");
        glasgowHover = toolkit.getImage(
            "resources/images/cityHover/glasgowHover.png");
        edinburghHover = toolkit.getImage(
            "resources/images/cityHover/edinburghHover.png");
        dundeeHover = toolkit.getImage(
            "resources/images/cityHover/dundeeHover.png");
        sligoHover = toolkit.getImage(
            "resources/images/cityHover/sligoHover.png");
        belfastHover = toolkit.getImage(
            "resources/images/cityHover/belfastHover.png");
        stranraerHover = toolkit.getImage(
            "resources/images/cityHover/stranraerHover.png");
        galwayHover = toolkit.getImage(
            "resources/images/cityHover/galwayHover.png");
        dundalkHover = toolkit.getImage(
            "resources/images/cityHover/dundalkHover.png");
        carlisleHover = toolkit.getImage(
            "resources/images/cityHover/carlisleHover.png");
        newcastleHover = toolkit.getImage(
            "resources/images/cityHover/newcastleHover.png");
        limerickHover = toolkit.getImage(
            "resources/images/cityHover/limerickHover.png");
        tullamoreHover = toolkit.getImage(
            "resources/images/cityHover/tullamoreHover.png");
        dublinHover = toolkit.getImage(
            "resources/images/cityHover/dublinHover.png");
        barrowsHover = toolkit.getImage(
            "resources/images/cityHover/barrowsHover.png");
        corkHover = toolkit.getImage(
            "resources/images/cityHover/corkHover.png");
        rosslareHover = toolkit.getImage(
            "resources/images/cityHover/rosslareHover.png");
        hollyheadHover = toolkit.getImage(
            "resources/images/cityHover/hollyheadHover.png");
        liverpoolHover = toolkit.getImage(
            "resources/images/cityHover/liverpoolHover.png");
        leedsHover = toolkit.getImage(
            "resources/images/cityHover/leedsHover.png");
        aberystrythHover = toolkit.getImage(
            "resources/images/cityHover/aberystrythHover.png");
        manchesterHover = toolkit.getImage(
            "resources/images/cityHover/manchesterHover.png");
        hullHover = toolkit.getImage(
            "resources/images/cityHover/hullHover.png");
        carmarthenHover = toolkit.getImage(
            "resources/images/cityHover/carmarthenHover.png");
        llandrindodwellsHover = toolkit.getImage(
            "resources/images/cityHover/llandrindodwellsHover.png");
        birminghamHover = toolkit.getImage(
            "resources/images/cityHover/birminghamHover.png");
        nottinghamHover = toolkit.getImage(
            "resources/images/cityHover/nottinghamHover.png");
        cardiffHover = toolkit.getImage(
            "resources/images/cityHover/cardiffHover.png");
        northamptonHover = toolkit.getImage(
            "resources/images/cityHover/northamptonHover.png");
        cambridgeHover = toolkit.getImage(
            "resources/images/cityHover/cambridgeHover.png");
        norwichHover = toolkit.getImage(
            "resources/images/cityHover/norwichHover.png");
        penzanceHover = toolkit.getImage(
            "resources/images/cityHover/penzanceHover.png");
        plymouthHover = toolkit.getImage(
            "resources/images/cityHover/plymouthHover.png");
        bristolHover = toolkit.getImage(
            "resources/images/cityHover/bristolHover.png");
        readingHover = toolkit.getImage(
            "resources/images/cityHover/readingHover.png");
        londonHover = toolkit.getImage(
            "resources/images/cityHover/londonHover.png");
        ipswichHover = toolkit.getImage(
            "resources/images/cityHover/ipswichHover.png");
        southamptonHover = toolkit.getImage(
            "resources/images/cityHover/southamptonHover.png");
        brightonHover = toolkit.getImage(
            "resources/images/cityHover/brightonHover.png");
        doverHover = toolkit.getImage(
            "resources/images/cityHover/doverHover.png");
        franceHover = toolkit.getImage(
            "resources/images/cityHover/franceHover.png");

        //get the image from the mouse cursor
        mouseCursor = toolkit.getImage(
            "resources/images/mouseCursors/mouseCursorFinal.png");

        //general Images needed more than once
        backButtonUnselected = toolkit.getImage(
            "resources/images/buttons/BackButtonUnselected.png");
        backButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/BackButtonHighlighted.png");
        backButtonPressed = toolkit.getImage(
            "resources/images/buttons/BackButtonPressed.png");

        //get the images from the backgrounds folder
        mainMenuBackground = toolkit.getImage(
            "resources/images/backgrounds/MainMenuBackground.png");
        gameBoarbackground2Players = toolkit.getImage(
            "resources/images/backgrounds/GameBackground 2 Players.png");
        gameBoarbackground3Players = toolkit.getImage(
            "resources/images/backgrounds/GameBackground 3 Players.png");
        gameBoarbackground4Players = toolkit.getImage(
            "resources/images/backgrounds/GameBackground 4 Players.png");

        //images for the Main Menu
        mainMenu = toolkit.getImage(
            "resources/images/backgrounds/MainMenu.png");
        playButtonUnselected = toolkit.getImage(
            "resources/images/buttons/mainMenu/PlayGameButtonUnselected.png");
        rulesButtonUnselected = toolkit.getImage(
            "resources/images/buttons/mainMenu/RulesButtonUnselected.png");
        quitButtonUnselected = toolkit.getImage(
            "resources/images/buttons/mainMenu/QuitButtonUnselected.png");
        playButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/mainMenu/PlayGameButtonHighlighted.png");
        rulesButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/mainMenu/RulesButtonHighlighted.png");
        quitButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/mainMenu/QuitButtonHighlighted.png");
        playButtonPressed = toolkit.getImage(
            "resources/images/buttons/mainMenu/PlayGameButtonPressed.png");
        rulesButtonPressed = toolkit.getImage(
            "resources/images/buttons/mainMenu/RulesButtonPressed.png");
        quitButtonPressed = toolkit.getImage(
            "resources/images/buttons/mainMenu/QuitButtonPressed.png");

        //images for the selectNumPlayersScreen
        selectPlayers = toolkit.getImage(
            "resources/images/backgrounds/MainMenuSelectPlayers.png");
        twoPlayersUnselected = toolkit.getImage(
            "resources/images/buttons/numPlayers/2PlayersUnselected.png");
        threePlayersUnselected = toolkit.getImage(
            "resources/images/buttons/numPlayers/3PlayersUnselected.png");
        fourPlayersUnselected = toolkit.getImage(
            "resources/images/buttons/numPlayers/4PlayersUnselected.png");
        twoPlayersHighlighted = toolkit.getImage(
            "resources/images/buttons/numPlayers/2PlayersHighlighted.png");
        threePlayersHighlighted = toolkit.getImage(
            "resources/images/buttons/numPlayers/3PlayersHighlighted.png");
        fourPlayersHighlighted = toolkit.getImage(
            "resources/images/buttons/numPlayers/4PlayersHighlighted.png");
        twoPlayersPressed = toolkit.getImage(
            "resources/images/buttons/numPlayers/2PlayersPressed.png");
        threePlayersPressed = toolkit.getImage(
            "resources/images/buttons/numPlayers/3PlayersPressed.png");
        fourPlayersPressed = toolkit.getImage(
            "resources/images/buttons/numPlayers/4PlayersPressed.png");

        //images for the rules screen
        rulesScreen1 = toolkit.getImage(
            "resources/images/backgrounds/rulesScreenPage1.png");
        rulesScreen2 = toolkit.getImage(
            "resources/images/backgrounds/rulesScreenPage2.png");
        nextButtonUnselected = toolkit.getImage(
            "resources/images/buttons/rulesScreen/NextButtonUnselected.png");
        previousButtonUnselected = toolkit.getImage(
            "resources/images/buttons/rulesScreen/PreviousButtonUnselected.png");
        nextButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/rulesScreen/NextButtonHighlighted.png");
        previousButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/rulesScreen/PreviousButtonHighlighted.png");
        nextButtonPressed = toolkit.getImage(
            "resources/images/buttons/rulesScreen/NextButtonPressed.png");
        previousButtonPressed = toolkit.getImage(
            "resources/images/buttons/rulesScreen/PreviousButtonPressed.png");

        //Images for the game board screen
        buyTechButtonUnselected = toolkit.getImage(
            "resources/images/buttons/gameBoard/BuyTechButtonUnselected.png");
        buyTechButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/gameBoard/BuyTechButtonHighlighted.png");
        buyTechButtonPressed = toolkit.getImage(
            "resources/images/buttons/gameBoard/BuyTechButtonPressed.png");
        viewTechButtonUnselected = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewTechButtonUnselected.png");
        viewTechButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewTechButtonHighlighted.png");
        viewTechButtonPressed = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewTechButtonPressed.png");
        viewDestButtonUnselected = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewDestButtonUnselected.png");
        viewDestButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewDestButtonHighlighted.png");
        viewDestButtonPressed = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewDestButtonPressed.png");
    }

    public static Image getHover(CityName name){
        String path = "resources\\images\\cityHover\\"+name+"Hover.png";
        try(Scanner sc = new Scanner(new File(path))){
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(path);
        }catch(Exception e){
            System.err.println("cannot find city hover: "+path);
        }
        return null;
    }
}
