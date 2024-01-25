import java.util.List;
import java.util.Set;

public class JavaApplication {

    List<String> stopWords;

    public static void main(String[] args) {
        InputParser stopWordParser = new InputFileParser("C:\\Users\\eros\\github\\george\\george-backend-hiring\\src\\main\\resources\\stopwords.txt");

        JavaApplication javaApplication = new JavaApplication();
        javaApplication.stopWords = stopWordParser.parse();

        WordCounter wordCounter = new WordCounter(javaApplication.stopWords);

        String filename;
        if(args.length == 1) {
            filename = args[0];
            InputParser inputParser = new InputFileParser("C:\\Users\\eros\\github\\george\\george-backend-hiring\\src\\main\\resources\\mytext.txt");

            System.out.println("Number of Words:" + wordCounter.countWords(inputParser.parse()));
        } else {
            System.out.println("Enter text: ");
            InputSupplier inputSupplier = new SystemInputSupplier();

            System.out.println("Number of Words:" + wordCounter.countWords(inputSupplier.read()));
        }


    }
}
