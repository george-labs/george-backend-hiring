import file.FileHandler;
import input.UserInputHandler;
import wordcount.WordCountKata;
import wordcount.WordExtractor;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.print("Enter text: ");
        int count = new WordCountKata( new UserInputHandler(inputStream), new FileHandler(), new WordExtractor()).countWords();
        System.out.println("Number of words:" + count);
    }
}
