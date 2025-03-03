import java.util.List;

public class JavaApplication {

    public static final String STOPWORDS_FILE_PATH = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        WordCounter wordCounter = new WordCounter();

        List<String> stopWords = fileReader.getStopWords(STOPWORDS_FILE_PATH);

        String line = new ReadInputUtil().readInputLine(args, fileReader);
        CountResponse countResponse = wordCounter.count(line, stopWords);
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters%n",
                countResponse.getTotalCount(),
                countResponse.getUniqueCount(),
                countResponse.getAverageWordLength()
                );
    }

}
