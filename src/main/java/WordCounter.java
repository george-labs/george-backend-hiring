import java.util.Arrays;
import java.util.List;

public class WordCounter {

    public int count(String line, List<String> stopWords) {
        return Arrays.stream(line
                .trim()                                     // cut spaces at the start and end of the string
                .replaceAll("\\s+"," ")     // replace more spaces by one
                .split(" "))                          // split by space into array
                .filter(word -> !stopWords.contains(word))  // exclude stopwords
                .toArray()                                  // transformation to array
                .length;                                    // return length of array
    }
}
