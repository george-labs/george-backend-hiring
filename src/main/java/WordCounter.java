public class WordCounter {

    private StopWords stopWords = new StopWords("stopwords.txt");

    public int count(String text) {
        if ((text == null) || text.isBlank()) {
            throw new IllegalArgumentException("Unsupported input text");
        }
        String[] words = text.split("\\s+");
        return countWords(words);
    }

    protected int countWords(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException("Unsupported array of words");
        }
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (isValidWord(words[i])) {
                counter++;
            }
        }
        return counter;
    }

    protected boolean isValidWord(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        String lowerCaseWord = word.toLowerCase();
        if (stopWords.isStopWord(lowerCaseWord)) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char character = lowerCaseWord.charAt(i);
            if ((character < 'a') || (character > 'z')) {
                return false;
            }
        }
        return true;
    }


}
