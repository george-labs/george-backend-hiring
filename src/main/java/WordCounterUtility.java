public class WordCounterUtility {
    public static int wordCounter(String[] words) {
        int numberOfWords = 0;
        for (String word : words
        ) {
            if (word.matches("[a-zA-Z]+")) {
                numberOfWords++;

            }
        }
        return numberOfWords;
    }

    public static String[] senteceSplitter(String sentence, String regex) {
        if (sentence.isEmpty() || sentence.isBlank()) {
            return new String[]{};
        }
        return sentence.split(regex);

    }
}
