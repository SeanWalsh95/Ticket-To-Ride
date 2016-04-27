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
    GameBoard board;
    String menuAudio = "";

    int playerCount = 0;

    private boolean firstClick = true;
    CityName firstCity;
    CityName secondCity;
    City Citya;
    City Cityb;

    //hover booleans
    private boolean stornowayHover = false;
    private boolean ullapoolHover = false;
    private boolean wickHover = false;
    private boolean fortwilliamHover = false;
    private boolean invernessHover = false;
    private boolean aberdeenHover = false;
    private boolean londonderryHover = false;
    private boolean glasgowHover = false;
    private boolean edinburghHover = false;
    private boolean dundeeHover = false;
    private boolean sligoHover = false;
    private boolean belfastHover = false;
    private boolean stranraerHover = false;
    private boolean galwayHover = false;
    private boolean dundalkHover = false;
    private boolean carlisleHover = false;
    private boolean newcastleHover = false;
    private boolean limerickHover = false;
    private boolean tullamoreHover = false;
    private boolean dublinHover = false;
    private boolean barrowsHover = false;
    private boolean corkHover = false;
    private boolean rosslareHover = false;
    private boolean hollyheadHover = false;
    private boolean liverpoolHover = false;
    private boolean leedsHover = false;
    private boolean aberystrythHover = false;
    private boolean manchesterHover = false;
    private boolean hullHover = false;
    private boolean carmarthenHover = false;
    private boolean llandrindodwellsHover = false;
    private boolean birminghamHover = false;
    private boolean nottinghamHover = false;
    private boolean cardiffHover = false;
    private boolean northamptonHover = false;
    private boolean cambridgeHover = false;
    private boolean norwichHover = false;
    private boolean penzanceHover = false;
    private boolean plymouthHover = false;
    private boolean bristolHover = false;
    private boolean readingHover = false;
    private boolean londonHover = false;
    private boolean ipswichHover = false;
    private boolean southamptonHover = false;
    private boolean brightonHover = false;
    private boolean doverHover = false;
    private boolean franceHover = false;

    //purchaseHighlight
    private boolean walesHighlight = false;
    private boolean irelandHighlight = false;
    private boolean scotlandHighlight = false;
    private boolean propellersHighlight = false;
    private boolean mechanicalHighlight = false;
    private boolean superheatedHighlight = false;
    private boolean dieselHighlight = false;
    private boolean boilerHighlight = false;
    private boolean doubleheadingHighlight = false;
    private boolean steamturbineHighlight = false;
    private boolean watertendersHighlight = false;
    private boolean boosterHighlight = false;
    private boolean riskycontractHighlight = false;
    private boolean rightofwayHighlight = false;
    private boolean equalisingbeamHighlight = false;
    private boolean thermocompressorHighlight = false;

    //board menu states
    private boolean mainMenu = true;
    private boolean selectNumPlayersScreen = false;
    private boolean rulesScreen1 = false;
    private boolean rulesScreen2 = false;
    private boolean quitScreen = false;
    private boolean gameBoard = false;
    private boolean buyTech = false;
    private boolean viewTech = false;
    private boolean viewDest = false;

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

    //gameBoard buttons
    private boolean buyTechButton = false;
    private boolean viewTechButton = false;
    private boolean viewDestButton = false;
    private boolean rulesScreenInGame = false;

    //buyTechButtons
    private boolean purchaseButton = false;
    private boolean highlight = false;
    private boolean canPurchase = false;

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first 
     * time that the start method is called.
     */
    public void init()
    {
        ImgLib.ImageLibrary();
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
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor a = toolkit.createCustomCursor(ImgLib.mouseCursor,
                new Point(this.getX(),this.getY()), "img");
        setCursor(a);

        //gameboard

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
            if((x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111) &&
            playButton == false)
            {
                //paint highlighted button
                playButton = true;
                repaint();
            }

            //when you mouse over RULES
            else if((x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111) &&
            rulesButton == false)
            {
                //paint highlighted button
                rulesButton = true;
                repaint();
            }

            //when you mouse over QUIT
            else if((x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111) &&
            quitButton == false)
            {
                //paint highlighted button
                quitButton = true;
                repaint();
            }
            else if(!(x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111) &&
            !(x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111) &&
            !(x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111))
            {
                playButton = rulesButton = quitButton = false;
                repaint();
            }

        }
        else if(selectNumPlayersScreen == true)
        {
            //when you mouse over BACK BUTTON
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }
            //when you mouse over TWO PLAYERS
            else if(x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111
            && twoPlayers == false)
            {
                //paint highlighted button
                twoPlayers = true;
                repaint();
            }
            //when you mouse over THREE PLAYERS
            else if(x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111
            && threePlayers == false)
            {
                //paint highlighted button
                threePlayers = true;
                repaint();
            }
            //when you mouse over FOUR PLAYERS
            else if(x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111
            && fourPlayers == false)
            {
                //paint highlighted button
                fourPlayers = true;
                repaint();
            }
            else if(!(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48) &&
            !(x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111) &&
            !(x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111) &&
            !(x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111))
            {
                backButton = twoPlayers = threePlayers = 
                fourPlayers = false;                
                repaint();
            }
        }
        else if(rulesScreen1 == true)
        {
            //when you mouse over BACK BUTTON
            if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48
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
            else if(!(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48) &&
            !(x >= 962 && x <= 962+80 && y >= 13 && y <= 13+30))
            {
                backButton = nextButton = false;
                repaint();
            }

        }
        else if(rulesScreen2 == true) {
            //when you mouse over BACK
            if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48
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
            else if(!(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48) &&
            !(x >= 219 && x <= 219+80 && y >= 13 && y <= 13+30))
            {
                backButton = previousButton = false;
                repaint();
            }

        }
        else if(gameBoard == true)
        {
            //when you mouse over viewTechButton
            if(x >= 612 && x <= 612+196 && y >= 508 && y <= 508+51
            && viewTechButton == false)
            {
                viewTechButton = true;
                repaint();
            }
            //when you mouse over buyTechButton
            else if(x >= 828 && x <= 828+196 && y >= 508 && y <= 508+51
            && buyTechButton == false)
            {
                buyTechButton = true;
                repaint();
            }
            //when you mouse over viewDestButton
            else if(x >= 1044 && x <= 1044+196 && y >= 508 && y <= 508+51
            && viewDestButton == false)
            {
                viewDestButton = true;
                repaint();
            }
            //when you mouse over RULES
            else if(x >= 781 && x <= 781+196 && y >= 28 && y <= 28+51
            && rulesButton == false)
            {
                //paint highlighted button
                rulesButton = true;
                repaint();
            }
            //if hovering over the city of stornoway
            else if(x >= 385 && x <= 385+20 && y >= 39 && y <= 39+20
            && stornowayHover == false)
            {
                stornowayHover = true;
                repaint();
            }
            //if hovering over the city of ullapool
            else if(x >= 419 && x <= 419+20 && y >= 84 && y <= 84+20
            && ullapoolHover == false)
            {
                ullapoolHover = true;
                repaint();
            }
            //if hovering over the city of wick
            else if(x >= 535 && x <= 535+20 && y >= 84 && y <= 84+20
            && wickHover == false)
            {
                wickHover = true;
                repaint();
            }
            //if hovering over the city of fort william
            else if(x >= 373 && x <= 373+20 && y >= 173 && y <= 173+20
            && fortwilliamHover == false)
            {
                fortwilliamHover = true;
                repaint();
            }
            //if hovering over the city of inverness
            else if(x >= 449 && x <= 449+20 && y >= 128 && y <= 128+20
            && invernessHover == false)
            {
                invernessHover = true;
                repaint();
            }
            //if hovering over the city of aberdeen
            else if(x >= 527 && x <= 527+20 && y >= 209 && y <= 209+20
            && aberdeenHover == false)
            {
                aberdeenHover = true;
                repaint();
            }
            //if hovering over the city of londonderry
            else if(x >= 213 && x <= 213+20 && y >= 253 && y <= 253+20
            && londonderryHover == false)
            {
                londonderryHover = true;
                repaint();
            }
            //if hovering over the city of glasgow
            else if(x >= 377 && x <= 377+20 && y >= 270 && y <= 270+20
            && glasgowHover == false)
            {
                glasgowHover = true;
                repaint();
            }
            //if hovering over the city of edinburgh
            else if(x >= 434 && x <= 434+20 && y >= 287 && y <= 287+20
            && edinburghHover == false)
            {
                edinburghHover = true;
                repaint();
            }
            //if hovering over the city of dundee
            else if(x >= 472 && x <= 472+20 && y >= 242 && y <= 242+20
            && dundeeHover == false)
            {
                dundeeHover = true;
                repaint();
            }
            //if hovering over the city of sligo
            else if(x >= 118 && x <= 118+20 && y >= 288 && y <= 288+20
            && sligoHover == false)
            {
                sligoHover = true;
                repaint();
            }
            //if hovering over the city of belfast
            else if(x >= 253 && x <= 253+20 && y >= 332 && y <= 332+20
            && belfastHover == false)
            {
                belfastHover = true;
                repaint();
            }
            //if hovering over the city of stranraer
            else if(x >= 311 && x <= 311+20 && y >= 326 && y <= 326+20
            && stranraerHover == false)
            {
                stranraerHover = true;
                repaint();
            }
            //if hovering over the city of galway
            else if(x >= 50 && x <= 50+20 && y >= 354 && y <= 354+20
            && galwayHover == false)
            {
                galwayHover = true;
                repaint();
            }
            //if hovering over the city of dundalk
            else if(x >= 205 && x <= 205+20 && y >= 367 && y <= 367+20
            && dundalkHover == false)
            {
                dundalkHover = true;
                repaint();
            }
            //if hovering over the city of carlisle
            else if(x >= 400 && x <= 400+20 && y >= 380 && y <= 380+20
            && carlisleHover == false)
            {
                carlisleHover = true;
                repaint();
            }
            //if hovering over the city of newcastle
            else if(x >= 467 && x <= 467+20 && y >= 397 && y <= 397+20
            && newcastleHover == false)
            {
                newcastleHover = true;
                repaint();
            }
            //if hovering over the city of limerick
            else if(x >= 50 && x <= 50+20 && y >= 420 && y <= 420+20
            && limerickHover == false)
            {
                limerickHover = true;
                repaint();
            }
            //if hovering over the city of tullamore
            else if(x >= 125 && x <= 125+20 && y >= 407 && y <= 407+20
            && tullamoreHover == false)
            {
                tullamoreHover = true;
                repaint();
            }
            //if hovering over the city of dublin
            else if(x >= 182 && x <= 182+20 && y >= 422 && y <= 422+20
            && dublinHover == false)
            {
                dublinHover = true;
                repaint();
            }
            //if hovering over the city of barrows
            else if(x >= 361 && x <= 361+20 && y >= 427 && y <= 427+20
            && barrowsHover == false)
            {
                barrowsHover = true;
                repaint();
            }
            //if hovering over the city of cork
            else if(x >= 39 && x <= 39+20 && y >= 489 && y <= 489+20
            && corkHover == false)
            {
                corkHover = true;
                repaint();
            }
            //if hovering over the city of rosslare
            else if(x >= 134 && x <= 134+20 && y >= 501 && y <= 501+20
            && rosslareHover == false)
            {
                rosslareHover = true;
                repaint();
            }
            //if hovering over the city of hollyhead
            else if(x >= 265 && x <= 265+20 && y >= 466 && y <= 466+20
            && hollyheadHover == false)
            {
                hollyheadHover = true;
                repaint();
            }
            //if hovering over the city of liverpool
            else if(x >= 335 && x <= 335+20 && y >= 478 && y <= 478+20
            && liverpoolHover == false)
            {
                liverpoolHover = true;
                repaint();
            }
            //if hovering over the city of leeds
            else if(x >= 432 && x <= 432+20 && y >= 483 && y <= 483+20
            && leedsHover == false)
            {
                leedsHover = true;
                repaint();
            }
            //if hovering over the city of aberystryth
            else if(x >= 245 && x <= 245+20 && y >= 551 && y <= 551+20
            && aberystrythHover == false)
            {
                aberystrythHover = true;
                repaint();
            }
            //if hovering over the city of manchester
            else if(x >= 381 && x <= 381+20 && y >= 510 && y <= 510+20
            && manchesterHover == false)
            {
                manchesterHover = true;
                repaint();
            }
            //if hovering over the city of hull
            else if(x >= 483 && x <= 483+20 && y >= 520 && y <= 520+20
            && hullHover == false)
            {
                hullHover = true;
                repaint();
            }
            //if hovering over the city of carmarthen
            else if(x >= 211 && x <= 211+20 && y >= 600 && y <= 600+20
            && carmarthenHover == false)
            {
                carmarthenHover = true;
                repaint();
            }
            //if hovering over the city of llandrindod wells
            else if(x >= 284 && x <= 284+20 && y >= 591 && y <= 591+20
            && llandrindodwellsHover == false)
            {
                llandrindodwellsHover = true;
                repaint();
            }
            //if hovering over the city of birmingham
            else if(x >= 364 && x <= 364+20 && y >= 602 && y <= 602+20
            && birminghamHover == false)
            {
                birminghamHover = true;
                repaint();
            }
            //if hovering over the city of nottingham
            else if(x >= 415 && x <= 415+20 && y >= 576 && y <= 576+20
            && nottinghamHover == false)
            {
                nottinghamHover = true;
                repaint();
            }
            //if hovering over the city of cardiff
            else if(x >= 252 && x <= 252+20 && y >= 640 && y <= 640+20
            && cardiffHover == false)
            {
                cardiffHover = true;
                repaint();
            }
            //if hovering over the city of northampton
            else if(x >= 402 && x <= 402+20 && y >= 646 && y <= 646+20
            && northamptonHover == false)
            {
                northamptonHover = true;
                repaint();
            }
            //if hovering over the city of cambridge
            else if(x >= 457 && x <= 457+20 && y >= 663 && y <= 663+20
            && cambridgeHover == false)
            {
                cambridgeHover = true;
                repaint();
            }
            //if hovering over the city of norwich
            else if(x >= 543 && x <= 543+20 && y >= 657 && y <= 657+20
            && norwichHover == false)
            {
                norwichHover = true;
                repaint();
            }
            //if hovering over the city of penzance
            else if(x >= 83 && x <= 83+20 && y >= 694 && y <= 694+20
            && penzanceHover == false)
            {
                penzanceHover = true;
                repaint();
            }
            //if hovering over the city of plymouth
            else if(x >= 172 && x <= 172+20 && y >= 703 && y <= 703+20
            && plymouthHover == false)
            {
                plymouthHover = true;
                repaint();
            }
            //if hovering over the city of bristol
            else if(x >= 290 && x <= 290+20 && y >= 675 && y <= 675+20
            && bristolHover == false)
            {
                bristolHover = true;
                repaint();
            }
            //if hovering over the city of reading
            else if(x >= 370 && x <= 370+20 && y >= 697 && y <= 697+20
            && readingHover == false)
            {
                readingHover = true;
                repaint();
            }
            //if hovering over the city of london
            else if(x >= 426 && x <= 426+20 && y >= 716 && y <= 716+20
            && londonHover == false)
            {
                londonHover = true;
                repaint();
            }
            //if hovering over the city of ipswich
            else if(x >= 500 && x <= 500+20 && y >= 709 && y <= 709+20
            && ipswichHover == false)
            {
                ipswichHover = true;
                repaint();
            }
            //if hovering over the city of southampton
            else if(x >= 338 && x <= 338+20 && y >= 751 && y <= 751+20
            && southamptonHover == false)
            {
                southamptonHover = true;
                repaint();
            }
            //if hovering over the city of brighton
            else if(x >= 399 && x <= 399+20 && y >= 777 && y <= 777+20
            && brightonHover == false)
            {
                brightonHover = true;
                repaint();
            }
            //if hovering over the city of dover
            else if(x >= 491 && x <= 491+20 && y >= 778 && y <= 778+20
            && doverHover == false)
            {
                doverHover = true;
                repaint();
            }
            //if hovering over the city of france
            else if(x >= 560 && x <= 560+20 && y >= 819 && y <= 819+20
            && franceHover == false)
            {
                franceHover = true;
                repaint();
            }
            //if hovering over the city of france
            else if(x >= 291 && x <= 291+20 && y >= 850 && y <= 850+20
            && franceHover == false)
            {
                franceHover = true;
                repaint();
            }
            else if(!(x >= 612 && x <= 612+196 && y >= 508 && y <= 508+51) &&
            !(x >= 828 && x <= 828+196 && y >= 508 && y <= 508+51) &&
            !(x >= 1044 && x <= 1044+196 && y >= 508 && y <= 508+51) &&
            !(x >= 781 && x <= 781+196 && y >= 28 && y <= 28+51) &&
            !(x >= 385 && x <= 385+20 && y >= 39 && y <= 39+20) &&
            !(x >= 419 && x <= 419+20 && y >= 84 && y <= 84+20) &&
            !(x >= 535 && x <= 535+20 && y >= 84 && y <= 84+20) &&
            !(x >= 373 && x <= 373+20 && y >= 173 && y <= 173+20) &&
            !(x >= 449 && x <= 449+20 && y >= 128 && y <= 128+20) &&
            !(x >= 527 && x <= 527+20 && y >= 209 && y <= 209+20) &&
            !(x >= 213 && x <= 213+20 && y >= 253 && y <= 253+20) &&
            !(x >= 377 && x <= 377+20 && y >= 270 && y <= 270+20) &&
            !(x >= 434 && x <= 434+20 && y >= 287 && y <= 287+20) &&
            !(x >= 472 && x <= 472+20 && y >= 242 && y <= 242+20) &&
            !(x >= 118 && x <= 118+20 && y >= 288 && y <= 288+20) &&
            !(x >= 253 && x <= 253+20 && y >= 332 && y <= 332+20) &&
            !(x >= 311 && x <= 311+20 && y >= 326 && y <= 326+20) &&
            !(x >= 50 && x <= 50+20 && y >= 354 && y <= 354+20) &&
            !(x >= 205 && x <= 205+20 && y >= 367 && y <= 367+20) &&
            !(x >= 400 && x <= 400+20 && y >= 380 && y <= 380+20) &&
            !(x >= 467 && x <= 467+20 && y >= 397 && y <= 397+20) &&
            !(x >= 50 && x <= 50+20 && y >= 420 && y <= 420+20) &&
            !(x >= 125 && x <= 125+20 && y >= 407 && y <= 407+20) &&
            !(x >= 182 && x <= 182+20 && y >= 422 && y <= 422+20) &&
            !(x >= 361 && x <= 361+20 && y >= 427 && y <= 427+20) &&
            !(x >= 39 && x <= 39+20 && y >= 489 && y <= 489+20) &&
            !(x >= 134 && x <= 134+20 && y >= 501 && y <= 501+20) &&
            !(x >= 265 && x <= 265+20 && y >= 466 && y <= 466+20) &&
            !(x >= 335 && x <= 335+20 && y >= 478 && y <= 478+20) &&
            !(x >= 432 && x <= 432+20 && y >= 483 && y <= 483+20) &&
            !(x >= 245 && x <= 245+20 && y >= 551 && y <= 551+20) &&
            !(x >= 381 && x <= 381+20 && y >= 510 && y <= 510+20) &&
            !(x >= 483 && x <= 483+20 && y >= 520 && y <= 520+20) &&
            !(x >= 211 && x <= 211+20 && y >= 600 && y <= 600+20) &&
            !(x >= 284 && x <= 284+20 && y >= 591 && y <= 591+20) &&
            !(x >= 364 && x <= 364+20 && y >= 602 && y <= 602+20) &&
            !(x >= 415 && x <= 415+20 && y >= 576 && y <= 576+20) &&
            !(x >= 252 && x <= 252+20 && y >= 640 && y <= 640+20) &&
            !(x >= 402 && x <= 402+20 && y >= 646 && y <= 646+20) &&
            !(x >= 457 && x <= 457+20 && y >= 663 && y <= 663+20) &&
            !(x >= 543 && x <= 543+20 && y >= 657 && y <= 657+20) &&
            !(x >= 83 && x <= 83+20 && y >= 694 && y <= 694+20) &&
            !(x >= 172 && x <= 172+20 && y >= 703 && y <= 703+20) &&
            !(x >= 290 && x <= 290+20 && y >= 675 && y <= 675+20) &&
            !(x >= 370 && x <= 370+20 && y >= 697 && y <= 697+20) &&
            !(x >= 426 && x <= 426+20 && y >= 716 && y <= 716+20) &&
            !(x >= 500 && x <= 500+20 && y >= 709 && y <= 709+20) &&
            !(x >= 338 && x <= 338+20 && y >= 751 && y <= 751+20) &&
            !(x >= 399 && x <= 399+20 && y >= 777 && y <= 777+20) &&
            !(x >= 491 && x <= 491+20 && y >= 778 && y <= 778+20) &&
            !(x >= 560 && x <= 560+20 && y >= 819 && y <= 819+20) &&
            !(x >= 291 && x <= 291+20 && y >= 850 && y <= 850+20))
            {
                viewTechButton = buyTechButton = viewDestButton =
                rulesButton = stornowayHover = false;
                ullapoolHover = false;
                wickHover = false;
                fortwilliamHover = false;
                invernessHover = false;
                aberdeenHover = false;
                londonderryHover = false;
                glasgowHover = false;
                edinburghHover = false;
                dundeeHover = false;
                sligoHover = false;
                belfastHover = false;
                stranraerHover = false;
                galwayHover = false;
                dundalkHover = false;
                carlisleHover = false;
                newcastleHover = false;
                limerickHover = false;
                tullamoreHover = false;
                dublinHover = false;
                barrowsHover = false;
                corkHover = false;
                rosslareHover = false;
                hollyheadHover = false;
                liverpoolHover = false;
                leedsHover = false;
                aberystrythHover = false;
                manchesterHover = false;
                hullHover = false;
                carmarthenHover = false;
                llandrindodwellsHover = false;
                birminghamHover = false;
                nottinghamHover = false;
                cardiffHover = false;
                northamptonHover = false;
                cambridgeHover = false;
                norwichHover = false;
                penzanceHover = false;
                plymouthHover = false;
                bristolHover = false;
                readingHover = false;
                londonHover = false;
                ipswichHover = false;
                southamptonHover = false;
                brightonHover = false;
                doverHover = false;
                franceHover = false;
                franceHover = false;

                repaint();
            }

        }
        else if(viewTech == true)
        {
            //when you mouse over BACK BUTTON
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }
            else if(!(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48))
            {
                backButton = false;
                repaint();
            }
        }
        else if(buyTech == true)
        {
            //when you mouse over BACK BUTTON
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }
            //when you mouse over the PURCHASE BUTTON
            else if(x >= 543 && x <= 543+174 && y >= 828 && y <= 828+51
            && purchaseButton == false)
            {
                purchaseButton = true;
                repaint();
            }
            //when you mouse over WALES
            else if(x >= 50 && x <= 50+247 && y >= 91 && y <= 91+160
            && walesHighlight == false)
            {
                walesHighlight = true;
                repaint();
            }
            //when you mouse over IRELAND
            else if(x >= 352 && x <= 352+247 && y >= 91 && y <= 91+160
            && irelandHighlight == false)
            {
                irelandHighlight = true;
                repaint();
            }
            //when you mouse over SCOTLAND
            else if(x >= 659 && x <= 659+247 && y >= 91 && y <= 91+160
            && scotlandHighlight == false)
            {
                scotlandHighlight = true;
                repaint();
            }
            //when you mouse over PROPELLERS
            else if(x >= 960 && x <= 960+247 && y >= 91 && y <= 91+160
            && propellersHighlight == false)
            {
                propellersHighlight = true;
                repaint();
            }
            //when you mouse over MECHANICAL STOKER
            else if(x >= 50 && x <= 50+247 && y >= 276 && y <= 276+160
            && mechanicalHighlight == false)
            {
                mechanicalHighlight = true;
                repaint();
            }
            //when you mouse over SUPERHEATED STEAM BOILER
            else if(x >= 352 && x <= 352+247 && y >= 276 && y <= 276+160
            && superheatedHighlight == false)
            {
                superheatedHighlight = true;
                repaint();
            }
            //when you mouse over DIESEL POWER
            else if(x >= 659 && x <= 659+247 && y >= 276 && y <= 276+160
            && dieselHighlight == false)
            {
                dieselHighlight = true;
                repaint();
            }
            //when you mouse over BOILER LAGGING
            else if(x >= 960 && x <= 960+247 && y >= 276 && y <= 276+160
            && boilerHighlight == false)
            {
                boilerHighlight = true;
                repaint();
            }
            //when you mouse over DOUBLE HEADING
            else if(x >= 50 && x <= 50+247 && y >= 461 && y <= 461+160
            && doubleheadingHighlight == false)
            {
                doubleheadingHighlight = true;
                repaint();
            }
            //when you mouse over STEAM TURBINE
            else if(x >= 352 && x <= 352+247 && y >= 461 && y <= 461+160
            && steamturbineHighlight == false)
            {
                steamturbineHighlight = true;
                repaint();
            }
            //when you mouse over WATER TENDERS
            else if(x >= 659 && x <= 659+247 && y >= 461 && y <= 461+160
            && watertendersHighlight == false)
            {
                watertendersHighlight = true;
                repaint();
            }
            //when you mouse over BOOSTER
            else if(x >= 960 && x <= 960+247 && y >= 461 && y <= 461+160
            && boosterHighlight == false)
            {
                boosterHighlight = true;
                repaint();
            }
            //when you mouse over RISKY CONTRACT
            else if(x >= 50 && x <= 50+247 && y >= 646 && y <= 646+160
            && riskycontractHighlight == false)
            {
                riskycontractHighlight = true;
                repaint();
            }
            //when you mouse over RIGHT OF WAY
            else if(x >= 352 && x <= 352+247 && y >= 646 && y <= 646+160
            && rightofwayHighlight == false)
            {
                rightofwayHighlight = true;
                repaint();
            }
            //when you mouse over EQUALISING BEAM
            else if(x >= 659 && x <= 659+247 && y >= 646 && y <= 646+160
            && equalisingbeamHighlight == false)
            {
                equalisingbeamHighlight = true;
                repaint();
            }
            //when you mouse over THERMO COMPRESSOR
            else if(x >= 960 && x <= 960+247 && y >= 646 && y <= 646+160
            && thermocompressorHighlight == false)
            {
                thermocompressorHighlight = true;
                repaint();
            }
            else if(!(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && !(x >= 543 && x <= 543+174 && y >= 828 && y <= 828+51)
            && !(x >= 50 && x <= 50+247 && y >= 91 && y <= 91+160)
            && !(x >= 352 && x <= 352+247 && y >= 91 && y <= 91+160)
            && !(x >= 659 && x <= 659+247 && y >= 91 && y <= 91+160)
            && !(x >= 960 && x <= 960+247 && y >= 91 && y <= 91+160)
            && !(x >= 50 && x <= 50+247 && y >= 276 && y <= 276+160)
            && !(x >= 352 && x <= 352+247 && y >= 276 && y <= 276+160)
            && !(x >= 659 && x <= 659+247 && y >= 276 && y <= 276+160)
            && !(x >= 960 && x <= 960+247 && y >= 276 && y <= 276+160)
            && !(x >= 50 && x <= 50+247 && y >= 461 && y <= 461+160)
            && !(x >= 352 && x <= 352+247 && y >= 461 && y <= 461+160)
            && !(x >= 659 && x <= 659+247 && y >= 461 && y <= 461+160)
            && !(x >= 960 && x <= 960+247 && y >= 461 && y <= 461+160)
            && !(x >= 50 && x <= 50+247 && y >= 646 && y <= 646+160)
            && !(x >= 352 && x <= 352+247 && y >= 646 && y <= 646+160)
            && !(x >= 659 && x <= 659+247 && y >= 646 && y <= 646+160)
            && !(x >= 960 && x <= 960+247 && y >= 646 && y <= 646+160))
            {
                purchaseButton = false;
                backButton = false;
                walesHighlight = false;
                irelandHighlight = false;
                scotlandHighlight = false;
                propellersHighlight = false;
                mechanicalHighlight = false;
                superheatedHighlight = false;
                dieselHighlight = false;
                boilerHighlight = false;
                doubleheadingHighlight = false;
                steamturbineHighlight = false;
                watertendersHighlight = false;
                boosterHighlight = false;
                riskycontractHighlight = false;
                rightofwayHighlight = false;
                equalisingbeamHighlight = false;
                thermocompressorHighlight = false;
                repaint();
            }
        }
        else if(viewDest == true)
        {
            //when you mouse over BACK BUTTON
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }
            else if(!(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48))
            {
                backButton = false;
                repaint();
            }
        }
        else if(rulesScreenInGame == true)
        {
            //when you mouse over BACK BUTTON
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //paint highlighted button
                backButton = true;
                repaint();
            }
            else if(!(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48))
            {
                backButton = false;
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
    public void mousePressed( MouseEvent e ){
        //when the mouse is pushed show the images for pushed buttons
        int x = e.getX();
        int y = e.getY();

        Graphics g = getGraphics();

        if(mainMenu == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the PLAY GAME button it shows
                    //a PRESSED button image
                    paintPressedPlayGameButton(g);
                }

                if(x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the RULES button it shows
                    //a PRESSED button image
                    paintPressedRulesButton(g);
                }

                if(x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button  
                    //on the QUIT button it shows
                    //a PRESSED button image
                    paintPressedQuitButton(g);
                }

            }
        }
        else if(rulesScreen1 == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintPressedBackButton(g);
                }

                if(x >= 962 && x <= 962+80 && y >= 13 && y <= 13+30)
                {
                    //if you press the 1st mouse button 
                    //on the NEXT button it shows
                    //a PRESSED button image
                    paintPressedNextButton(g);
                }

            }
        }
        else if(rulesScreen2 == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintPressedBackButton(g);
                }

                if(x >= 219 && x <= 219+80 && y >= 13 && y <= 13+30)
                {
                    //if you press the 1st mouse button 
                    //on the NEXT button it shows
                    //a PRESSED button image
                    paintPressedPreviousButton(g);
                }

            }
        }
        else if(quitScreen == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

            }
        }

        else if(selectNumPlayersScreen == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintPressedBackButton(g);
                }

                //Plays a button sound when you press 2 PLAYERS
                if(x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the 2 PLAYERS button it shows
                    //a PRESSED button image
                    paintPressed2PlayersButton(g);
                }

                //Plays a button sound when you press 3 PLAYERS
                if(x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the 3 PLAYERS button it shows
                    //a PRESSED button image
                    paintPressed3PlayersButton(g);
                }

                //Plays a button sound when you press 4 PLAYERS
                if(x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the 4 PLAYERS button it shows
                    //a PRESSED button image
                    paintPressed4PlayersButton(g);
                }

            }
        }
        else if(gameBoard == true){
            if (e.getButton() == MouseEvent.BUTTON1) {
                //Plays a button sound when you press viewTechButton
                if(x >= 612 && x <= 612+196 && y >= 508 && y <= 508+51)
                {
                    //if you press the 1st mouse button 
                    //on the VIEWTECH button it shows
                    //a PRESSED button image
                    paintPressedviewTechButton(g);
                }
                //Plays a button sound when you press buyTechButton
                else if(x >= 828 && x <= 828+196 && y >= 508 && y <= 508+51)
                {
                    //if you press the 1st mouse button 
                    //on the BUYTECH button it shows
                    //a PRESSED button image
                    paintPressedBuyTechButton(g);
                }
                //Plays a button sound when you press viewDestButton
                else if(x >= 1044 && x <= 1044+196 && y >= 508 && y <= 508+51)
                {
                    //if you press the 1st mouse button 
                    //on the VIEWDESTINATION button it shows
                    //a PRESSED button image
                    paintPressedviewDestButton(g);
                }
                //Plays a button sound when you press RULES
                else if(x >= 781 && x <= 781+196 && y >= 28 && y <= 28+51)
                {
                    //if you press the 1st mouse button 
                    //on the RULES button it shows
                    //a PRESSED button image
                    g.drawImage(ImgLib.viewRulesButtonPressed, 781, 28, this);
                }
            }

        }
        else if(viewTech == true){
            if (e.getButton() == MouseEvent.BUTTON1) {
                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintPressedBackButton(g);
                }
            }

        }        
        else if(buyTech == true){
            if (e.getButton() == MouseEvent.BUTTON1) {
                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintPressedBackButton(g);
                }

                else if(x >= 543 && x <= 543+174 && y >= 828 && y <= 828+51)
                {
                    //if you press the 1st mouse button 
                    //on the PURCHASE button it shows
                    //a PRESSED button image
                    paintPressedPurchaseButton(g);
                }
            }

        }        
        else if(viewDest == true){
            if (e.getButton() == MouseEvent.BUTTON1) {
                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintPressedBackButton(g);
                }
            }

        }
        else if(rulesScreenInGame == true){
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintPressedBackButton(g);
                }
            }

        }

    }

    /**
     * public void mouseReleased is triggered when the mouse click is released
     * @param MouseEvent e is the event that the mouse creates
     */
    public void mouseReleased( MouseEvent e ){
        //when the mouse is pushed show the images for pushed buttons
        int x = e.getX();
        int y = e.getY();

        Graphics g = getGraphics();

        if(mainMenu == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the PLAY GAME button it shows
                    //a PRESSED button image
                    paintUnselectedPlayGameButton(g);
                }

                if(x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the RULES button it shows
                    //a PRESSED button image
                    paintUnselectedRulesButton(g);
                }

                if(x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button  
                    //on the QUIT button it shows
                    //a PRESSED button image
                    paintUnselectedQuitButton(g);
                }

            }
        }
        else if(rulesScreen1 == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintUnselectedBackButton(g);
                }

                if(x >= 962 && x <= 962+80 && y >= 13 && y <= 13+30)
                {
                    //if you press the 1st mouse button 
                    //on the NEXT button it shows
                    //a PRESSED button image
                    paintUnselectedNextButton(g);
                }

            }
        }
        else if(rulesScreen2 == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintUnselectedBackButton(g);
                }

                if(x >= 219 && x <= 219+80 && y >= 13 && y <= 13+30)
                {
                    //if you press the 1st mouse button 
                    //on the NEXT button it shows
                    //a PRESSED button image
                    paintUnselectedPreviousButton(g);
                }

            }
        }
        else if(quitScreen == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

            }
        }

        else if(selectNumPlayersScreen == true) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
                {
                    //if you press the 1st mouse button 
                    //on the BACK button it shows
                    //a PRESSED button image
                    paintUnselectedBackButton(g);
                }

                //Plays a button sound when you press 2 PLAYERS
                if(x >= 125 && x <= 125+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the 2 PLAYERS button it shows
                    //a PRESSED button image
                    paintUnselected2PlayersButton(g);
                }

                //Plays a button sound when you press 3 PLAYERS
                if(x >= 500 && x <= 500+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the 3 PLAYERS button it shows
                    //a PRESSED button image
                    paintUnselected3PlayersButton(g);
                }

                //Plays a button sound when you press 4 PLAYERS
                if(x >= 875 && x <= 875+260 && y >= 464 && y <= 464+111)
                {
                    //if you press the 1st mouse button 
                    //on the 4 PLAYERS button it shows
                    //a PRESSED button image
                    paintUnselected4PlayersButton(g);
                }

            }
        }
        else if(gameBoard == true)
        {
            //Plays a button sound when you press viewTechButton
            if(x >= 612 && x <= 612+196 && y >= 508 && y <= 508+51)
            {
                //if you press the 1st mouse button 
                //on the 3 PLAYERS button it shows
                //a PRESSED button image
                paintUnselectedviewTechButton(g);
            }
            //Plays a button sound when you press buyTechButton
            else if(x >= 828 && x <= 828+196 && y >= 508 && y <= 508+51)
            {
                //if you press the 1st mouse button 
                //on the 3 PLAYERS button it shows
                //a PRESSED button image
                paintUnselectedBuyTechButton(g);
            }
            //Plays a button sound when you press viewDestButton
            else if(x >= 1044 && x <= 1044+196 && y >= 508 && y <= 508+51)
            {
                //if you press the 1st mouse button 
                //on the 3 PLAYERS button it shows
                //a PRESSED button image
                paintUnselectedviewDestButton(g);
            }
            //Plays a button sound when you press RULES
            else if(x >= 781 && x <= 781+196 && y >= 28 && y <= 28+51)
            {
                //if you press the 1st mouse button 
                //on the RULES button it shows
                //a PRESSED button image
                g.drawImage(ImgLib.viewRulesButtonUnselected, 781, 28, this);
            }

        }
        else if(viewTech == true)
        {
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //if you press the 1st mouse button 
                //on the BACK button it shows
                //a PRESSED button image
                paintUnselectedBackButton(g);
            }
        }
        else if(buyTech == true)
        {
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //if you press the 1st mouse button 
                //on the BACK button it shows
                //a PRESSED button image
                paintUnselectedBackButton(g);
            }
            else if(x >= 543 && x <= 543+174 && y >= 828 && y <= 828+51)
            {
                //if you press the 1st mouse button 
                //on the PURCHASE button it shows
                //a PRESSED button image
                paintUnselectedPurchaseButton(g);
            }
        }
        else if(viewDest == true)
        {
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //if you press the 1st mouse button 
                //on the BACK button it shows
                //a PRESSED button image
                paintUnselectedBackButton(g);
            }
        }
        else if(rulesScreenInGame == true)
        {
            if((x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            && backButton == false)
            {
                //if you press the 1st mouse button 
                //on the BACK button it shows
                //a PRESSED button image
                paintUnselectedBackButton(g);
            }
        }

    }

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
                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
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
                    playButtonSoundPage();
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
                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
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
                    playButtonSoundPage();
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
                if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
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
                    playerCount = 2;
                    //board = new GameBoard(playerCount);
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
                    playerCount = 3;
                    //board = new GameBoard(playerCount);
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
                    playerCount = 4;
                    //board = new GameBoard(playerCount);
                }

            }
        }
        else if(gameBoard == true){
            if (e.getButton() == MouseEvent.BUTTON1) {

                //Plays a button sound when you press viewTechButton
                if(x >= 612 && x <= 612+196 && y >= 508 && y <= 508+51)
                {
                    //play the button sound
                    playButtonSound();
                    //set the gameBoard to false
                    //set the viewtech true
                    gameBoard = false;
                    viewTech = true;
                }
                //Plays a button sound when you press buyTechButton
                else if(x >= 828 && x <= 828+196 && y >= 508 && y <= 508+51)
                {
                    //play the button sound
                    playButtonSound();
                    //set the gameBoard to false
                    //set the buyTech true
                    gameBoard = false;
                    buyTech = true;
                }
                //Plays a button sound when you press viewDestButton
                else if(x >= 1044 && x <= 1044+196 && y >= 508 && y <= 508+51)
                {
                    //play the button sound
                    playButtonSound();
                    //set the gameBoard to false
                    //set the viewDest true
                    gameBoard = false;
                    viewDest = true;
                }
                //Plays a button sound when you press RULES
                else if(x >= 781 && x <= 781+196 && y >= 28 && y <= 28+51)
                {
                    //play the button sound
                    playButtonSound();
                    //set mainMenu to false
                    //set rulesScreen to true
                    gameBoard = false;
                    rulesScreenInGame = true;
                }
                //if you press the destination card deck
                else if(x >= 772 && x <= 772+214 && y >= 110 && y <= 110+138)
                {
                    showStatus("You Draw cards from the destination card deck");
                }
                //if you press the traincards deck
                else if(x >= 772 && x <= 772+214 && y >= 265 && y <= 265+138)
                {
                    showStatus("You a card from the Train Card Deck");
                }
                //if you draw CARD 1
                else if(x >= 603 && x <= 603+146 && y >= 8 && y <= 8+93)
                {
                    showStatus("You Pickup card 1");
                }
                //if you draw CARD 2
                else if(x >= 603 && x <= 603+146 && y >= 106 && y <= 106+93)
                {
                    showStatus("You Pickup card 2");
                }
                //if you draw CARD 3
                else if(x >= 603 && x <= 603+146 && y >= 203 && y <= 203+93)
                {
                    showStatus("You Pickup card 3");
                }
                //if you draw CARD 4
                else if(x >= 603 && x <= 603+146 && y >= 301 && y <= 301+93)
                {
                    showStatus("You Pickup card 4");
                }
                //if you draw CARD 5
                else if(x >= 603 && x <= 603+146 && y >= 399 && y <= 399+93)
                {
                    showStatus("You Pickup card 5");
                }
                //if you click the city of stornoway
                else if(x >= 385 && x <= 385+20 && y >= 39 && y <= 39+20)
                {
                    //if this is the first click set it as first
                    //otherwise set it to the second
                    //if this is the second click then
                    //
                    if(firstClick == true)
                    {
                        firstCity = CityName.Stornoway;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Stornoway;
                        firstClick = true;
                    }
                    showStatus("Selected City: stornoway - " + firstCity + ", " + secondCity);

                }
                //if hovering over the city of ullapool
                else if(x >= 419 && x <= 419+20 && y >= 84 && y <= 84+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Ullapool;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Ullapool;
                        firstClick = true;
                    }
                    showStatus("Selected City: ullapool - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of wick
                else if(x >= 535 && x <= 535+20 && y >= 84 && y <= 84+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Wick;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Wick;
                        firstClick = true;
                    }
                    showStatus("Selected City: wick - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of fort william
                else if(x >= 373 && x <= 373+20 && y >= 173 && y <= 173+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.FortWilliam;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.FortWilliam;
                        firstClick = true;
                    }
                    showStatus("Selected City: fort william - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of inverness
                else if(x >= 449 && x <= 449+20 && y >= 128 && y <= 128+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Inverness;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Inverness;
                        firstClick = true;
                    }
                    showStatus("Selected City: inverness - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of aberdeen
                else if(x >= 527 && x <= 527+20 && y >= 209 && y <= 209+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Aberdeen;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Aberdeen;
                        firstClick = true;
                    }
                    showStatus("Selected City: aberdeen - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of londonderry
                else if(x >= 213 && x <= 213+20 && y >= 253 && y <= 253+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Londonderry;;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Londonderry;;
                        firstClick = true;
                    }
                    showStatus("Selected City: londonderry - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of glasgow
                else if(x >= 377 && x <= 377+20 && y >= 270 && y <= 270+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Glasgow;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Glasgow;
                        secondCity = null;
                        firstClick = true;
                    }
                    showStatus("Selected City: glasgow - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of edinburgh
                else if(x >= 434 && x <= 434+20 && y >= 287 && y <= 287+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Edinburgh;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Edinburgh;
                        firstClick = true;
                    }
                    showStatus("Selected City: edinburgh - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of dundee
                else if(x >= 472 && x <= 472+20 && y >= 242 && y <= 242+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Dundee;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Dundee;
                        firstClick = true;
                    }
                    showStatus("Selected City: dundee - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of sligo
                else if(x >= 118 && x <= 118+20 && y >= 288 && y <= 288+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Sligo;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Sligo;
                        firstClick = true;
                    }
                    showStatus("Selected City: sligo - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of belfast
                else if(x >= 253 && x <= 253+20 && y >= 332 && y <= 332+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Belfast;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Belfast;
                        firstClick = true;
                    }
                    showStatus("Selected City: belfast - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of stranraer
                else if(x >= 311 && x <= 311+20 && y >= 326 && y <= 326+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Stranraer;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Stranraer;
                        firstClick = true;
                    }
                    showStatus("Selected City: stranraer - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of galway
                else if(x >= 50 && x <= 50+20 && y >= 354 && y <= 354+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Galway;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Galway;
                        firstClick = true;
                    }
                    showStatus("Selected City: galway - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of dundalk
                else if(x >= 205 && x <= 205+20 && y >= 367 && y <= 367+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Dundalk;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Dundalk;
                        firstClick = true;
                    }
                    showStatus("Selected City: dundalk - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of carlisle
                else if(x >= 400 && x <= 400+20 && y >= 380 && y <= 380+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Carlisle;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Carlisle;
                        firstClick = true;
                    }
                    showStatus("Selected City: carlisle - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of newcastle
                else if(x >= 467 && x <= 467+20 && y >= 397 && y <= 397+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Newcastle;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Newcastle;
                        firstClick = true;
                    }
                    showStatus("Selected City: newcastle - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of limerick
                else if(x >= 50 && x <= 50+20 && y >= 420 && y <= 420+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Limerick;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Limerick;
                        firstClick = true;
                    }
                    showStatus("Selected City: limerick - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of tullamore
                else if(x >= 125 && x <= 125+20 && y >= 407 && y <= 407+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Tullamore;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Tullamore;
                        firstClick = true;
                    }
                    showStatus("Selected City: tullamore - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of dublin
                else if(x >= 182 && x <= 182+20 && y >= 422 && y <= 422+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Dublin;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Dublin;
                        firstClick = true;
                    }
                    showStatus("Selected City: dublin - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of barrows
                else if(x >= 361 && x <= 361+20 && y >= 427 && y <= 427+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Barrow;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Barrow;
                        firstClick = true;
                    }
                    showStatus("Selected City: barrows - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of cork
                else if(x >= 39 && x <= 39+20 && y >= 489 && y <= 489+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Cork;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Cork;
                        secondCity = null;
                        firstClick = true;
                    }
                    showStatus("Selected City: cork - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of rosslare
                else if(x >= 134 && x <= 134+20 && y >= 501 && y <= 501+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Rosslare;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Rosslare;
                        firstClick = true;
                    }
                    showStatus("Selected City: rosslare - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of hollyhead
                else if(x >= 265 && x <= 265+20 && y >= 466 && y <= 466+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Holyhead;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Holyhead;
                        firstClick = true;
                    }
                    showStatus("Selected City: hollyhead - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of liverpool
                else if(x >= 335 && x <= 335+20 && y >= 478 && y <= 478+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Liverpool;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Liverpool;
                        firstClick = true;
                    }
                    showStatus("Selected City: liverpool - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of leeds
                else if(x >= 432 && x <= 432+20 && y >= 483 && y <= 483+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Leeds;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Leeds;
                        firstClick = true;

                    }
                    showStatus("Selected City: leeds - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of aberystryth
                else if(x >= 245 && x <= 245+20 && y >= 551 && y <= 551+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Aberystwyth;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Aberystwyth;
                        firstClick = true;
                    }
                    showStatus("Selected City: aberystryth - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of manchester
                else if(x >= 381 && x <= 381+20 && y >= 510 && y <= 510+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Manchester;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Manchester;
                        firstClick = true;
                    }
                    showStatus("Selected City: manchester - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of hull
                else if(x >= 483 && x <= 483+20 && y >= 520 && y <= 520+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Hull;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Hull;
                        secondCity = null;
                        firstClick = true;
                    }
                    showStatus("Selected City: hull - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of carmarthen
                else if(x >= 211 && x <= 211+20 && y >= 600 && y <= 600+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Carmarthen;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Carmarthen;
                        firstClick = true;
                    }
                    showStatus("Selected City: carmarthen - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of llandrindod wells
                else if(x >= 284 && x <= 284+20 && y >= 591 && y <= 591+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.LlandrindodWells;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.LlandrindodWells;
                        firstClick = true;
                    }
                    showStatus("Selected City: llandrindod wells - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of birmingham
                else if(x >= 364 && x <= 364+20 && y >= 602 && y <= 602+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Birmingham;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Birmingham;
                        firstClick = true;
                    }
                    showStatus("Selected City: birmingham - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of nottingham
                else if(x >= 415 && x <= 415+20 && y >= 576 && y <= 576+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Nottingham;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Nottingham;
                        firstClick = true;
                    }
                    showStatus("Selected City: nottingham - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of cardiff
                else if(x >= 252 && x <= 252+20 && y >= 640 && y <= 640+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Cardiff;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Cardiff;
                        firstClick = true;
                    }
                    showStatus("Selected City: cardiff - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of northampton
                else if(x >= 402 && x <= 402+20 && y >= 646 && y <= 646+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Northampton;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Northampton;
                        firstClick = true;
                    }
                    showStatus("Selected City: northampton - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of cambridge
                else if(x >= 457 && x <= 457+20 && y >= 663 && y <= 663+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Cambridge;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Cambridge;
                        firstClick = true;
                    }
                    showStatus("Selected City: cambridge - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of norwich
                else if(x >= 543 && x <= 543+20 && y >= 657 && y <= 657+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Norwich;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Norwich;
                        firstClick = true;
                    }
                    showStatus("Selected City: norwich - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of penzance
                else if(x >= 83 && x <= 83+20 && y >= 694 && y <= 694+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Penzance;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Penzance;
                        firstClick = true;
                    }
                    showStatus("Selected City: penzance - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of plymouth
                else if(x >= 172 && x <= 172+20 && y >= 703 && y <= 703+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Plymouth;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Plymouth;
                        firstClick = true;
                    }
                    showStatus("Selected City: plymouth - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of bristol
                else if(x >= 290 && x <= 290+20 && y >= 675 && y <= 675+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Bristol;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Bristol;
                        firstClick = true;
                    }
                    showStatus("Selected City: bristol - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of reading
                else if(x >= 370 && x <= 370+20 && y >= 697 && y <= 697+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Reading;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Reading;
                        firstClick = true;
                    }
                    showStatus("Selected City: reading - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of london
                else if(x >= 426 && x <= 426+20 && y >= 716 && y <= 716+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.London;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.London;
                        firstClick = true;
                    }
                    showStatus("Selected City: london - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of ipswich
                else if(x >= 500 && x <= 500+20 && y >= 709 && y <= 709+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Ipswich;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Ipswich;
                        firstClick = true;
                    }
                    showStatus("Selected City: ipswich - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of southampton
                else if(x >= 338 && x <= 338+20 && y >= 751 && y <= 751+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Southampton;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Southampton;
                        firstClick = true;
                    }
                    showStatus("Selected City: southampton - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of brighton
                else if(x >= 399 && x <= 399+20 && y >= 777 && y <= 777+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Brighton;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Brighton;
                        firstClick = true;
                    }
                    showStatus("Selected City: brighton - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of dover
                else if(x >= 491 && x <= 491+20 && y >= 778 && y <= 778+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.Dover;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.Dover;
                        firstClick = true;
                    }
                    showStatus("Selected City: dover - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of france
                else if(x >= 560 && x <= 560+20 && y >= 819 && y <= 819+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.France;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.France;
                        firstClick = true;
                    }
                    showStatus("Selected City: france - " + firstCity + ", " + secondCity);
                }
                //if hovering over the city of france
                else if(x >= 291 && x <= 291+20 && y >= 850 && y <= 850+20)
                {
                    if(firstClick == true)
                    {
                        firstCity = CityName.France;
                        secondCity = null;
                        firstClick = false;
                    }
                    else if(firstClick == false)
                    {
                        secondCity = CityName.France;
                        firstClick = true;
                    }
                    showStatus("Selected City: france - " + firstCity + ", " + secondCity);
                }
            }

        }        
        else if(viewTech == true)
        {
            //Plays a button sound when you press BACK
            if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            {
                //play the button sound
                playButtonSound();
                //set the gameBoard to false
                //set the buyTech true
                gameBoard = true;
                viewTech = false;
            }

        }
        else if(buyTech == true)
        {
            //Plays a button sound when you press BACK
            if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            {
                //play the button sound
                playButtonSound();
                //set the gameBoard to false
                //set the buyDest true
                gameBoard = true;
                buyTech = false;
            }
            //plays a button sound when you press on WALES
            else if(x >= 50 && x <= 50+247 && y >= 91 && y <= 91+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a button sound when you press on IRELAND
            else if(x >= 352 && x <= 352+247 && y >= 91 && y <= 91+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a button sound when you press on SCOTLAND
            else if(x >= 659 && x <= 659+247 && y >= 91 && y <= 91+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }

            //plays a button sound when you press on PROPELLERS
            else if(x >= 659 && x <= 659+247 && y >= 91 && y <= 91+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on MECHANICAL STOKER
            else if(x >= 50 && x <= 50+247 && y >= 276 && y <= 276+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on SUPERHEATED STEAM BOILER
            else if(x >= 352 && x <= 352+247 && y >= 276 && y <= 276+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on DIESEL POWER
            else if(x >= 960 && x <= 960+247 && y >= 276 && y <= 276+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on BOILER LAGGING
            else if(x >= 659 && x <= 659+247 && y >= 276 && y <= 276+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on DOUBLE HEADING
            else if(x >= 50 && x <= 50+247 && y >= 461 && y <= 461+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on STEAM TURBINE
            else if(x >= 352 && x <= 352+247 && y >= 461 && y <= 461+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on WATER TENDERS
            else if(x >= 659 && x <= 659+247 && y >= 461 && y <= 461+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on BOOSTERS
            else if(x >= 960 && x <= 960+247 && y >= 461 && y <= 461+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on RISKY CONTRACT
            else if(x >= 50 && x <= 50+247 && y >= 646 && y <= 646+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on RIGHT OF WAY
            else if(x >= 352 && x <= 352+247 && y >= 646 && y <= 646+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on EQUALISING BEAM
            else if(x >= 659 && x <= 659+247 && y >= 646 && y <= 646+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //plays a sound when you press on THERMO COMPRESSOR
            else if(x >= 960 && x <= 960+247 && y >= 646 && y <= 646+160)
            {
                //play the button sound
                playButtonSound();
                //set the tech to purchase
                canPurchase = true;
            }
            //Plays a button sound when you press PURCHASE
            else if(x >= 543 && x <= 543+174 && y >= 828 && y <= 828+51)
            {
                if(canPurchase == true)
                {
                    //play the purchase sound
                    playButtonSoundPurchase();
                    //check to see if selected tech is
                    //buyable

                    //add the selected tech to the player

                    //reset the purchase boolean
                    canPurchase = false;
                    //go back to the gameboard
                    gameBoard = true;
                    buyTech = false;
                }
                else
                {
                    //play the error sound
                    playButtonSoundError();
                }

            }

        }        
        else if(viewDest == true)
        {
            //Plays a button sound when you press BACK
            if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            {
                //play the button sound
                playButtonSound();
                //set the gameBoard to false
                //set the viewDest true
                gameBoard = true;
                viewDest = false;
            }

        }
        else if(rulesScreenInGame == true)
        {
            //Plays a button sound when you press BACK
            if(x >= 5 && x <= 5+98 && y >= 846 && y <= 846+48)
            {
                //play the button sound
                playButtonSound();
                //set the gameBoard to false
                //set the viewDest true
                gameBoard = true;
                rulesScreenInGame = false;
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
            if(playerCount == 2)
            {
                setUpGameBoardScreenTwoPlayers();
            }
            if(playerCount == 3)
            {
                setUpGameBoardScreenThreePlayers();
            }
            if(playerCount == 4)
            {
                setUpGameBoardScreenFourPlayers();
            }
            //this needs a condition where it only prints when updated
            g.setFont(new Font("Wide Latin", Font.PLAIN, 20)); 
            g.drawString("0",770,610);
            checkGameBoardButtons(g);
            checkCityHover(g);
        }
        else if(selectNumPlayersScreen == true)
        {
            setUpSelectNumPlayersScreen();
            checkPlayerButtons(g);
        }
        else if(buyTech == true)
        {
            setUpBuyTechScreen();
            checkBuyTechButtons(g);
        }
        else if(viewTech == true)
        {
            setUpViewTechScreen();
            checkViewTechButtons(g);
        }
        else if(viewDest == true)
        {
            setUpViewDestScreen();
            checkViewDestButtons(g);
        }
        else if(rulesScreenInGame == true)
        {
            setUpRulesScreenInGame();
            checkViewRulesScreenInGameButtons(g);
        }

    }

    //===============================================
    //      methods for button highlighting
    //===============================================

    public void checkViewRulesScreenInGameButtons(Graphics g)
    {
        if(backButton == true)
        {
            //show the highlighted button
            paintHighlightedBackButton(g);
        }
        else
        {
            //show the unselected button
            paintUnselectedBackButton(g);
        }
    }

    public void checkViewTechButtons(Graphics g)
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
    }

    public void checkBuyTechButtons(Graphics g)
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

        if(purchaseButton == true)
            paintHighlightedPurchaseButton(g);
        else
            paintUnselectedPurchaseButton(g);

        if(walesHighlight == true)
            g.drawImage(ImgLib.walesHighlight, 50, 91, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(irelandHighlight == true)
            g.drawImage(ImgLib.irelandHighlight, 352, 91, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(scotlandHighlight == true)
            g.drawImage(ImgLib.scotlandHighlight, 659, 91, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(propellersHighlight == true)
            g.drawImage(ImgLib.propellersHighlight, 960, 91, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(mechanicalHighlight == true)
            g.drawImage(ImgLib.mechanicalHighlight, 50, 276, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(superheatedHighlight == true)
            g.drawImage(ImgLib.superheatedHighlight, 352, 276, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(dieselHighlight == true)
            g.drawImage(ImgLib.dieselHighlight, 659, 276, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(boilerHighlight == true)
            g.drawImage(ImgLib.boilerHighlight, 960, 276, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(doubleheadingHighlight == true)
            g.drawImage(ImgLib.doubleheadingHighlight, 50, 461, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(steamturbineHighlight == true)
            g.drawImage(ImgLib.steamturbineHighlight, 352, 461, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(watertendersHighlight == true)
            g.drawImage(ImgLib.watertendersHighlight, 659, 461, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(boosterHighlight == true)
            g.drawImage(ImgLib.boosterHighlight, 960, 461, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(riskycontractHighlight == true)
            g.drawImage(ImgLib.riskycontractHighlight, 50, 646, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(rightofwayHighlight == true)
            g.drawImage(ImgLib.rightofwayHighlight, 352, 646, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(equalisingbeamHighlight == true)
            g.drawImage(ImgLib.equalisingbeamHighlight, 659, 646, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);

        if(thermocompressorHighlight == true)
            g.drawImage(ImgLib.thermocompressorHighlight, 960, 646, this);
        else
            g.drawImage(ImgLib.emptySelect, 50, 91, this);
    }

    public void checkViewDestButtons(Graphics g)
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
    }

    public void checkCityHover(Graphics g)
    {
        if(stornowayHover == true)
            g.drawImage(ImgLib.stornowayHover, 395-87, 49-60, this);
        if(ullapoolHover == true)
            g.drawImage(ImgLib.ullapoolHover, 429-87, 94-60, this);
        if(wickHover == true)
            g.drawImage(ImgLib.wickHover, 545-87, 94-60, this);
        if(fortwilliamHover == true)
            g.drawImage(ImgLib.fortwilliamHover, 383-87, 183-60, this);
        if(invernessHover == true)
            g.drawImage(ImgLib.invernessHover, 459-87, 138-60, this);
        if(aberdeenHover == true)
            g.drawImage(ImgLib.aberdeenHover, 537-87, 219-60, this);
        if(londonderryHover == true)
            g.drawImage(ImgLib.londonderryHover, 223-87, 263-60, this);
        if(glasgowHover == true)
            g.drawImage(ImgLib.glasgowHover, 387-87, 280-60, this);
        if(edinburghHover == true)
            g.drawImage(ImgLib.edinburghHover, 444-87, 297-60, this);
        if(dundeeHover == true)
            g.drawImage(ImgLib.dundeeHover, 482-87, 252-60, this);
        if(sligoHover == true)
            g.drawImage(ImgLib.sligoHover, 128-87, 298-60, this);
        if(belfastHover == true)
            g.drawImage(ImgLib.belfastHover, 263-87, 342-60, this);
        if(stranraerHover == true)
            g.drawImage(ImgLib.stranraerHover, 321-87, 336-60, this);
        if(galwayHover == true)
            g.drawImage(ImgLib.galwayHover, 60-87, 364-60, this);
        if(dundalkHover == true)
            g.drawImage(ImgLib.dundalkHover, 215-87, 377-60, this);
        if(carlisleHover == true)
            g.drawImage(ImgLib.carlisleHover, 410-87, 390-60, this);
        if(newcastleHover == true)
            g.drawImage(ImgLib.newcastleHover, 477-87, 407-60, this);
        if(limerickHover == true)
            g.drawImage(ImgLib.limerickHover, 60-87, 430-60, this);
        if(tullamoreHover == true)
            g.drawImage(ImgLib.tullamoreHover, 135-87, 417-60, this);
        if(dublinHover == true)
            g.drawImage(ImgLib.dublinHover, 192-87, 432-60, this);
        if(barrowsHover == true)
            g.drawImage(ImgLib.barrowsHover, 371-87, 437-60, this);
        if(corkHover == true)
            g.drawImage(ImgLib.corkHover, 49-87, 499-60, this);
        if(rosslareHover == true)
            g.drawImage(ImgLib.rosslareHover, 144-87, 511-60, this);
        if(hollyheadHover == true)
            g.drawImage(ImgLib.hollyheadHover, 275-87, 476-60, this);
        if(liverpoolHover == true)
            g.drawImage(ImgLib.liverpoolHover, 345-87, 488-60, this);
        if(leedsHover == true)
            g.drawImage(ImgLib.leedsHover, 442-87, 493-60, this);
        if(aberystrythHover == true)
            g.drawImage(ImgLib.aberystrythHover, 255-87, 561-60, this);
        if(manchesterHover == true)
            g.drawImage(ImgLib.manchesterHover, 391-87, 520-60, this);
        if(hullHover == true)
            g.drawImage(ImgLib.hullHover, 493-87, 530-60, this);
        if(carmarthenHover == true)
            g.drawImage(ImgLib.carmarthenHover, 221-87, 610-60, this);
        if(llandrindodwellsHover == true)
            g.drawImage(ImgLib.llandrindodwellsHover, 294-87, 601-60, this);
        if(birminghamHover == true)
            g.drawImage(ImgLib.birminghamHover, 374-87, 612-60, this);
        if(nottinghamHover == true)
            g.drawImage(ImgLib.nottinghamHover, 425-87, 586-60, this);
        if(cardiffHover == true)
            g.drawImage(ImgLib.cardiffHover, 262-87, 650-60, this);
        if(northamptonHover == true)
            g.drawImage(ImgLib.northamptonHover, 412-87, 656-60, this);
        if(cambridgeHover == true)
            g.drawImage(ImgLib.cambridgeHover, 467-87, 673-60, this);
        if(norwichHover == true)
            g.drawImage(ImgLib.norwichHover, 553-87, 667-60, this);
        if(penzanceHover == true)
            g.drawImage(ImgLib.penzanceHover, 93-87, 704-60, this);
        if(plymouthHover == true)
            g.drawImage(ImgLib.plymouthHover, 182-87, 713-60, this);
        if(bristolHover == true)
            g.drawImage(ImgLib.bristolHover, 300-87, 685-60, this);
        if(readingHover == true)
            g.drawImage(ImgLib.readingHover, 380-87, 707-60, this);
        if(londonHover == true)
            g.drawImage(ImgLib.londonHover, 436-87, 726-60, this);
        if(ipswichHover == true)
            g.drawImage(ImgLib.ipswichHover, 510-87, 719-60, this);
        if(southamptonHover == true)
            g.drawImage(ImgLib.southamptonHover, 348-87, 761-60, this);
        if(brightonHover == true)
            g.drawImage(ImgLib.brightonHover, 409-87, 787-60, this);
        if(doverHover == true)
            g.drawImage(ImgLib.doverHover, 501-87, 788-60, this);
        if(franceHover == true)
            g.drawImage(ImgLib.franceHover, 570-87, 829-60, this);
        if(franceHover == true)
            g.drawImage(ImgLib.franceHover, 301-87, 860-60, this);

        else
            g.drawImage(ImgLib.emptyHover, 8, 8, this);

    }

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

    public void checkGameBoardButtons(Graphics g)
    {

        if(viewTechButton == true)
            g.drawImage(ImgLib.viewTechButtonHighlighted, 612, 508, this);
        else
            g.drawImage(ImgLib.viewTechButtonUnselected, 612, 508, this);

        if(buyTechButton == true)
            g.drawImage(ImgLib.buyTechButtonHighlighted, 828, 508, this);
        else
            g.drawImage(ImgLib.buyTechButtonUnselected, 828, 508, this);

        if(viewDestButton == true)
            g.drawImage(ImgLib.viewDestButtonHighlighted, 1044, 508, this);
        else
            g.drawImage(ImgLib.viewDestButtonUnselected, 1044, 508, this);

        if(rulesButton == true)
            g.drawImage(ImgLib.viewRulesButtonHighlighted, 781, 28, this);
        else
            g.drawImage(ImgLib.viewRulesButtonUnselected, 781, 28, this);
    }    

    //===============================================
    //      Seting up the game screens
    //===============================================

    public void setUpMainMenuScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.mainMenu, 0, 0, this);
    }

    public void setUpRulesScreen1()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.rulesScreen1, 0, 0, this);
    }

    public void setUpRulesScreen2()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.rulesScreen2, 0, 0, this);
    }

    public void setUpSelectNumPlayersScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.selectPlayers, 0, 0, this);
    }

    public void setUpGameBoardScreenTwoPlayers()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.gameBoarbackground2Players, 0, 0, this);
    }

    public void setUpGameBoardScreenThreePlayers()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.gameBoarbackground3Players, 0, 0, this);
    }

    public void setUpGameBoardScreenFourPlayers()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.gameBoarbackground4Players, 0, 0, this);
    }

    public void setUpBuyTechScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.buyTech, 0, 0, this);
    }

    public void setUpViewTechScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.viewTech, 0, 0, this);
    }

    public void setUpViewDestScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.viewDest, 0, 0, this);
    }

    public void setUpRulesScreenInGame()
    {
        Graphics g = getGraphics();
        g.drawImage(ImgLib.rulesScreenInGame, 0, 0, this);
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

    public void playButtonSoundPage()
    {
        //set the random number to play random button sound
        String buttonSound = "resources/sounds/buttons/Pageturn.wav";
        //plays random button sound from button names
        play( getDocumentBase(), buttonSound );
    }

    public void playButtonSoundError()
    {
        //set the random number to play random button sound
        String buttonSound = "resources/sounds/buttons/error.wav";
        //plays random button sound from button names
        play( getDocumentBase(), buttonSound );
    }

    public void playButtonSoundPurchase()
    {
        //set the random number to play random button sound
        String buttonSound = "resources/sounds/buttons/purchase.wav";
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

    //buyTech
    public void paintUnselectedPurchaseButton(Graphics g)
    {
        g.drawImage(ImgLib.purchaseButtonUnselected, 543, 828, this);
    }

    public void paintHighlightedPurchaseButton(Graphics g)
    {
        g.drawImage(ImgLib.purchaseButtonHighlighted, 543, 828, this);
    }

    public void paintPressedPurchaseButton(Graphics g)
    {
        g.drawImage(ImgLib.purchaseButtonPressed, 543, 828, this);
    }

    //main menu
    public void paintUnselectedBackButton(Graphics g)
    {
        g.drawImage(ImgLib.backButtonUnselected, 5, 846, this);
    }

    public void paintUnselectedPlayGameButton(Graphics g)
    {
        g.drawImage(ImgLib.playButtonUnselected, 500, 464, this);
    }

    public void paintUnselectedRulesButton(Graphics g)
    {
        g.drawImage(ImgLib.rulesButtonUnselected, 125, 464, this);
    }

    public void paintUnselectedQuitButton(Graphics g)
    {
        g.drawImage(ImgLib.quitButtonUnselected, 875, 464, this);
    }

    public void paintHighlightedBackButton(Graphics g)
    {
        g.drawImage(ImgLib.backButtonHighlighted, 5, 846, this);
    }

    public void paintHighlightPlayGameButton(Graphics g)
    {
        g.drawImage(ImgLib.playButtonHighlighted, 500, 464, this);
    }

    public void paintHighlightRulesButton(Graphics g)
    {
        g.drawImage(ImgLib.rulesButtonHighlighted, 125, 464, this);
    }

    public void paintHighlightQuitButton(Graphics g)
    {
        g.drawImage(ImgLib.quitButtonHighlighted, 875, 464, this);
    }

    public void paintPressedBackButton(Graphics g)
    {
        g.drawImage(ImgLib.backButtonPressed, 5, 846, this);
    }

    public void paintPressedPlayGameButton(Graphics g)
    {
        g.drawImage(ImgLib.playButtonPressed, 500, 464, this);
    }

    public void paintPressedRulesButton(Graphics g)
    {
        g.drawImage(ImgLib.rulesButtonPressed, 125, 464, this);
    }

    public void paintPressedQuitButton(Graphics g)
    {
        g.drawImage(ImgLib.quitButtonPressed, 875, 464, this);
    }

    //images for selectnumplyers screen
    public void paintUnselected2PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.twoPlayersUnselected, 125, 464, this);
    }

    public void paintUnselected3PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.threePlayersUnselected, 500, 464, this);
    }

    public void paintUnselected4PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.fourPlayersUnselected, 875, 464, this);
    }

    public void paintHighlighted2PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.twoPlayersHighlighted, 125, 464, this);
    }

    public void paintHighlighted3PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.threePlayersHighlighted, 500, 464, this);
    }

    public void paintHighlighted4PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.fourPlayersHighlighted, 875, 464, this);
    }

    public void paintPressed2PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.twoPlayersPressed, 125, 464, this);
    }

    public void paintPressed3PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.threePlayersPressed, 500, 464, this);
    }

    public void paintPressed4PlayersButton(Graphics g)
    {
        g.drawImage(ImgLib.fourPlayersPressed, 875, 464, this);
    }

    //rules screen
    public void paintUnselectedNextButton(Graphics g)
    {
        g.drawImage(ImgLib.nextButtonUnselected, 962, 13, this);
    }

    public void paintUnselectedPreviousButton(Graphics g)
    {
        g.drawImage(ImgLib.previousButtonUnselected, 219, 13, this);
    }

    public void paintHighlightedNextButton(Graphics g)
    {
        g.drawImage(ImgLib.nextButtonHighlighted, 962, 13, this);
    }

    public void paintHighlightedPreviousButton(Graphics g)
    {
        g.drawImage(ImgLib.previousButtonHighlighted, 219, 13, this);
    }

    public void paintPressedNextButton(Graphics g)
    {
        g.drawImage(ImgLib.nextButtonPressed, 962, 13, this);
    }

    public void paintPressedPreviousButton(Graphics g)
    {
        g.drawImage(ImgLib.previousButtonPressed, 219, 13, this);
    }

    //gameboard
    public void paintPressedviewTechButton(Graphics g)
    {
        g.drawImage(ImgLib.viewTechButtonPressed, 612, 508, this);
    }

    public void paintPressedBuyTechButton(Graphics g)
    {
        g.drawImage(ImgLib.buyTechButtonPressed, 828, 508, this);
    }

    public void paintPressedviewDestButton(Graphics g)
    {
        g.drawImage(ImgLib.viewDestButtonPressed, 1044, 508, this);
    }

    public void paintUnselectedviewTechButton(Graphics g)
    {
        g.drawImage(ImgLib.viewTechButtonUnselected, 612, 508, this);
    }

    public void paintUnselectedBuyTechButton(Graphics g)
    {
        g.drawImage(ImgLib.buyTechButtonUnselected, 828, 508, this);
    }

    public void paintUnselectedviewDestButton(Graphics g)
    {
        g.drawImage(ImgLib.viewDestButtonUnselected, 1044, 508, this);
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