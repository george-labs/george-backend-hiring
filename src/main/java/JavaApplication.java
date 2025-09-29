import java.util.Scanner;
import java.util.Set;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileLocationForStopwords = "stopwords.txt";
        IFileReadingService readingService = new FileReadingService();

        StopWordReadingService stopWordReadingService = new StopWordReadingService();
        Set<String> stopwords = stopWordReadingService.getStopWords(fileLocationForStopwords);

        System.out.print("Enter File to read from: ");
        String inputFile = scanner.nextLine();

        readingService.getFileContent(inputFile);

        System.out.print("Enter Text: ");
        String userInput = scanner.nextLine();

        //int numberOfWords = WordCountService.countWordsInString(userInput);
        int numberOfWords = WordCountService.countWordsInStringWithStopwords(userInput, stopwords).size();

        System.out.println("Number of words: " + numberOfWords);
    }
}
