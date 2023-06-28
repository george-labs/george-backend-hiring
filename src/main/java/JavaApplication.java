import services.InputService;
import services.WordCounterService;

public class JavaApplication {
    private static final String STOP_WORDS = "/stopwords.txt";
    private static final String OUTPUT = "Number of words: %s, unique: %s";
    public static void main(String[] args) {
        var wordCounterService = new WordCounterService(STOP_WORDS);
        var inputService = new InputService();

        String userInput;
        if (args.length > 0) {
            userInput = inputService.readWordsFromFile(args[0]);
        } else {
            userInput = inputService.readWords();
        }

        var numberOfWords = wordCounterService.countWords(userInput);
        var numberOfUniqueWords = wordCounterService.countUniqueWords(userInput);
        var output = String.format(OUTPUT, numberOfWords, numberOfUniqueWords);
        System.out.println(output);

        inputService.close();
    }
}
