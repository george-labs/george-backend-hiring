import services.InputService;
import services.WordCounterService;
import services.StopWordsService;

public class JavaApplication {
    private static final String STOP_WORDS = "/stopwords.txt";
    private static final String OUTPUT = "Number of words: %s, unique: %s";
    public static void main(String[] args) {
        var stopWordsService = new StopWordsService(STOP_WORDS);
        var wordCounterService = new WordCounterService();
        var inputService = new InputService();

        String userInput;
        if (args.length > 0) {
            userInput = inputService.readWordsFromFile(args[0]);
        } else {
            userInput = inputService.readWords();
        }

        var stopWordSet = stopWordsService.getStopWords();
        var numberOfWords = wordCounterService.countWords(userInput, stopWordSet);
        var numberOfUniqueWords = wordCounterService.countUniqueWords(userInput, stopWordSet);
        var output = String.format(OUTPUT, numberOfWords, numberOfUniqueWords);
        System.out.println(output);

        inputService.close();
    }
}
