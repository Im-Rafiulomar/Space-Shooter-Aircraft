package Settings;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class SaveScores {

    public static ArrayList<Data> saveScores = new ArrayList<>();
    public static ArrayList<Data> getSaveScores = new ArrayList<>();


    public SaveScores(String name, int score) {
        saveScores.add(new Data(name, score));
    }

    public static void saveFile() {
        String filePath = "./src/SaveScores/data.txt";
        File file = new File(filePath);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file, true))) {
            for(int i = 0; i < saveScores.size(); i++) {
                outputStream.writeObject(saveScores.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadData() {
        String filePath = "./src/SaveScores/data.txt";
        File file = new File(filePath);
        try (ObjectInputStream objectInputStream =  new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Data data = (Data) objectInputStream.readObject();
                    getSaveScores.add(data);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAllScores() {
        JFrame frame = new JFrame("Scores");
    }

    public static int getHighScore() {
        int highScore = 0;
        for(int i = 0; i < getSaveScores.size(); i++) {
            if(highScore < getSaveScores.get(i).getScore()) {
                highScore = getSaveScores.get(i).getScore();
            }
        }
        return highScore;
    }
}
