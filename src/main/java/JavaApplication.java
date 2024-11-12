import service.impl.InputsServiceImpl;
import service.OutputService;
import service.WordCounterService;

public class JavaApplication {
    public static void main(String[] args) {
        int wordsCount = WordCounterService.wordCounter(new InputsServiceImpl().getInput());
        OutputService.printWordCounterOutput("Number of words: " + wordsCount);
    }
}
