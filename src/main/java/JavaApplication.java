import input.InputReader;
import input.StopWordsProvider;
import input.impl.ConsoleInputReader;
import input.impl.FileStopWordsProvider;
import output.OutputWriter;
import output.impl.ConsoleOutputWriter;
import service.WordsService;
import service.impl.WordsServiceImpl;

import java.nio.file.NoSuchFileException;
import java.util.Set;

public class JavaApplication {

    public static void main(String[] args) throws NoSuchFileException {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        WordsService wordsService = new WordsServiceImpl();
        StopWordsProvider stopWordsProvider = new FileStopWordsProvider();

        Set<String> stopWords = stopWordsProvider.getStopWords("stopwords.txt");

        outputWriter.writeLine("Enter text: ");
        String inputTextLine = inputReader.readLine();

        int wordsCount = wordsService.countWords(inputTextLine, stopWords);

        outputWriter.writeLine("Number of words: " + wordsCount);
    }
}
