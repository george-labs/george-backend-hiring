import service.impl.IOServiceImpl;
import service.impl.StopWordsCheckerServiceImpl;
import service.impl.WordCountServiceImpl;
import service.IOService;

public class JavaApplication {

    private static final String NUMBER_OF_WORDS = "Number of words: %s";

    public static void main(String[] args) {
        IOService ioService = new IOServiceImpl();
        WordCountServiceImpl wordCountService = new WordCountServiceImpl();
        StopWordsCheckerServiceImpl stopWordsCheckerService = new StopWordsCheckerServiceImpl();
        var text = ioService.readStringWithPrompt("Enter text:");
        var validText = stopWordsCheckerService.processSentence(text);
        ioService.outputValue(String.format(NUMBER_OF_WORDS, wordCountService.checkTheCountOfWord(validText)));
    }
}