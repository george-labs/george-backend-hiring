import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingWords {

    private final Pattern pattern;

    public CountingWords() {
        this.pattern = Pattern.compile("[a-zA-Z]+");
    }


    public long countNumberOfWords(String text) {
        if(text == null || text.isEmpty()){
            return 0;
        }

        var words = text.split("[\\s]");
        long counter = 0;

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);

            if (matcher.matches()) {
                counter++;
            }
        }

        return counter;
    }
}
