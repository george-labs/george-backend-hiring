import counter.filter.FileStopWordsFilter;
import counter.filter.StopWordsFilter;
import counter.WordCounter;
import counter.WordCounterProcessor;
import counter.WordCounterService;
import java.nio.file.Path;

public class JavaApplication {

    public static void main(String[] args) {
        Path stopWordsFile = Path.of("src/test/resources/stopwords.txt");
        final StopWordsFilter wordsFilter = new FileStopWordsFilter(stopWordsFile);
        final WordCounter wordCounter = new WordCounterService(wordsFilter);
        final WordCounterProcessor processor = new WordCounterProcessor(wordCounter);
        String input = args[0];
        //in Q-env: debug input
        String output = processor.process(input);

        //in Q-env: debug output
        System.out.println(output);
    }
}
