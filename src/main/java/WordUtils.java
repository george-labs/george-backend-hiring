import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordUtils {

    public static String[] splitInput(String inputStr) {
        return inputStr.split("\\s+");
    }
    public static @NotNull List<String> splitLineAsList(String line) {
        return Arrays.stream(WordUtils.splitInput(line)).toList();
    }
    public static List<String> splitWords(List<String> inputLines ){
        List<String> wordsList = new ArrayList<>();
        for (var line : inputLines) {
            wordsList.addAll(WordUtils.splitLineAsList(line));
        }
        return wordsList;
    }
}
