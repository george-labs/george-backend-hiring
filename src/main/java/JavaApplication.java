import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter text: ");
        String textLine = scanner.nextLine();

        int numberOfWords = countNumberOfAlphabeticalWords(textLine);

        System.out.println("Number of words: " + numberOfWords);
    }

    public static int countNumberOfAlphabeticalWords(String textLine) {
        List<String> wordList = Arrays.asList(textLine.split(" "));
        wordList = wordList.stream().filter(word -> word.matches("[a-zA-Z]+")).toList();

        return wordList.size();
    }
}
