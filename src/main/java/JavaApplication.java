import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    public static final String STOPWORDS_FILE_PATH = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        WordCounter wordCounter = new WordCounter();

        List<String> stopWords = fileReader.getStopWords(STOPWORDS_FILE_PATH);

        String line = readInputLine(args, sc, fileReader);
        CountResponse countResponse = wordCounter.count(line, stopWords);
        System.out.printf("Number of words: %d, unique: %d%n",
                countResponse.getTotalCount(),
                countResponse.getUniqueCount());
    }

    private static String readInputLine(String[] args, Scanner sc, FileReader fileReader) {
        String line;
        if (args != null && args.length > 0 && args[0] != null) {
            line = fileReader.getContent(args[0]);
        } else {
            System.out.print("Enter text: ");
            line = sc.nextLine();
        }
        return line;
    }
}
