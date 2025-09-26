import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {

        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        FileReader fileReader = new FileReader();

        WordCountService wordCountService = new WordCountService(fileReader);

        System.out.println("Number of words: " + wordCountService.countWords(input));
    }
}
