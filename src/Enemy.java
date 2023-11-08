import javax.swing.*;
import java.awt.*;

public class Enemy extends Entity{

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void update() {
        y += 1;
        checkCollisions();
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getEnemyImg(), x, y,null);
        g2d.draw(getBounds());
    }

    public Image getEnemyImg() {
        ImageIcon ic = new ImageIcon("./src/resources/player4.png");
        return ic.getImage();
    }

    public void checkCollisions() {
        for(int i = 0; i < GameFrame.getMissileList().size(); i++) {
            Missile m = GameFrame.getMissileList().get(i);
            if(getBounds().intersects(m.getBounds())) {
                GameFrame.removeEnemy(this);
                GameFrame.removeMissile(m);
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getEnemyImg().getWidth(null), getEnemyImg().getHeight(null));
    }
}
