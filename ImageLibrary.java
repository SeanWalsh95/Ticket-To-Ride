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
public class ImageLibrary
{
    //mouse cursor
    Image mouseCursor;

    Image woodBackground;

    //general Images needed more than once
    Image backButtonUnselected;
    Image backButtonHighlighted;
    Image backButtonPressed;

    //get the images from the backgrounds folder
    Image mainMenuBackground;
    Image gameBoarbackground2Players;
    Image gameBoarbackground3Players;
    Image gameBoarbackground4Players;

    //images for the Main Menu
    Image mainMenu;
    Image playButtonUnselected;
    Image rulesButtonUnselected;
    Image quitButtonUnselected;
    Image playButtonHighlighted;
    Image rulesButtonHighlighted;
    Image quitButtonHighlighted;
    Image playButtonPressed;
    Image rulesButtonPressed;
    Image quitButtonPressed;

    //images for the selectNumPlayersScreen
    Image selectPlayers;
    Image twoPlayersUnselected;
    Image threePlayersUnselected;
    Image fourPlayersUnselected;
    Image twoPlayersHighlighted;
    Image threePlayersHighlighted;
    Image fourPlayersHighlighted;
    Image twoPlayersPressed;
    Image threePlayersPressed;
    Image fourPlayersPressed;

    //images for the rulesScreen
    Image rulesScreen1;
    Image rulesScreen2;
    Image nextButtonUnselected;
    Image previousButtonUnselected;
    Image nextButtonHighlighted;
    Image previousButtonHighlighted;
    Image nextButtonPressed;
    Image previousButtonPressed;

    //images for the gameBoard screen
    Image buyTechButtonUnselected;
    Image buyTechButtonHighlighted;
    Image buyTechButtonPressed;
    Image viewTechButtonUnselected;
    Image viewTechButtonHighlighted;
    Image viewTechButtonPressed;
    Image viewDestButtonUnselected;
    Image viewDestButtonHighlighted;
    Image viewDestButtonPressed;

    //CityHover Images
    Image emptyHover;
    Image stornowayHover;
    Image ullapoolHover;
    Image wickHover;
    Image fortwilliamHover;
    Image invernessHover;
    Image aberdeenHover;
    Image londonderryHover;
    Image glasgowHover;
    Image edinburghHover;
    Image dundeeHover;
    Image sligoHover;
    Image belfastHover;
    Image stranraerHover;
    Image galwayHover;
    Image dundalkHover;
    Image carlisleHover;
    Image newcastleHover;
    Image limerickHover;
    Image tullamoreHover;
    Image dublinHover;
    Image barrowsHover;
    Image corkHover;
    Image rosslareHover;
    Image hollyheadHover;
    Image liverpoolHover;
    Image leedsHover;
    Image aberystrythHover;
    Image manchesterHover;
    Image hullHover;
    Image carmarthenHover;
    Image llandrindodwellsHover;
    Image birminghamHover;
    Image nottinghamHover;
    Image cardiffHover;
    Image northamptonHover;
    Image cambridgeHover;
    Image norwichHover;
    Image penzanceHover;
    Image plymouthHover;
    Image bristolHover;
    Image readingHover;
    Image londonHover;
    Image ipswichHover;
    Image southamptonHover;
    Image brightonHover;
    Image doverHover;
    Image franceHover;

    Image background;

    //images for the viewTechScreen
    Image viewTech;

    //Images for the buyTechScreen
    Image buyTech;
    Image purchaseButtonUnselected;
    Image purchaseButtonHighlighted;
    Image purchaseButtonPressed;

    //Images for the viewDestScreen
    Image viewDest;

    /**
     * Constructor for objects of class ImageLibrary
     */
    public ImageLibrary()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Images for the viewTechScreen
        viewTech = toolkit.getImage(
            "resources/images/backgrounds/viewTechScreen.png");

        woodBackground = toolkit.getImage(
            "resources/images/backgrounds/Woodbackground.png");

        background = toolkit.getImage(
            "resources/images/backgrounds/GameBackground.png");

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

    public Image getHover(CityName name){
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
