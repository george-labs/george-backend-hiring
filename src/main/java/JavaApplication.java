import org.jetbrains.annotations.NotNull;

import java.util.*;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileLocationForStopwords = "stopwords.txt";
        IFileReadingService readingService = new FileReadingService();
        WordCountService wordCountService = new WordCountService();
        IFilterService filterService = new FilterService();

        StopWordReadingService stopWordReadingService = new StopWordReadingService(new FileReadingService());
        Set<String> stopwords = stopWordReadingService.getStopWords(fileLocationForStopwords);

        System.out.print("Enter File to read from: ");
        String inputFile = scanner.nextLine();

        int numberOfWords;
        List<String> inputWords;
        if(readingService.getFileUrl(inputFile) != null){
            inputWords = flattenListOfStrings(readingService.getFileContent(inputFile));
        }else{
            System.out.println("File could not be found!");
            System.out.print("Enter Text: ");
            inputWords = Arrays.stream(splitLine(scanner.nextLine())).toList();
        }
        numberOfWords = wordCountService.countWordsInStringWithStopwords(filterService.filterInputString(inputWords), 
                stopwords).size();

        System.out.println("Number of words: " + numberOfWords);
    }

    private static List<String> flattenListOfStrings(List<String> linesFromFile) {
        return linesFromFile.stream().flatMap(s -> Arrays.stream(splitLine(s))).toList();
    }

    private static String[] splitLine(String s) {
        return s.split("\\s");
    }
}
