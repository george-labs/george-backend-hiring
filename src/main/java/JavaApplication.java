public class JavaApplication {
    public static void main(String[] args) {
        WordCounterFactory wordCounterFactory = new WordCounterFactory();
        WordCounter wordCounter = wordCounterFactory.getWordCounter(args);
        System.out.println("Number of words: " + wordCounter.count());
    }
}
