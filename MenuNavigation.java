import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.URISyntaxException;

/**
 * Class MenuNavigation
 *  This class allows a user to navigate through
 *  a menu to select their desired options for
 *  playing ticket to ride
 * 
 * @author (Jordan Cartwright) 
 * @version (1.0)
 */
public class MenuNavigation extends JApplet
implements MouseListener, MouseMotionListener, ActionListener {
    //set up access to the Image Library
    ImageLibrary image = new ImageLibrary();
    String menuAudio = "";

    //board menu states
    private boolean mainMenu = true;
    private boolean selectNumPlayersScreen = false;
    private boolean rulesScreen1 = false;
    private boolean rulesScreen2 = false;
    private boolean quitScreen = false;
    private boolean gameBoard = false;

    //general buttons
    private boolean backButton = false;

    //Main Menu Buttons
    private boolean playButton = false;
    private boolean rulesButton = false;
    private boolean quitButton = false;

    //rules Buttons
    private boolean nextButton = false;
    private boolean previousButton = false;

    //selectNumPlayers Buttons
    private boolean twoPlayers = false;
    private boolean threePlayers = false;
    private boolean fourPlayers = false;

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do 
        // not allow access to the AWT system event queue which JApplets do 
        // on startup to check access. May not be necessary with your browser. 
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

        // set the size of the applet to the size of the background image
        setSize(1260, 900);     //height, width

        //Background Audio Setup
        playBackgroundSound();

        //set the mouseCursor image
        //         Toolkit toolkit = Toolkit.getDefaultToolkit();
        //         Image mouseCursor = toolkit.getImage("resources/images/mouseCursor/mouseCursorFinal.png");
        //         Toolkit toolkit = Toolkit.getDefaultToolkit();
        //         Cursor a = toolkit.createCustomCursor(image.mouseCursor , new Point(this.getX(),this.getY()), "img");
        //         setCursor(a);

        // provide any initialisation necessary for your JApplet
        addMouseListener( this );
        addMouseMotionListener( this );
    }

    public void actionPerformed(ActionEvent e){}

    /**
     * public void mouseEntered is triggered upon a click or other mouse event
     * @param MouseEvent e is the event that the mouse creates
     */
    public void mouseEntered( MouseEvent e ){}

    /**
     * public void mouseExited is triggered when event is exited
     * @param MouseEvent e is the event that the mouse creates
     */
    public void mouseExited( MouseEvent e ){}

    /**
     * public void mouseMoved is triggered when event is moved
     * @param MouseEvent e is the event that the mouse creates
     */
    public void mouseMoved(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if(mainMenu == true) {
            //when you mouse over PLAY GAME
            if((x >= 509 && x <= 509+242 && y >= 473 && y <= 473+92) &&
            playButton == false)
            {
                //paint highlighted button
                playButton = true;
                repaint();
            }

            //when you mouse over RULES
            else if((x >= 131 && x <= 131+242 && y >= 473 && y <= 473+92) &&
            rulesButton == false)
            {
                //paint highlighted button
                rulesButton = true;
                repaint();
            }

            //when you mouse over QUIT
            else if((x >= 887 && x <= 887+242 && y >= 473 && y <= 473+92) &&
            quitButton == false)
            {
                //paint highlighted button
                quitButton = true;
                repaint();
            }
            else if(!(x >= 509 && x <= 509+242 && y >= 473 && y <= 473+92) &&
            !(x >= 131 && x <= 131+242 && y >= 473 && y <= 473+92) &&
            !(x >= 887 && x <= 887+242 && y >= 473 && y <= 473+92))
            {
                playButton = false;
                rulesButton = false;
                quitButton = false;
                repaint();
            }

        }
        else if(selectNumPlayersScreen == true)
        {
            //when you mouse over BACK BUTTON
            if((x >= 5 && x <= 5+80 && y >= 864 && y <= 864+30)
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }
            //when you mouse over TWO PLAYERS
            else if(x >= 131 && x <= 131+242 && y >= 473 && y <= 473+92
            && twoPlayers == false)
            {
                //paint highlighted button
                twoPlayers = true;
                repaint();
            }
            //when you mouse over THREE PLAYERS
            else if(x >= 509 && x <= 509+242 && y >= 473 && y <= 473+92
            && threePlayers == false)
            {
                //paint highlighted button
                threePlayers = true;
                repaint();
            }
            //when you mouse over FOUR PLAYERS
            else if(x >= 887 && x <= 887+242 && y >= 473 && y <= 473+92
            && fourPlayers == false)
            {
                //paint highlighted button
                fourPlayers = true;
                repaint();
            }
            else if(!(x >= 5 && x <= 5+80 && y >= 864 && y <= 864+30) &&
            !(x >= 131 && x <= 131+242 && y >= 473 && y <= 473+92) &&
            !(x >= 509 && x <= 509+242 && y >= 473 && y <= 473+92) &&
            !(x >= 887 && x <= 887+242 && y >= 473 && y <= 473+92))
            {
                backButton = false;
                twoPlayers = false;
                threePlayers = false;
                fourPlayers = false;                
                repaint();
            }
        }
        else if(rulesScreen1 == true)
        {
            //when you mouse over BACK BUTTON
            if((x >=5 && x <= 5+80 && y >=864  && y <= 864+30)
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }
            //when you mouse over NEXT
            else if(x >= 962 && x <= 962+80 && y >= 13 && y <= 13+30
            && nextButton == false)
            {
                nextButton = true;
                repaint();
            }
            else if(!(x >=5 && x <= 5+80 && y >=864  && y <= 864+30) &&
            !(x >= 962 && x <= 962+80 && y >= 13 && y <= 13+30))
            {
                backButton = false;
                nextButton = false;
                repaint();
            }

        }
        else if(rulesScreen2 == true) {
            //when you mouse over BACK
            if(x >= 5 && x <= 5+80 && y >= 864 && y <= 864+30
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }

            //when you mouse over Previous
            else if(x >= 219 && x <= 219+80 && y >= 13 && y <= 13+30
            && previousButton == false)
            {
                previousButton = true;
                repaint();
            }
            else if(!(x >= 5 && x <= 5+80 && y >= 864 && y <= 864+30) &&
            !(x >= 219 && x <= 219+80 && y >= 13 && y <= 13+30))
            {
                backButton = false;
                previousButton = false;
                repaint();
            }

        }
        e.consume();
    }

    public void mouseDragged(MouseEvent e){}

    /**
     * public void mousePressed creates an event when mouse is pressed
     * @param MouseEvent e is the event that the mouse creates
     */
    public void mousePressed( MouseEvent e ){}

    /**
     * public void mouseReleased is triggered when the mouse click is released
     * @param MouseEvent e is the event that the mouse creates
     */
    public void mouseReleased( MouseEvent e ){}

    /**
     * public void mouseClicked creates an event when a mouse is clicked
     * @param MouseEvent e is the event that the mouse creates
     */
    public void mouseClicked( MouseEvent e )
    {
        int x = e.getX();
        int y = e.getY();

        if(mainMenu == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                //Plays a button sound when you press PLAY GAME
                if(x >= 509 && x <= 509+242 && y >= 473 && y <= 473+92)
                {
                    //play the button sound
                    playButtonSound();
                    //set mainMenu to false
                    //set selectNumPlayers to true
                    mainMenu = false;
                    selectNumPlayersScreen = true;
                }

                //Plays a button sound when you press RULES
                if(x >= 131 && x <= 131+242 && y >= 473 && y <= 473+92)
                {
                    //play the button sound
                    playButtonSound();
                    //set mainMenu to false
                    //set rulesScreen to true
                    mainMenu = false;
                    rulesScreen1 = true;
                }

                //Plays a button sound when you press QUIT
                if(x >= 887 && x <= 887+242 && y >= 473 && y <= 473+92)
                {
                    //play the button sound
                    playButtonSound();
                    //set mainMenu to false
                    //set quitscreen to true
                    mainMenu = false;
                    quitScreen = true;
                }

            }
        }
        else if(rulesScreen1 == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                //Plays a button sound when you press BACK
                if(x >= 5 && x <= 5+80 && y >= 864 && y <= 864+30)
                {
                    //play the button sound
                    playButtonSound();
                    //set mainMenu to false
                    //set quitscreen to true
                    mainMenu = true;
                    rulesScreen1 = false;
                }
                //Plays a button sound when you press NEXT
                if(x >= 962 && x <= 962+80 && y >= 13 && y <= 13+30)
                {
                    //play the button sound
                    playButtonSound();
                    //set rulesScreen1 to false
                    //set rulesScreen2 to true
                    rulesScreen1 = false;
                    rulesScreen2 = true;
                }

            }
        }
        else if(rulesScreen2 == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                //Plays a button sound when you press BACK
                if(x >= 5 && x <= 5+80 && y >= 864 && y <= 864+30)
                {
                    //play the button sound
                    playButtonSound();
                    //set mainMenu to false
                    //set quitscreen to true
                    mainMenu = true;
                    rulesScreen2 = false;
                }

                //Plays a button sound when you press Previous
                if(x >= 219 && x <= 219+80 && y >= 13 && y <= 13+30)
                {
                    //play the button sound
                    playButtonSound();
                    //set rulesScreen1 to true
                    //set rulesScreen2 to false
                    rulesScreen1 = true;
                    rulesScreen2 = false;
                }

            }
        }
        else if(quitScreen == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

            }
        }

        else if(selectNumPlayersScreen == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                //Plays a button sound when you press BACK
                if(x >= 5 && x <= 5+80 && y >= 864 && y <= 864+30)
                {
                    //play the button sound
                    playButtonSound();
                    //set mainMenu to true
                    //set selectNumPlayersScreen to false
                    mainMenu = true;
                    selectNumPlayersScreen = false;
                }

                //Plays a button sound when you press 2 PLAYERS
                if(x >= 131 && x <= 131+242 && y >= 473 && y <= 473+92)
                {
                    //play the button sound
                    playButtonSound();
                    //set selectNumPlayers to false
                    //set the gameboard to true
                    selectNumPlayersScreen = false;
                    gameBoard = true;
                }

                //Plays a button sound when you press 3 PLAYERS
                if(x >= 509 && x <= 509+242 && y >= 473 && y <= 473+92)
                {
                    //play the button sound
                    playButtonSound();
                    //set selectNumPlayers to false
                    //set the gameboard to true
                    selectNumPlayersScreen = false;
                    gameBoard = true;
                }

                //Plays a button sound when you press 4 PLAYERS
                if(x >= 887 && x <= 887+242 && y >= 473 && y <= 473+92)
                {
                    //play the button sound
                    playButtonSound();
                    //set selectNumPlayers to false
                    //set the gameboard to true
                    selectNumPlayersScreen = false;
                    gameBoard = true;
                }

            }
        }

        //repaint with the new Booleans
        repaint();

        e.consume();
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        if(mainMenu == true)
        {
            setUpMainMenuScreen();
            checkMainMenuButtons(g);

        }
        else if(rulesScreen1 == true)
        {
            setUpRulesScreen1();
            checkRulesScreen1Buttons(g);
        }
        else if(rulesScreen2 == true)
        {
            setUpRulesScreen2();
            checkRulesScreen2Buttons(g);
        }
        else if( gameBoard == true)
        {
            setUpGameBoardScreen();
        }
        else if(selectNumPlayersScreen == true)
        {
            setUpSelectNumPlayersScreen();
            checkPlayerButtons(g);
        }

    }

    //===============================================
    //      methods for button highlighting
    //===============================================

    public void checkMainMenuButtons(Graphics g)
    {
        if(playButton == true)
        {
            //visibility of the play button is true
            paintHighlightPlayGameButton(g);
        }
        else
        {
            //visibility of the play button icon is false
            paintUnselectedPlayGameButton(g);
        }

        if(rulesButton == true)
        {
            //visibility of the rules button icon is true
            paintHighlightRulesButton(g);
        }
        else
        {
            //visibility of the rules button icon is false
            paintUnselectedRulesButton(g);
        }

        if(quitButton == true)
        {
            //visibility of the quit button icon is true
            paintHighlightQuitButton(g);
        }
        else
        {
            //visibility of the quit button icon is false
            paintUnselectedQuitButton(g);
        }
    }

    public void checkRulesScreen1Buttons(Graphics g)
    {
        if(backButton == true)
        {
            //visibility of the play button is true
            paintHighlightedBackButton(g);
        }
        else
        {
            //visibility of the play button icon is false
            paintUnselectedBackButton(g);
        }

        if(nextButton == true)
        {
            //visibility of the play button is true
            paintHighlightedNextButton(g);
        }
        else
        {
            //visibility of the play button icon is false
            paintUnselectedNextButton(g);
        }
    }

    public void checkRulesScreen2Buttons(Graphics g)
    {
        if(backButton == true)
        {
            //visibility of the play button is true
            paintHighlightedBackButton(g);
        }
        else
        {
            //visibility of the play button icon is false
            paintUnselectedBackButton(g);
        }

        if(previousButton == true)
        {
            //visibility of the play button is true
            paintHighlightedPreviousButton(g);
        }
        else
        {
            //visibility of the play button icon is false
            paintUnselectedPreviousButton(g);
        }
    }

    public void checkPlayerButtons(Graphics g)
    {

        if(backButton == true)
        {
            paintHighlightedBackButton(g);
        }
        else
        {
            paintUnselectedBackButton(g);
        }

        if(twoPlayers == true)
        {
            paintHighlighted2PlayersButton(g);
        }
        else
        {
            paintUnselected2PlayersButton(g);
        }

        if(threePlayers == true)
        {
            paintHighlighted3PlayersButton(g);
        }
        else
        {
            paintUnselected3PlayersButton(g);
        }

        if(fourPlayers == true)
        {
            paintHighlighted4PlayersButton(g);
        }
        else
        {
            paintUnselected4PlayersButton(g);
        }
    }

    //===============================================
    //      Seting up the game screens
    //===============================================

    public void setUpMainMenuScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(image.mainMenu, 0, 0, this);
    }

    public void setUpRulesScreen1()
    {
        Graphics g = getGraphics();
        g.drawImage(image.rulesScreen1, 0, 0, this);
    }

    public void setUpRulesScreen2()
    {
        Graphics g = getGraphics();
        g.drawImage(image.rulesScreen2, 0, 0, this);
    }

    public void setUpSelectNumPlayersScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(image.selectPlayers, 0, 0, this);
    }

    public void setUpGameBoardScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(image.gameBoarbackground, 0, 0, this);
    }

    //===============================================
    //      Setting up the game sounds
    //===============================================

    public void playButtonSound()
    {
        //set the random number to play random button sound
        String buttonSound = "resources/sounds/buttons/button1.wav";
        //plays random button sound from button names
        play( getDocumentBase(), buttonSound );
    }

    /**
     * Generate a random number for the background sounds and sets the sound to play
     */
    public void playBackgroundSound() {
        //random call
        Random num = new Random();
        //set diceOne to random # between 1 and 3
        int diceNum = num.nextInt(6) + 1;
        //set the random number to play random button sound
        if(diceNum == 1)
        {
            menuAudio = "resources/sounds/backgroundSounds/america.au";
        }
        if(diceNum == 2)
        {
            menuAudio = "resources/sounds/backgroundSounds/europe.au";
        }
        if(diceNum == 3)
        {
            menuAudio = "resources/sounds/backgroundSounds/legendaryAsia.au";
        }
        if(diceNum == 4)
        {
            menuAudio = "resources/sounds/backgroundSounds/suspense.au";
        }
        if(diceNum == 5)
        {
            menuAudio = "resources/sounds/backgroundSounds/switzerland.au";
        }
        if(diceNum == 6)
        {
            menuAudio = "resources/sounds/backgroundSounds/titleTheme.au";
        }

        //plays random background sound from filelocation
        AudioClip ac = getAudioClip(getCodeBase(), menuAudio);
        ac.loop();  //plays audio on loop
    }

    //===============================================
    //      Setting up the button Images for print
    //===============================================
    //main menu
    public void paintUnselectedBackButton(Graphics g)
    {
        g.drawImage(image.backButtonUnselected, 5, 864, this);
    }

    public void paintUnselectedPlayGameButton(Graphics g)
    {
        g.drawImage(image.playButtonUnselected, 509, 473, this);
    }

    public void paintUnselectedRulesButton(Graphics g)
    {
        g.drawImage(image.rulesButtonUnselected, 131, 473, this);
    }

    public void paintUnselectedQuitButton(Graphics g)
    {
        g.drawImage(image.quitButtonUnselected, 887, 473, this);
    }

    public void paintHighlightedBackButton(Graphics g)
    {
        g.drawImage(image.backButtonHighlighted, 5, 864, this);
    }

    public void paintHighlightPlayGameButton(Graphics g)
    {
        g.drawImage(image.playButtonHighlighted, 509, 473, this);
    }

    public void paintHighlightRulesButton(Graphics g)
    {
        g.drawImage(image.rulesButtonHighlighted, 131, 473, this);
    }

    public void paintHighlightQuitButton(Graphics g)
    {
        g.drawImage(image.quitButtonHighlighted, 887, 473, this);
    }

    public void paintPressedBackButton(Graphics g)
    {
        g.drawImage(image.backButtonPressed, 5, 864, this);
    }

    public void paintPressedPlayGameButton(Graphics g)
    {
        g.drawImage(image.playButtonPressed, 509, 473, this);
    }

    public void paintPressedRulesButton(Graphics g)
    {
        g.drawImage(image.rulesButtonPressed, 131, 473, this);
    }

    public void paintPressedQuitButton(Graphics g)
    {
        g.drawImage(image.quitButtonPressed, 887, 473, this);
    }

    //images for selectnumplyers screen
    public void paintUnselected2PlayersButton(Graphics g)
    {
        g.drawImage(image.twoPlayersUnselected, 131, 473, this);
    }

    public void paintUnselected3PlayersButton(Graphics g)
    {
        g.drawImage(image.threePlayersUnselected, 509, 473, this);
    }

    public void paintUnselected4PlayersButton(Graphics g)
    {
        g.drawImage(image.fourPlayersUnselected, 887, 473, this);
    }

    public void paintHighlighted2PlayersButton(Graphics g)
    {
        g.drawImage(image.twoPlayersHighlighted, 131, 473, this);
    }

    public void paintHighlighted3PlayersButton(Graphics g)
    {
        g.drawImage(image.threePlayersHighlighted, 509, 473, this);
    }

    public void paintHighlighted4PlayersButton(Graphics g)
    {
        g.drawImage(image.fourPlayersHighlighted, 887, 473, this);
    }

    public void paintPressed2PlayersButton(Graphics g)
    {
        g.drawImage(image.twoPlayersPressed, 131, 473, this);
    }

    public void paintPressed3PlayersButton(Graphics g)
    {
        g.drawImage(image.threePlayersPressed, 509, 473, this);
    }

    public void paintPressed4PlayersButton(Graphics g)
    {
        g.drawImage(image.fourPlayersPressed, 887, 473, this);
    }

    //rules screen
    public void paintUnselectedNextButton(Graphics g)
    {
        g.drawImage(image.nextButtonUnselected, 962, 13, this);
    }

    public void paintUnselectedPreviousButton(Graphics g)
    {
        g.drawImage(image.previousButtonUnselected, 219, 13, this);
    }

    public void paintHighlightedNextButton(Graphics g)
    {
        g.drawImage(image.nextButtonHighlighted, 962, 13, this);
    }

    public void paintHighlightedPreviousButton(Graphics g)
    {
        g.drawImage(image.previousButtonHighlighted, 219, 13, this);
    }

    public void paintPressedNextButton(Graphics g)
    {
        g.drawImage(image.nextButtonPressed, 962, 13, this);
    }

    public void paintPressedPreviousButton(Graphics g)
    {
        g.drawImage(image.previousButtonPressed, 219, 13, this);
    }

    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Called by the browser or applet viewer to inform this JApplet that it 
     * should start its execution. It is called after the init method and 
     * each time the JApplet is revisited in a Web page. 
     */
    public void start()
    {
        // provide any code requred to run each time 
        // web page is visited
    }

    /** 
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed. 
     */
    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed 
    }    

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }

    /**
     * Returns information about this applet. 
     * An applet should override this method to return a String containing 
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }

    /**
     * Returns parameter information about this JApplet. 
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings 
     * describing these parameters. 
     * Each element of the array should be a set of three Strings containing 
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                {"firstParameter",    "1-10",    "description of first parameter"},
                {"status", "boolean", "description of second parameter"},
                {"images",   "url",     "description of third parameter"}
            };
        return paramInfo;
    }
}
