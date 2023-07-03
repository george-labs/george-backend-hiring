public class JavaApplication {

    public static void main(String[] args) {

        WordCounter wordCounter = new WordCounterImpl();

        int numberWords = wordCounter.countWords();

        System.out.println("Number of words: " + numberWords);

    }

}
