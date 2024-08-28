import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;
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

    // This should make iteration 3 try to read from file and if not exists then return value from manual input
    // both shoult return 1 line string that is modified by split filter and count funtion to get result
    public static String readSentence() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.print("Enter text : ");
        try {
            return readWordFromFile(input);
        } catch (Exception e) {
            System.out.println("File not found");
        }

        return scanner.nextLine();
    }

    public static List<String> readStopWordsFromFile(String fileName) {
        List<String> stopwords = new ArrayList<>();
        String file = WordUtils.class.getResource(fileName).getFile();
        System.out.println("file test "+ file);
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

    // This should return 1 liner string from file, but it should be refactored completely
    public static String readWordFromFile(String fileName) {
        String st = "";
        System.out.println(WordUtils.class.getResource(fileName));
        String file = WordUtils.class.getResource(fileName).getFile();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((st = br.readLine()) != null) {
                st += st; // this is wrong
            }
            return st;

        } catch (Exception e) {
            System.out.println("More specific exception should be handled !");
        }
        return st;

    }

    public static List<String> filterStopWords(List<String> list, List<String> stopwords) {
        return list.stream()
                .filter(it -> !stopwords.contains(it))
                .collect(Collectors.toList());
    }

}
