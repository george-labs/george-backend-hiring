import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {


        UserInput userInput = new UserInputImpl(System.in);
        CountWords countWords = new CountWords(userInput);
        FileContent fileContent = new FileContent();

        String text = userInput.input();
        int numberOfWords = countWords.count(text, fileContent.getStopWords("stopwords.txt"));

        System.out.printf("Number of words: " + numberOfWords);

    }
}
