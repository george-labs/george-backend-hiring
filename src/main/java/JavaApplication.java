import wordcounter.*;
import wordcounter.input.FileInputReader;
import wordcounter.input.InputReader;
import wordcounter.input.UserInputReader;

public class JavaApplication {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        InputReader inputReader;
        StopWordsService stopWordsService = new StopWordsService("stopwords.txt", fileReader);
        WordCounter wordCounter = new WordCounter(stopWordsService);
        ResultPrinter resultPrinter = new ResultPrinter();

        if (args.length == 1) {
            String inputFileName = args[0];
            inputReader = new FileInputReader(inputFileName, fileReader);
        } else {
            inputReader = new UserInputReader();
        }

        WordCounterApplication wordCounterApplication = new WordCounterApplication(inputReader, wordCounter, resultPrinter);
        wordCounterApplication.run();

    }

}
