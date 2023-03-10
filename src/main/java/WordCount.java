import java.util.Arrays;

public class WordCount {
    public Long count(String s) {
        if (s.isEmpty()) {
            return 0L;
        }
        String[] stringSplitted = s.split(" ");
        return Arrays.stream(stringSplitted)
                .filter(s1 -> !s1.isEmpty())
                .count();
    }
}
