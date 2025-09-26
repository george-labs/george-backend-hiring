import java.util.List;
import java.util.Scanner;

public class InputProvider {

    private final FileReader fileReader;

    public InputProvider(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public List<String> getInputWords(String[] params) {
        List<String> inputWords;

        Scanner scanner = new Scanner(System.in);

        if (params.length == 0) {
            System.out.println("Enter text: ");
            inputWords = TextUtil.getTrimmedAndSplitedWords(scanner.nextLine());

        } else {
            String fileName = params[0];
            try {
                inputWords = fileReader.getWordsFromFile(fileName);

            } catch (Exception e) {
                System.out.println("Enter text: ");
                inputWords = TextUtil.getTrimmedAndSplitedWords(scanner.nextLine());
            }
        }

        return inputWords;
    }
}
