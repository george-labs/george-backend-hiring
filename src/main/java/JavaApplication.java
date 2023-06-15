import java.util.List;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("src/main/resources/stopwords.txt");
        List<String> forbiddenWords = fileReader.readWordsFromFile();

        WordCounter wordCounter = new WordCounter(readFromInput(), forbiddenWords);

        System.out.println("Number of words: " + wordCounter.countWords());
    }

    private static String readFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");

        return sc.nextLine();
    }
}
