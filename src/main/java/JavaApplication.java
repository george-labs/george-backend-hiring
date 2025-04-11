import service.counter.Counter;
import service.reader.InputReader;
import service.reader.Reader;
import service.counter.WordCounter;

public class JavaApplication {

    public static void main(String[] args) {
        Reader inputReader = new InputReader();
        Counter wordCounter = new WordCounter();

        String input = inputReader.readInput();
        Long result = wordCounter.countWordsWithStopWords(input);

        System.out.printf("Number of words: %d", result);
    }
}
