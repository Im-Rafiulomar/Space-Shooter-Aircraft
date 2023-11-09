import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Entity {
    int velocityX = 0, velocityY = 0;
    int speed = 5;

    int startX = 0, startY = 0;

    public Player(int x, int y) {
        super(x, y);
    }

    public void update() {
        x += velocityX;
        y += velocityY;

        checkCollision();
        checkOffScreen();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImg(), x, y, null);
//        g2d.draw(getBounds());
    }

    public Image getPlayerImg() {
        ImageIcon ic = new ImageIcon("./src/resources/player1.png");
        return ic.getImage();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            velocityY = -speed;
        } else if (key == KeyEvent.VK_S) {
            velocityY = speed;
        } else if (key == KeyEvent.VK_A) {
            velocityX = -speed;
        } else if (key == KeyEvent.VK_D) {
            velocityX = speed;
        } else if (key == KeyEvent.VK_SPACE) {
            Missile missile = new Missile(x, y);
            Sound.missileSound();
            GameFrame.addMissile(missile);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            velocityY = 0;
        } else if (key == KeyEvent.VK_S) {
            velocityY = 0;
        } else if (key == KeyEvent.VK_A) {
            velocityX = 0;
        } else if (key == KeyEvent.VK_D) {
            velocityX = 0;
        }
    }

    public void checkCollision() {
        ArrayList<Enemy> enemies = GameFrame.getEnemeyList();

        for(int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            if(getBounds().intersects(enemies.get(i).getBounds())) {
                JOptionPane.showMessageDialog(null, "You died on level " + GameFrame.level + " ,try better next time");
                System.exit(0);
            }
        }
    }

    public void checkOffScreen() {
        if(x < 0) {
            x = 0;
        }

        if( x > 600) {
            x = 600;
        }

        if(y < 0) {
            y = 0;
        }

        if(y > 600) {
            y = 600;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
    }
}
