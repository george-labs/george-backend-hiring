import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public String getSentenceFromFile(String filePath) {
        return String.join(" ", readWordsFromFile(filePath));
    }

    public List<String> readWordsFromFile(String filePath) {
        List<String> result = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(new java.io.FileReader(filePath));
            while (myReader.hasNext()) {
                result.add(myReader.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not load file. \n" + e);
        }
        return result;
    }
}
