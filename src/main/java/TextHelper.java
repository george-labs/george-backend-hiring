import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextHelper {

    public static List<String> splitAndTrimText(String input) {

        if (input == null){
            return new ArrayList<>();
        }

        return Arrays
            .stream(input.trim().toLowerCase().split("[^a-zA-Z]+"))
            .collect(Collectors.toList());
    }
}
