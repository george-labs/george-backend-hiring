import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) throws Exception {

        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        FileReader fileReader = new FileReader();
        WordCount wordCount = new WordCount(fileReader);

        System.out.println("Number of words: " + wordCount.countWordsExcludingStopWords(input));
    }
}
