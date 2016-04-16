import java.awt.*;

/**
 * Write a description of class ImageLibrary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageLibrary
{
    //mouse cursor
    Image mouseCursor;

    //general Images needed more than once
    Image backButtonUnselected;
    Image backButtonHighlighted;
    Image backButtonPressed;

    //get the images from the backgrounds folder
    Image mainMenuBackground;
    Image gameBoarbackground;

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

    /**
     * Constructor for objects of class ImageLibrary
     */
    public ImageLibrary()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //get the image from the mouse cursor
        mouseCursor = toolkit.getImage(
            "resources/images/mouseCursor/mouseCursorFinal.png");

        //general Images needed more than once
        backButtonUnselected = toolkit.getImage(
            "resources/images/buttons/BackButtonUnselected.png");
        backButtonHighlighted = toolkit.getImage(
            "resources/images/buttons/BackButtonHighlighted.png");
        backButtonPressed = toolkit.getImage(
            "resources/images/buttons/BackButtonPressed.png");

        //get the images from the backgrounds folder
        mainMenuBackground = toolkit.getImage(
            "resources/images/backgrounds/MainMenu.png");
        gameBoarbackground = toolkit.getImage(
            "resources/images/backgrounds/GameBackground.png");

        //images for the Main Menu
        mainMenu = toolkit.getImage(
            "resources/images/backgrounds/MainMenuBackground.png");
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
            "resources/images/buttons/mainMenu/RulesButtonButtonPressed.png");
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

    }
}
