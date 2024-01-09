package service.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextUtils {

    private TextUtils() {
    }

    public static List<String> getWords(String text){
        var splitText = text.split(" |-|;");
        return Arrays.stream(splitText)
                .filter(s -> !s.isBlank() || !s.isEmpty())
                .filter(s -> s.matches("^[a-zA-Z.]+$"))
                .collect(Collectors.toList());
    }
}
