import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordUtils {

    private WordUtils() {
    }

    public static String[] splitWordsBySpace(String sentence) {
        return sentence.split("\s+");
    }

    public static int countWords(List<String> list) {
       return list.size();
    }

    public static List<String> filterWords(String[] list) {
        return filterWords(list, Collections.emptyList());
    }

    public static List<String> filterWords(String[] list, List<String> stopwords) {
        List<String> filteredList = Arrays.stream(list).toList();
        if (!stopwords.isEmpty()) {
            filteredList = filterStopWords(filteredList, stopwords);
        }

        return filteredList.stream()
                .filter(it -> it.matches("[a-zA-Z]+"))
                .collect(Collectors.toList());
    }

    public static String readSentence() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text : ");
        return input.nextLine();
    }

    public static List<String> readStopWordsFromFile() throws IOException {
        List<String> stopwords = new ArrayList<>();
        String file = WordUtils.class.getResource("/stopwords.txt").getFile();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = br.readLine()) != null) {
                stopwords.add(st);
            }
        } catch (Exception e) {
            System.out.println("More specific exception should be handled !");
        }
        return stopwords;
    }

    public static List<String> filterStopWords(List<String> list, List<String> stopwords) {
        return list.stream()
                .filter(stopwords::contains)
                .collect(Collectors.toList());
    }

}
