import services.InputService;
import services.WordCounterService;

public class JavaApplication {
    private static final String STOP_WORDS = "/stopwords.txt";
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
        System.out.println("Number of words: " + numberOfWords);

        inputService.close();
    }
}
