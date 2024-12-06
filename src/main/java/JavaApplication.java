import com.erste.mm.component.FileReader;
import com.erste.mm.model.UniqueCount;
import com.erste.mm.service.WordService;

import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    private static final String STOP_WORD_FILE = "stopwords.txt";

    public static void main(String[] args) {
        UniqueCount counts = args.length == 1 ?
                getCountWordsFile(args[0]) : getCountWordsInput();

        System.out.printf("Number of words: %d, unique: %d", counts.getCount(), counts.getUniqueCount());
    }

    static UniqueCount getCountWordsFile(String path) {
        List<String> read = FileReader.readWordsInput(path);

        return WordService.countWordsWithoutStoppedWords(read, STOP_WORD_FILE);
    }

    static UniqueCount getCountWordsInput() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        return WordService.countWordsWithoutStoppedWords(input, STOP_WORD_FILE);
    }

}
