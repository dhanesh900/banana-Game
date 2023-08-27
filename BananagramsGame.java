import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Player {
    String name;
    int score;

    Player(String name) {
        this.name = name;
        this.score = 0;
    }
}

public class BananagramsGame extends JFrame {
    private Map<String, Player> playerProfiles;
    private Timer timer;

    BananagramsGame() {
        // Initialize player profiles
        playerProfiles = new HashMap<>();

        // Create UI components
        JLabel nameLabel = new JLabel("Player Name:");
        JTextField nameField = new JTextField(20);
        JButton startButton = new JButton("Start Game");

        // Set up the timer
        int durationInSeconds = 120; // Timer duration
        timer = new Timer(durationInSeconds * 1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Timer has ended, handle end of session
                // ...
            }
        });

        // Start button action listener
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String playerName = nameField.getText();
                if (!playerName.isEmpty()) {
                    Player player = playerProfiles.getOrDefault(playerName, new Player(playerName));
                    playerProfiles.put(playerName, player);

                    // Start the timer
                    timer.start();

                    // Start the game
                    startGame(player);
                }
            }
        });

        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bananagrams Game");
        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameField);
        add(startButton);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    private void startGame(Player player) {
//        // Implement the game logic here
//        // ...
//    }
//private void startGame(Player player) {
//    // Create a pouch of letters
//    java.util.List<Character> letterPouch = (java.util.List<Character>) createLetterPouch();
//
//    // Create a grid for players to place tiles
//    int gridSize = 10; // Adjust as needed
//    JTextField[][] letterGrid = new JTextField[gridSize][gridSize];
//
//    // Set up UI components for the grid
//    JPanel gridPanel = new JPanel(new GridLayout(gridSize, gridSize));
//    for (int i = 0; i < gridSize; i++) {
//        for (int j = 0; j < gridSize; j++) {
//            letterGrid[i][j] = new JTextField(1);
//            gridPanel.add(letterGrid[i][j]);
//        }
//    }
//
//    // Set up the game window
//    JFrame gameFrame = new JFrame("Bananagrams Game - " + player.name);
//    gameFrame.setLayout(new BorderLayout());
//    gameFrame.add(gridPanel, BorderLayout.CENTER);
//    gameFrame.setSize(400, 400);
//    gameFrame.setLocationRelativeTo(null);
//    gameFrame.setVisible(true);
//
//    // Deal letters to players (for simplicity, we'll deal random letters)
//    Collections.shuffle(letterPouch);
//    int numTilesToDeal = 10; // Adjust as needed
//    for (int i = 0; i < numTilesToDeal; i++) {
//        char letter = letterPouch.remove(0);
//        // Place the letter on a tile of your choice in the grid
//        // For simplicity, let's place it in a fixed position
//        letterGrid[i / gridSize][i % gridSize].setText(String.valueOf(letter));
//    }
//
//    // Start the timer
//    timer.start();
//}

    public java.util.List<Character> createLetterPouch() {
        java.util.List<Character> pouch = new ArrayList<>();
        // Add letters to the pouch (adjust distribution as needed)
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            pouch.add(letter);
        }
        return pouch;
    }

    private void startGame(Player player) {
        // Create and set up the game window
        JFrame gameFrame = new JFrame("Bananagrams Game - " + player.name);
        gameFrame.setSize(800, 600); // Adjust size as needed
        gameFrame.setLayout(new BorderLayout());

        // Create grid panel
        JPanel gridPanel = new JPanel(new GridLayout(10, 10)); // Customize rows and columns
        // Add text fields to gridPanel
        for (int i = 0; i < 100; i++) {
            JTextField textField = new JTextField();
            gridPanel.add(textField);
        }

        // Create player's letter panel
        JPanel playerLetterPanel = new JPanel(new BorderLayout());
        playerLetterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        playerLetterPanel.setBackground(Color.LIGHT_GRAY);
        JLabel playerNameLabel = new JLabel(player.name + "'s Letters");
        playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerLetterPanel.add(playerNameLabel, BorderLayout.NORTH);
        // Add pouch letters to playerLetterPanel
        // ...
        // Create a pouch of letters
        java.util.List<Character> letterPouch = (java.util.List<Character>) createLetterPouch();



        // Deal letters to players (for simplicity, we'll deal random letters)
//        Collections.shuffle(letterPouch);
//        int numTilesToDeal = 10; // Adjust as needed
//        for (int i = 0; i < numTilesToDeal; i++) {
//            char letter = letterPouch.remove(0);
//            // Place the letter on a tile of your choice in the grid
//            // For simplicity, let's place it in a fixed position
//            letterGrid[i / gridSize][i % gridSize].setText(String.valueOf(letter));
//        }


        // Create check word button
        JButton checkWordButton = new JButton("Check Word");
        checkWordButton.setPreferredSize(new Dimension(100, 40)); // Adjust size
        // ...

        // Create player info panel
        JPanel playerInfoPanel = new JPanel();
        playerInfoPanel.setLayout(new BoxLayout(playerInfoPanel, BoxLayout.Y_AXIS));
        playerInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Add labels and information to playerInfoPanel
        // ...

        // Create timer label
        JLabel timerLabel = new JLabel("Timer: " ); // Initialize with timer value
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // ...
        // Start the timer
        timer.start();

        // Add components to the gameFrame
        gameFrame.add(gridPanel, BorderLayout.CENTER);
        gameFrame.add(playerLetterPanel, BorderLayout.LINE_START);
        gameFrame.add(checkWordButton, BorderLayout.LINE_END);
        gameFrame.add(playerInfoPanel, BorderLayout.EAST);
        gameFrame.add(timerLabel, BorderLayout.SOUTH);

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BananagramsGame();
            }
        });
    }
}
