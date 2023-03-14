import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileContent {

    private Scanner sc;
    public ArrayList<String> getStopWords(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try {
            sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                words.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
