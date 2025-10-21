import java.util.Arrays;
import java.util.List;

public class WordCount {

    public static int getWordCount(String userInput) {

        String fileName = "stopWords.txt";
        List<String> stopWords = IOOperationHandler.getStopWords(fileName);

        return (int) Arrays.stream(
                        userInput.split("\\s"))
                .map(token -> token.replace('-', ' '))
                .map(token -> token.replaceAll("^[a-zA-Z]+|[^a-zA-Z]+$",""))
                .filter(token -> token.matches("^[a-zA-Z]*$"))
                .filter(token -> null != token && !token.isEmpty())
                .filter(token -> !stopWords.contains(token))
                .count();
    }
}
