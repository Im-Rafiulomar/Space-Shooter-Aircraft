import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JFrame frame;
    JLabel label;
    public GameFrame() {
        frame = new JFrame("Space AirCraft");
        label = new JLabel("This text is for test only");



//        Start Frame adding section
            frame.add(label);
//        End Frame adding section

        frame.setSize(new Dimension(700, 700));
        frame.setLocationRelativeTo(null); // centered relative to the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // This should be at the end of frame.
    }
}
