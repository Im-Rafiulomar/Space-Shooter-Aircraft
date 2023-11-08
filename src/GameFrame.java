import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GameFrame extends JPanel implements ActionListener {
    Timer mainTimer;
    Player player;
    int enemyCount = 5;
    int level = 1;


    static ArrayList<Enemy> enemies = new ArrayList<>();
    static ArrayList<Missile> missiles = new ArrayList<>();
    Random rand = new Random();



    public GameFrame() {
        setFocusable(true);


        player = new Player(230, 530);
        addKeyListener(new KeyAdapt(player));

        mainTimer = new Timer(10, this);
        mainTimer.start();

        startGame();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);

        for(int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            tempEnemy.draw(g2d);
        }

        for(int i = 0; i < missiles.size(); i++) {
            Missile m = missiles.get(i);
            m.draw(g2d);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        for(int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            tempEnemy.update();
        }
        for(int i = 0; i < missiles.size(); i++) {
            Missile m = missiles.get(i);
            m.update();
        }

        repaint();
    }

    public static void addEnemy(Enemy e) {
        enemies.add(e);
    }


    public static void removeEnemy(Enemy e) {
        enemies.remove(e);
    }

    public static ArrayList<Enemy> getEnemeyList() {
        return enemies;
    }

//
    public static void addMissile(Missile e) {
        missiles.add(e);
    }


    public static void removeMissile(Missile e) {
        missiles.remove(e);
    }

    public static ArrayList<Missile> getMissileList() {
        return missiles;
    }



    public void startGame() {
        enemyCount = level * 5;
        for(int i = 0; i < enemyCount; i++) {
            addEnemy(new Enemy(rand.nextInt(500), -10 + - rand.nextInt(600)));
        }
    }
}
