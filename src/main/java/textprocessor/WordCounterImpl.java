package textprocessor;

public class WordCounterImpl implements WordsCounter {
    @Override
    public int countWords(String text) {
        boolean isLastCharLetter = false;
        int counter = 0;
        char[] chars = text.toCharArray();
        for (char ch : chars) {
            boolean isCharLetter = Character.isLetter(ch);
            if (isCharLetter && !isLastCharLetter) {
                counter++;
            }
            isLastCharLetter = isCharLetter;
        }

        return counter;
    }
}
