import input.UserInputHandler;
import wordcount.WordCounter;

public class JavaApplication {
    private static final UserInputHandler userInputHandler = new UserInputHandler();
    private static final WordCounter wordCounter = new WordCounter();
    public static void main(String[] args) {
        System.out.print("Enter text: ");
        String inputText = userInputHandler.readUserInput(System.in);
        int wordCount = wordCounter.countNumberOfWords(inputText);
        System.out.println("Number of words:" + wordCount);
    }
}
