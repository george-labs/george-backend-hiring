import service.StopWordsProcessorService;
import service.UniqueWordCounterService;
import service.WordCountService;
import service.impl.IOServiceImpl;
import service.impl.StopWordsProcessorServiceImpl;
import service.impl.UniqueWordCounterServiceImpl;
import service.impl.WordCountServiceImpl;
import service.IOService;

public class JavaApplication {

    private static final String OUTPUT_MESSAGE = "Number of words: %s, unique: %s";

    public static void main(String[] args) {
        IOService ioService = new IOServiceImpl();
        WordCountService wordCountService = new WordCountServiceImpl();
        StopWordsProcessorService stopWordsCheckerService = new StopWordsProcessorServiceImpl();
        UniqueWordCounterService uniqueWordCounterService = new UniqueWordCounterServiceImpl();
        String text = "";
        if(args.length > 0 && args[0] != null){
            text = ioService.extractStringFromFile(args[0]);
            if(text == null){
                System.exit(0);
            }
        }
        if(text.isBlank()){
            text = ioService.readStringWithPrompt("Enter text:");
        }
        var validText = stopWordsCheckerService.processSentence(text);
        ioService.outputValue(String.format(OUTPUT_MESSAGE,
                wordCountService.checkTheCountOfWord(validText),
                uniqueWordCounterService.processText(validText)));
    }
}