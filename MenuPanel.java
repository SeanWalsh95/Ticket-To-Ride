import javax.sound.sampled.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;

/**
 * A panel to present the user with a game menu and take in the initial Player
 * options
 * 
 * @author Sean Walsh
 * @version 1.0
 */
public class MenuPanel extends JPanel {
	// backround image to paint behind everything
	Image background;
	// Player count choice
	protected int numberOfPlayers;
	// ArrayList of players to be eventually passed to the GameBoard
	protected ArrayList<Player> players = new ArrayList<Player>();

	/**
	 * Constructor for MenuPanel
	 */
	public MenuPanel() {
		// sets the layout to null allowing for absolute positioning of
		// components
		this.setLayout(null);
		playBackgroundSound();
		// defaults to the main menu page
		mainMenu();
	}

	/**
	 * Generate a random number for the background sounds and sets the sound to
	 * play
	 */
	public void playBackgroundSound() {
		String filePath = "";
		// instance of Random Class
		Random r = new Random();
		// set randomInt to random # between 1 and 6
		int randomInt = r.nextInt(6) + 1;
		// set the random number to play random button sound
		if (randomInt == 1) {
			filePath = "resources/sounds/backgroundSounds/america.au";
		}
		if (randomInt == 2) {
			filePath = "resources/sounds/backgroundSounds/europe.au";
		}
		if (randomInt == 3) {
			filePath = "resources/sounds/backgroundSounds/legendaryAsia.au";
		}
		if (randomInt == 4) {
			filePath = "resources/sounds/backgroundSounds/suspense.au";
		}
		if (randomInt == 5) {
			filePath = "resources/sounds/backgroundSounds/switzerland.au";
		}
		if (randomInt == 6) {
			filePath = "resources/sounds/backgroundSounds/titleTheme.au";
		}

		// plays random background sound from filePath
		try (AudioInputStream inputStream = AudioSystem
				.getAudioInputStream(new File(filePath))) {
			Clip clip = AudioSystem.getClip();
			clip.open(inputStream);
			// plays audio on loop
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			System.err.println("Cannot find sound file: \"" + filePath + "\"");
		}
	}

	/**
	 * Paint component method for this JPanel component
	 * 
	 * @param g
	 *            the Graphics object for this Class
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);
	}

	/**
	 * Main mene method to present the user with starting options
	 */
	public void mainMenu() {
		this.removeAll();
		background = ImgLib.mainMenuBackground;

		GButton playGameButt = new GButton(new int[] { 503, 464, 260, 111 },
				ImgLib.playButtonUnselected, ImgLib.playButtonHighlighted);
		playGameButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playGame();
			}
		});
		this.add(playGameButt);

		GButton rulesButt = new GButton(new int[] { 125, 464, 260, 111 },
				ImgLib.rulesButtonUnselected, ImgLib.rulesButtonHighlighted);
		rulesButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameRules();
			}
		});
		this.add(rulesButt);

		GButton quitButt = new GButton(new int[] { 875, 464, 260, 111 },
				ImgLib.quitButtonUnselected, ImgLib.quitButtonHighlighted);
		quitButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(quitButt);

		this.repaint();
	}

	/**
	 * gameRules method to present the user with the game rules
	 */
	private void gameRules() {
		this.removeAll();
		background = ImgLib.rulesScreen1;

		GButton next = new GButton(new int[] { 962, 13, 80, 30 },
				ImgLib.nextButtonUnselected, ImgLib.nextButtonHighlighted);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background = ImgLib.rulesScreen2;
				repaint();
			}
		});
		this.add(next);

		GButton previous = new GButton(new int[] { 219, 13, 80, 30 },
				ImgLib.previousButtonUnselected,
				ImgLib.previousButtonHighlighted);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background = ImgLib.rulesScreen1;
				repaint();
			}
		});
		this.add(previous);

		GButton back = new GButton(new int[] { 5, 846, 98, 48 },
				ImgLib.backButtonUnselected, ImgLib.backButtonHighlighted);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu();
			}
		});
		this.add(back);

		this.repaint();
	}

	/**
	 * playGame method to present the user with the initial starting options for
	 * a new game
	 */
	private void playGame() {
		this.removeAll();

		GButton twoPlayers = new GButton(new int[] { 125, 464, 260, 111 },
				ImgLib.twoPlayersUnselected, ImgLib.twoPlayersHighlighted);
		twoPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfPlayers = 2;
				buildPlayers();
			}
		});
		this.add(twoPlayers);

		GButton threePlayers = new GButton(new int[] { 500, 464, 260, 111 },
				ImgLib.threePlayersUnselected, ImgLib.threePlayersHighlighted);
		threePlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfPlayers = 3;
				buildPlayers();
			}
		});
		this.add(threePlayers);

		GButton fourPlayers = new GButton(new int[] { 875, 464, 260, 111 },
				ImgLib.fourPlayersUnselected, ImgLib.fourPlayersHighlighted);
		fourPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfPlayers = 4;
				buildPlayers();
			}
		});
		this.add(fourPlayers);

		GButton back = new GButton(new int[] { 5, 846, 98, 48 },
				ImgLib.backButtonUnselected, ImgLib.backButtonHighlighted);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu();
			}
		});
		this.add(back);

		this.repaint();
	}

	/**
	 * buildPlayers method to build a List of players based on user input and
	 * then launch the game
	 */
	private void buildPlayers() {
		// lists to keep track of what has already been chosen
		ArrayList<String> chosenNames = new ArrayList<String>();
		ArrayList<Color> chosenColors = new ArrayList<Color>();

		// loop through the selected number of players
		for (int i = 0; i < numberOfPlayers; i++) {
			// player input values to be placed into a Player object
			String name;
			Color color;

			// default player name if nothing is chosen
			String generated = "Player " + (i + 1);

			// player inputs a name of their choice
			String input = JOptionPane
					.showInputDialog("Player " + (i + 1) + " enter your name");

			// handles bad inputs
			if (input == null || input.equals("")) {
				name = generated;
			} else {
				name = input + " (Player " + (i + 1) + ")";
			}

			// loops untill a valid choice
			while (true) {
				// player inputs a custom color
				Color newColor = JColorChooser.showDialog(null,
						"Choose a color", Color.BLUE);

				// handles if the color has already been chosen
				boolean uniqueColor = true;
				if (newColor != null) {
					for (Color c : chosenColors)
						if (c.equals(newColor))
							uniqueColor = false;
					if (uniqueColor) {
						color = newColor;
						break;
					} else {
						JOptionPane.showMessageDialog(new JFrame(),
								"This Color was already chosen "+ 
                                "please choose another");
					}
				}
			}

			// adds choices to lists for future refrence
			chosenNames.add(name);
			chosenColors.add(color);

			// creates and adds a new player to the player list
			players.add(new Player(i, name, color));
		}
		// closes the JDialog Class containing this JPanel
		((JDialog) SwingUtilities.windowForComponent(this)).dispose();
	}
}
