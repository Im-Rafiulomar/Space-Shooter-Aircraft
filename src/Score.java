import java.awt.*;

public class Score {
    public static int score = 0;

    public Score() {

    }
    public void update() {
        score += 1;
    }

    public void draw(Graphics2D g2d) {
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.setColor(Color.GREEN);
        g2d.drawString("Score: " + score, 10, 20);
        g2d.drawString("Controls: W,A,A,D,Space ", 350, 20);
    }
}
