import input.InputReader;
import input.impl.ConsoleInputReader;
import output.OutputWriter;
import output.impl.OutputWriterImpl;
import service.WordsService;
import service.impl.WordsServiceImpl;

public class JavaApplication {

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new OutputWriterImpl();
        WordsService wordsService = new WordsServiceImpl();

        outputWriter.writeLine("Enter text: ");
        String inputTextLine = inputReader.readLine();

        int wordsCount = wordsService.countWords(inputTextLine);

        outputWriter.writeLine("Number of words: " + wordsCount);
    }
}
