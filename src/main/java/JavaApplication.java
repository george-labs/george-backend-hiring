import input.InputReader;
import input.StopWordsProvider;
import input.impl.ConsoleInputReader;
import input.impl.FileInputReader;
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


        String inputText;

        if (args[0] != null) {
            InputReader fileInputReader = new FileInputReader(args[0]);
            inputText = fileInputReader.readInput();
        } else {
            outputWriter.writeLine("Enter text: ");
            inputText = inputReader.readInput();
        }

        Set<String> stopWords = stopWordsProvider.getStopWords("stopwords.txt");

        int wordsCount = wordsService.countWords(inputText, stopWords);

        outputWriter.writeLine("Number of words: " + wordsCount);
    }
}
