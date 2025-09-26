import java.util.List;
import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        List<String> inputWords;

        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Enter text: ");
            inputWords = TextUtil.getTrimmedAndSplitedWords(scanner.nextLine());

        } else {
            String fileName = args[0];
            try {
                inputWords = fileReader.getWordsFromFile(fileName);

            } catch (Exception e) {
                System.out.println("Enter text: ");
                inputWords = TextUtil.getTrimmedAndSplitedWords(scanner.nextLine());
            }
        }

        WordCountService wordCountService = new WordCountService(fileReader);
        System.out.println("Number of words: " + wordCountService.countWords(inputWords));
    }
}
