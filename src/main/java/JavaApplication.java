import service.InputsService;
import service.OutputService;
import service.WordCounterService;

public class JavaApplication {
    public static void main(String[] args) {
        int wordsCount = WordCounterService.wordCounter(InputsService.userInput());
        OutputService.printWordCounterOutput("Number of words: " + wordsCount);
    }
}
