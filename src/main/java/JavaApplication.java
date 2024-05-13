import wordcount.InputReader;
import wordcount.OutputWriter;
import wordcount.StopWordsLoader;
import wordcount.WordCountService;

import java.util.Set;

public class JavaApplication {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final WordCountService wordCountService;

    JavaApplication(InputReader inputReader, OutputWriter outputWriter, WordCountService wordCountService) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.wordCountService = wordCountService;
    }

    public static void main(String[] args) {
        StopWordsLoader stopWordsLoader = new StopWordsLoader();
        Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords.txt");

        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        WordCountService wordCountService = new WordCountService(stopWords);

        JavaApplication javaApplication = new JavaApplication(inputReader, outputWriter, wordCountService);
        javaApplication.run();
    }

    public void run() {
        String sentence = inputReader.getInput();

        outputWriter.writeOutput(wordCountService.countWords(sentence));
    }
}
