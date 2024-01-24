public class WordCounterApp {

    public static void main(String[] args) {
        String sentence = System.console().readLine();
        String[] words = sentence.split(" ");
        int numberOfWords = WordCounterUtility.wordCounter(words);
        System.out.println();

    }

}
