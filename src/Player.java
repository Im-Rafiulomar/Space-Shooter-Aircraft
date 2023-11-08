import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Entity {

    int velX = 0, velY = 0;
    int speed = 6;
    public Player(int x, int y) {
        super(x, y);
    }

    public void update() {
        y += velY;
        x += velX;

        checkCollision();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImg(), x, y, null);
        g2d.draw(getBounds());
    }

    public Image getPlayerImg() {
        ImageIcon ic = new ImageIcon("./src/resources/player1.png");
        return ic.getImage();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            velY = -speed;
        } else if (key == KeyEvent.VK_S) {
            velY = speed;
        } else if (key == KeyEvent.VK_A) {
            velX = -speed;
        } else if (key == KeyEvent.VK_D) {
            velX = speed;
        } else if (key == KeyEvent.VK_SPACE) {
            GameFrame.addMissile(new Missile(x, y));
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

    public void checkCollision() {
        ArrayList<Enemy> enemies = GameFrame.getEnemeyList();

        for(int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            if(getBounds().intersects(enemies.get(i).getBounds())) {
                JOptionPane.showMessageDialog(null, "You died on level " + GameFrame.level + "try better next time");
                System.exit(0);
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
    }
}
