import java.util.regex.Pattern;

public class WordCounter {

    private final static String REGEX = "[a-zA-Z]";

    public int getCountOfWords(String input) {

        if (input == null || input.isEmpty() || input.isBlank()) {
            return 0;
        }

        int counter = 0;
        Pattern pattern = Pattern.compile(REGEX);

        String [] words = input.split(" ");
        for (int i=0; i<words.length; i++) {

            if(pattern.matcher(words[i]).matches()) {
                counter++;
            }
        }

        return counter;
    }
}
