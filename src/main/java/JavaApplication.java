import java.util.List;

public class JavaApplication {


    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        InputProvider inputProvider = new InputProvider(fileReader);

        List<String> inputWords = inputProvider.getInputWords(args);

        WordCountService wordCountService = new WordCountService(fileReader);

        System.out.println("Number of words: " + wordCountService.countWords(inputWords));
    }
}
