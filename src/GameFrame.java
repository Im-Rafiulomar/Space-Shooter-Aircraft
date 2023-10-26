import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GameFrame extends JPanel implements ActionListener {
    Timer mainTimer;
    Player player;

    static ArrayList<Enemy> enemies = new ArrayList<>();
    Random rand = new Random();

    int enemyCount = 5;

    public GameFrame() {
        setFocusable(true);


        player = new Player(500, 500);
        addKeyListener(new KeyAdapt(player));

        mainTimer = new Timer(10, this);
        mainTimer.start();

        for(int i = 0; i < enemyCount; i++) {
            addEnemy(new Enemy(rand.nextInt(800), rand.nextInt(600)));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);

        for(int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            tempEnemy.draw(g2d);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
    }


    public static void removeEnemy(Enemy e) {
        enemies.remove(e);
    }

    public static ArrayList<Enemy> getEnemeyList() {
        return enemies;
    }
}
