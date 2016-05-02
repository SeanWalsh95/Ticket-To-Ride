import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * ImageLibrary holds all the images that are Used in the GUI construction
 *
 * @author Jordan Cartwright
 * @version 2.0
 */
public class ImgLib {
    public static Image mouseCursor;

    public static Image appIcon;

    public static Image clearRouteButtonUnselected;
    public static Image clearRouteButtonHighlighted;
    public static Image purchaseRouteButtonUnselected;
    public static Image purchaseRouteButtonHighlighted;

    public static Image confirmPurchaseButtonUnselected;
    public static Image confirmPurchaseButtonHighlighted;

    public static Image mainMenu;
    public static Image background;
    public static Image woodBackground;
    public static Image mainMenuBackground;
    public static Image trainPickerBackground;

    public static Image rulesScreen1;
    public static Image rulesScreen2;

    public static Image trainIcon;
    public static Image playerCard;

    public static Image backOfTrainCard;
    public static Image backOfDestCard;

    //buttons
    public static Image backButtonHighlighted;
    public static Image backButtonUnselected;
    public static Image backButtonPressed;
    public static Image playButtonHighlighted;
    public static Image playButtonUnselected;
    public static Image rulesButtonHighlighted;
    public static Image rulesButtonUnselected;
    public static Image rulesButtonHighlightedGb;
    public static Image rulesButtonPressedGb;
    public static Image rulesButtonUnselectedGb;
    public static Image quitButtonHighlighted;
    public static Image quitButtonUnselected;
    public static Image selectButtonHighlighted;
    public static Image selectButtonUnselected;
    public static Image selectButtonPressed;
    public static Image purchaseButtonHighlighted;
    public static Image purchaseButtonUnselected;
    public static Image twoPlayersHighlighted;
    public static Image twoPlayersUnselected;
    public static Image threePlayersHighlighted;
    public static Image threePlayersUnselected;
    public static Image fourPlayersHighlighted;
    public static Image fourPlayersUnselected;
    public static Image nextButtonHighlighted;
    public static Image nextButtonUnselected;
    public static Image previousButtonHighlighted;
    public static Image previousButtonUnselected;
    public static Image buyTechButtonHighlighted;
    public static Image buyTechButtonUnselected;
    public static Image viewTechButtonHighlighted;
    public static Image viewTechButtonUnselected;
    public static Image viewDestButtonHighlighted;
    public static Image viewDestButtonUnselected;

    //other
    public static Image confirmPurchaseButtonPressed;

    //main menu Pressed
    public static Image playButtonPressed;
    public static Image rulesButtonPressed;
    public static Image quitButtonPressed;

    //select num players
    public static Image twoPlayersPressed;
    public static Image threePlayersPressed;
    public static Image fourPlayersPressed;

    //rules screen
    public static Image nextButtonPressed;
    public static Image previousButtonPressed;

    //gameboard
    public static Image buyTechButtonPressed;
    public static Image viewTechButtonPressed;
    public static Image viewDestButtonPressed;
    public static Image viewRulesButtonPressed;
    public static Image clearRouteButtonPressed;
    public static Image purchaseRouteButtonPressed;

    //buy tech
    public static Image purchaseButtonPressed;

    /**
     * Constructor for objects of class ImageLibrary
     */
    public static void ImageLibrary() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // get the image for the mouse cursor
        mouseCursor = toolkit.getImage(
            "resources/images/mouseCursors/mouseCursorFinal.png");
        appIcon = toolkit.getImage(
            "resources/images/icon.png");  

        //main menu test pressed
        playButtonPressed = toolkit.getImage(
            "resources/images/buttons/mainMenu/PlayGameButtonPressed.png");
        rulesButtonPressed = toolkit.getImage(
            "resources/images/buttons/mainMenu/RulesButtonPressed.png");
        quitButtonPressed = toolkit.getImage(
            "resources/images/buttons/mainMenu/QuitButtonPressed.png");

        //selectnumplayers
        twoPlayersPressed = toolkit.getImage(
            "resources/images/buttons/numPlayers/2PlayersPressed.png");
        threePlayersPressed = toolkit.getImage(
            "resources/images/buttons/numPlayers/3PlayersPressed.png");
        fourPlayersPressed = toolkit.getImage(
            "resources/images/buttons/numPlayers/4PlayersPressed.png");

        //rules
        nextButtonPressed = toolkit.getImage(
            "resources/images/buttons/rulesScreen/NextButtonPressed.png");
        previousButtonPressed = toolkit.getImage(
            "resources/images/buttons/rulesScreen/PreviousButtonPressed.png");

        // gameboard screen
        buyTechButtonPressed = toolkit.getImage(
            "resources/images/buttons/gameBoard/BuyTechButtonPressed.png");
        viewTechButtonPressed = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewTechButtonPressed.png");
        viewDestButtonPressed = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewDestButtonPressed.png");
        viewRulesButtonPressed = toolkit.getImage(
            "resources/images/buttons/gameBoard/RulesButtonPressed.png");
        clearRouteButtonPressed = toolkit.getImage(
            "resources/images/buttons/ClearRouteButtonPressed.png");
        purchaseRouteButtonPressed = toolkit.getImage(
            "resources/images/buttons/PurchaseRouteButtonPressed.png");

        //

        //////gameboard hover images////
        clearRouteButtonUnselected = toolkit.getImage(
            "resources/images/buttons/ClearRouteButtonUnselected.png");
        clearRouteButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/ClearRouteButtonHighlighted.png");

        purchaseRouteButtonUnselected = toolkit.getImage(
            "resources/images/buttons/PurchaseRouteButtonUnselected.png");
        purchaseRouteButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/PurchaseRouteButtonHighlighted.png");

        confirmPurchaseButtonUnselected = toolkit.getImage(
            "resources/images/buttons/ConfirmPurchaseButtonUnselected.png");
        confirmPurchaseButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/ConfirmPurchaseButtonHighlighted.png");
        confirmPurchaseButtonPressed = toolkit.getImage(
            "resources/images/buttons/ConfirmPurchaseButtonPressed.png");

        // get the images from the backgrounds folder
        mainMenu = toolkit.getImage(
            "resources/images/backgrounds/MainMenu.png");
        background = toolkit.getImage(
            "resources/images/backgrounds/GameBackground.png");
        woodBackground = toolkit.getImage(
            "resources/images/backgrounds/Woodbackground.png");
        mainMenuBackground = toolkit.getImage(
            "resources/images/backgrounds/MainMenuBackground.png");
        trainPickerBackground = toolkit.getImage(
            "resources/images/backgrounds/TrainPickerBackground.png");

        // images for the rules screen
        rulesScreen1 = toolkit.getImage(
            "resources/images/backgrounds/rulesScreenPage1.png");
        rulesScreen2 = toolkit.getImage(
            "resources/images/backgrounds/rulesScreenPage2.png");

        //images for player card
        trainIcon = toolkit.getImage(
            "resources/images/backgrounds/TrainIcon.png");
        playerCard = toolkit.getImage(
            "resources/images/backgrounds/PlayerCard.png");

        //back of cards
        backOfTrainCard = toolkit.getImage(
            "resources/images/cards/BackOfCard.jpg");
        backOfDestCard = toolkit.getImage(
            "resources/images/cards/BackOfTicket.jpg");

        // button images

        //genral
        backButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/BackButtonHighlighted.png");
        backButtonUnselected = toolkit.getImage(
            "resources/images/buttons/BackButtonUnselected.png");
        //general pressed
        backButtonPressed = toolkit.getImage(
            "resources/images/buttons/BackButtonPressed.png");

        playButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/mainMenu/PlayGameButtonHighlighted" +
            ".png");
        playButtonUnselected = toolkit.getImage(
            "resources/images/buttons/mainMenu/PlayGameButtonUnselected" +
            ".png");

        rulesButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/mainMenu/RulesButtonHighlighted.png");
        rulesButtonUnselected = toolkit.getImage(
            "resources/images/buttons/mainMenu/RulesButtonUnselected.png");

        rulesButtonHighlightedGb = toolkit.getImage(
            "resources/images/buttons/gameBoard/RulesButtonHighlighted.png");
        rulesButtonUnselectedGb = toolkit.getImage(
            "resources/images/buttons/gameBoard/RulesButtonUnselected.png");
        rulesButtonPressedGb = toolkit.getImage(
            "resources/images/buttons/gameBoard/RulesButtonPressed.png");

        quitButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/mainMenu/QuitButtonHighlighted.png");
        quitButtonUnselected = toolkit.getImage(
            "resources/images/buttons/mainMenu/QuitButtonUnselected.png");

        selectButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/selectButtonHighlighted.png");
        selectButtonUnselected = toolkit.getImage(
            "resources/images/buttons/selectButtonUnselected.png");
        selectButtonPressed = toolkit.getImage(
            "resources/images/buttons/selectButtonPressed.png");

        purchaseButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/buyTech/purchaseButtonHighlighted" +
            ".png");
        purchaseButtonUnselected = toolkit.getImage(
            "resources/images/buttons/buyTech/purchaseButtonUnselected" +
            ".png");
        purchaseButtonPressed = toolkit.getImage(
            "resources/images/buttons/buyTech/purchaseButtonPressed" +
            ".png");

        twoPlayersHighlighted = toolkit.getImage(
            "resources/images/buttons/numPlayers/2PlayersHighlighted.png");
        twoPlayersUnselected = toolkit.getImage(
            "resources/images/buttons/numPlayers/2PlayersUnselected.png");

        threePlayersHighlighted = toolkit.getImage(
            "resources/images/buttons/numPlayers/3PlayersHighlighted.png");
        threePlayersUnselected = toolkit.getImage(
            "resources/images/buttons/numPlayers/3PlayersUnselected.png");

        fourPlayersHighlighted = toolkit.getImage(
            "resources/images/buttons/numPlayers/4PlayersHighlighted.png");
        fourPlayersUnselected = toolkit.getImage(
            "resources/images/buttons/numPlayers/4PlayersUnselected.png");

        nextButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/rulesScreen/NextButtonHighlighted.png");
        nextButtonUnselected = toolkit.getImage(
            "resources/images/buttons/rulesScreen/NextButtonUnselected.png");

        previousButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/rulesScreen/" +
            "PreviousButtonHighlighted.png");
        previousButtonUnselected = toolkit.getImage(
            "resources/images/buttons/rulesScreen/" +
            "PreviousButtonUnselected.png");

        buyTechButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/gameBoard/BuyTechButtonHighlighted.png");
        buyTechButtonUnselected = toolkit.getImage(
            "resources/images/buttons/gameBoard/BuyTechButtonUnselected.png");

        viewTechButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewTechButtonHighlighted.png");
        viewTechButtonUnselected = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewTechButtonUnselected.png");

        viewDestButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewDestButtonHighlighted.png");
        viewDestButtonUnselected = toolkit.getImage(
            "resources/images/buttons/gameBoard/ViewDestButtonUnselected.png");

    }

    public static Image getHover(CityName name) {
        String path = "resources\\images\\cityHover\\" + name + "Hover.png";
        try (Scanner sc = new Scanner(new File(path))) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            return toolkit.getImage(path);
        } catch (Exception e) {
            System.err.println("cannot find city hover: " + path);
        }
        return null;
    }
}
