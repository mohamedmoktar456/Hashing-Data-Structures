import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tableSize = 997; // Prime number table size

        List<String> words = readWordsFromFile("words.txt");

    }

    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                words.add(scanner.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return words;
    }
}
