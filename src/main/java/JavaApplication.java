
public class JavaApplication {



    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        WordCounter wordCounter = new WordCounter();

        final var input = ioHandler.getInput();
        final var wordCount = wordCounter.getNumberOfWords(input);

        System.out.println("Number of words: " + wordCount);
    }
}
