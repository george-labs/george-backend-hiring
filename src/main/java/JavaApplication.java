import service.counter.WordCounter;
import service.reader.FileReader;
import service.reader.InputReader;

public class JavaApplication {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();

        String input = "";
        if (args.length == 0) {
            InputReader inputReader = new InputReader();
            input = inputReader.readInput();
        } else {
            String fileName = args[0];
            FileReader reader = new FileReader();
            input = reader.readInput(fileName);
        }

        Long result = wordCounter.countWordsWithStopWords(input);

        System.out.printf("Number of words: %d", result);
    }
}
