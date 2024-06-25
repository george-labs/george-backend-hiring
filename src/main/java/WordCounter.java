import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {

    public long countWords(String input) {
        int counter = 0;
//        for (var item : splitInput(input)) {
////            System.out.println(item);
//            if (item.matches("[a-zA-Z]+")) {
//                counter++;
//            }
//        }
        var pattern = Pattern.compile("[a-zA-Z]+");

        return Arrays.stream(splitInput(input))
                .filter(item -> pattern.matcher(item).matches())
                .count();
    }

    private String[] splitInput(String inputStr) {
        return inputStr.split("\\s+");
    }
}
