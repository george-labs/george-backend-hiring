import services.InputService;
import services.WordCounterService;

public class JavaApplication {
    private static final String STOP_WORDS = "/stopwords.txt";
    public static void main(String[] args) {
        var wordCounterService = new WordCounterService(STOP_WORDS);
        var inputService = new InputService();

        var userInput = inputService.readWords();
        var numberOfWords = wordCounterService.countWords(userInput);
        System.out.println("Number of words: " + numberOfWords);

        inputService.close();
    }
}
