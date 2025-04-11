import service.Counter;
import service.InputReader;
import service.Reader;
import service.WordCounter;

public class JavaApplication {

    public static void main(String[] args) {
        Reader inputReader = new InputReader();
        Counter wordCounter = new WordCounter();

        String input = inputReader.readInput();
        Long result = wordCounter.countWords(input);

        System.out.printf("Number of words: %d", result);
    }
}
