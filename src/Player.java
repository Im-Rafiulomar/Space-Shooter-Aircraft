import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    int velX = 0, velY = 0;
    public Player(int x, int y) {
        super(x, y);
    }

    public void update() {
        y += velY;
        x += velX;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImg(), x, y, null);
    }

    public Image getPlayerImg() {
        ImageIcon ic = new ImageIcon("./src/resources/player3.png");
        return ic.getImage();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            velY = -5;
        } else if (key == KeyEvent.VK_S) {
            velY = 5;
        } else if (key == KeyEvent.VK_A) {
            velX = -5;
        } else if (key == KeyEvent.VK_D) {
            velX = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            velY = 0;
        } else if (key == KeyEvent.VK_S) {
            velY = 0;
        } else if (key == KeyEvent.VK_A) {
            velX = 0;
        } else if (key == KeyEvent.VK_D) {
            velX = 0;
        }
    }
}
