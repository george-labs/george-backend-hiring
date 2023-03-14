public class CountWords {

    private UserInput userInput;
    public CountWords(UserInput userInput) {
        this.userInput = userInput;
    }

    public static final String ACCEPTED_LETTERS = "[a-zA-Z]+";

    public int count(final String text) {

        int count = 0;
        String[] words = text.split("\\s+");

        for(int i = 0; i < words.length; i++) {
            if(words[i].matches(ACCEPTED_LETTERS)) {
                count++;
            }
        }
        return count;
    }
}
