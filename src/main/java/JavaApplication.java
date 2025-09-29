import java.util.*;

public class JavaApplication {
    public static void main(String[] args) {
        Set<String> stopwords = getStopwords();

        IFileReadingService readingService = new FileReadingService();
        WordService wordService = new WordService();
        IFilterService filterService = new FilterServiceHyphen();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter File to read from: ");
        String inputFile = scanner.nextLine();

        List<String> inputWords;
        if(readingService.getFileUrl(inputFile) != null){
            inputWords = flattenListOfStrings(readingService.getFileContent(inputFile));
        }else{
            System.out.println("File could not be found!");
            System.out.print("Enter Text: ");
            inputWords = Arrays.stream(splitLine(scanner.nextLine())).toList();
        }

        List<String> filteredInput = filterService.filterInputString(inputWords);
        List<String> filteredInputAfterStopwords = wordService.getWordsConsideringStopwords(filteredInput, stopwords);

        System.out.println("Number of words: " + filteredInputAfterStopwords.size());
        System.out.println("Number of unique words: " + wordService.getUniqueWords(filteredInputAfterStopwords).size());
    }

    private static Set<String> getStopwords() {
        String fileLocationForStopwords = "stopwords.txt";
        StopWordReadingService stopWordReadingService = new StopWordReadingService(new FileReadingService());
        return stopWordReadingService.getStopWords(fileLocationForStopwords);
    }

    private static List<String> flattenListOfStrings(List<String> linesFromFile) {
        return linesFromFile.stream().flatMap(s -> Arrays.stream(splitLine(s))).toList();
    }

    private static String[] splitLine(String s) {
        return s.split("\\s");
    }
}
