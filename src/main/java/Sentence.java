import java.util.Arrays;

public class Sentence implements SentenceWordsCounting {

    public static String LETTER_REGEX = "^[a-zA-Z]*$";

    public String sentence;


    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public int countingWordsOnlyLetter(String sentence) {
        String[] words = sentence.split("\\s+");
        int counter = 0;
        for (int i = 0; i < words.length; i++) {

            if (!words[i].equals("") && words[i].matches(LETTER_REGEX)) {
                counter++;
            }
        }
        return counter;
    }
}
