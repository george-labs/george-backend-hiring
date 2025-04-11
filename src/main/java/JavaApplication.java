import util.counter.WordCounter;
import util.index.IndexCreator;
import util.reader.InputReader;

import java.util.Arrays;
import java.util.List;

public class JavaApplication {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        boolean indexEnabled = false;
        String input = "";
        InputReader inputReader = new InputReader();
        input = inputReader.readInput();
        if (args.length > 0) {
            List<String> argList = Arrays.asList(args);
            if (argList.contains("-index")) {
                indexEnabled = true;
            }
        }

        Long countedWords = wordCounter.countWords(input);
        Long countedUniqueWords = wordCounter.countUniqueWords(input);
        double averageWordLength = wordCounter.calculateAverageWordLength(input);

        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters\n",
                countedWords, countedUniqueWords, averageWordLength);

        // Index prints, but in wrong order
        if (indexEnabled) {
            IndexCreator indexCreator = new IndexCreator();
            String index = indexCreator.createIndex(wordCounter.getFilteredWords(input));
            System.out.println(index);
        }
    }
}
