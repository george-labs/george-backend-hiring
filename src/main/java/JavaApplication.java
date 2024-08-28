
public class JavaApplication {
    public static void main(String[] args) {
        WordCounter w = new WordCounterImpl(new SentenceReader(), new WordFilter(), new WordSpliter());
        System.out.println("Number of words: "+ w.countWords());
    }
}
