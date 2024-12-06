import com.erste.mm.component.FileReader;
import com.erste.mm.model.UniqueCount;
import com.erste.mm.service.WordService;

import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    private static final String STOP_WORD_FILE = "stopwords.txt";
    private static final String INDEXED_PARAM = "indexed";

    public static void main(String[] args) {
        UniqueCount counts = args.length > 0 && !INDEXED_PARAM.equals(args[0])?
                getCountWordsFile(args[0]) : getCountWordsInput();

        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters",
                counts.getCount(), counts.getUniqueCount(), counts.getAverage());

        if (args[0].equals(INDEXED_PARAM))
            outputIndexedList(counts.getTextualIndex());
    }

    static void outputIndexedList(List<String> strings) {
        System.out.println("Index:");
        strings.forEach(System.out::println);
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
