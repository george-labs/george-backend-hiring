import service.StopWordsLoader;
import service.impl.FileInputService;
import service.impl.UserInputService;
import service.OutputService;
import service.WordCounterService;

import java.io.IOException;

public class JavaApplication {
    public static void main(String[] args) {
        int wordsCount = WordCounterService.wordCounter(new UserInputService().getInput());
        OutputService.printWordCounterOutput("Number of words: " + wordsCount);

        runStopWordsMethod();
    }

    private static void runStopWordsMethod() {
        try {
            String fileContent = new FileInputService().getInput();
            int countWithoutStopWords = WordCounterService.wordCounter(
                    new UserInputService().getInput(),
                    StopWordsLoader.getStopWords(fileContent)
            );
            OutputService.printWordCounterOutput("Number of words: " + countWithoutStopWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
