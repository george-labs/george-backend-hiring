import wordcounter.*;
import wordcounter.input.FileInputReader;
import wordcounter.input.InputReader;
import wordcounter.input.UserInputReader;
import wordcounter.service.StopWordsService;
import wordcounter.service.WordCounterService;

public class JavaApplication {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        InputReader inputReader;
        StopWordsService stopWordsService = new StopWordsService("stopwords.txt", fileReader);
        WordCounterService wordCounterService = new WordCounterService(stopWordsService);
        ResultPrinter resultPrinter = new ResultPrinter();

        if (args.length == 1) {
            String inputFileName = args[0];
            inputReader = new FileInputReader(inputFileName, fileReader);
        } else {
            inputReader = new UserInputReader();
        }

        WordCounterApplication wordCounterApplication = new WordCounterApplication(inputReader, wordCounterService, resultPrinter);
        wordCounterApplication.run();

    }

}
