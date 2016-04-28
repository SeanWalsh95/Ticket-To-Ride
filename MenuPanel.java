import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 * A panel to present the user with a game menu and take in the initial options 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPanel extends JPanel
{
    Image background;
    protected int numberOfPlayers;
    protected ArrayList<Player> players = new ArrayList<Player>();

    public MenuPanel(){
        this.setLayout(null);
        mainMenu();
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.drawImage(background,0,0,this);
    }

    public void mainMenu(){
        this.removeAll();
        background = ImgLib.mainMenuBackground;

        GButton playGameButt = new GButton(new int[]{503,464,260,111},ImgLib.playButtonUnselected,ImgLib.playButtonHighlighted);
        playGameButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    playGame();
                }
            });
        this.add(playGameButt);

        GButton rulesButt = new GButton(new int[]{125,464,260,111},ImgLib.rulesButtonUnselected,ImgLib.rulesButtonHighlighted);
        rulesButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    gameRules();
                }
            });
        this.add(rulesButt);

        GButton quitButt = new GButton(new int[]{875,464,260,111},ImgLib.quitButtonUnselected,ImgLib.quitButtonHighlighted);
        quitButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
        this.add(quitButt);

        this.repaint(); 
    }

    private void gameRules(){
        this.removeAll();
        background = ImgLib.rulesScreen1;

        GButton next = new GButton(new int[]{962,13,80,30},ImgLib.nextButtonUnselected,ImgLib.nextButtonHighlighted);
        next.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    background = ImgLib.rulesScreen2;
                    repaint(); 
                }
            });
        this.add(next);

        GButton previous = new GButton(new int[]{219,13,80,30},ImgLib.previousButtonUnselected,ImgLib.previousButtonHighlighted);
        previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    background = ImgLib.rulesScreen1;
                    repaint(); 
                }
            });
        this.add(previous);

        GButton back = new GButton(new int[]{5,846,98,48},ImgLib.backButtonUnselected,ImgLib.backButtonHighlighted);
        back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    mainMenu();
                }
            });
        this.add(back);

        this.repaint(); 
    }

    private void playGame(){
        this.removeAll();

        GButton twoPlayers = new GButton(new int[]{125,464,260,111},ImgLib.twoPlayersUnselected,ImgLib.twoPlayersHighlighted);
        twoPlayers.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    numberOfPlayers = 2;
                    buildPlayers();
                }
            });
        this.add(twoPlayers);

        GButton threePlayers = new GButton(new int[]{500,464,260,111},ImgLib.threePlayersUnselected,ImgLib.threePlayersHighlighted);
        threePlayers.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    numberOfPlayers = 3;
                    buildPlayers();
                }
            });
        this.add(threePlayers);

        GButton fourPlayers = new GButton(new int[]{875,464,260,111},ImgLib.fourPlayersUnselected,ImgLib.fourPlayersHighlighted);
        fourPlayers.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    numberOfPlayers = 4;
                    buildPlayers();
                }
            });
        this.add(fourPlayers);

        GButton back = new GButton(new int[]{5,846,98,48},ImgLib.backButtonUnselected,ImgLib.backButtonHighlighted);
        back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    mainMenu();
                }
            });
        this.add(back);

        this.repaint(); 
    }

    private void buildPlayers(){
        ArrayList<String> chosenNames = new ArrayList<String>();
        ArrayList<Color> chosenColors = new ArrayList<Color>();
        for(int i=0; i < numberOfPlayers; i++){
            String name;
            Color color;

            String generated = "Player "+(i+1);
            String input = JOptionPane.showInputDialog("Player "+(i+1)+" enter your name");
            if(input ==  null || input.equals("")){
                name = generated;
            }else{
                name = input+" (Player "+(i+1)+")";
            }
            System.out.println(name);

            while(true){
                Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLUE);
                boolean uniqueColor = true;
                if(newColor != null){
                    for(Color c : chosenColors)
                        if(c.equals(newColor))
                            uniqueColor = false;
                    if(uniqueColor){
                        color = newColor;
                        break;
                    }else{
                        JOptionPane.showMessageDialog(new JFrame(), "This Color was already chosen please choose another");
                    }
                }
            }

            chosenNames.add(name);
            chosenColors.add(color);

            players.add(new Player(i,name,color));
        }
        ((JDialog)SwingUtilities.windowForComponent(this)).dispose();
    }
}
