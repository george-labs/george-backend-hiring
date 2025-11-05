import input.InputReader;
import input.StopWordsProvider;
import input.impl.ConsoleInputReader;
import output.OutputWriter;
import output.impl.ConsoleOutputWriter;
import service.WordsService;
import service.impl.WordsServiceImpl;

public class JavaApplication {

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        WordsService wordsService = new WordsServiceImpl();
        StopWordsProvider stopWordsProvider = new StopWordsProviderImpl();

        outputWriter.writeLine("Enter text: ");
        String inputTextLine = inputReader.readLine();

        int wordsCount = wordsService.countWords(inputTextLine);

        outputWriter.writeLine("Number of words: " + wordsCount);
    }
}
