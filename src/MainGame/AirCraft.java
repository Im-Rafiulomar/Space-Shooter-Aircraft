package MainGame;

import javax.swing.*;

public class AirCraft extends JFrame {
    public AirCraft() {
        setTitle("Space MainGame.AirCraft");
        setSize(600,600);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new GameFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
