import wordcount.InputReader;
import wordcount.OutputWriter;
import wordcount.StopWordsLoader;
import wordcount.WordCountService;

import java.util.Set;

public class JavaApplication {
    public static void main(String[] args) {
        StopWordsLoader stopWordsLoader = new StopWordsLoader();
        Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords.txt");

        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        WordCountService wordCountService = new WordCountService(stopWords);

        String sentence = inputReader.getInput();

        outputWriter.writeOutput(wordCountService.countWords(sentence));
    }
}
