import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaApplication {
    private static final String PATH_ROOT = "src/main/resources/";
    public static void main(String[] args) throws IOException {

        long count;
        Set<String> uniqueWords = new HashSet<>();
        if (args.length != 1) {
            System.out.print("Enter text: ");
            String text = InputHandler.readInput(System.in);
            count = WordUtil.getWordsCount(text);

        } else {
            List<String> words = WordUtil.readFile(PATH_ROOT + "mytext.txt");
            count = WordUtil.getWordsCount(words);
            uniqueWords = WordUtil.getUniqueWords(words);
        }

        System.out.println("Number of words: " + count + ", unique: " + uniqueWords.size());

    }
}
