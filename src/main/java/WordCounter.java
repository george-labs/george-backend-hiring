import java.util.Arrays;
import java.util.List;

public class WordCounter {

    public int countWords(String input) {
        int count = 0;
        String[] splice = input.split("[^a-zA-Z]+");
        if (splice.length == 1 && splice[0].equals("")) {
            count = 0;
        } else {
            count += splice.length;
        }
        return count;
    }

    public int countWords(String input, List<String> stopWords) {
        int count = 0;
        String[] splice = input.split("[^a-zA-Z]+");

        // "ab", "cd" ...

            for (String str: splice) {
                if (!str.equals("") && !stopWords.contains(str)) {
                    count++;
                }
            };

        return count;

    }

}
