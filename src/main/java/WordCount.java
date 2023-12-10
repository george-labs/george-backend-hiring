public class WordCount {
    private static WordCount INSTANCE = null;
    private final static String WORD_LETTER_PATTERN = "[a-zA-Z]+";
    private final static String WHITESPACE_PATTERN = "\\s+";

    private WordCount() {}

    public static synchronized WordCount getInstance() {
        if (INSTANCE == null) INSTANCE = new WordCount();
        return INSTANCE;
    }

    private boolean containsOnlyLetters(String[] wordArray) {
        for (String word : wordArray) {
            if (!word.matches(WORD_LETTER_PATTERN)) {
                return false;
            }
        }
        return true;
    }

    public int countText(String text) {
        if(text.isEmpty()) return 0;
        String[] wordArray = text.split(WHITESPACE_PATTERN);
        if(!containsOnlyLetters(wordArray)) {
            throw new IllegalArgumentException("Text containing non allowed characters");
        }
        return wordArray.length;
    }
}
