import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Missile extends Entity{


    public Missile(int x, int y) {
        super(x, y);
    }

    public void update() {
        y -= 3;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getMissileImg(), x + 5, y, null);
    }

    public Image getMissileImg() {
        ImageIcon ic = new ImageIcon("./src/resources/missile.png");
        return ic.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getMissileImg().getWidth(null), getMissileImg().getHeight(null));
    }

}
