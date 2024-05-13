import wordcount.StopWordsLoader;
import wordcount.WordCountService;

import java.util.Scanner;
import java.util.Set;

public class JavaApplication {
    public static void main(String[] args) {
        StopWordsLoader stopWordsLoader = new StopWordsLoader();
        Set<String> stopWords = stopWordsLoader.loadStopWords("src/main/resources/stopwords.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String sentence = scanner.nextLine();

        WordCountService wordCountService = new WordCountService(stopWords);
        System.out.println("Number of words: " + wordCountService.countWords(sentence));
    }
}
