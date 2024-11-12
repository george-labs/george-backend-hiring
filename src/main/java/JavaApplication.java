import constant.FilePaths;
import exception.WrongParameterException;
import service.OutputService;
import service.StopWordsLoader;
import service.WordCounterService;
import service.impl.FileInputService;
import service.impl.UserInputService;

import java.io.IOException;

public class JavaApplication {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            runStopWordsMethod();
        } else {
            wordCounterFromFile(args[0]);
        }
    }

    private static void wordCounterFromFile(String inputFileName) throws IOException {
        try {
            String fileContent = new FileInputService(inputFileName).getInput();
            String stopWordsFileContent = new FileInputService(FilePaths.STOP_WORDS_FILE).getInput();
            int wordsCount = WordCounterService.wordCounter(
                    fileContent,
                    StopWordsLoader.getStopWords(stopWordsFileContent)
            );
            OutputService.printWordCounterOutput("Number of words: " + wordsCount);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new WrongParameterException("File " + inputFileName + " was not possible to find or read.");
        }
    }

    private static void runStopWordsMethod() {
        try {
            String fileContent = new FileInputService(FilePaths.STOP_WORDS_FILE).getInput();
            int countWithoutStopWords = WordCounterService.wordCounter(
                    new UserInputService().getInput(),
                    StopWordsLoader.getStopWords(fileContent)
            );
            OutputService.printWordCounterOutput("Number of words: " + countWithoutStopWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void wordCounterFromConsole() {
        int wordsCount = WordCounterService.wordCounter(new UserInputService().getInput());
        OutputService.printWordCounterOutput("Number of words: " + wordsCount);
    }


}
