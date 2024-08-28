import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
        return Arrays.stream(list)
                .filter(it -> it.matches("[a-zA-Z]+"))
                .collect(Collectors.toList());
    }

    public static String readSentence() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text : ");
        return input.nextLine();
    }
}
