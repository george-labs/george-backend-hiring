import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCounter {

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }

        String[] words = input.split("\\s");
        List<String> stopWords = loadStopWords();
        return Arrays.stream(words)
                .filter(s -> !s.equals(""))
                .filter(s -> s.matches("\\b[a-zA-Z]*\\b"))
                .filter(s -> !stopWords.contains(s))
                .count();
    }

    private List<String> loadStopWords() {
        try {
            Scanner myReader = new Scanner(new FileReader("..\\resources\\stopwords.txt"));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
