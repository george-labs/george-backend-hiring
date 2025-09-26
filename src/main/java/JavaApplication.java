import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaApplication {


    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        List<String> inputWords = new ArrayList<>();


        String input;
        if (args.length == 0) {
            System.out.println("Enter text: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            inputWords = TextHelper.splitAndTrimText(input);

        } else {
            String fileName = args[0];
            try {
                inputWords = fileReader.getWordsFromFile(fileName);
            } catch (Exception e) {
                System.out.println("Enter text: ");
            }
        }

        WordCountService wordCountService = new WordCountService(fileReader);

        System.out.println("Number of words: " + wordCountService.countWords(inputWords));
    }
}
