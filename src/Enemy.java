import javax.swing.*;
import java.awt.*;

public class Enemy extends Entity{

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void update() {}
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getEnemyImg(), x, y,null);
        g2d.draw(getBounds());
    }

    public Image getEnemyImg() {
        ImageIcon ic = new ImageIcon("./src/resources/player4.png");
        return ic.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getEnemyImg().getWidth(null), getEnemyImg().getHeight(null));
    }
}
