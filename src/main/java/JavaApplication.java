import java.util.Set;

public class JavaApplication {

    Set<String> stopWords;

    public static void main(String[] args) {
        StopWordParser stopWordParser = new StopWordFileParser("../resources/stopwords.txt");
        InputSupplier inputSupplier = new SystemInputSupplier();

        JavaApplication javaApplication = new JavaApplication();
        javaApplication.stopWords = stopWordParser.parseStopWords();
        WordCounter wordCounter = new WordCounter(javaApplication.stopWords);
        System.out.println("Number of Words:" + wordCounter.countWords(inputSupplier.read()));
    }
}
