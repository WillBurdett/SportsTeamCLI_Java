package player;

import player.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PlayerDAO {

    public List<Player> getAllPlayers() {

        Player carlin = new Player("Carlin Isles", "Wing", 14, LocalDate.of(2022,05,01));
        Player jonny = new Player("Jonny Wilkinson", "Fly Half", 10, LocalDate.of(2022,04,21));

        return List.of(carlin, jonny);
    }

    public void savePlayerToFile(Player player){

        String dirPath = "/Users/williamburdett/Desktop/Intellij/IdeaProjects/Sports_Team/src/main/java/player";
        String dirName = "playerDB.txt";
        try {
            File file = new File(dirPath,dirName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(player.toStringCSV());

            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Player[] readFile(){
        String dirPath = "/Users/williamburdett/Desktop/Intellij/IdeaProjects/Sports_Team/src/main/java/player";
        String dirName = "playerDB.txt";
        try {
            File file = new File(dirPath, dirName);
            if (!file.exists()) {
                throw new IllegalStateException("File " + file + " does not exist");
            }

            int count = 0;
            Scanner scannerForLineCount = new Scanner(file);
            while(scannerForLineCount.hasNext()){
                scannerForLineCount.nextLine();
                count++;
            }

            Player[] allPlayers = new Player[count];

            Scanner scannerForReading = new Scanner(file);

            int index = 0;

            while (scannerForReading.hasNext()){
                String[] info = scannerForReading.nextLine().split(",");
                String[] date = info[3].split("-");
                Player player = new Player(info[0], info[1], Integer.parseInt(info[2]), LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                allPlayers[index++] = player;
            }
            return allPlayers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Player[0];
    }
}
