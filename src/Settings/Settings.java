package Settings;

import MainGame.AirCraft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Settings extends JFrame implements SettingsUtility, ActionListener{
    final static int PLAYER1 = 0;
    final static int PLAYER2 = 1;
    final static int PLAYER3 = 2;

    public static boolean soundOn = true;
    public static boolean musicOn = false;
    public static int selectPlayer = PLAYER1;

    JLabel title, nameLabel, playerLabel, soundLabel, musicLabel;
    JTextField nameField;
    JComboBox<String> playerComboBox;
    JRadioButton soundOnRadioButton, soundOffRadioButton;
    JRadioButton musicOnRadioButton, musicOffRadioButton;
    JButton seeScoresButton, startGameButton;
    ButtonGroup musicButtonGroup, soundButtonGroup;

    public Settings() {
        setSize(500, 500);
        setTitle("Game Settings.Settings");
        setLayout(null);
        setLocationRelativeTo(null);

        title = new JLabel("Space MainGame.AirCraft");
        title.setFont(new Font("Roboto", Font.PLAIN, 24));
        title.setBounds(150, 10, 200, 30);

        nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(50, 70, 100, 30);
        nameField = new JTextField();
        nameField.setBounds(160, 70, 200, 30);

        playerLabel = new JLabel("Select MainGame.Player:");
        playerLabel.setBounds(50, 120, 100, 30);
        String[] players = {"MainGame.Player 1", "MainGame.Player 2", "MainGame.Player 3"};
        playerComboBox = new JComboBox<>(players);
        playerComboBox.setBounds(160, 120, 200, 30);

        soundLabel = new JLabel("MainGame.Sound:");
        soundLabel.setBounds(50, 170, 100, 30);
        soundOnRadioButton = new JRadioButton("On");
        soundOnRadioButton.setBounds(160, 170, 50, 30);
        soundOffRadioButton = new JRadioButton("Off");
        soundOffRadioButton.setBounds(220, 170, 50, 30);

        soundButtonGroup = new ButtonGroup();
        soundButtonGroup.add(soundOnRadioButton);
        soundButtonGroup.add(soundOffRadioButton);
        soundOnRadioButton.setSelected(true); // Setting "On" as default

        musicLabel = new JLabel("Music:");
        musicLabel.setBounds(50, 220, 100, 30);
        musicOnRadioButton = new JRadioButton("On");
        musicOnRadioButton.setBounds(160, 220, 50, 30);
        musicOffRadioButton = new JRadioButton("Off");
        musicOffRadioButton.setBounds(220, 220, 50, 30);

        musicButtonGroup = new ButtonGroup();
        musicButtonGroup.add(musicOnRadioButton);
        musicButtonGroup.add(musicOffRadioButton);
        musicOffRadioButton.setSelected(true); // Setting "Off" as default

        seeScoresButton = new JButton("See Scores");
        seeScoresButton.setBounds(50, 270, 120, 30);
        seeScoresButton.addActionListener(this);

        startGameButton = new JButton("Start Game");
        startGameButton.setBounds(190, 320, 120, 40);
        startGameButton.addActionListener(this);


        soundOnRadioButton.setFocusable(false);
        soundOffRadioButton.setFocusable(false);
        musicOnRadioButton.setFocusable(false);
        musicOffRadioButton.setFocusable(false);
        seeScoresButton.setFocusable(false);
        startGameButton.setFocusable(false);

        add(title);
        add(nameLabel);
        add(nameField);
        add(playerLabel);
        add(playerComboBox);
        add(soundLabel);
        add(soundOnRadioButton);
        add(soundOffRadioButton);
        add(musicLabel);
        add(musicOnRadioButton);
        add(musicOffRadioButton);
        add(seeScoresButton);
        add(startGameButton);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showScores() {
        JOptionPane.showMessageDialog(this, "Scores Button Clicked!");
    }
    private void startGame() {
        new AirCraft();
    }


    @Override
    public void setPlayer(String player) {
        if(Objects.equals(player, "MainGame.Player 1")) {
            selectPlayer = PLAYER1;
        } else if (Objects.equals(player, "MainGame.Player 2")) {
            selectPlayer = PLAYER2;
        } else if (Objects.equals(player, "MainGame.Player 3")) {
            selectPlayer = PLAYER3;
        }
    }

    @Override
    public void musicOn(String music) {
        if (Objects.equals(music, "On")) {
            musicOn = true;
        }
        else {
            musicOn = false;
        }
    }

    @Override
    public void soundOn(String music) {
        if (Objects.equals(music, "On")) {
            soundOn = true;
        }
        else {
            soundOn = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startGameButton) {
            try {
                String name = nameField.getText();
                String player = (String) playerComboBox.getSelectedItem();
                String soundOption = soundOnRadioButton.isSelected() ? "On" : "Off";
                String musicOption = musicOnRadioButton.isSelected() ? "On" : "Off";
                if(Objects.equals(name, "")) {
                    throw new NameBlankException("Name cannot be empty!");
                } else {
                    setPlayer(player);
                    musicOn(musicOption);
                    soundOn(soundOption);
                    System.out.println( name + " " + selectPlayer + " " + soundOn + " " + musicOn);

                    startGame(); // Start the game
                }
            } catch (NameBlankException err) {
                JOptionPane.showMessageDialog(this, err);
            } catch (Exception err) {
                System.out.println("Other error!");
            }
        } else if ( e.getSource() == seeScoresButton) {
            showScores(); // Show all the MainGame.Score
        }
    }


    public static void main(String[] args) {
        new Settings();
    }
}
