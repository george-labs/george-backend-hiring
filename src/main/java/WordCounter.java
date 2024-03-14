import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {
    public int count(String words) {
        if (words == null) {
            return 0;
        }

        String[] split = words.split("\\s+");

        if (split.length < 1) {
            return 0;
        }

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        List<String> items = Arrays.stream(split).filter(w -> {
            Matcher matcher = pattern.matcher(w);
            return matcher.matches();
        }).collect(Collectors.toList());

        return items.size();
    }
}
