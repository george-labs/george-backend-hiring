import services.InputService;
import services.WordCounterService;

public class JavaApplication {
    public static void main(String[] args) {
        var wordCounterService = new WordCounterService();
        var inputService = new InputService();

        var userInput = inputService.readWords();
        var numberOfWords = wordCounterService.countWords(userInput);
        System.out.println("Number of words: " + numberOfWords);

        inputService.close();
    }
}
