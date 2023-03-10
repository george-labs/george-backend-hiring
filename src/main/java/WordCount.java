import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordCount {
    public Long count(String s) {
        return count(s, Collections.emptyList());
    }

    public Long count(String s, List<String> filterList) {
        if (s.isEmpty()) {
            return 0L;
        }
        String[] stringSplitted = s.split("\\s+");
        return Arrays.stream(stringSplitted)
                .filter(s1 -> !s1.isEmpty() && !containsSymbol(s1) && !filterList.contains(s1))
                .count();
    }

    private boolean containsSymbol(String s) {
        for (Character c : s.toCharArray()) {
            if (!Character.isLetter(c))
                return true;
        }
        return false;
    }


}
