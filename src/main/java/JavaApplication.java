import input.ConsoleInputReader;
import input.FileWordsProvider;
import input.InputReader;
import input.WordsProvider;
import output.ConsoleOutputWriter;
import output.OutputWriter;
import service.InputReaderService;
import service.WordCounter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JavaApplication {

    private static final String NUMBER_OF_WORDS = "Number of words: ";
    private static final String UNIQUE = ", unique: ";

    public static void main(String[] args) throws IOException {

        Set<String> stopWords = new HashSet<>();
        String inputText;
        OutputWriter outputWriter = new ConsoleOutputWriter();
        InputReader inputReader = new ConsoleInputReader();
        WordsProvider fileWordsProvider = new FileWordsProvider();
        InputReaderService inputReaderService = new InputReaderService(fileWordsProvider, outputWriter, inputReader);

        inputText = inputReaderService.getInput(args);

        try {
            stopWords = new HashSet<>(fileWordsProvider.getWords("src/main/resources/stopwords.txt"));
        } catch (IOException e) {
            System.out.println("Error reading stopwords.txt");
        }

        WordCounter wordCounter = new WordCounter(stopWords);

        StringBuilder sb = new StringBuilder();

        sb.append(NUMBER_OF_WORDS)
          .append(wordCounter.countWords(inputText))
          .append(UNIQUE)
          .append(wordCounter.uniqueWordCounts(inputText));

        outputWriter.write(sb.toString());

        /*TODO: Extract this whole logic into a new Service
        *  Example:
        * public static void main(String[] args) throws IOException {
        *
        *   WordCounterService wordCounterService = new WordCounterService(dependencies)
        *   wordCounterService.execute(args);
        * }
        *
        * */
    }

}
